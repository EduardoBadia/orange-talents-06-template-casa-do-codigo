package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public class AutorRequest {

	private Long id;

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

	public AutorRequest(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		this.email = autor.getEmail();
	}

	public Long getId() {
		return id;
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
}
