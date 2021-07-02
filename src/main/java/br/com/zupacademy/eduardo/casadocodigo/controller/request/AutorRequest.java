package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.EmailUnico;
import br.com.zupacademy.eduardo.casadocodigo.exception.EmailDuplicadoException;
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

	private LocalDateTime criadoEm;

	public AutorRequest() {
	}

	public AutorRequest(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao) {
		
		if(nome == null || nome.trim().equals(""))
		{
			throw new IllegalArgumentException("O nome não pode ser vazio!");
		}
		else if(descricao == null || descricao.trim().equals(""))
		{	
			throw new IllegalArgumentException("A descrição não pode ser vazia!");
		}
		
		else if(email == null || email.trim().equals(""))
		{
			throw new IllegalArgumentException("O email não pode ser vazio!");
		}
		
		else if(email == this.email)
		{
			throw new EmailDuplicadoException("O email não pode ser duplicado");
		}
		
		this.nome = nome;
		this.descricao = email;
		this.email = descricao;
		
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
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
