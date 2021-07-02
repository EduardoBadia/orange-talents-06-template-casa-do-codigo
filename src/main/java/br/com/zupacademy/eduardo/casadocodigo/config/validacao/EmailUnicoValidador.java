package br.com.zupacademy.eduardo.casadocodigo.config.validacao;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.EmailUnico;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;
import br.com.zupacademy.eduardo.casadocodigo.repository.AutorRepository;

public class EmailUnicoValidador implements ConstraintValidator<EmailUnico, String>{
	
	@Autowired
	private AutorRepository autorRepository;
	 
    @Override
    public void initialize(EmailUnico anotacao) {
        
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Optional<Autor> optAutor = autorRepository.findByEmail(value);
		
		if(optAutor.isPresent())
		{
			return false;
		}
		
		return true;
	}	
}
