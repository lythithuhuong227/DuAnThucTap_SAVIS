package com.example.DuAnThucTap_SAVIS.model.mapper.impl;

import com.example.DuAnThucTap_SAVIS.entity.VaiTro;
import com.example.DuAnThucTap_SAVIS.model.mapper.VaiTroMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateVaiTroRequest;
import com.example.DuAnThucTap_SAVIS.model.response.VaiTroResponse;
import jakarta.annotation.Generated;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-03-29T01:09:18+0700", comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)")
@Component
public class VaiTroMapperImpl implements VaiTroMapper {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VaiTro vaiTroResponseToVaiTroEntity(VaiTroResponse vaiTroResponse) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VaiTro vaiTro = modelMapper.map(vaiTroResponse, VaiTro.class);
        return vaiTro;
    }

    @Override
    public VaiTroResponse vaiTroEntityToVaiTroResponse(VaiTro vaiTro) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VaiTroResponse vaiTroResponse = modelMapper.map(vaiTro, VaiTroResponse.class);
        return vaiTroResponse;
    }

    @Override
    public VaiTro createVaiTroRequestToVaiTroEntity(CreateVaiTroRequest createVaiTroRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VaiTro vaiTro = modelMapper.map(createVaiTroRequest, VaiTro.class);
        return vaiTro;
    }

    @Override
    public VaiTro updateVaiTroRequestToVaiTroEntity(UpdateVaiTroRequest updateVaiTroRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VaiTro vaiTro = modelMapper.map(updateVaiTroRequest, VaiTro.class);
        return vaiTro;
    }

    @Override
    public List<VaiTroResponse> listVaiTroEntityToVaiTroResponse(List<VaiTro> vaiTroList) {
        List<VaiTroResponse> list = new ArrayList<>(vaiTroList.size());
        for (VaiTro th : vaiTroList) {
            list.add(vaiTroEntityToVaiTroResponse(th));
        }
        return list;
    }
}
