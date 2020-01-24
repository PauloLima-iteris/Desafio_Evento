package com.example.project_banco.service;

import java.util.Optional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.domain.dto.request.EventoRequest;
import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final StatusEventoService statusEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository, StatusEventoService statusEventoService) {
        this.eventoRepository = eventoRepository;
        this.statusEventoService = statusEventoService;
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
    
    public Evento cancelar(Integer id){
        Evento e = findById(id);

        Calendar diaEvento = Calendar.getInstance();
        Calendar deletarEvento = Calendar.getInstance();

        diaEvento.setTime(e.getDataHoraInicio());
        deletarEvento.setTime(new Date());

        if(validaData(diaEvento, deletarEvento)){
            throw new DataNotFoundException("Não é possivel cancelar o Evento no dia de inicio.");
        }
        e.setEventoStatus(statusEventoService.findById(4));
        return eventoRepository.save(e);
    }

    public Evento iniciar(Integer id){
        Evento ini = findById(id);

        Calendar iniE = Calendar.getInstance();
        Calendar iniD = Calendar.getInstance();

        iniE.setTime(ini.getDataHoraInicio());
        iniD.setTime(new Date());

        if(!validaData(iniE, iniD)){
            throw new DataNotFoundException("Não é possivel iniciar o evento.");
        }
        ini.setEventoStatus(statusEventoService.findById(2));
        return eventoRepository.save(ini);
    }

    public List<Evento> listEventoUsuario() {
        return eventoRepository.findAll();
    }

    public boolean validaData(Calendar ini, Calendar dia){
        if((ini.get(Calendar.DAY_OF_YEAR) == dia.get(Calendar.DAY_OF_YEAR)) && (ini.get(Calendar.YEAR) == dia.get(Calendar.YEAR))){
            return true;
        }
        return false;
    } 

    public Evento iniciarevento(Integer id){
        Evento ini = findById(id);

        Calendar iniE = Calendar.getInstance();
        Calendar iniD = Calendar.getInstance();

        iniE.setTime(ini.getDataHoraInicio());
        iniD.setTime(new Date());

        Long inicioevento = iniE.getTimeInMillis();
        Long confirmacao = iniD.getTimeInMillis();

        if(confirmacao < inicioevento){

            throw new DataNotFoundException("Não é possivel alterar o status do evento");
        }

        ini.setEventoStatus(statusEventoService.findById(2));
        return eventoRepository.save(ini);
    }

}

