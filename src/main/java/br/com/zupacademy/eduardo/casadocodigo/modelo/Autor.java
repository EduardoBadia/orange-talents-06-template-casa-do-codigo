package br.com.zupacademy.eduardo.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {
      
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nome; 
	 private String descricao;
	 private String email;
	 
	 @CreationTimestamp
	 private LocalDateTime criadoEm;
	 
	 @Deprecated
	 public Autor() {}

	public Autor(String nome, String descricao, String email) {
		
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
		
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
