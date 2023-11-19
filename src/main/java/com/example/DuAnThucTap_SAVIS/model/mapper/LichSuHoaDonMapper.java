package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.LichSuHoaDon;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateLichSuHoaDonRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateLichSuHoaDonRequest;
import com.example.DuAnThucTap_SAVIS.model.response.LichSuHoaDonResponse;

import java.util.List;

public interface LichSuHoaDonMapper {
    LichSuHoaDon lichSuHoaDonResponseToLichSuHoaDonEntity(LichSuHoaDonResponse lichSuHoaDonResponse);

    LichSuHoaDonResponse lichSuHoaDonEntityToLichSuHoaDonResponse(LichSuHoaDon lichSuHoaDon);

    LichSuHoaDon createLichSuHoaDonRequestToLichSuHoaDonEntity(CreateLichSuHoaDonRequest createLichSuHoaDonRequest);

    LichSuHoaDon updateLichSuHoaDonRequestToLichSuHoaDonEntity(UpdateLichSuHoaDonRequest updateLichSuHoaDonRequest);

    List<LichSuHoaDonResponse> listLichSuHoaDonEntityToLichSuHoaDonResponse(List<LichSuHoaDon> lichSuHoaDonList);
}
