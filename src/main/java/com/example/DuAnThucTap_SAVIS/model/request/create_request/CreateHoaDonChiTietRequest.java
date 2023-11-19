package com.example.DuAnThucTap_SAVIS.model.request.create_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiHoaDonChiTiet;
import com.example.DuAnThucTap_SAVIS.entity.ChiTietSanPham;
import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
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
public class CreateHoaDonChiTietRequest {

    private Integer id;
    private ChiTietSanPham chiTietSanPham;
    private HoaDon hoaDon;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal giaBan;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
    @Enumerated(EnumType.STRING)
    private TrangThaiHoaDonChiTiet trangThai;
}
