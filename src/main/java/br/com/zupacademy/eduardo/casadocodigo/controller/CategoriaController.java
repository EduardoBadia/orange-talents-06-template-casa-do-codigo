package br.com.zupacademy.eduardo.casadocodigo.controller;

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

import br.com.zupacademy.eduardo.casadocodigo.controller.request.CategoriaRequest;
import br.com.zupacademy.eduardo.casadocodigo.controller.response.CategoriaResponse;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;
import br.com.zupacademy.eduardo.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest request , UriComponentsBuilder uriBuilder) {
		
		Categoria categoria = request.toModel();
		categoriaRepository.save(categoria);
		
		URI uri = uriBuilder.path("/api/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoriaResponse(categoria));
	}

}
