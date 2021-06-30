package br.com.zupacademy.eduardo.casadocodigo.controller.response;

import java.time.LocalDateTime;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public class AutorResponse {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime criadoEm;

	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		this.email = autor.getEmail();
		this.criadoEm = autor.getCriadoEm();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public String getDescricao() {
		return descricao;
	}
}
