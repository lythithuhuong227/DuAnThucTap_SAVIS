package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.ChiTietSanPham;
import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
import com.example.DuAnThucTap_SAVIS.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet,Integer> {

    List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon);

    HoaDonChiTiet findHoaDonChiTietByHoaDonAndChiTietSanPham(HoaDon hoaDon, ChiTietSanPham chiTietSanPham);


}
