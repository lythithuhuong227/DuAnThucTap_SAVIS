package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.NhaSanXuat;
import com.example.DuAnThucTap_SAVIS.model.mapper.NhaSanXuatMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateNhaSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateNhaSanXuatRequest;
import com.example.DuAnThucTap_SAVIS.model.response.NhaSanXuatResponse;
import com.example.DuAnThucTap_SAVIS.repository.NhaSanXuatRepository;
import com.example.DuAnThucTap_SAVIS.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    NhaSanXuatRepository nhaSanXuatRepository;

    @Autowired
    NhaSanXuatMapper nhaSanXuatMapper;


    @Override
    public Page<NhaSanXuatResponse> pageNhaSanXuatActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NhaSanXuat> nhaSanXuatPage = nhaSanXuatRepository.pageACTIVE(pageable);
        return nhaSanXuatPage.map(nhaSanXuatMapper::nhaSanXuatEntityToNhaSanXuatResponse);

    }

    @Override
    public List<NhaSanXuatResponse> getAll() {
        List<NhaSanXuat> nhaSanXuatList = nhaSanXuatRepository.getAll();

        return nhaSanXuatMapper.listNhaSanXuatEntityToNhaSanXuatRespnse(nhaSanXuatList);
    }

    @Override
    public Page<NhaSanXuatResponse> pageNhaSanXuatInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NhaSanXuat> nhaSanXuatPage = nhaSanXuatRepository.pageINACTIVE(pageable);
        return nhaSanXuatPage.map(nhaSanXuatMapper::nhaSanXuatEntityToNhaSanXuatResponse);

    }

    @Override
    public NhaSanXuatResponse add(CreateNhaSanXuatRequest createNhaSanXuatRequest) {
        NhaSanXuat nhaSanXuat = nhaSanXuatMapper.createNhaSanXuatRequestToNhaSanXuatEntity(createNhaSanXuatRequest);
        nhaSanXuat.setMa(GenCode.generateNhaSanXuatCode());
        nhaSanXuat.setNgayTao(LocalDate.now());
        nhaSanXuat.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return nhaSanXuatMapper.nhaSanXuatEntityToNhaSanXuatResponse(nhaSanXuatRepository.save(nhaSanXuat));
    }

    @Override
    public NhaSanXuatResponse update(UpdateNhaSanXuatRequest updateNhaSanXuatRequest) {
        NhaSanXuat nhaSanXuat = nhaSanXuatMapper.updateNhaSanXuatRequestToNhaSanXuatEntity(updateNhaSanXuatRequest);
        nhaSanXuat.setNgayCapNhat(LocalDate.now());
        nhaSanXuat.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return nhaSanXuatMapper.nhaSanXuatEntityToNhaSanXuatResponse(nhaSanXuatRepository.save(nhaSanXuat));
    }

    @Override
    public NhaSanXuatResponse getOne(Integer id) {
        Optional<NhaSanXuat> nhaSanXuatOptional = nhaSanXuatRepository.findById(id);
        return nhaSanXuatMapper.nhaSanXuatEntityToNhaSanXuatResponse(nhaSanXuatOptional.get());
    }

    @Override
    public Page<NhaSanXuatResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NhaSanXuat> nhaSanXuatPage = nhaSanXuatRepository.pageSearchActive(searchName, pageable);
        return nhaSanXuatPage.map(nhaSanXuatMapper::nhaSanXuatEntityToNhaSanXuatResponse);
    }

    @Override
    public Page<NhaSanXuatResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<NhaSanXuat> nhaSanXuatPage = nhaSanXuatRepository.pageSearchIvActive(searchName, pageable);
        return nhaSanXuatPage.map(nhaSanXuatMapper::nhaSanXuatEntityToNhaSanXuatResponse);
    }


    @Override
    public void deleteNhaSanXuat(Integer id,LocalDate now) {
        nhaSanXuatRepository.delete(id,LocalDate.now());
    }

    @Override
    public void revertNhaSanXuat(Integer id,LocalDate now) {
        nhaSanXuatRepository.revert(id,LocalDate.now());
    }
}
