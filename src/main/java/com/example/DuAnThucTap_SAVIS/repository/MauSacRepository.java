package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.MauSac;
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
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

    @Query(value = "SELECT * FROM mau_sac WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='ACTIVE' ", nativeQuery = true)
    Page<MauSac> pageSearchActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM mau_sac WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    List<MauSac> getAll();

    @Query(value = "SELECT * FROM mau_sac WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<MauSac> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM mau_sac WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<MauSac> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM mau_sac WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<MauSac> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE MauSac m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update MauSac m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);
}
