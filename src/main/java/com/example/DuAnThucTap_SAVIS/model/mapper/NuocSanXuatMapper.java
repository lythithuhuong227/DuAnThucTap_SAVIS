package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.NuocSanXuat;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateNuocSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateNuocSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.response.NuocSanXuatResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NuocSanXuatMapper {

    NuocSanXuat nuocSanXuatResponseToNuocSanXuatEntity(NuocSanXuatResponse nuocSanXuatResponse);

    NuocSanXuatResponse nuocSanXuatEntityToNuocSanXuatResponse(NuocSanXuat nuocSanXuat);

    NuocSanXuat createNuocSanXuatRequestToNuocSanXuatEntity(CreateNuocSanXuatRequest createNuocSanXuatRequest);

    NuocSanXuat updateNuocSanXuatRequestToNuocSanXuatEntity(UpdateNuocSanXuatRequest updateNuocSanXuatRequest);

    List<NuocSanXuatResponse> listNuocSanXuatEntityToNuocSanXuatResponses(List<NuocSanXuat> nuocSanXuatList);
}
