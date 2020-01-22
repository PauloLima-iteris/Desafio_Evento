package com.example.project_banco.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.project_banco.domain.dto.response.StatusEventoResponse;
import com.example.project_banco.service.StatusEventoService;
import com.example.project_banco.domain.mapper.StatusEventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StatusEvento")
public class StatusEventoController {

	private final StatusEventoService statuseventoService;
	private final StatusEventoMapper mapper;

	@Autowired
	public StatusEventoController(StatusEventoService statuseventoService, StatusEventoMapper statuseventoMapper) {
		this.statuseventoService = statuseventoService;
		this.mapper = statuseventoMapper;
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> getById(@PathVariable Integer IdEventoStatus) {
         return ResponseEntity.ok(mapper.toDto(statuseventoService.findById(IdEventoStatus))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<StatusEventoResponse>> list() {
		return ResponseEntity.ok(statuseventoService.listStatusEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

}