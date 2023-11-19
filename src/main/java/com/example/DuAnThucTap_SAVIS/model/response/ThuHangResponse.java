package com.example.DuAnThucTap_SAVIS.model.response;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
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
public class ThuHangResponse {

    private Integer id;

    private String ma;

    private String ten;

    private BigDecimal soTienKhachChiToiThieu;

    private Integer soLuongDonHangToiThieu;

    @Enumerated(EnumType.STRING)
    private ApplicationConstant.TrangThaiThuHang trangThai;

    private LocalDate ngayTao;

    private LocalDate ngayCapNhat;
}
