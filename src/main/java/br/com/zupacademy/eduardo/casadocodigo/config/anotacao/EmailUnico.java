package br.com.zupacademy.eduardo.casadocodigo.config.anotacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.eduardo.casadocodigo.config.validacao.EmailUnicoValidador;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailUnicoValidador.class)
public @interface EmailUnico {

	String message() default "O email precisa ser único no sistema";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String value() default "";
}
