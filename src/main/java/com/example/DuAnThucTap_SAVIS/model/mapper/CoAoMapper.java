package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.CoAo;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CoAoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoAoMapper {

    CoAo coAoResponseToCoAoEntity(CoAoResponse coAoResponse);

    CoAoResponse coAoEntityToCoAoResponse(CoAo coAo);

    CoAo createCoAoRequestToCoAoEntity(CreateCoAoRequest createCoAoRequest);

    CoAo updateCoAoRequestToCoAoEntity(UpdateCoAoRequest updateCoAoRequest);

    List<CoAoResponse> listCoAoEntityToCoAoResponse(List<CoAo> coAoList);
}
