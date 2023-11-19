package com.example.DuAnThucTap_SAVIS.model.request.create_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.HinhThucBanHang;
import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiHoaDon;
import com.example.DuAnThucTap_SAVIS.entity.KhachHang;
import com.example.DuAnThucTap_SAVIS.entity.NhanVien;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateHoaDonRequest {

    private Integer id;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String ma;
    private LocalDate ngayTao;
    private LocalDate ngayMuonNhan;
    private BigDecimal tienMatKhachTra;
    private BigDecimal tienKhachChuyenKhoan;
    private BigDecimal tienShip;
    private BigDecimal thanhTien;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdtNguoiNhan;
    private String sdtNguoiShip;
    private BigDecimal phieu_giam_gia;
    private Integer phanTramGiamGia;
    private String maGiaoDich;
    @Enumerated(EnumType.STRING)
    private HinhThucBanHang hinhThucBanHang;
    @Enumerated(EnumType.STRING)
    private TrangThaiHoaDon trangThai;
}
