package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateDongSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateDongSanPhamRequest;
import com.example.DuAnThucTap_SAVIS.model.response.DongSanPhamResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DongSanPhamService {
    Page<DongSanPhamResponse> pageDongSanPhamActive(Integer pageNo, Integer size);

    List<DongSanPhamResponse> getAll();

    Page<DongSanPhamResponse> pageDongSanPhamInActive(Integer pageNo, Integer size);

    DongSanPhamResponse add(CreateDongSanPhamRequest createDongSanPhamRequest);

    DongSanPhamResponse update(UpdateDongSanPhamRequest updateDongSanPhamRequest);

    DongSanPhamResponse getOne(Integer id);

    Page<DongSanPhamResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);
    Page<DongSanPhamResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteDongSanPham(Integer id, LocalDate now);

    void revertDongSanPham(Integer id,LocalDate now);
}
