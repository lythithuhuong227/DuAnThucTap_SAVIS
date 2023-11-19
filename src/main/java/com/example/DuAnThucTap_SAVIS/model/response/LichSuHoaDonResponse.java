package com.example.DuAnThucTap_SAVIS.model.response;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant.LoaiLichSuHoaDon;
import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
import com.example.DuAnThucTap_SAVIS.entity.NhanVien;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LichSuHoaDonResponse {
    private Integer Id;
    private NhanVien nhanVien;
    private HoaDon hoaDon;
    private LocalDateTime ngayTao;
    private String moTa;
    @Enumerated(EnumType.STRING)
    private LoaiLichSuHoaDon loaiLichSuHoaDon;
}
