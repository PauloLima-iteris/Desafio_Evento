package com.example.project_banco.domain.mapper;

import com.example.project_banco.domain.dto.request.ParticipacaoRequest;
import com.example.project_banco.domain.dto.response.ParticipacaoResponse;
import com.example.project_banco.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoRequest input) {
        return mapper.map(input, Participacao.class);
    }

} 