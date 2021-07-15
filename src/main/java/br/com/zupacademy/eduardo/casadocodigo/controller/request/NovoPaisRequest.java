package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.UniqueValue;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Pais;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName =  "nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
