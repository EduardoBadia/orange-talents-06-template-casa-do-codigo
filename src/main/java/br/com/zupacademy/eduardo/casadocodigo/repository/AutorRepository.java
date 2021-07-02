package br.com.zupacademy.eduardo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    public Optional<Autor> findByEmail(String email);
}
