package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.HinhThucThanhToan;
import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.LoaiGiaoDich;
import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiGiaoDich;
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
public class UpdateGiaoDichRequest {

    private Integer id;

//    @NotNull(message = "Hóa đơn không để trống")
    private HoaDon hoaDon;

//    @NotNull(message = "Khách hàng không để trống")
    private KhachHang khachHang;

//    @NotNull(message = "Nhân viên không để trống")
    private NhanVien nhanVien;

    @Enumerated(EnumType.STRING)
    private TrangThaiGiaoDich trangThaiGiaoDich;

    @Enumerated(EnumType.STRING)
    private HinhThucThanhToan phuongThucThanhToan;

    private BigDecimal soTienChuyenKhoan;

    private BigDecimal soTienMat;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;

    @Enumerated(EnumType.STRING)
    private LoaiGiaoDich loaiGiaoDich;
}
