package com.example.project_banco.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.project_banco.configuration.MapperConfig;
import com.example.project_banco.domain.dto.request.StatusEventoRequest;
import com.example.project_banco.domain.dto.response.StatusEventoResponse;
import com.example.project_banco.domain.entities.StatusEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class StatusEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private StatusEventoMapper mapper;

    @Test
    public void shouldConvertEventoToEventoResponse() {
        StatusEvento entity = StatusEvento.builder().IdEventoStatus(5).NomeStatus("Em andamento").build();
        StatusEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdEventoStatus(), entity.getIdEventoStatus());
        assertEquals("Unexpected value found!", dto.getNomeStatus(), entity.getNomeStatus());
    }

    @Test
    public void shouldConvertEventoCreateRequestToEvento() {
        StatusEventoRequest dto = StatusEventoRequest.builder().NomeStatus("Em andamento").build();

        StatusEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNomeStatus(), entity.getNomeStatus());

    }
}