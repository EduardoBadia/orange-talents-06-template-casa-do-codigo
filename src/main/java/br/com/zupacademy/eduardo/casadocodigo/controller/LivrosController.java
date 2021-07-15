package br.com.zupacademy.eduardo.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoLivroRequest;
import br.com.zupacademy.eduardo.casadocodigo.controller.response.DetalheSiteLivroResponse;
import br.com.zupacademy.eduardo.casadocodigo.controller.response.LivroResponse;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Livro;
import br.com.zupacademy.eduardo.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private LivroRepository livroRepository;

	@Transactional
	@PostMapping
	//1
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		//1
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}
	
	@GetMapping
	public List<LivroResponse> listaTituloIdDosLivros() {

			List<Livro> livros = livroRepository.findAll();
			return LivroResponse.toResponse(livros);
	} 
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> ExibirDetalheDoLivro(@PathVariable Long id) {
		
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			
				return ResponseEntity.ok(new DetalheSiteLivroResponse(optional.get()));
		}
		return ResponseEntity.notFound().build();

	}
}
