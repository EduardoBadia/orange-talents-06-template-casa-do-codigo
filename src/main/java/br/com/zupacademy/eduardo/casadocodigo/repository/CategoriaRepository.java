package br.com.zupacademy.eduardo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

public interface CategoriaRepository  extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);
}
