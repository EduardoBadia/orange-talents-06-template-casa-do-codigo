package br.com.zupacademy.eduardo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoAutorRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

@RestController
public class AutoresController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value="/autores")
	@Transactional
	public String cria(@RequestBody @Valid NovoAutorRequest request)
	{
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
}
