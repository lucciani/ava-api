package io.github.lucciani.ava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.EscolaPrivada;

@Repository
public interface EscolaPrivadaRepository extends JpaRepository<EscolaPrivada, Long> {

}
