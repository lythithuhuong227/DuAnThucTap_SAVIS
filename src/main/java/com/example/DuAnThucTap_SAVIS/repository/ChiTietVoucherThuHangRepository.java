package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.entity.ChiTietVoucherThuHang;
import com.example.DuAnThucTap_SAVIS.entity.ThuHang;
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
public interface ChiTietVoucherThuHangRepository extends JpaRepository<ChiTietVoucherThuHang,Integer> {

    @Query(value = "SELECT * FROM chi_tiet_voucher_thu_hang WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='ACTIVE' ", nativeQuery = true)
    Page<ChiTietVoucherThuHang> pageSearchActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM chi_tiet_voucher_thu_hang WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    List<ChiTietVoucherThuHang> getAll();

    @Query(value = "SELECT * FROM chi_tiet_voucher_thu_hang WHERE ten LIKE %?1% OR ma LIKE %?1% and trang_thai='INACTIVE' ", nativeQuery = true)
    Page<ChiTietVoucherThuHang> pageSearchIvActive(String searchString, Pageable pageable);

    @Query(value = "SELECT * FROM chi_tiet_voucher_thu_hang WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<ChiTietVoucherThuHang> pageINACTIVE(Pageable pageable);

    @Query(value = "SELECT * FROM chi_tiet_voucher_thu_hang WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<ChiTietVoucherThuHang> pageACTIVE(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ChiTietVoucherThuHang m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update ChiTietVoucherThuHang m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);

    @Query(value = "select c from ChiTietVoucherThuHang c where c.trangThai = 'PENDING'")
    List<ChiTietVoucherThuHang> getChiTietVoucherThuHangPending();

    @Query("SELECT ctvth FROM ChiTietVoucherThuHang ctvth " +
            "JOIN FETCH ctvth.thuHang th " +
            "WHERE th.id = (SELECT MAX(thh.id) FROM ThuHang thh)")
    List<ChiTietVoucherThuHang> findLatestChiTietVoucherThuHang();

    @Transactional
    @Modifying
    @Query("update ChiTietVoucherThuHang c set c.soLuong =?1, c.trangThai ='ACTIVE' WHERE c.trangThai = 'PENDING'")
    void updateSoLuongChiTietVoucherThuHang(Integer soLuong);

    @Query("select c from ChiTietVoucherThuHang c join fetch c.thuHang th where th.id = ?1")
    ChiTietVoucherThuHang getChiTietVoucherThuHangTheoId(Integer id);

    List<ChiTietVoucherThuHang> getChiTietVoucherThuHangByThuHang(ThuHang thuHang);

    @Query("SELECT c FROM ChiTietVoucherThuHang c JOIN FETCH c.voucherThuHang")
    List<ChiTietVoucherThuHang> findAllWithVoucher();

}
