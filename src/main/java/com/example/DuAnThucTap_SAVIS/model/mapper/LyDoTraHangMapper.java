package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.LyDoTraHang;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateLyDoTraHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateLyDoTraHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.LyDoTraHangResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LyDoTraHangMapper {

    LyDoTraHang lyDoTraHangResponseToLyDoTraHangEntity(LyDoTraHangResponse lyDoTraHangResponse);

    LyDoTraHangResponse lyDoTraHangEntityToLyDoTraHangResponse(LyDoTraHang lyDoTraHang);

    LyDoTraHang createLyDoTraHangRequestToLyDoTraHangEntity(CreateLyDoTraHangRequest createLyDoTraHangRequest);

    LyDoTraHang updateLyDoTraHangRequestToLyDoTraHangEntity(UpdateLyDoTraHangRequest updateLyDoTraHangRequest);

    List<LyDoTraHangResponse> listLyDoTraHangEntityToLyDoTraHangResponses(List<LyDoTraHang> lyDoTraHangList);

}
