package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public class AutorRequest {

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	@Email
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 400)
	private String descricao;

	private LocalDateTime dataCriacao;

	public AutorRequest() {
	}

	public AutorRequest(String nome, String email, String descricao) {
		
		this.nome = nome;
		this.descricao = email;
		this.email = descricao;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}
	
	public Autor toModel()
	{
		return new Autor(nome, descricao, email);
	}
}
