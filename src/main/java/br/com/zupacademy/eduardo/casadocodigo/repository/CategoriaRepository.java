package br.com.zupacademy.eduardo.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
