package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.ChiTietSanPham;
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
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, Integer> {



    List<ChiTietSanPham> getChiTietSanPhamBySanPham(SanPham sanPham);

//    @Query(value = "SELECT ctsp.*, sp.ten AS sanPhamTen FROM chi_tiet_san_pham ctsp JOIN san_pham sp ON tk.vai_tro_id = vt.id WHERE ctsp.trang_thai = 'ACTIVE' AND sp.ten like %?1% ", nativeQuery = true)
//    Page<ChiTietSanPham> pageSearchActive(String searchString, Pageable pageable);


    @Query(value = "SELECT * FROM chi_tiet_san_pham WHERE trang_thai='ACTIVE'", nativeQuery = true)
    List<ChiTietSanPham> getAll();

    @Query(value = "SELECT * FROM chi_tiet_san_pham WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<ChiTietSanPham> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM chi_tiet_san_pham WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<ChiTietSanPham> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM chi_tiet_san_pham WHERE trang_thai='PENDING' ", nativeQuery = true)
    List<ChiTietSanPham> getAllPending();



    @Query(value = "SELECT * FROM chi_tiet_san_pham WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<ChiTietSanPham> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ChiTietSanPham m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void deleteChiTietSanPhamUpdate(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update ChiTietSanPham m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query("UPDATE ChiTietSanPham c SET c.trangThai = 'ACTIVE' WHERE c.trangThai = 'PENDING'")
    void updatePendingToActive();
}
