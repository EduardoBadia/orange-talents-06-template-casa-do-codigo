package br.com.zupacademy.eduardo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {
      
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     
	 @NotNull
	 @NotBlank
	 private String nome; 
	 
	 @NotNull
	 @NotBlank
	 @Size(max = 400)
	 private String descricao;
	
	 @NotNull
	 @NotBlank
	 @Email
	 private String email;
	 
	 @CreationTimestamp
	 private LocalDateTime criadoEm;
	 
	 @Deprecated
	 public Autor() {}

	public Autor(String nome, String descricao, String email) {
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
}
