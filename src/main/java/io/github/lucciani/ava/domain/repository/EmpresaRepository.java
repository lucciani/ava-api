package io.github.lucciani.ava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucciani.ava.domain.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
