package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.Document;
import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.HasCountryStates;
import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.UniqueValue;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Cliente;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Estado;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Pais;

public class NovoClienteRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@UniqueValue(domainClass= Cliente.class, fieldName= "email", message="O email do cliente não pode ser repetido")
	private String email;

	@NotBlank
	private String sobrenome;

	@Document
	@NotBlank
	@UniqueValue(domainClass= Cliente.class, fieldName= "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;
	
	@HasCountryStates(domainClass= Cliente.class, fieldName= "id")
	@NotNull
	private Long idPais;

	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente toModel(EntityManager manager)
	{
		@NotNull Pais pais;
		Estado estado;
		
		pais = manager.find(Pais.class, idPais);
		estado = null;
		
		if(idEstado != null)
		{
			estado = manager.find(Estado.class, idEstado);
		}
		
		return new Cliente
    		   (email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep); 		
	}
}
