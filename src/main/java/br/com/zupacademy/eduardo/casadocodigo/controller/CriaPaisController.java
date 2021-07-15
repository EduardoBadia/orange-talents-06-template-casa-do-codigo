package br.com.zupacademy.eduardo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoPaisRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Pais;

@RestController
public class CriaPaisController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/paises")
	@Transactional
	public String criaPais(@RequestBody @Valid NovoPaisRequest request) {
		Pais novoPais = new Pais(request.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}
}
