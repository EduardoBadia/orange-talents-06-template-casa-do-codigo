package br.com.zupacademy.eduardo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoEstadoRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Estado;

@RestController
public class CriaEstadoController {

	@Autowired
	private EntityManager manager;

	@PostMapping(value = "/estados")
	@Transactional
	public String cria(@RequestBody @Valid NovoEstadoRequest request) {		
		
		Estado novoEstado = request.toModel(manager);
			
		manager.persist(novoEstado);
		
		return novoEstado.toString();
	}
}
