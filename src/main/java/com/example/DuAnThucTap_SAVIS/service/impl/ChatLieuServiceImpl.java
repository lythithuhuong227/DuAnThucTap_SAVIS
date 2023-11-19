package com.example.DuAnThucTap_SAVIS.service.impl;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.common.GenCode;
import com.example.DuAnThucTap_SAVIS.entity.ChatLieu;
import com.example.DuAnThucTap_SAVIS.model.mapper.ChatLieuMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateChatLieuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateChatLieuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ChatLieuResponse;
import com.example.DuAnThucTap_SAVIS.repository.ChatLieuRepository;
import com.example.DuAnThucTap_SAVIS.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository chatLieuRepository;

    @Autowired
    ChatLieuMapper chatLieuMapper;


    @Override
    public Page<ChatLieuResponse> pageChatLieuActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ChatLieu> chatLieuPage = chatLieuRepository.pageACTIVE(pageable);
        return chatLieuPage.map(chatLieuMapper::chatLieuEntityToChatLieuResponse);
    }

    @Override
    public List<ChatLieuResponse> getAll() {
        List<ChatLieu> chatLieuList = chatLieuRepository.getAll();
        return chatLieuMapper.listChatLieuEntityToChatLieuResponse(chatLieuList);
    }

    @Override
    public Page<ChatLieuResponse> pageChatLieuInActive(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ChatLieu> chatLieuPage = chatLieuRepository.pageINACTIVE(pageable);
        return chatLieuPage.map(chatLieuMapper::chatLieuEntityToChatLieuResponse);

    }

    @Override
    public ChatLieuResponse add(CreateChatLieuRequest createChatLieuRequest) {
        ChatLieu chatLieu = chatLieuMapper.createChatLieuRequestToChatLieuEntity(createChatLieuRequest);
        chatLieu.setMa(GenCode.generateChatLieuCode());
        chatLieu.setNgayTao(LocalDate.now());
        chatLieu.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return chatLieuMapper.chatLieuEntityToChatLieuResponse(chatLieuRepository.save(chatLieu));
    }

    @Override
    public ChatLieuResponse update(UpdateChatLieuRequest updateChatLieuRequest) {
        ChatLieu chatLieu = chatLieuMapper.updateChatLieuRequestToChatLieuEntity(updateChatLieuRequest);
        chatLieu.setNgayCapNhat(LocalDate.now());
        chatLieu.setTrangThai(ApplicationConstant.TrangThaiSanPham.ACTIVE);
        return chatLieuMapper.chatLieuEntityToChatLieuResponse(chatLieuRepository.save(chatLieu));
    }

    @Override
    public ChatLieuResponse getOne(Integer id) {
        Optional<ChatLieu> chatLieuOptional = chatLieuRepository.findById(id);
        return chatLieuMapper.chatLieuEntityToChatLieuResponse(chatLieuOptional.get());
    }

    @Override
    public Page<ChatLieuResponse> searchNameOrMaActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ChatLieu> chatLieuPage = chatLieuRepository.pageSearchActive(searchName, pageable);
        return chatLieuPage.map(chatLieuMapper::chatLieuEntityToChatLieuResponse);
    }

    @Override
    public Page<ChatLieuResponse> searchNameOrMaInActive(String searchName, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<ChatLieu> chatLieuPage = chatLieuRepository.pageSearchIvActive(searchName, pageable);
        return chatLieuPage.map(chatLieuMapper::chatLieuEntityToChatLieuResponse);
    }


    @Override
    public void deleteChatLieu(Integer id, LocalDate now) {
        chatLieuRepository.delete(id, LocalDate.now());
    }

    @Override
    public void revertChatLieu(Integer id, LocalDate now) {
        chatLieuRepository.revert(id, LocalDate.now());
    }
}
