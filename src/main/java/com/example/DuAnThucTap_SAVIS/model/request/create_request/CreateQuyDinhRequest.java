package com.example.DuAnThucTap_SAVIS.model.request.create_request;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.TrangThaiQuyDinh;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateQuyDinhRequest {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private TrangThaiQuyDinh trangThai;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;


    @Future(message = "Không được chọn ngày quá khứ")
    @NotNull(message = "Ngày đặt lại không để trống")
    private LocalDateTime ngayDatLaiThuHang;
}
