package br.com.zupacademy.eduardo.casadocodigo.controller.response;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

public class CategoriaResponse {

	private String nome;

	public String getNome() {
		return nome;
	} 
	
    public CategoriaResponse(Categoria categoria)
    {
    	this.nome = categoria.getNome();
    }
}
