package com.example.project_banco.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
import java.util.List;
import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.utils.IntegrationTestConfig;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = com.example.project_banco.utils.IntegrationTestConfig.appProperties)
@ActiveProfiles("test")
public class EventoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventoRepository eventoRepository;

    @Test
    public void when_ListDistinct_OK() {

        entityManager.persist(Evento.builder().Nome("Nome").DataHoraInicio(new Date()).DataHoraFim(new Date()).Local("Rua").Descricao("Cursos").LimiteVagas(10));
        entityManager.persist(Evento.builder().Nome("Nome").DataHoraInicio(new Date()).DataHoraFim(new Date()).Local("Rua").Descricao("Cursos").LimiteVagas(10));
        entityManager.persist(Evento.builder().Nome("NomeNovamente").DataHoraInicio(new Date()).DataHoraFim(new Date()).Local("Rua do aviador").Descricao("Cursos de origami").LimiteVagas(20));
        entityManager.flush();

        List<String> found = eventoRepository.listDistinct();

        assertNotNull(found);
        assertEquals(found.size(), 2);
        
    }
    
}

