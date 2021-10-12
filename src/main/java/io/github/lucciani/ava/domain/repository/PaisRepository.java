package io.github.lucciani.ava.domain.repository;

import java.util.List;

import io.github.lucciani.ava.domain.model.Pais;

public interface PaisRepository extends CustomJpaRepository<Pais, Long> {
	
	List<Pais> findByNome(String nome);

}
