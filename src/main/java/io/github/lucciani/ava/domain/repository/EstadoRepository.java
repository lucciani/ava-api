package io.github.lucciani.ava.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Estado;

@Repository
public interface EstadoRepository extends CustomJpaRepository<Estado, Long>, 
	EstadoRepositoryQueries, JpaSpecificationExecutor<Estado> {
	
	@Query("FROM Estado e JOIN FETCH e.regiao")
	List<Estado> findAll();
	
}
