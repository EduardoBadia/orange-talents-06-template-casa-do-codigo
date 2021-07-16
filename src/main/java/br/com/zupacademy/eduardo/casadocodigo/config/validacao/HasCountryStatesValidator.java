package br.com.zupacademy.eduardo.casadocodigo.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.HasCountryStates;

public class HasCountryStatesValidator implements ConstraintValidator<HasCountryStates, Object> {

	private String domainAttribute;
	private Class<?> klass;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(HasCountryStates params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object id, ConstraintValidatorContext context) {

		Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.pais.id = :id");
		query.setParameter("id", id);
		List<?> list = query.getResultList();
		return list.isEmpty();
	}
}
