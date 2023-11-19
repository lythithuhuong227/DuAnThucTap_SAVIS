package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CoAoResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CoAoService {
    Page<CoAoResponse> pageCoAoActive(Integer pageNo, Integer size);

    List<CoAoResponse> getAll();

    Page<CoAoResponse> pageCoAoInActive(Integer pageNo, Integer size);

    CoAoResponse add(CreateCoAoRequest createCoAoRequest);

    CoAoResponse update(UpdateCoAoRequest updateCoAoRequest);

    CoAoResponse getOne(Integer id);

    Page<CoAoResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);

    Page<CoAoResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteCoAo(Integer id, LocalDate now);

    void revertCoAo(Integer id, LocalDate now);
}
