package com.example.project_banco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.project_banco.domain.entities.StatusEvento;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.repository.StatusEventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatusEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private StatusEventoRepository repositoryMock;

    @InjectMocks
    private StatusEventoService service;

    private final Integer IdEventoStatus = 1;
    private final String NomeStatus = "Em andamento";

    StatusEvento entity = StatusEvento.builder().IdEventoStatus(IdEventoStatus).NomeStatus(NomeStatus).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("StatusEvento Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        StatusEvento model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<StatusEvento> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<StatusEvento> listR = service.listStatusEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }


    
}

