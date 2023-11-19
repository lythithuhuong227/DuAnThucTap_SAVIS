package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;
import com.example.DuAnThucTap_SAVIS.model.mapper.VoucherThuHangMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.VoucherThuHangResponse;
import com.example.DuAnThucTap_SAVIS.repository.VoucherThuHangRepository;
import com.example.DuAnThucTap_SAVIS.service.VoucherThuHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Component
public class VoucherThuHangServiceImpl implements VoucherThuHangService {
    @Autowired
    private VoucherThuHangRepository voucherThuHangRepository;

    @Autowired
    VoucherThuHangMapper voucherThuHangMapper;

    @Override
    public Page<VoucherThuHangResponse> pageVouCherThuHangActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<VoucherThuHang> voucherThuHangs = voucherThuHangRepository.pageACTIVE(pageable);
        return voucherThuHangs.map(voucherThuHangMapper::voucherThuHangEntityToVoucherThuHangResponse);
    }

    @Override
    public List<VoucherThuHang> getAll() {
        return this.voucherThuHangRepository.findByTrangThaiActive();
    }

    @Override
    public Page<VoucherThuHangResponse> pageVouCherThuHangInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<VoucherThuHang> voucherThuHangs = voucherThuHangRepository.pageINACTIVE(pageable);
        return voucherThuHangs.map(voucherThuHangMapper::voucherThuHangEntityToVoucherThuHangResponse);
    }

    @Override
    public Page<VoucherThuHangResponse> pageVouCherThuHangPending(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<VoucherThuHang> voucherThuHangs = voucherThuHangRepository.pagePENDING(pageable);
        return voucherThuHangs.map(voucherThuHangMapper::voucherThuHangEntityToVoucherThuHangResponse);
    }

    @Override
    public VoucherThuHangResponse add(CreateVoucherThuHangRequest createVoucherThuHangRequest) {
        VoucherThuHang voucherThuHang = voucherThuHangMapper.createVoucherThuHangRequestToVoucherThuHangEntity(createVoucherThuHangRequest);
        voucherThuHang.setMa(GenCode.generateVoucherCode());
        voucherThuHang.setNgayTao(LocalDateTime.now());

        LocalDateTime ngayBatDau = createVoucherThuHangRequest.getNgayBatDau();
        if (ngayBatDau.isAfter(LocalDateTime.now())) {
            voucherThuHang.setTrangThai(ApplicationConstant.TrangThaiVoucher.PENDING);
        } else {
            voucherThuHang.setTrangThai(ApplicationConstant.TrangThaiVoucher.ACTIVE);
        }

        return voucherThuHangMapper.voucherThuHangEntityToVoucherThuHangResponse(voucherThuHangRepository.save(voucherThuHang));
    }



    @Override
    public VoucherThuHangResponse update(UpdateVoucherThuHangRequest updateVouCherThuHangRequest) {
        VoucherThuHang voucherThuHang = voucherThuHangMapper.updateVoucherThuHangRequestToVoucherThuHangEntity(updateVouCherThuHangRequest);
        voucherThuHang.setNgayCapNhat(LocalDateTime.now());
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime startTime = voucherThuHang.getNgayBatDau();
        if (currentTime.isBefore(startTime)){
            voucherThuHang.setTrangThai(ApplicationConstant.TrangThaiVoucher.PENDING);
        }else {
            voucherThuHang.setTrangThai(ApplicationConstant.TrangThaiVoucher.ACTIVE);
        }

        voucherThuHang.setNgayCapNhat(LocalDateTime.now());
        return voucherThuHangMapper.voucherThuHangEntityToVoucherThuHangResponse(voucherThuHangRepository.save(voucherThuHang));
    }

    @Override
    public VoucherThuHangResponse getOne(Integer id) {
        Optional<VoucherThuHang> voucherThuHangOptional = voucherThuHangRepository.findById(id);
        return voucherThuHangMapper.voucherThuHangEntityToVoucherThuHangResponse(voucherThuHangOptional.get());
    }

    @Override
    public Page<VoucherThuHangResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<VoucherThuHang> voucherThuHangPage = voucherThuHangRepository.pageSearchActive(searchName, pageable);
        return voucherThuHangPage.map(voucherThuHangMapper::voucherThuHangEntityToVoucherThuHangResponse);
    }

    @Override
    public Page<VoucherThuHangResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<VoucherThuHang> voucherThuHangPage = voucherThuHangRepository.pageSearchIvActive(searchName, pageable);
        return voucherThuHangPage.map(voucherThuHangMapper::voucherThuHangEntityToVoucherThuHangResponse);
    }

    @Override
    public void deleteVoucherThuHang(Integer id, LocalDateTime now) {
        voucherThuHangRepository.delete(id, LocalDateTime.now());
    }

    @Override
    public void revertVoucherThuHang(Integer id, LocalDateTime now) {
        voucherThuHangRepository.revert(id, LocalDateTime.now());
    }

    @Override
    public VoucherThuHang findById(Integer voucherId) {
        return this.voucherThuHangRepository.getOne(voucherId);
    }
}
