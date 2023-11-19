package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.CongNghe;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCongNgheRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCongNgheRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CongNgheResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CongNgheMapper {

    CongNghe congNgheResponseToCongNgheEntity(CongNgheResponse congNgheResponse);

    CongNgheResponse congNgheEntityToCongNgheResponse(CongNghe congNghe);

    CongNghe createCongNgheRequestToCongNgheEntity(CreateCongNgheRequest createCongNgheRequest);

    CongNghe updateCongNgheRequestToCongNgheEntity(UpdateCongNgheRequest updateCongNgheRequest);

    List<CongNgheResponse> listCongNgheEntityToCongNgheResponses(List<CongNghe> congNgheList);
}
