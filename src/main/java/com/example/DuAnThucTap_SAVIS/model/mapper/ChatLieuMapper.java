package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ChatLieu;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateChatLieuRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateChatLieuRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ChatLieuResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatLieuMapper {

    ChatLieu chatLieuResponseToChatLieuEntity(ChatLieuResponse chatLieuResponse);

    ChatLieuResponse chatLieuEntityToChatLieuResponse(ChatLieu chatLieu);

    ChatLieu createChatLieuRequestToChatLieuEntity(CreateChatLieuRequest createChatLieuRequest);

    ChatLieu updateChatLieuRequestToChatLieuEntity(UpdateChatLieuRequest updateChatLieuRequest);

    List<ChatLieuResponse> listChatLieuEntityToChatLieuResponse(List<ChatLieu> chatLieuList);
}
