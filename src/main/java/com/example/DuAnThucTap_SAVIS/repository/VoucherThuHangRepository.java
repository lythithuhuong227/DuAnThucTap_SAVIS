package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VoucherThuHangRepository extends JpaRepository<VoucherThuHang,Integer> {

    @Query(value = "SELECT c from VoucherThuHang  c WHERE c.trangThai = 'ACTIVE'")
    List<VoucherThuHang> findByTrangThaiActive();
    @Query(value = "SELECT * FROM voucher_thu_hang WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='ACTIVE'  ", nativeQuery = true)
    Page<VoucherThuHang> pageSearchActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM voucher_thu_hang WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<VoucherThuHang> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM voucher_thu_hang WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<VoucherThuHang> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM voucher_thu_hang WHERE trang_thai='PENDING' ", nativeQuery = true)
    Page<VoucherThuHang> pagePENDING(Pageable pageable);

    @Query(value = "SELECT * FROM voucher_thu_hang WHERE trang_thai='ACTIVE'   ", nativeQuery = true)
    Page<VoucherThuHang> pageACTIVE(Pageable pageable);

    List<VoucherThuHang> findByNgayKetThucBeforeAndTrangThaiNot(LocalDateTime ngayKetThuc, ApplicationConstant.TrangThaiVoucher trangThai);

    List<VoucherThuHang> findByNgayBatDauIsBeforeAndTrangThai(LocalDateTime currentDateTime, ApplicationConstant.TrangThaiVoucher trangThai);

    @Transactional
    @Modifying
    @Query(value = "UPDATE VoucherThuHang m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDateTime now);


    @Transactional
    @Modifying
    @Query(value = "update VoucherThuHang m set m.trangThai = 'ACTIVE' , m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDateTime now);



}
