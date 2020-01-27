package com.example.project_banco.domain.mapper;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import com.example.project_banco.configuration.MapperConfig;
import com.example.project_banco.domain.dto.request.EventoRequest;
import com.example.project_banco.domain.dto.response.EventoResponse;
import com.example.project_banco.domain.entities.Evento;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class EventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private EventoMapper mapper;

    @Test
    public void shouldConvertEventoToEventoResponse() {
        Evento entity = Evento.builder().IdEvento(1).Nome("Paulo").DataHoraInicio(new Date()).DataHoraFim(new Date())
                .Local("Rua").Descricao("Curso de beber agua").LimiteVagas(10).build();
        EventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
        assertEquals("Unexpected value found!", dto.getDataHoraInicio(), entity.getDataHoraInicio());
        assertEquals("Unexpected value found!", dto.getDataHoraFim(), entity.getDataHoraFim());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getLimiteVagas(), entity.getLimiteVagas());
    }

    @Test
    public void shouldConvertEventoCreateRequestToEvento() {
        EventoRequest dto = EventoRequest.builder().Nome("Paulo").DataHoraInicio(new Date()).DataHoraFim(new Date())
                .Local("Rua").Descricao("Curso de beber agua").LimiteVagas(10).build();

        Evento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
        assertEquals("Unexpected value found!", dto.getDataHoraInicio(), entity.getDataHoraInicio());
        assertEquals("Unexpected value found!", dto.getDataHoraFim(), entity.getDataHoraFim());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getLimiteVagas(), entity.getLimiteVagas());
    }

}