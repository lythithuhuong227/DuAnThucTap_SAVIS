package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ChiTietSanPham;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateChiTietSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateChiTietSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ChiTietSanPhamResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChiTietSanPhamMapper {
    
    ChiTietSanPham chiTietSanPhamResponseTochiTietSanPhamEntity(ChiTietSanPhamResponse chiTietSanPhamResponse);
    
    ChiTietSanPhamResponse chiTietSanPhamEntityTochiTietSanPhamResponse(ChiTietSanPham chiTietSanPham);
    
    ChiTietSanPham createChiTietSanPhamRequestToChiTietSanPhamEntity(CreateChiTietSanPhamRequest createchiTietSanPhamRequest);
    
    ChiTietSanPham updateChiTietSanPhamRequestToChiTietSanPhamEntity(UpdateChiTietSanPhamRequest updatechiTietSanPhamRequest);
    
    List<ChiTietSanPhamResponse> listchiTietSanPhamEntityTochiTietSanPhamResponse(List<ChiTietSanPham> chiTietSanPhamList);
}
