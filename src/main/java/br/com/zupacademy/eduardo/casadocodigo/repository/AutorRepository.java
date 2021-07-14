package br.com.zupacademy.eduardo.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
	
}
