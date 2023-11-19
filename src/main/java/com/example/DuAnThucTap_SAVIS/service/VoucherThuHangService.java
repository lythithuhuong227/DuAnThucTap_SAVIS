package com.example.DuAnThucTap_SAVIS.service;

import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;

import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVoucherThuHangRequest;

import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVoucherThuHangRequest;

import com.example.DuAnThucTap_SAVIS.model.response.VoucherThuHangResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public interface VoucherThuHangService {

    Page<VoucherThuHangResponse> pageVouCherThuHangActive(Integer pageNo, Integer size);

    List<VoucherThuHang> getAll();

    Page<VoucherThuHangResponse> pageVouCherThuHangInActive(Integer pageNo, Integer size);

    Page<VoucherThuHangResponse> pageVouCherThuHangPending(Integer pageNo, Integer size);

    VoucherThuHangResponse add(CreateVoucherThuHangRequest createVouCherThuHangRequest);

    VoucherThuHangResponse update(UpdateVoucherThuHangRequest updateVouCherThuHangRequest);

    VoucherThuHangResponse getOne(Integer id);
    Page<VoucherThuHangResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size);
    Page<VoucherThuHangResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size);

    void deleteVoucherThuHang(Integer id, LocalDateTime now);

    void revertVoucherThuHang(Integer id,LocalDateTime now);





    VoucherThuHang findById(Integer voucherId);
}
