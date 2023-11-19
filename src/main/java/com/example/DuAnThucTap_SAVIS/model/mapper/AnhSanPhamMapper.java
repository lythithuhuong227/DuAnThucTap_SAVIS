package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.AnhSanPham;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateAnhSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateAnhSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.response.AnhSanPhamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnhSanPhamMapper {

    AnhSanPham anhSanPhamResponeToAnhSanPhamEntity(AnhSanPhamResponse anhSanPhamResponse);

    AnhSanPhamResponse anhSanPhamEntityToAnhSanPhamResponse(AnhSanPham anhSanPham);

    AnhSanPham createAnhSanPhamRequestToAnhSanPhamEntity(CreateAnhSanPhamRequest createAnhSanPhamRequest);

    AnhSanPham updateAnhSanPhamRequestToAnhSanPhamEntity(UpdateAnhSanPhamRequest updateAnhSanPhamRequest);

    List<AnhSanPhamResponse> listAnhSanPhamEntityToAnhSanPhamResponse(List<AnhSanPham> anhSanPhamList);
}
