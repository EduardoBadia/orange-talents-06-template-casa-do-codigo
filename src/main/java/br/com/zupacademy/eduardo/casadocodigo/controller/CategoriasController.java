package br.com.zupacademy.eduardo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.config.validacao.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.eduardo.casadocodigo.config.validacao.ProibeNomeDuplicadoCategoriaValidator;
import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovaCategoriaRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

@RestController
public class CategoriasController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {

		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		
		return novaCategoria.toString();
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		//1
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
}
