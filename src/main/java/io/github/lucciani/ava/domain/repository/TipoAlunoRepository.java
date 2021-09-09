package io.github.lucciani.ava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.TipoAluno;

@Repository
public interface TipoAlunoRepository extends JpaRepository<TipoAluno, Long> {

}
