package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.response.DiaChiResponse;
import com.example.DuAnThucTap_SAVIS.model.response.KhachHangResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DiaChiService {
    Page<DiaChiResponse> pageDiaChiActive(Integer pageNo, Integer size);

    Page<DiaChiResponse> pageDiaChiInActive(Integer pageNo, Integer size);

    DiaChiResponse add(CreateDiaChiRequest createDiaChiRequest);

    DiaChiResponse update(UpdateDiaChiRequest updateDiaChiRequest);

    DiaChiResponse getOne(Integer id);
    Page<DiaChiResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);
    Page<DiaChiResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteDiaChi(Integer id, LocalDate now);

    void revertDiaChi(Integer id,LocalDate now);

    List<KhachHangResponse> getAllKhachHangActive();
}
