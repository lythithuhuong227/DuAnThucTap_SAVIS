package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.model.mapper.ChiTietSanPhamMapper;
import com.example.DuAnThucTap_SAVIS.model.mapper.SanPhamMapper;
import com.example.DuAnThucTap_SAVIS.model.response.ChiTietSanPhamResponse;
import com.example.DuAnThucTap_SAVIS.model.response.SanPhamResponse;
import com.example.DuAnThucTap_SAVIS.repository.ChiTietSanPhamRepository;
import com.example.DuAnThucTap_SAVIS.repository.SanPhamRepository;
import com.example.DuAnThucTap_SAVIS.service.TrangChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrangChuServiceImpl implements TrangChuService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private ChiTietSanPhamMapper chiTietSanPhamMapper;

    @Override
    public List<SanPhamResponse> danhSachSanPhamCauThu(Integer id) {
        return sanPhamMapper.listSanPhamEntityToSanPhamResponse(sanPhamRepository.danhSachSanPhamCauThu(id));
    }

    @Override
    public List<ChiTietSanPhamResponse> getChiTietSanPhamBySanPham(Integer idSP)  {
        return chiTietSanPhamMapper.listchiTietSanPhamEntityTochiTietSanPhamResponse(chiTietSanPhamRepository.getChiTietSanPhamBySanPham(sanPhamRepository.findById(idSP).get()));

    }


//    @Override
//    public List<AnhSanPham> pageCauThu() {
//        return trangChuRepository.danhSachCauThuHienThi();
//    }

//    @Override
//    public List<AnhSanPham> getAnhSanPhamBySanPham(SanPham sanPham) {
//        return null;
//    }
}
