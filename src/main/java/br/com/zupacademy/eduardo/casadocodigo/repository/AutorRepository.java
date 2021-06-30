package br.com.zupacademy.eduardo.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    

}
