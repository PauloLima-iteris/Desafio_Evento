package com.example.project_banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.repository.EventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private EventoRepository repositoryMock;

    @InjectMocks
    private EventoService service;

    private final Integer IdEvento = 1;
    private final String Nome = "Jose da Silva";
    private final Date DataHoraInicio = new Date();
    private final Date DataHoraFim = new Date();
    private final String Local = "Praca da Se";
    private final String Descricao = "Curso de como lutar capoeira";
    private final Integer LimiteVagas = 10;

    Evento entity = Evento.builder().IdEvento(IdEvento).Nome(Nome).DataHoraInicio(DataHoraInicio).DataHoraFim(DataHoraFim).Local(Local).Descricao(Descricao).LimiteVagas(LimiteVagas).build();
    
    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Evento Not found");

        // when
        service.findById(1);
    }

    
    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Evento model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Evento> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Evento> listR = service.listEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}