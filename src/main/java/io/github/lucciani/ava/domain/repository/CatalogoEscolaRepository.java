package io.github.lucciani.ava.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import io.github.lucciani.ava.domain.model.CatalogoEscola;

public interface CatalogoEscolaRepository extends CustomJpaRepository<CatalogoEscola, Long> {

	@Query("from CatalogoEscola ce "
			+ "join fetch ce.endereco e left join fetch e.cidade ci left join fetch ci.estado e left join e.regiao "
			+ "join fetch ce.categoriaAdministrativa "
			+ "join fetch ce.situacaoEscola "
			+ "left join fetch ce.crede "
			+ "join fetch ce.dadosEndereco d left join fetch d.localizacao left join fetch d.pais")
	List<CatalogoEscola> findAll();
	
}
