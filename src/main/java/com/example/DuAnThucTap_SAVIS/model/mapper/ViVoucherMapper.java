package com.example.DuAnThucTap_SAVIS.model.mapper;

import com.example.DuAnThucTap_SAVIS.entity.ViVoucher;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateViVoucherRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateViVoucherRequest;
import com.example.DuAnThucTap_SAVIS.model.response.ViVoucherResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ViVoucherMapper {

    ViVoucher viVoucherResponseToViVoucherEntity(ViVoucherResponse viVoucherResponse);

    ViVoucherResponse viVoucherEntityToViVoucherResponse(ViVoucher viVoucher);

    ViVoucher createViVoucherRequestToViVoucherEntity(CreateViVoucherRequest createViVoucherRequest);

    ViVoucher updateViVoucherRequestToViVoucherEntity(UpdateViVoucherRequest updateViVoucherRequest);

    List<ViVoucherResponse> listViVoucherEntityToViVoucherResponse(List<ViVoucher> viVoucherList);
}
