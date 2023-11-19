package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.VaiTro;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.response.VaiTroResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaiTroMapper {

    VaiTro vaiTroResponseToVaiTroEntity(VaiTroResponse vaiTroResponse);

    VaiTroResponse vaiTroEntityToVaiTroResponse(VaiTro vaiTro);

    VaiTro createVaiTroRequestToVaiTroEntity(CreateVaiTroRequest createVaiTroRequest);

    VaiTro updateVaiTroRequestToVaiTroEntity(UpdateVaiTroRequest updateVaiTroRequest);

    List<VaiTroResponse> listVaiTroEntityToVaiTroResponse(List<VaiTro> vaiTroList);
}
