package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

	@NotBlank
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
