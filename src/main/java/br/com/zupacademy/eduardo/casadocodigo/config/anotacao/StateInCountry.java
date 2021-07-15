package br.com.zupacademy.eduardo.casadocodigo.config.anotacao;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.eduardo.casadocodigo.config.validacao.StateInCountryValidator;

@Documented
@Constraint(validatedBy = {StateInCountryValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface StateInCountry {
        
	String message() default "O estado já foi registrado para o país";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; 
}
