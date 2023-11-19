package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.CoAo;
import com.example.DuAnThucTap_SAVIS.model.mapper.CoAoMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CoAoResponse;
import com.example.DuAnThucTap_SAVIS.repository.CoAoRepository;
import com.example.DuAnThucTap_SAVIS.service.CoAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CoAoServiceImpl implements CoAoService {
    @Autowired
    CoAoRepository coAoRepository;

    @Autowired
    CoAoMapper coAoMapper;


    @Override
    public Page<CoAoResponse> pageCoAoActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<CoAo> coAoPage = coAoRepository.pageACTIVE(pageable);
        return coAoPage.map(coAoMapper::coAoEntityToCoAoResponse);
    }

    @Override
    public List<CoAoResponse> getAll() {
        List<CoAo> coAoList = coAoRepository.getAll();
        return coAoMapper.listCoAoEntityToCoAoResponse(coAoList);
    }

    @Override
    public Page<CoAoResponse> pageCoAoInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<CoAo> coAoPage = coAoRepository.pageINACTIVE(pageable);
        return coAoPage.map(coAoMapper::coAoEntityToCoAoResponse);

    }

    @Override
    public CoAoResponse add(CreateCoAoRequest createCoAoRequest) {
        CoAo coAo = coAoMapper.createCoAoRequestToCoAoEntity(createCoAoRequest);
        coAo.setMa(GenCode.generateCoAoCode());
        coAo.setNgayTao(LocalDate.now());
        coAo.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return coAoMapper.coAoEntityToCoAoResponse(coAoRepository.save(coAo));
    }

    @Override
    public CoAoResponse update(UpdateCoAoRequest updateCoAoRequest) {
        CoAo coAo = coAoMapper.updateCoAoRequestToCoAoEntity(updateCoAoRequest);
        coAo.setNgayCapNhat(LocalDate.now());
        coAo.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return coAoMapper.coAoEntityToCoAoResponse(coAoRepository.save(coAo));
    }

    @Override
    public CoAoResponse getOne(Integer id) {
        Optional<CoAo> coAoOptional = coAoRepository.findById(id);
        return coAoMapper.coAoEntityToCoAoResponse(coAoOptional.get());
    }

    @Override
    public Page<CoAoResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<CoAo> coAoPage = coAoRepository.pageSearchActive(searchName, pageable);
        return coAoPage.map(coAoMapper::coAoEntityToCoAoResponse);
    }

    @Override
    public Page<CoAoResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<CoAo> coAoPage = coAoRepository.pageSearchIvActive(searchName, pageable);
        return coAoPage.map(coAoMapper::coAoEntityToCoAoResponse);
    }


    @Override
    public void deleteCoAo(Integer id, LocalDate now) {
        coAoRepository.delete(id, LocalDate.now());
    }

    @Override
    public void revertCoAo(Integer id, LocalDate now) {
        coAoRepository.revert(id, LocalDate.now());
    }
}
