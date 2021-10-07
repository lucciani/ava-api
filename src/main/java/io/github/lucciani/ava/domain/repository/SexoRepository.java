package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Sexo;

@Repository
public interface SexoRepository extends CustomJpaRepository<Sexo, Long> {

}
