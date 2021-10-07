package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.TipoAluno;

@Repository
public interface TipoAlunoRepository extends CustomJpaRepository<TipoAluno, Long> {

}
