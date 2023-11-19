package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.entity.KichThuoc;
import com.example.DuAnThucTap_SAVIS.entity.SanPham;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

public class UpdateChiTietSanPhamRequest {

    private Integer id;

    @NotNull(message = "Kích thước không để trống")
    private KichThuoc kichThuoc;

    @NotNull(message = "Sản phẩm không để trống")
    private SanPham sanPham;

    @NotNull(message = "Số lượng không để trống")
    @Min(value = 1, message = "Số lượng là số nguyên")
    private Integer soLuong;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;

    @Enumerated(EnumType.STRING)
    private ApplicationConstant.TrangThaiChiTietSanPham trangThai;
}
