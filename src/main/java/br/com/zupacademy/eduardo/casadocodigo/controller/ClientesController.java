package br.com.zupacademy.eduardo.casadocodigo.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoClienteRequest;
import br.com.zupacademy.eduardo.casadocodigo.controller.response.ClienteResponse;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Cliente;

@RestController
public class ClientesController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/clientes")
	@Transactional
	public ResponseEntity<ClienteResponse> cria
	(@RequestBody @Valid NovoClienteRequest request, UriComponentsBuilder uriBuilder) {		
		
		Cliente cliente = request.toModel(manager);
		
		manager.persist(cliente);
		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteResponse(cliente));
	}
}
