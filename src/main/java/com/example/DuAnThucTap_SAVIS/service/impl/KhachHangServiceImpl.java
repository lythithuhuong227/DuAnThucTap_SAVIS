package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.KhachHang;
import com.example.DuAnThucTap_SAVIS.model.mapper.KhachHangMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateKhachHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateKhachHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.KhachHangResponse;
import com.example.DuAnThucTap_SAVIS.repository.KhachHangRepository;
import com.example.DuAnThucTap_SAVIS.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private KhachHangMapper khachHangMapper;

    @Autowired
    private JavaMailSender sender;

    @Override
    public Page<KhachHangResponse> pageTaiKhoanActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<KhachHang> taiKhoanPage = khachHangRepository.pageACTIVEKhachHang(pageable);
        return taiKhoanPage.map(khachHangMapper::khachHangEntityToTaiKhoanResponse);
    }

    @Override
    public Page<KhachHangResponse> pageTaiKhoanInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<KhachHang> taiKhoanPage = khachHangRepository.pageINACTIVEKhachHang(pageable);
        return taiKhoanPage.map(khachHangMapper::khachHangEntityToTaiKhoanResponse);
    }

    @Override
    public void add(CreateKhachHangRequest createKhachHangRequest, MultipartFile file) throws IOException, SQLException {
        SimpleMailMessage message = new SimpleMailMessage();
        KhachHang khachHang = khachHangMapper.createKhachHangRequestToTaiKhoanEntity(createKhachHangRequest);
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        khachHang.setMa(GenCode.generateKhachHangCode());
        khachHang.setMatKhau(GenCode.generatePassWordKhachHang());
        khachHang.setSoLuongDonHangThanhCong(0);
        khachHang.setSoTienDaChiTieu(BigDecimal.valueOf(0));
        khachHang.setNgayTao(LocalDate.now());
        khachHang.setTrangThai(ApplicationConstant.TrangThaiTaiKhoan.ACTIVE);
        khachHang.setAnh(blob);
        khachHangRepository.save(khachHang);

        String subject = "Đăng ký tài khoản thành công";
        String content = "Chào anh/chị,\n" +
                "Dưới đây là thông tin tài khoản của bạn:\n" +
                "Tên đăng nhập (Email): " + khachHang.getEmail() + "\n" +
                "Mật khẩu: " + khachHang.getMatKhau() + "\n" +
                "Vui lòng đăng nhập bằng thông tin này để sử dụng tài khoản của bạn.\n" +
                "\n" +
                "Trân trọng,\n" +
                "Cửa hàng bán áo thể thao PSG";
        message.setTo(khachHang.getEmail());
        message.setSubject(subject);
        message.setText(content);
        this.sender.send(message);
    }

    @Override
    public void update(Integer id, MultipartFile file, UpdateKhachHangRequest updateKhachHangRequest) throws IOException, SQLException {
        KhachHang kh = khachHangRepository.findById(id).orElse(null);
        if (kh != null) {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                kh.setAnh(blob);

            }
            kh.setSdt(updateKhachHangRequest.getSdt());
            kh.setTen(updateKhachHangRequest.getTen());
            kh.setNgaySinh(updateKhachHangRequest.getNgaySinh());
            kh.setGioiTinh(updateKhachHangRequest.getGioiTinh());
            kh.setDiaChi(updateKhachHangRequest.getDiaChi());
            kh.setEmail(updateKhachHangRequest.getEmail());
            khachHangRepository.save(kh);
        }
    }

    @Override
    public List<KhachHangResponse> getAllKhachHangActive() {
        return khachHangMapper.listKhachHangEntityToKhachHangResponse(khachHangRepository.listKhachHangActive());
    }


    @Override
    public KhachHangResponse getOne(Integer id) {
        Optional<KhachHang> optionalTaiKhoan = khachHangRepository.findById(id);
        return khachHangMapper.khachHangEntityToTaiKhoanResponse(optionalTaiKhoan.get());
    }

    @Override
    public void delete(Integer id, LocalDate now) {
        khachHangRepository.deleteKhachHang(id, now);
    }

    @Override
    public void revertTaiKhoan(Integer id, LocalDate now) {
        khachHangRepository.revertKhachHang(id, now);
    }

    @Override
    public Page<KhachHangResponse> pageSearchACTIVE(String search, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<KhachHang> taiKhoanPage = khachHangRepository.pageSearchACTIVEKhachHang(search, pageable);
        return taiKhoanPage.map(khachHangMapper::khachHangEntityToTaiKhoanResponse);
    }

    @Override
    public Page<KhachHangResponse> pageSearchTuoiMinMax(Integer min, Integer max, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<KhachHang> taiKhoanPage = khachHangRepository.pageSearchTuoiMinMaxKhachHang(min, max, pageable);
        return taiKhoanPage.map(khachHangMapper::khachHangEntityToTaiKhoanResponse);
    }
//
    @Override
    public KhachHang viewById(Integer id) {
        return khachHangRepository.findById(id).get();
    }
//
    @Override
    public Boolean existsBySdtKhachHang(String sdt) {
        return khachHangRepository.existsBySdtKhachHang(sdt);
    }

    @Override
    public Boolean existsByEmailKhachHang(String email) {
        return khachHangRepository.existsByEmailKhachHang(email);
    }

    @Override
    public Boolean existsBySdtKhachHangWithDifferentId(String sdt, Integer id) {
        return khachHangRepository.existsBySdtKhachHangWithDifferentId(sdt,id);
    }

    @Override
    public Boolean existsByEmailKhachHangWithDifferentId(String sdt, Integer id) {
        return khachHangRepository.existsByEmailKhachHangWithDifferentId(sdt,id);

    }



}
