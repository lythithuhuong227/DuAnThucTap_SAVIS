package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiGioHangChiTiet;
import com.example.DuAnThucTap_SAVIS.entity.ChiTietSanPham;
import com.example.DuAnThucTap_SAVIS.entity.KhachHang;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UpdateGioHangChiTietRequest {
    private Integer id;
    private ChiTietSanPham chiTietSanPham;
    private KhachHang khachHang;
    private Integer soLuong;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
    @Enumerated(EnumType.STRING)
    private TrangThaiGioHangChiTiet trangThai;
}
