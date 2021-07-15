package br.com.zupacademy.eduardo.casadocodigo.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.StateInCountry;
import br.com.zupacademy.eduardo.casadocodigo.controller.request.NovoEstadoRequest;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Estado;

public class StateInCountryValidator implements ConstraintValidator<StateInCountry, NovoEstadoRequest>{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean isValid(NovoEstadoRequest estadoRequest, ConstraintValidatorContext context) {
		
		
		Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.nome = :nome AND e.pais.id = :id");
		query.setParameter("id", estadoRequest.getIdPais());
		query.setParameter("nome", estadoRequest.getNome());
		List<?> list = query.getResultList();
		return list.isEmpty();
	}
}
