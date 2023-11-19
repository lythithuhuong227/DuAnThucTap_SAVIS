package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiSanPham;
import com.example.DuAnThucTap_SAVIS.entity.SanPham;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UpdateAnhSanPhamRequest {

    private Integer id;

    @NotNull(message = "Sản phẩm không để trống")
    private SanPham sanPham;

    @Lob
    @NotBlank(message = "Tên ảnh không để trống")
    private Blob ten;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;

    @Enumerated(EnumType.STRING)
    private TrangThaiSanPham trangThai;
}
