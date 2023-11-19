package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.KhachHang;
import com.example.DuAnThucTap_SAVIS.entity.ViVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViVoucherRepository extends JpaRepository<ViVoucher,Integer> {

    List<ViVoucher> getViVouchersByKhachHang(KhachHang khachHang);
}
