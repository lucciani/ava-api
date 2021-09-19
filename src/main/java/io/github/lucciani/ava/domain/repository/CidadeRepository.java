package io.github.lucciani.ava.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query("FROM Cidade c JOIN FETCH c.estado")
	List<Cidade> findAll();
	
}
