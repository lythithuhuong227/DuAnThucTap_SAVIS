package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.SanPham;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.response.SanPhamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SanPhamMapper {

    SanPham sanPhamResponseToSanPhamEntity(SanPhamResponse sanPhamResponse);

    SanPhamResponse sanPhamEntityToSanPhamResponse(SanPham sanPham);

    SanPham createSanPhamRequestToSanPhamEntity(CreateSanPhamRequest createSanPhamRequest);

    SanPham updateSanPhamRequestToSanPhamEntity(UpdateSanPhamRequest updateSanPhamRequest);

    List<SanPhamResponse> listSanPhamEntityToSanPhamResponse(List<SanPham> sanPhamList);
}
