package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.KhachHang;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateKhachHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateKhachHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.KhachHangResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KhachHangMapper {

    KhachHang khachHangResponseToTaiKhoanEntity(KhachHangResponse khachHangResponse);

    KhachHangResponse khachHangEntityToTaiKhoanResponse(KhachHang khachHang);
    KhachHang createKhachHangRequestToTaiKhoanEntity(CreateKhachHangRequest createKhachHangRequest);

    KhachHang updateKhachHangRequestToTaiKhoanEntity(UpdateKhachHangRequest updateKhachHangRequest);

    List<KhachHangResponse> listKhachHangEntityToKhachHangResponse(List<KhachHang> khachHangList);

}
