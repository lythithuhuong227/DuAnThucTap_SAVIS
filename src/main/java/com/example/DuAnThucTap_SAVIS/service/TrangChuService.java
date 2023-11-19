package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.response.ChiTietSanPhamResponse;
import com.example.DuAnThucTap_SAVIS.model.response.SanPhamResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TrangChuService {
//    List<AnhSanPham> pageCauThu();
//    List<AnhSanPham> getAnhSanPhamBySanPham(SanPham sanPham);
List<SanPhamResponse> danhSachSanPhamCauThu(Integer id) ;
List<ChiTietSanPhamResponse> getChiTietSanPhamBySanPham(Integer idSP) ;
}
