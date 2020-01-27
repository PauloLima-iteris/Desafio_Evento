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
import com.example.project_banco.domain.entities.Participacao;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.repository.ParticipacaoRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ParticipacaoRepository repositoryMock;

    @InjectMocks
    private ParticipacaoService service;

    private final Integer IdParticipacao = 2;
    private final String LoginParticipante = "Teste Teste";
    private final Boolean FlagPresente = true;
    private final Integer Nota = 10;
    private final String Comentario = "Festa do Rei do Camarote";

    Participacao entity = Participacao.builder().IdParticipacao(IdParticipacao).LoginParticipante(LoginParticipante).FlagPresente(FlagPresente).Nota(Nota).Comentario(Comentario).build();
    
    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Participacao Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Participacao model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Participacao> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Participacao> listR = service.listParticipacao();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }




}
