package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.NhaSanXuat;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateNhaSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateNhaSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.response.NhaSanXuatResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhaSanXuatMapper {

    NhaSanXuat nhaSanXuatResponseToNhaSanXuatEntity(NhaSanXuatResponse nhaSanXuatResponse);

    NhaSanXuatResponse nhaSanXuatEntityToNhaSanXuatResponse(NhaSanXuat nhaSanXuat);

    NhaSanXuat createNhaSanXuatRequestToNhaSanXuatEntity(CreateNhaSanXuatRequest createNhaSanXuatRequest);

    NhaSanXuat updateNhaSanXuatRequestToNhaSanXuatEntity(UpdateNhaSanXuatRequest updateNhaSanXuatRequest);

    List<NhaSanXuatResponse> listNhaSanXuatEntityToNhaSanXuatRespnse(List<NhaSanXuat> nhaSanXuatList);
}
