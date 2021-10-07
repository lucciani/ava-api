package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Genero;

@Repository
public interface GeneroRepository extends CustomJpaRepository<Genero, Long> {

}
