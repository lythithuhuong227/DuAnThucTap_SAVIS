package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.KichThuoc;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateKichThuocRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateKichThuocRequest;
import com.example.DuAnThucTap_SAVIS.model.response.KichThuocResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KichThuocMapper {

    KichThuoc kichThuocResponseToKichThuocEntity(KichThuocResponse kichThuocResponse);

    KichThuocResponse kichThuocEntityToKichThuocResponse(KichThuoc kichThuoc);

    KichThuoc createKichThuocRequestToKichThuocEntity(CreateKichThuocRequest createKichThuocRequest);

    KichThuoc updateKichThuocRequestToKichThuocEntity(UpdateKichThuocRequest updateKichThuocRequest);

    List<KichThuocResponse> listKichThuocEntityToKichThuocResponses(List<KichThuoc> kichThuocList);
}
