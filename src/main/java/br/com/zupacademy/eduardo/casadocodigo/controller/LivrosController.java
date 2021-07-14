package br.com.zupacademy.eduardo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoLivroRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Livro;

@RestController
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/livros")
	@Transactional
	//1
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		//1
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}
}
