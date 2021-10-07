package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Escolaridade;

@Repository
public interface EscolaridadeRepository extends CustomJpaRepository<Escolaridade, Long> {

}
