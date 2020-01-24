package com.example.project_banco.controller;

import java.util.List;
import javax.validation.Valid;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.project_banco.domain.dto.request.EventoRequest;
import com.example.project_banco.domain.dto.response.EventoResponse;
import com.example.project_banco.service.CategoriaEventoService;
import com.example.project_banco.service.EventoService;
import com.example.project_banco.service.StatusEventoService;
import com.example.project_banco.domain.entities.Evento;
import com.example.project_banco.domain.mapper.EventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Evento")
public class EventoController {

	private final EventoService eventoService;
	private final EventoMapper mapper;
	private final StatusEventoService statuseventoService;
	private final CategoriaEventoService categoriaeventoService; 

	@Autowired
	public EventoController(EventoService eventoService, EventoMapper eventoMapper, StatusEventoService statuseventoService, CategoriaEventoService categoriaeventoService) {
		this.eventoService = eventoService;
		this.mapper = eventoMapper;
		this.statuseventoService = statuseventoService;
		this.categoriaeventoService = categoriaeventoService;
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(eventoService.findById(id))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<EventoResponse>> list() {
		return ResponseEntity.ok(eventoService.listEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/usuario")
	public ResponseEntity<List<EventoResponse>> listEventoUsuario() {
		return ResponseEntity.ok(eventoService.listEventoUsuario().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(eventoService.listDistinct());
	}

	@PostMapping
	public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoRequest model) {
		Evento evento = mapper.fromDto(model);
		evento.setCategoriaEvento(categoriaeventoService.findById(model.getIdCategoriaEvento()));
		evento.setEventoStatus(statuseventoService.findById(1));
		eventoService.createEvento(evento);
		return ResponseEntity.ok(mapper.toDto(evento));
	}

	@PutMapping(value = "/cancelar/{id}")
	public ResponseEntity<EventoResponse> update(@PathVariable Integer id){

		return ResponseEntity.ok(mapper.toDto(eventoService.cancelar(id)));
	}

	@DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {

		eventoService.delete(id);
	}

	@PutMapping(value = "/iniciar/{id}")
	public ResponseEntity<EventoResponse> iniciar(@PathVariable Integer id){

		return ResponseEntity.ok(mapper.toDto(eventoService.iniciar(id)));
	}

	@PutMapping(value = "/iniciarEvento/{id}")
	public ResponseEntity<EventoResponse> iniciarevento(@PathVariable Integer id){
		return ResponseEntity.ok(mapper.toDto(eventoService.iniciarevento(id)));
	}

}