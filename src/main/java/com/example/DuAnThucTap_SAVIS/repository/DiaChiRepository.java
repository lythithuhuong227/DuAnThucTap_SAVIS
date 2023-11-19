package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.DiaChi;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi,Integer> {
    @Query(value = "SELECT * FROM dia_chi WHERE ho_ten LIKE %?1% OR sdt LIKE %?1% and trang_thai='ACTIVE' ", nativeQuery = true)
    Page<DiaChi> pageSearchActive(String searchString, Pageable pageable);
    @Query(value = "SELECT * FROM dia_chi WHERE ho_ten LIKE %?1% OR sdt LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<DiaChi> pageSearchIvActive(String searchString, Pageable pageable);

//    @Query(value = "", nativeQuery = true)

    @Query(value = "SELECT * FROM dia_chi WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<DiaChi> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM dia_chi WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<DiaChi> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE DiaChi m SET m.trangThai = 'INACTIVE', m.ngayCapNhap = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update DiaChi m set m.trangThai = 'ACTIVE', m.ngayCapNhap= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);
}
