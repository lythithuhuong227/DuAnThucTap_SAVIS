package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.LoaiSanPham;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateLoaiSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateLoaiSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.response.LoaiSanPhamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoaiSanPhamMapper {

    LoaiSanPham loaiSanPhamResponseToLoaiSanPhamEntity(LoaiSanPhamResponse loaiSanPhamResponse);

    LoaiSanPhamResponse loaiSanPhamEntityToLoaiSanPhamResponse(LoaiSanPham loaiSanPham);

    LoaiSanPham createLoaiSanPhamRequestToLoaiSanPhamEntity(CreateLoaiSanPhamRequest createLoaiSanPhamRequest);

    LoaiSanPham updateLoaiSanPhamRequestToLoaiSanPhamEntity(UpdateLoaiSanPhamRequest updateLoaiSanPhamRequest);

    List<LoaiSanPhamResponse> listLoaiSanPhamEntityToLoaiSanPhamResponses(List<LoaiSanPham> loaiSanPhamList);
}
