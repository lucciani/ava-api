package io.github.lucciani.ava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.model.AlunoId;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, AlunoId> {

}
