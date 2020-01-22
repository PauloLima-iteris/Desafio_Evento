package com.example.project_banco.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.project_banco.domain.dto.response.CategoriaEventoResponse;
import com.example.project_banco.service.CategoriaEventoService;
import com.example.project_banco.domain.mapper.CategoriaEventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CategoriaEvento")
public class CategoriaEventoController {

	private final CategoriaEventoService categoriaeventoService;
	private final CategoriaEventoMapper mapper;

	@Autowired
	public CategoriaEventoController(CategoriaEventoService categoriaeventoService, CategoriaEventoMapper categoriaeventoMapper) {
		this.categoriaeventoService = categoriaeventoService;
		this.mapper = categoriaeventoMapper;
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> getById(@PathVariable Integer IdCategoriaEvento) {
         return ResponseEntity.ok(mapper.toDto(categoriaeventoService.findById(IdCategoriaEvento)));
    }
    
	@GetMapping
	public ResponseEntity<List<CategoriaEventoResponse>> list() {
		return ResponseEntity.ok(categoriaeventoService.listCategoriaEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}


}