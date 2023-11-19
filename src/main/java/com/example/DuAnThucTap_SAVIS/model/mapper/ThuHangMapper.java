package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ThuHang;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateThuHangRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ThuHangResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThuHangMapper {

    ThuHang thuHangResponseToThuHangEntity(ThuHangResponse thuHangResponse);

    ThuHangResponse thuHangEntiyToThuHangResponse(ThuHang thuHang);

    ThuHang createThuHangRequestToThuHangEntity(CreateThuHangRequest createThuHangRequest);

    ThuHang updateThuHangRequestToThuHangEntity(UpdateThuHangRequest updateThuHangRequest);

    List<ThuHangResponse> listThuHangEntityToThuHangResponse(List<ThuHang> thuHangMapperList);
}
