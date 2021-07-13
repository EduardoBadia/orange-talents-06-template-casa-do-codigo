package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.UniqueValue;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass= Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
