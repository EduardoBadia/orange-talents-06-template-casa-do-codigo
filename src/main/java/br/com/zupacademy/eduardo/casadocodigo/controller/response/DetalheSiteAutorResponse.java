package br.com.zupacademy.eduardo.casadocodigo.controller.response;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public class DetalheSiteAutorResponse {

	private String nome;
	private String descricao;

	public DetalheSiteAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
