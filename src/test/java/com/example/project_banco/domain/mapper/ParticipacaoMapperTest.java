package com.example.project_banco.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.project_banco.configuration.MapperConfig;
import com.example.project_banco.domain.dto.request.ParticipacaoRequest;
import com.example.project_banco.domain.dto.response.ParticipacaoResponse;
import com.example.project_banco.domain.entities.Participacao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private ParticipacaoMapper mapper;

    @Test
    public void shouldConvertParticipacaoToParticipacaoResponse() {
        Participacao entity = Participacao.builder().IdParticipacao(2).LoginParticipante("Lima").FlagPresente(false).Nota(10).Comentario("Bom").build(); 
            
        ParticipacaoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdParticipacao(), entity.getIdParticipacao());
        assertEquals("Unexpected value found!", dto.getLoginParticipante(), entity.getLoginParticipante());
        assertEquals("Unexpected value found!", dto.getFlagPresente(), entity.getFlagPresente());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
    }

    @Test
    public void shouldConvertEventoCreateRequestToEvento() {
        ParticipacaoRequest dto = ParticipacaoRequest.builder().LoginParticipante("Lima").FlagPresente(false).build(); 

        Participacao entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getLoginParticipante(), entity.getLoginParticipante());
        assertEquals("Unexpected value found!", dto.getFlagPresente(), entity.getFlagPresente());
    }
}
