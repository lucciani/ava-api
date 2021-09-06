package io.github.lucciani.ava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.AlunoEscolaPublica;

@Repository
public interface AlunoEscolaPublicaRepository extends JpaRepository<AlunoEscolaPublica, Long> {

}
