package com.example.DuAnThucTap_SAVIS.model.mapper.impl;

import com.example.DuAnThucTap_SAVIS.entity.CoAo;
import com.example.DuAnThucTap_SAVIS.model.mapper.CoAoMapper;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateCoAoRequest;
import com.example.DuAnThucTap_SAVIS.model.response.CoAoResponse;
import jakarta.annotation.Generated;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-03-29T01:09:18+0700", comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)")
@Component
public class CoAoMapperImpl implements CoAoMapper {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CoAo coAoResponseToCoAoEntity(CoAoResponse coAoResponse) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CoAo coAo = this.modelMapper.map(coAoResponse, CoAo.class);
        return coAo;
    }

    @Override
    public CoAoResponse coAoEntityToCoAoResponse(CoAo coAo) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CoAoResponse coAoResponse = this.modelMapper.map(coAo, CoAoResponse.class);
        return coAoResponse;
    }

    @Override
    public CoAo createCoAoRequestToCoAoEntity(CreateCoAoRequest createCoAoRequest) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CoAo coAo = this.modelMapper.map(createCoAoRequest, CoAo.class);
        return coAo;
    }

    @Override
    public CoAo updateCoAoRequestToCoAoEntity(UpdateCoAoRequest updateCoAoRequest) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CoAo coAo = this.modelMapper.map(updateCoAoRequest, CoAo.class);
        return coAo;
    }

    @Override
    public List<CoAoResponse> listCoAoEntityToCoAoResponse(List<CoAo> coAoList) {
        List<CoAoResponse> list = new ArrayList<>(coAoList.size());
        for (CoAo ca : coAoList) {
            list.add(coAoEntityToCoAoResponse(ca));
        }
        return list;
    }
}
