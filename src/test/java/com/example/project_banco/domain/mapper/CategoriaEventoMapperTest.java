package com.example.project_banco.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.project_banco.configuration.MapperConfig;
import com.example.project_banco.domain.dto.request.CategoriaEventoRequest;
import com.example.project_banco.domain.dto.response.CategoriaEventoResponse;
import com.example.project_banco.domain.entities.CategoriaEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void shouldConvertCategoriaEventoToCategoriaEventoResponse() {
        CategoriaEvento entity = CategoriaEvento.builder().IdCategoriaEvento(8).NomeCategoria("Spring").build();
        CategoriaEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdCategoriaEvento(), entity.getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getNomeCategoria(), entity.getNomeCategoria());
    }

    @Test
    public void shouldConvertEventoCreateRequestToEvento() {
        CategoriaEventoRequest dto = CategoriaEventoRequest.builder().NomeCategoria("Spring").build();

        CategoriaEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNomeCategoria(), entity.getNomeCategoria());
    }


}