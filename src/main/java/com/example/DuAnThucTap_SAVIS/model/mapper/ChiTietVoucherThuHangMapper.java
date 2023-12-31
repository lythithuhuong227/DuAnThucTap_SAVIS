package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ChiTietVoucherThuHang;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateChiTietVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateChiTietVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ChiTietVoucherThuHangResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChiTietVoucherThuHangMapper {

    ChiTietVoucherThuHang chiTietVoucherThuHangResponseToChiTietVoucherThuHangEntity(ChiTietVoucherThuHangResponse chiTietVoucherThuHangResponse);

    ChiTietVoucherThuHangResponse chiTietVoucherThuHangEntityToChiTietVoucherThuHangResponse(ChiTietVoucherThuHang chiTietVoucherThuHang);

    ChiTietVoucherThuHang createChiTietVoucherThuHangRequestToChiTietVouCherThuHangEntity(CreateChiTietVoucherThuHangRequest createChiTietVoucherThuHangRequest);

    ChiTietVoucherThuHang updateChiTietVoucherThuHangRequestToChiTietVouCherThuHangEntity(UpdateChiTietVoucherThuHangRequest updateChiTietVoucherThuHangRequest);

    List<ChiTietVoucherThuHangResponse> listChiTietVoucherThuHangEntityToChiTietVoucherThuHangResponse(List<ChiTietVoucherThuHang> chiTietVoucherThuHangList);
}
