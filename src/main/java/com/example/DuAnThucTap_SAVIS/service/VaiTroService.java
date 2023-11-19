package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.entity.VaiTro;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.response.VaiTroResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VaiTroService {
    Page<VaiTroResponse> pageVaiTroActive(Integer pageNo, Integer size);

    Page<VaiTroResponse> pageVaiTroInActive(Integer pageNo, Integer size);

    VaiTroResponse add(CreateVaiTroRequest createVaiTroRequest);

    VaiTroResponse update(UpdateVaiTroRequest updateVaiTroRequest);

    VaiTroResponse getOne(Integer id);

    Page<VaiTroResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);
    Page<VaiTroResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);
    void deleteVaiTro(Integer id, LocalDate now);

    void revertVaiTro(Integer id,LocalDate now);
    List<VaiTro>getAll();
}
