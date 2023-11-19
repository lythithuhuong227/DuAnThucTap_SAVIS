package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.ThuongHieu;
import com.example.DuAnThucTap_SAVIS.model.mapper.ThuongHieuMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateThuongHieuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateThuongHieuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ThuongHieuResponse;
import com.example.DuAnThucTap_SAVIS.repository.ThuongHieuRepository;
import com.example.DuAnThucTap_SAVIS.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    ThuongHieuRepository thuongHieuRepository;

    @Autowired
    ThuongHieuMapper thuongHieuMapper;


    @Override
    public Page<ThuongHieuResponse> pageThuongHieuActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ThuongHieu> thuongHieuPage = thuongHieuRepository.pageACTIVE(pageable);
        return thuongHieuPage.map(thuongHieuMapper::thuongHieuEntityToThuongHieuResponse);
    }

    @Override
    public List<ThuongHieuResponse> getAll() {
        List<ThuongHieu> thuongHieuList = thuongHieuRepository.getAll();
        return thuongHieuMapper.listThuongHieuEntityToThuongHieuResponse(thuongHieuList);
    }

    @Override
    public Page<ThuongHieuResponse> pageThuongHieuInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ThuongHieu> thuongHieuPage = thuongHieuRepository.pageINACTIVE(pageable);
        return thuongHieuPage.map(thuongHieuMapper::thuongHieuEntityToThuongHieuResponse);

    }

    @Override
    public ThuongHieuResponse add(CreateThuongHieuRequest createThuongHieuRequest) {
        ThuongHieu thuongHieu = thuongHieuMapper.createThuongHieuRequestToThuongHieuEntity(createThuongHieuRequest);
        thuongHieu.setMa(GenCode.generateThuongHieuCode());
        thuongHieu.setNgayTao(LocalDate.now());
        thuongHieu.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return thuongHieuMapper.thuongHieuEntityToThuongHieuResponse(thuongHieuRepository.save(thuongHieu));
    }

    @Override
    public ThuongHieuResponse update(UpdateThuongHieuRequest updateThuongHieuRequest) {
        ThuongHieu thuongHieu = thuongHieuMapper.updateThuongHieuRequestToThuongHieuEntity(updateThuongHieuRequest);
        thuongHieu.setNgayCapNhat(LocalDate.now());
        thuongHieu.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return thuongHieuMapper.thuongHieuEntityToThuongHieuResponse(thuongHieuRepository.save(thuongHieu));
    }

    @Override
    public ThuongHieuResponse getOne(Integer id) {
        Optional<ThuongHieu> thuongHieuOptional = thuongHieuRepository.findById(id);
        return thuongHieuMapper.thuongHieuEntityToThuongHieuResponse(thuongHieuOptional.get());
    }

    @Override
    public Page<ThuongHieuResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ThuongHieu> thuongHieuPage = thuongHieuRepository.pageSearchActive(searchName, pageable);
        return thuongHieuPage.map(thuongHieuMapper::thuongHieuEntityToThuongHieuResponse);
    }

    @Override
    public Page<ThuongHieuResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ThuongHieu> thuongHieuPage = thuongHieuRepository.pageSearchIvActive(searchName, pageable);
        return thuongHieuPage.map(thuongHieuMapper::thuongHieuEntityToThuongHieuResponse);
    }

    @Override
    public void deleteThuongHieu(Integer id, LocalDate now) {
        thuongHieuRepository.delete(id, LocalDate.now());
    }

    @Override
    public void revertThuongHieu(Integer id, LocalDate now) {
        thuongHieuRepository.revert(id, LocalDate.now());
    }
}
