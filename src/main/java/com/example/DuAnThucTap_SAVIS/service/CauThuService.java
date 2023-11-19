package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCauThuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCauThuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CauThuResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CauThuService {
    Page<CauThuResponse> pageCauThuActive(Integer pageNo, Integer size);

    List<CauThuResponse> getAll();

    Page<CauThuResponse> pageCauThuInActive(Integer pageNo, Integer size);

    CauThuResponse add(CreateCauThuRequest createCauThuRequest);

    CauThuResponse update(UpdateCauThuRequest updateCauThuRequest);

    CauThuResponse getOne(Integer id);

    Page<CauThuResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);

    Page<CauThuResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteCauThu(Integer id, LocalDate now);

    void revertCauThu(Integer id, LocalDate now);
}
