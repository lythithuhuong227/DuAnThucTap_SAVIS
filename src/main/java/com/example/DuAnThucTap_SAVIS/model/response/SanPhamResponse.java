package com.example.DuAnThucTap_SAVIS.model.response;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SanPhamResponse {
    private Integer id;
    private MauSac mauSac;
    private LoaiSanPham loaiSanPham;
    private ChatLieu chatLieu;
    private DongSanPham dongSanPham;
    private CauThu cauThu;
    private NhaSanXuat nhaSanXuat;
    private ThuongHieu thuongHieu;
    private NuocSanXuat nuocSanXuat;
    private CongNghe congNghe;
    private CoAo coAo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate namSanXuat;
    private String ma;
    private String ten;
    private BigDecimal gia;
    private String moTa;
    private String maVach;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
    @Enumerated(EnumType.STRING)
    private TrangThaiTaiKhoan trangThai;
}
