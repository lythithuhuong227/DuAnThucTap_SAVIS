package com.example.DuAnThucTap_SAVIS.repository;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.entity.ThuHang;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ThuHangRepository extends JpaRepository<ThuHang, Integer> {

    @Query(value = "select max(th.id) from ThuHang th")
    Integer findMaxId();

    @Query(value = "SELECT * FROM thu_hang WHERE (ten LIKE %?1% OR ma LIKE %?1%) AND trang_thai='ACTIVE'", nativeQuery = true)
    Page<ThuHang> pageSearchActive(String searchString, org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE (so_luong_don_hang_toi_thieu LIKE %?1% OR so_tien_khach_chi_toi_thieu LIKE %?1%) AND trang_thai='ACTIVE'", nativeQuery = true)
    Page<ThuHang> pageSoLuongDonHangToiThieuPageActive(Integer search, Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE (so_luong_don_hang_toi_thieu LIKE %?1% OR so_tien_khach_chi_toi_thieu LIKE %?1%) AND trang_thai='ACTIVE'", nativeQuery = true)
    Page<ThuHang> pageSoLuongDonHangToiThieuPageInActive(Integer search, Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE (ten LIKE %?1% OR ma LIKE %?1%) AND trang_thai='INACTIVE'", nativeQuery = true)
    Page<ThuHang> pageSearchInActive(String searchString, org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE (so_luong_don_hang_toi_thieu LIKE %?1% OR so_tien_khach_chi_toi_thieu LIKE %?1%) AND trang_thai='INACTIVE'", nativeQuery = true)
    Page<ThuHang> pageSearchSoLuongDonHangOrSoTienInActive(String searchString, org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE trang_thai='INACTIVE' ", nativeQuery = true)
    Page<ThuHang> pageINACTIVE(org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT * FROM thu_hang WHERE trang_thai='ACTIVE' ", nativeQuery = true)
    Page<ThuHang> pageACTIVE(Pageable pageable);

    boolean existsByTenAndTrangThai(@Param("ten") String ten, @Param("trangThai") ApplicationConstant.TrangThaiThuHang trangThai);

    @Query("SELECT th FROM ThuHang th WHERE th.trangThai = 'ACTIVE' AND th.soTienKhachChiToiThieu BETWEEN :minAmount AND :maxAmount")
    Page<ThuHang> findBySoTienKhachChiToiThieuInRange(BigDecimal minAmount, BigDecimal maxAmount, Pageable pageable);

    @Query("SELECT th FROM ThuHang th WHERE th.trangThai = 'ACTIVE' AND th.soLuongDonHangToiThieu BETWEEN :minAmount AND :maxAmount")
    Page<ThuHang> findBySoLuongDonHangToiThieuInRange(Integer minAmount, Integer maxAmount, Pageable pageable);

    @Query("SELECT th FROM ThuHang th WHERE th.trangThai = 'INACTIVE' AND th.soTienKhachChiToiThieu BETWEEN :minAmount AND :maxAmount")
    Page<ThuHang> findBySoTienKhachChiToiThieuInRangeInActive(BigDecimal minAmount, BigDecimal maxAmount, Pageable pageable);

    @Query("SELECT th FROM ThuHang th WHERE th.trangThai = 'INACTIVE' AND th.soLuongDonHangToiThieu BETWEEN :minAmount AND :maxAmount")
    Page<ThuHang> findBySoLuongDonHangToiThieuInRangeInActive(Integer minAmount, Integer maxAmount, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ThuHang m SET m.trangThai = 'INACTIVE', m.ngayCapNhat = :now WHERE m.id = :id")
    void delete(@Param("id") Integer id, @Param("now") LocalDate now);

    @Transactional
    @Modifying
    @Query(value = "update ThuHang m set m.trangThai = 'ACTIVE', m.ngayCapNhat= :now where m.id = :id")
    void revert(@Param("id") Integer id, @Param("now") LocalDate now);

    ThuHang findByTen(String ten);

    List<ThuHang> findAllBySoTienKhachChiToiThieuLessThanEqualAndSoLuongDonHangToiThieuLessThanEqual(BigDecimal soTienDaChi, Integer soLuongDonHangThanhCong);

    @Query(value = "select c.soLuongDonHangToiThieu, c.soTienKhachChiToiThieu from ThuHang c where c.id=?1 and c.trangThai ='ACTIVE'")
    ThuHang selectSoLuongVaTien(Integer id);

    @Query(value = "select c from  ThuHang c where c.trangThai ='ACTIVE'")
    List<ThuHang> findAllByActive();

}
