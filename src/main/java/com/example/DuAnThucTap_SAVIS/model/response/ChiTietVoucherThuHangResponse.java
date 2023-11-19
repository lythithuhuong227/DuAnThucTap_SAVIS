package com.example.DuAnThucTap_SAVIS.model.response;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiVoucher;
import com.example.DuAnThucTap_SAVIS.entity.ThuHang;
import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;
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
public class ChiTietVoucherThuHangResponse {
    private Integer id;
    private ThuHang thuHang;
    private VoucherThuHang voucherThuHang;
    private Integer soLuong;
    @Enumerated(EnumType.STRING)
    private TrangThaiVoucher trangThai;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
}
