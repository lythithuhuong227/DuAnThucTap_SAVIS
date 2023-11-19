package com.example.DuAnThucTap_SAVIS.model.request.update_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiVoucher;
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
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UpdateVoucherThuHangRequest {

    private Integer id;
    @NotBlank(message = "Ma không để trống")
    @Size(min = 0, max = 50, message = "Tên không vượt quá 50 ký tự")
    private String ma;

    @NotBlank(message = "Tên không để trống")
    @Size(min = 0, max = 45, message = "Tên không vượt quá 45 ký tự")
    private String ten;
    @NotNull(message = "Số tiền giảm không để trống")
    @Min(value = 1, message = "Số tiền giảm là số nguyên và lớn hơn 0")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,###.## VND")
    private BigDecimal soTienGiam;

    @NotNull(message = "Ngày bắt đầu không để trống")
    private LocalDateTime ngayBatDau;

    @NotNull(message = "Ngày kết thúc không để trống")
    private LocalDateTime ngayKetThuc;

    @NotNull(message = "Giá trị đơn hàng tối thiểu không để trống")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,###.## VND")
    private BigDecimal giaTriDonHangToiThieu;

    @NotBlank(message = "Mô tả không để trống")
    @Size(min = 0, max = 225, message = "Mô tả không vượt quá 225 ký tự")
    private String moTa;

    private LocalDateTime ngayTao;

    private LocalDateTime ngayCapNhat;

    @Enumerated(EnumType.STRING)
    private TrangThaiVoucher trangThai;
}
