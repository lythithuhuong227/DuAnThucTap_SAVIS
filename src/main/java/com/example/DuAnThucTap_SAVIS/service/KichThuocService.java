package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateKichThuocRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateKichThuocRequest;
import com.example.DuAnThucTap_SAVIS.model.response.KichThuocResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface KichThuocService {
    Page<KichThuocResponse> pageKichThuocActive(Integer pageNo, Integer size);

    List<KichThuocResponse> getALl();

    Page<KichThuocResponse> pageKichThuocInActive(Integer pageNo, Integer size);

    KichThuocResponse add(CreateKichThuocRequest createKichThuocRequest);

    KichThuocResponse update(UpdateKichThuocRequest updateKichThuocRequest);

    KichThuocResponse getOne(Integer id);

    Page<KichThuocResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);

    Page<KichThuocResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteKichThuoc(Integer id, LocalDate now);

    void revertKichThuoc(Integer id,LocalDate now);
}
