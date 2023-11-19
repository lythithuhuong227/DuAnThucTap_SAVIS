package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.entity.AnhSanPham;
import com.example.DuAnThucTap_SAVIS.model.mapper.AnhSanPhamMapper;
import com.example.DuAnThucTap_SAVIS.model.response.AnhSanPhamResponse;
import com.example.DuAnThucTap_SAVIS.repository.AnhSanPhamRepository;
import com.example.DuAnThucTap_SAVIS.repository.SanPhamRepository;
import com.example.DuAnThucTap_SAVIS.service.AnhSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class AnhSanPhamServiceImpl implements AnhSanPhamService {

    @Autowired
    AnhSanPhamRepository anhSanPhamRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    AnhSanPhamMapper anhSanPhamMapper;

    @Override
    public List<AnhSanPhamResponse> anhSanPhamResponseList(Integer idSP) {
        List<AnhSanPham> anhSanPhamList = anhSanPhamRepository.getAnhSanPhamBySanPham(sanPhamRepository.findById(idSP).get());
        return anhSanPhamMapper.listAnhSanPhamEntityToAnhSanPhamResponse(anhSanPhamList);
    }

    @Override
    public AnhSanPhamResponse getOne(Integer id) {
        return anhSanPhamMapper.anhSanPhamEntityToAnhSanPhamResponse(anhSanPhamRepository.findById(id).get());
    }

    @Override
    public void deleteAnhSanPham(Integer id, LocalDate now) {
        anhSanPhamRepository.delete(id,LocalDate.now());
    }




}
