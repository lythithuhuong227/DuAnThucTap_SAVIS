package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.HoaDonChiTiet;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateHoaDonChiTietRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateHoaDonChiTietRequest;
import com.example.DuAnThucTap_SAVIS.model.response.HoaDonChiTietResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HoaDonChiTietMapper {
    HoaDonChiTiet hoaDonChiTietResponseToHoaDonChiTietEntity(HoaDonChiTietResponse hoaDonChiTietResponse);

    HoaDonChiTietResponse hoaDonChiTietEntityToHoaDonChiTietResponse(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet createHoaDonChiTietRequestToHoaDonChiTietEntity(CreateHoaDonChiTietRequest createHoaDonChiTietRequest);

    HoaDonChiTiet updateHoaDonChiTietRequestToHoaDonChiTietEntity(UpdateHoaDonChiTietRequest updateHoaDonChiTietRequest);

    List<HoaDonChiTietResponse> listHoaDonChiTietEntityToHoaDonChiTietResponse(List<HoaDonChiTiet> listHoaDonChiTiet);
}
