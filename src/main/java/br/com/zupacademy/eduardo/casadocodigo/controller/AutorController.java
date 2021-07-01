package br.com.zupacademy.eduardo.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.AutorRequest;
import br.com.zupacademy.eduardo.casadocodigo.controller.response.AutorResponse;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;
import br.com.zupacademy.eduardo.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/api/autores")
@Validated
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody AutorRequest request , UriComponentsBuilder uriBuilder) {
		
		Autor autor = request.toModel();
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/api/autores/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorResponse(autor));
	}
}
