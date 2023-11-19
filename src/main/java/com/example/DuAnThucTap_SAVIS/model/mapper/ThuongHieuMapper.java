package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ThuongHieu;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateThuongHieuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateThuongHieuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ThuongHieuResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThuongHieuMapper {

    ThuongHieu thuongHieuResponseToThuongHieuEntity(ThuongHieuResponse thuongHieuResponse);

    ThuongHieuResponse thuongHieuEntityToThuongHieuResponse(ThuongHieu thuongHieu);

    ThuongHieu createThuongHieuRequestToThuongHieuEntity(CreateThuongHieuRequest createThuongHieuRequest);

    ThuongHieu updateThuongHieuRequestToThuongHieuEntity(UpdateThuongHieuRequest updateThuongHieuRequest);

    List<ThuongHieuResponse> listThuongHieuEntityToThuongHieuResponse(List<ThuongHieu> thuongHieuList);
}
