package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.QuyDinh;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateQuyDinhRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateQuyDinhRequest;
import com.example.DuAnThucTap_SAVIS.model.response.QuyDinhResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuyDinhMapper {

    QuyDinh quyDinhResponseToQuyDinhEntity(QuyDinhResponse quyDinhResponse);

    QuyDinhResponse quyDinhEntityToQuyDinhResponse(QuyDinh quyDinh);

    QuyDinh createQuyDinhRequestToQuyDinhEntity(CreateQuyDinhRequest createQuyDinhRequest);

    QuyDinh updateQuyDinhRequestToQuyDinhEntity(UpdateQuyDinhRequest updateQuyDinhRequestQuyDinhRequest);

    List<QuyDinhResponse> listQuyDinhEntityToQuyDinhResponse(List<QuyDinh> quyDinhList);
}
