package br.com.zupacademy.eduardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.eduardo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    

}
