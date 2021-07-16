package br.com.zupacademy.eduardo.casadocodigo.controller.response;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Cliente;

public class ClienteResponse {

	private Long id;

	public ClienteResponse(Cliente cliente) {

		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}
}
