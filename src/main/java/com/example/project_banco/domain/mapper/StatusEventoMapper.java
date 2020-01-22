package com.example.project_banco.domain.mapper;

import com.example.project_banco.domain.dto.request.StatusEventoRequest;
import com.example.project_banco.domain.dto.response.StatusEventoResponse;
import com.example.project_banco.domain.entities.StatusEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public StatusEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StatusEventoResponse toDto(StatusEvento input) {
        return mapper.map(input, StatusEventoResponse.class);
    }

    public StatusEvento fromDto(StatusEventoRequest input) {
        return mapper.map(input, StatusEvento.class);
    }

} 