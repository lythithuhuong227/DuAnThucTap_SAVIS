package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.SanPham;
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
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {


    @Query(value = "SELECT * FROM san_pham WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='ACTIVE' ", nativeQuery = true)
    Page<SanPham> pageSearchActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM san_pham WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    List<SanPham> getAll();

    @Query(value = "SELECT * FROM san_pham WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<SanPham> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM san_pham WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<SanPham> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM san_pham WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<SanPham> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE SanPham m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update SanPham m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);


    @Transactional
    @Modifying
    @Query(value = "SELECT sp.* " +
            "FROM san_pham sp " +
            "JOIN cau_thu ct ON sp.cau_thu_id = ct.id " +
            "WHERE ct.id = :idCauThu",
            nativeQuery = true)
    List<SanPham> danhSachSanPhamCauThu(@Param("idCauThu") Integer idCauThu);


}

