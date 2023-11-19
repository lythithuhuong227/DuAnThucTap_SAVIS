package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.GiaoDich;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateGiaoDichRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateGiaoDichRequest;
import com.example.DuAnThucTap_SAVIS.model.response.GiaoDichResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GiaoDichMapper {
    GiaoDich giaoDichResponseToGiaoDichEntity(GiaoDichResponse giaoDichResponse);

    GiaoDichResponse giaoDichEntityToGiaoDichResponse(GiaoDich giaoDich);

    GiaoDich createGiaoDichRequestToGiaoDichEntity(CreateGiaoDichRequest createGiaoDichRequest);

    GiaoDich updateGiaoDichRequestToGiaoDichEntity(UpdateGiaoDichRequest updateGiaoDichRequest);

    List<GiaoDichResponse> listGiaoDichEntityToGiaoDichResponse(List<GiaoDich> listGiaoDich);
}
