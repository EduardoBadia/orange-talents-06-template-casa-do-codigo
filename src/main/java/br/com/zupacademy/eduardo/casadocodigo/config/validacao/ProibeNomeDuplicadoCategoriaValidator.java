package br.com.zupacademy.eduardo.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovaCategoriaRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;
import br.com.zupacademy.eduardo.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if (errors.hasErrors()) {
			return;
		}
		
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null,
					"Já existe uma outra categoria com o nome de "
							+ request.getNome());
		}
		
	}

}
