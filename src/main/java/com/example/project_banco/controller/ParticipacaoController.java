package com.example.project_banco.controller;

import java.util.List;
import javax.validation.Valid;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.project_banco.domain.dto.request.ParticipacaoRequest;
import com.example.project_banco.domain.dto.response.ParticipacaoResponse;
import com.example.project_banco.service.EventoService;
import com.example.project_banco.service.ParticipacaoService;
import com.example.project_banco.domain.entities.Participacao;
import com.example.project_banco.domain.mapper.ParticipacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Participacao")
public class ParticipacaoController {

	private final ParticipacaoService participacaoService;
	private final ParticipacaoMapper mapper;
	//private final EventoService eventoService;

	@Autowired
	public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper participacaoMapper) {
		this.participacaoService = participacaoService;
		this.mapper = participacaoMapper;
		//this.eventoService = eventoService;
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> getById(@PathVariable Integer IdParticipacao) {
         return ResponseEntity.ok(mapper.toDto(participacaoService.findById(IdParticipacao))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<ParticipacaoResponse>> list() {
		return ResponseEntity.ok(participacaoService.listParticipacao().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(participacaoService.listDistinct());
	}

	@PostMapping
	public ResponseEntity<ParticipacaoResponse> post(@Valid @RequestBody ParticipacaoRequest model) {
		Participacao participacao = participacaoService.createParticipacao(mapper.fromDto(model));

		//participacao.setEvento(eventoService.findById(model.getIdEvento()));
	
		//participacaoService.createParticipacao(participacao);
	

		return ResponseEntity.ok(mapper.toDto(participacao));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ParticipacaoResponse> update(@PathVariable Integer IdParticipacao, @Valid @RequestBody ParticipacaoRequest model){
		Participacao participacao = mapper.fromDto(model);
		participacao.setIdParticipacao(IdParticipacao);
		participacaoService.update(participacao);

		return ResponseEntity.ok(mapper.toDto(participacao));
	}

	@DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer IdParticipacao) {

		participacaoService.delete(IdParticipacao);

	}

}