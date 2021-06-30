package br.com.zupacademy.eduardo.controller.response;

import java.time.LocalDateTime;

import br.com.zupacademy.eduardo.modelo.Autor;

public class AutorResponse {

	private Long id;
	private String nome;
	private String mensagem;
	private String descricao;
	private LocalDateTime criadoEm;

	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.descricao = autor.getDescricao();
		this.mensagem = autor.getEmail();
		this.criadoEm = autor.getCriadoEm();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public String getDescricao() {
		return descricao;
	}
}
