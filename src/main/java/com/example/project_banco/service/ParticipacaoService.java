package com.example.project_banco.service;

import java.util.Optional;
import java.util.List;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.domain.entities.Participacao;
import com.example.project_banco.repository.ParticipacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

    public Participacao createParticipacao(Participacao model) {
        return participacaoRepository.save(model);
    }

    public List<Participacao> listParticipacao() {
        return participacaoRepository.findAll();
    }

    public Participacao findById(Integer IdParticipacao) {
        Optional<Participacao> evento = participacaoRepository.findById(IdParticipacao);
        return evento.orElseThrow(() -> new DataNotFoundException("Participacao Not found"));
    }
    
    public void delete(Integer IdParticipacao) {
        participacaoRepository.deleteById(IdParticipacao);
    }

    public Participacao update(Participacao novo){
        Participacao antigo = findById(novo.getIdParticipacao());

        antigo.setIdEvento(novo.getIdEvento());
        antigo.setLoginParticipante(novo.getLoginParticipante());
        antigo.setFlagPresente(novo.getFlagPresente());
        antigo.setNota(novo.getNota());
        antigo.setComentario(novo.getComentario());
        return participacaoRepository.save(antigo);
    }

    public  List<String> listDistinct() {
        return participacaoRepository.listDistinct();
	}

}