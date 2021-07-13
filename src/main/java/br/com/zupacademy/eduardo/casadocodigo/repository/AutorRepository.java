package br.com.zupacademy.eduardo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
	
	Optional<Autor> findByEmail(String email);
}
