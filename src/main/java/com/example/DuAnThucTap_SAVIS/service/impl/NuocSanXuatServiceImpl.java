package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.NuocSanXuat;
import com.example.DuAnThucTap_SAVIS.model.mapper.NuocSanXuatMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateNuocSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateNuocSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.response.NuocSanXuatResponse;
import com.example.DuAnThucTap_SAVIS.repository.NuocSanXuatRepository;
import com.example.DuAnThucTap_SAVIS.service.NuocSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class NuocSanXuatServiceImpl implements NuocSanXuatService {

    @Autowired
    NuocSanXuatRepository nuocSanXuatRepository;

    @Autowired
    NuocSanXuatMapper nuocSanXuatMapper;


    @Override
    public Page<NuocSanXuatResponse> pageNuocSanXuatActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NuocSanXuat> nuocSanXuatPage = nuocSanXuatRepository.pageACTIVE(pageable);
        return nuocSanXuatPage.map(nuocSanXuatMapper::nuocSanXuatEntityToNuocSanXuatResponse);

    }

    @Override
    public List<NuocSanXuatResponse> getAll() {
        List<NuocSanXuat> nuocSanXuatList = nuocSanXuatRepository.getAll();
        return nuocSanXuatMapper.listNuocSanXuatEntityToNuocSanXuatResponses(nuocSanXuatList);
    }

    @Override
    public Page<NuocSanXuatResponse> pageNuocSanXuatInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NuocSanXuat> nuocSanXuatPage = nuocSanXuatRepository.pageINACTIVE(pageable);
        return nuocSanXuatPage.map(nuocSanXuatMapper::nuocSanXuatEntityToNuocSanXuatResponse);

    }

    @Override
    public NuocSanXuatResponse add(CreateNuocSanXuatRequest createNuocSanXuatRequest) {
        NuocSanXuat nuocSanXuat = nuocSanXuatMapper.createNuocSanXuatRequestToNuocSanXuatEntity(createNuocSanXuatRequest);
        nuocSanXuat.setMa(GenCode.generateNuocSanXuatCode());
        nuocSanXuat.setNgayTao(LocalDate.now());
        nuocSanXuat.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return nuocSanXuatMapper.nuocSanXuatEntityToNuocSanXuatResponse(nuocSanXuatRepository.save(nuocSanXuat));
    }

    @Override
    public NuocSanXuatResponse update(UpdateNuocSanXuatRequest updateNuocSanXuatRequest) {
        NuocSanXuat nuocSanXuat = nuocSanXuatMapper.updateNuocSanXuatRequestToNuocSanXuatEntity(updateNuocSanXuatRequest);
        nuocSanXuat.setNgayCapNhat(LocalDate.now());
        nuocSanXuat.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return nuocSanXuatMapper.nuocSanXuatEntityToNuocSanXuatResponse(nuocSanXuatRepository.save(nuocSanXuat));
    }

    @Override
    public NuocSanXuatResponse getOne(Integer id) {
        Optional<NuocSanXuat> nuocSanXuatOptional = nuocSanXuatRepository.findById(id);
        return nuocSanXuatMapper.nuocSanXuatEntityToNuocSanXuatResponse(nuocSanXuatOptional.get());
    }

    @Override
    public Page<NuocSanXuatResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NuocSanXuat> nuocSanXuatPage = nuocSanXuatRepository.pageSearchActive(searchName, pageable);
        return nuocSanXuatPage.map(nuocSanXuatMapper::nuocSanXuatEntityToNuocSanXuatResponse);
    }

    @Override
    public Page<NuocSanXuatResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NuocSanXuat> nuocSanXuatPage = nuocSanXuatRepository.pageSearchIvActive(searchName, pageable);
        return nuocSanXuatPage.map(nuocSanXuatMapper::nuocSanXuatEntityToNuocSanXuatResponse);
    }


    @Override
    public void deleteNuocSanXuat(Integer id,LocalDate now) {
        nuocSanXuatRepository.delete(id,LocalDate.now());
    }

    @Override
    public void revertNuocSanXuat(Integer id,LocalDate now) {
        nuocSanXuatRepository.revert(id,LocalDate.now());
    }
}
