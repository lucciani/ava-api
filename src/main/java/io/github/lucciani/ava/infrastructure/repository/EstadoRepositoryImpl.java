package io.github.lucciani.ava.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import io.github.lucciani.ava.domain.model.Estado;
import io.github.lucciani.ava.domain.repository.EstadoRepositoryQueries;

@Repository
public class EstadoRepositoryImpl implements EstadoRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> find(String nome, String sigla){ 
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
		Root<Estado> root = criteria.from(Estado.class);
		
		var predicates = new ArrayList<Predicate>();
		
		if (StringUtils.hasLength(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		
		if (StringUtils.hasLength(sigla)) {
			predicates.add(builder.equal(root.get("sigla"), sigla));
		}
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Estado> query = manager.createQuery(criteria);
		return query.getResultList();
		
	}

}
