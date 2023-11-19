package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.KichThuoc;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    @Query(value = "SELECT * FROM kich_thuoc WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='ACTIVE' ", nativeQuery = true)
    Page<KichThuoc> pageSearchActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM kich_thuoc WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    List<KichThuoc> getAll();

    @Query(value = "SELECT * FROM kich_thuoc WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<KichThuoc> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM kich_thuoc WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<KichThuoc> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM kich_thuoc WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<KichThuoc> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE KichThuoc m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update KichThuoc m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);
}
