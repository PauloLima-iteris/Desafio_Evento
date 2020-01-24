package com.example.project_banco.service;

import java.util.Optional;
import java.util.List;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.domain.entities.StatusEvento;
import com.example.project_banco.repository.StatusEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusEventoService {

    private final StatusEventoRepository statuseventoRepository;

    @Autowired
    public StatusEventoService(StatusEventoRepository statuseventoRepository) {
        this.statuseventoRepository = statuseventoRepository;
    }

    public List<StatusEvento> listStatusEvento() {
        return statuseventoRepository.findAll();
    }

    public StatusEvento findById(Integer IdEventoStatus) {
        Optional<StatusEvento> statusevento = statuseventoRepository.findById(IdEventoStatus);
        return statusevento.orElseThrow(() -> new DataNotFoundException("StatusEvento Not found"));
    }
}