package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVoucherThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.VoucherThuHangResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherThuHangMapper {

    VoucherThuHang voucherThuHangResponseToVoucherThuHangEntity(VoucherThuHangResponse voucherThuHangResponse);

    VoucherThuHangResponse voucherThuHangEntityToVoucherThuHangResponse(VoucherThuHang voucherThuHang);

    VoucherThuHang createVoucherThuHangRequestToVoucherThuHangEntity(CreateVoucherThuHangRequest createVoucherThuHangRequest);

    VoucherThuHang updateVoucherThuHangRequestToVoucherThuHangEntity(UpdateVoucherThuHangRequest updateVoucherThuHangRequest);

    List<VoucherThuHangResponse> listVoucherThuHangEntityToVoucherThuHangResponse(List<VoucherThuHang> voucherThuHangList);
}
