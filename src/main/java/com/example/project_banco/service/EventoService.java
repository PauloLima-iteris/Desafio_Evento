package com.example.project_banco.service;

import java.util.Optional;
import java.util.List;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento createEvento(Evento model) {
        return eventoRepository.save(model);
    }

    public List<Evento> listEvento() {
        return eventoRepository.findAll();
    }

    public Evento findById(Integer IdEvento) {
        Optional<Evento> evento = eventoRepository.findById(IdEvento);
        return evento.orElseThrow(() -> new DataNotFoundException("Evento Not found"));
    }
    
    public void delete(Integer IdEvento) {
        eventoRepository.deleteById(IdEvento);
    }

    // public Evento update(Evento novo){
    //     Evento antigo = findById(novo.getIdEvento());
    //     antigo.setIdEventoStatus(novo.getIdEventoStatus());
    //     antigo.setIdCategoriaEvento(novo.getIdCategoriaEvento());
    //     antigo.setNome(novo.getNome());
    //     antigo.setDataHoraInicio(novo.getDataHoraInicio());
    //     antigo.setDataHoraFim(novo.getDataHoraFim());
    //     antigo.setLocal(novo.getLocal());
    //     antigo.setDescricao(novo.getDescricao());
    //     antigo.setLimiteVagas(novo.getLimiteVagas());
    //     return eventoRepository.save(antigo);
    // }

    public  List<String> listDistinct() {
        return eventoRepository.listDistinct();
	}

}