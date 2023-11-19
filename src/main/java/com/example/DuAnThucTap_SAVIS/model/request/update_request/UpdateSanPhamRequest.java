package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiTaiKhoan;
import com.example.DuAnThucTap_SAVIS.entity.CauThu;
import com.example.DuAnThucTap_SAVIS.entity.ChatLieu;
import com.example.DuAnThucTap_SAVIS.entity.CoAo;
import com.example.DuAnThucTap_SAVIS.entity.CongNghe;
import com.example.DuAnThucTap_SAVIS.entity.DongSanPham;
import com.example.DuAnThucTap_SAVIS.entity.LoaiSanPham;
import com.example.DuAnThucTap_SAVIS.entity.MauSac;
import com.example.DuAnThucTap_SAVIS.entity.NhaSanXuat;
import com.example.DuAnThucTap_SAVIS.entity.NuocSanXuat;
import com.example.DuAnThucTap_SAVIS.entity.ThuongHieu;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class UpdateSanPhamRequest {

    private Integer id;

    @NotNull(message = "Màu sắc không để trống")
    private MauSac mauSac;

    @NotNull(message = "Loại sản phẩm không để trống")
    private LoaiSanPham loaiSanPham;

    @NotNull(message = "Chất liệu không để trống")
    private ChatLieu chatLieu;

    @NotNull(message = "Dòng sản phẩm không để trống")
    private DongSanPham dongSanPham;

    @NotNull(message = "Cầu thủ không để trống")
    private CauThu cauThu;

    @NotNull(message = "Nhà sản xuất không để trống")
    private NhaSanXuat nhaSanXuat;

    @NotNull(message = "Thương hiệu không để trống")
    private ThuongHieu thuongHieu;

    @NotNull(message = "Quốc gia sản xuất không để trống")
    private NuocSanXuat nuocSanXuat;

    @NotNull(message = "Công nghệ không để trống")
    private CongNghe congNghe;

    @NotNull(message = "Cổ áo không để trống")
    private CoAo coAo;

    @NotNull(message = "Năm sản xuất không để trống")
    private LocalDate namSanXuat;

    private String ma;

    @NotBlank(message = "Tên không để trống")
    @Size(min = 0, max = 45, message = "Tên không vượt quá 45 ký tự")
    private String ten;

    @NotNull(message = "Giá không để trống")
    @Min(value = 1, message = "Giá phải là số nguyên và lớn hơn 0")
    private BigDecimal gia;

    @NotBlank(message = "Mô tả không để trống")
    @Size(min = 0, max = 225, message = "Tên không vượt quá 225 ký tự")
    private String moTa;

    @NotBlank(message = "Mã vạch không để trống")
    @Size(min = 0, max = 45, message = "Mã vạch không vượt quá 45 ký tự")
    private String maVach;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;

    @Enumerated(EnumType.STRING)
    private TrangThaiTaiKhoan trangThai;
}
