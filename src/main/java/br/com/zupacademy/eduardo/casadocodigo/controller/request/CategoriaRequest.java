package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

public class CategoriaRequest {

	@NotNull
	@NotBlank
	private String nome;

	public CategoriaRequest() {
	}

	public CategoriaRequest(@NotBlank @NotNull String nome) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("O nome não pode ser vazio!");
		} 

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}
