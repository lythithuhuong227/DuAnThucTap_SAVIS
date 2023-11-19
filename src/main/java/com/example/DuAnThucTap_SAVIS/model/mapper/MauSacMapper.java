package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.MauSac;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateMauSacRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateMauSacRequest;
import com.example.DuAnThucTap_SAVIS.model.response.MauSacResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MauSacMapper {

    MauSac mauSacResponseToMauSacEntity(MauSacResponse mauSacResponse);

    MauSacResponse mauSacEntityToMauSacResponse(MauSac mauSac);

    MauSac createMauSacRequestToMauSacEntity(CreateMauSacRequest createMauSacRequest);

    MauSac updateMauSacRequestToMauSacEntity(UpdateMauSacRequest updateMauSacRequest);

    List<MauSacResponse> listMauSacEntityToMauSacResponse(List<MauSac> mauSacList);
}
