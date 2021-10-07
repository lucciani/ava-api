package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Ocupacao;

@Repository
public interface OcupacaoRepository extends CustomJpaRepository<Ocupacao, Long> {

}
