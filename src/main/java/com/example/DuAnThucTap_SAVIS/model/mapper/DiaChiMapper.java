package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.DiaChi;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.response.DiaChiResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiaChiMapper {

    DiaChi diaChiResponseToDiaChiEntity(DiaChiResponse diaChiResponse);

    DiaChiResponse diaChiEntityToDiaChiResponse(DiaChi diaChi);

    DiaChi createDiaChiRequestToDiaChiEntity(CreateDiaChiRequest createDiaChiRequest);

    DiaChi updateDiaChiRequestToDiaChiEntity(UpdateDiaChiRequest updateDiaChiRequest);

    List<DiaChiResponse> listDiaChiEntityToDiaChiResponse(List<DiaChi> diaChiList);
}
