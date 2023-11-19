package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.GiaoDich;
import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, Integer> {
    List<GiaoDich> getGiaoDichByHoaDon(HoaDon hoaDon);
}
