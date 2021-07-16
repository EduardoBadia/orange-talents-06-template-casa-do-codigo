package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.StateInCountry;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Estado;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Pais;

@StateInCountry
public class NovoEstadoRequest {

	@NotBlank
	private String nome;
	
	@NotNull
	private Long idPais;
	
	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	@Override
	public String toString() {
		return "NovoEstadoRequest [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}
}
