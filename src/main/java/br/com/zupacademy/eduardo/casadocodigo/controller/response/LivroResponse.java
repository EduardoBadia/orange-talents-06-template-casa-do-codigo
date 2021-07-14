package br.com.zupacademy.eduardo.casadocodigo.controller.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Livro;

public class LivroResponse {

	private String titulo;
	private Long id;

	public LivroResponse(Livro livro) {

		this.titulo = livro.getTitulo();
		this.id = livro.getId();
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}
	
	public static List<LivroResponse> toResponse(List<Livro> livros) {
		
		return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
	}
}
