package com.example.project_banco.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.example.project_banco.domain.dto.request.EventoRequest;
import com.example.project_banco.domain.dto.response.EventoResponse;
import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.domain.mapper.EventoMapper;
import com.example.project_banco.service.EventoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class EventoControllerTest {

    @Mock
    private EventoMapper mapper;

    @Mock
    private EventoService service;

    @InjectMocks
    private EventoController controller;

    private final Integer IdEvento = 1;
    private final String Nome = "Jose da Silva";
    private final Date DataHoraInicio = new Date();
    private final Date DataHoraFim = new Date();
    private final String Local = "Praca da Se";
    private final String Descricao = "Curso de como lutar capoeira";
    private final Integer LimiteVagas = 10;

    Evento entity = Evento.builder().IdEvento(IdEvento).Nome(Nome).DataHoraInicio(DataHoraInicio).DataHoraFim(DataHoraFim).Local(Local).Descricao(Descricao).LimiteVagas(LimiteVagas).build();

    EventoRequest createDto = EventoRequest.builder().Nome(Nome).DataHoraInicio(DataHoraInicio).DataHoraFim(DataHoraFim).Local(Local).Descricao(Descricao).LimiteVagas(LimiteVagas).build();

    EventoResponse responseDto = EventoResponse.builder().IdEvento(IdEvento).Nome(Nome).DataHoraInicio(DataHoraInicio).DataHoraFim(DataHoraFim).Local(Local).Descricao(Descricao).LimiteVagas(LimiteVagas).build();

    @Test
    public void should_GetById() {
        //given
        when(service.findById(any())).thenReturn(entity);
        when(mapper.toDto(any())).thenReturn(responseDto);

        // when
        ResponseEntity<EventoResponse> response = controller.getById(1);

        //then
        assertEquals("Deve ser 0k /200", response.getStatusCode(), HttpStatus.OK);
    }

    // @Test
    // public void should_Created_WhenInvalid() {
    //     //given
    //     when(mapper.fromDto(any())).thenReturn(entity);
    //     when(service.createEvento(any())).thenReturn(entity);
    //     when(mapper.toDto(any())).thenReturn(responseDto);

    //     // when
    //     ResponseEntity<EventoResponse> response = controller.post(createDto);

    //     //then
    //     assertEquals("Deve ser 0k /200", response.getStatusCode(), HttpStatus.OK);
    // }


    


    
}