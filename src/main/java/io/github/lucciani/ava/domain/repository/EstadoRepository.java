package io.github.lucciani.ava.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("FROM Estado e JOIN FETCH e.regiao")
	List<Estado> findAll();

}
