package com.example.DuAnThucTap_SAVIS.model.response;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.LoaiGiaoDich;
import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiGiaoDich;
import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.HinhThucThanhToan;
import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
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
public class GiaoDichResponse {
    private Integer id;
    private HoaDon hoaDon;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    @Enumerated(EnumType.STRING)
    private TrangThaiGiaoDich trangThaiGiaoDich;
    @Enumerated(EnumType.STRING)
    private HinhThucThanhToan phuongThucThanhToan;
    private LocalDate ngayTao;
    private BigDecimal soTienChuyenKhoan;
    private BigDecimal soTienMat;
    private LocalDate ngayCapNhat;
    @Enumerated(EnumType.STRING)
    private LoaiGiaoDich loaiGiaoDich;
}
