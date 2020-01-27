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

import com.example.project_banco.domain.entities.CategoriaEvento;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.repository.CategoriaEventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private CategoriaEventoRepository repositoryMock;

    @InjectMocks
    private CategoriaEventoService service;

    private final Integer IdCategoriaEvento = 2;
    private final String NomeCategoria = "Cursos";

    CategoriaEvento entity = CategoriaEvento.builder().IdCategoriaEvento(IdCategoriaEvento).NomeCategoria(NomeCategoria).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("CategoriaEvento Not found");

        // when
        service.findById(1);
    }

    
    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        CategoriaEvento model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("CategoriaEvento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<CategoriaEvento> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<CategoriaEvento> listR = service.listCategoriaEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}
