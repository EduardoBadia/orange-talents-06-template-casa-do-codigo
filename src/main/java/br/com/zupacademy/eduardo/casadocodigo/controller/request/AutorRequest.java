package br.com.zupacademy.eduardo.controller.request;

import java.time.LocalDateTime;

import br.com.zupacademy.eduardo.modelo.Autor;

public class AutorRequest {

	private Long id;
	private String nome;
	private String email;
	private String mensagem;
	private String descricao;
	private LocalDateTime dataCriacao;

	public AutorRequest(Autor autor) {
		this.id = autor.getId();
		this.descricao = autor.getDescricao();
		this.mensagem = autor.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public String getMensagem() {
		return mensagem;
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
