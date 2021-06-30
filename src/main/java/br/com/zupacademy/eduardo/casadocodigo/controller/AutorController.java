package br.com.zupacademy.eduardo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.eduardo.controller.request.AutorRequest;
import br.com.zupacademy.eduardo.controller.response.AutorResponse;
import br.com.zupacademy.eduardo.modelo.Autor;
import br.com.zupacademy.eduardo.repository.AutorRepository;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest request , UriComponentsBuilder uriBuilder) {
		
		Autor autor = new Autor(request.getNome(), request.getDescricao(), request.getEmail());
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/api/autores/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorResponse(autor));
	}
}
