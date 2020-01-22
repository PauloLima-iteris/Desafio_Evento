package com.example.project_banco.service;

import java.util.Optional;
import java.util.List;
import com.example.project_banco.exception.DataNotFoundException;
import com.example.project_banco.domain.entities.CategoriaEvento;
import com.example.project_banco.repository.CategoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository categoriaeventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaeventoRepository) {
        this.categoriaeventoRepository = categoriaeventoRepository;
    }

    // public CategoriaEvento createCategoriaEvento(CategoriaEvento model) {
    //     return categoriaeventoRepository.save(model);
    // }

    public List<CategoriaEvento> listCategoriaEvento() {
        return categoriaeventoRepository.findAll();
    }

    public CategoriaEvento findById(Integer IdCategoriaEvento) {
        Optional<CategoriaEvento> categoriaevento = categoriaeventoRepository.findById(IdCategoriaEvento);
        return categoriaevento.orElseThrow(() -> new DataNotFoundException("CategoriaEvento Not found"));
    }
    
    // public void delete(Integer IdCategoriaEvento) {
    //     categoriaeventoRepository.deleteById(IdCategoriaEvento);
    // }

    // public CategoriaEvento update(CategoriaEvento novo){
    //     CategoriaEvento antigo = findById(novo.getIdCategoriaEvento());
    //     antigo.setNomeCategoria(novo.getNomeCategoria());

    //     return categoriaeventoRepository.save(antigo);
    // }

    // public  List<String> listDistinct() {
    //     return categoriaeventoRepository.listDistinct();
	// }

}