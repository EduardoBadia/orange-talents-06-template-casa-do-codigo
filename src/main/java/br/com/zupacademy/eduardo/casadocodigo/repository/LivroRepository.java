package br.com.zupacademy.eduardo.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
}
