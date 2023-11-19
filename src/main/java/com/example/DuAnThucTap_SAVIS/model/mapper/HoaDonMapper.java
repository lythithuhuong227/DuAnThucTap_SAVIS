package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.HoaDon;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateHoaDonRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateHoaDonRequest;
import com.example.DuAnThucTap_SAVIS.model.response.HoaDonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HoaDonMapper {
    HoaDon hoaDonResponseToHoaDonEntity(HoaDonResponse hoaDonResponse);

    HoaDonResponse hoaDonEntityToHoaDonResponse(HoaDon hoaDon);

    HoaDon createHoaDonRequestToHoaDonEntity(CreateHoaDonRequest createHoaDonRequest);

    HoaDon updateHoaDonRequestToHoaDonEntity(UpdateHoaDonRequest updateHoaDonRequest);

    List<HoaDonResponse> listHoaDonEntityToHoaDonResponse(List<HoaDon> listHoaDon);
}
