package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.CauThu;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCauThuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCauThuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CauThuResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CauThuMapper {

    CauThu cauThuResponseToCauThuEntity(CauThuResponse cauThuResponse);

    CauThuResponse cauThuEntityToCauThuResponse(CauThu cauThu);

    CauThu createCauThuRequestToCauThuEntity(CreateCauThuRequest createCauThuRequest);

    CauThu updateCauThuRequestToCauThuEntity(UpdateCauThuRequest updateCauThuRequest);

    List<CauThuResponse> listCauThuEntityToCauThuResponse(List<CauThu> cauThuList);
}
