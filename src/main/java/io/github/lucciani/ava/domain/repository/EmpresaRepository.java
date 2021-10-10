package io.github.lucciani.ava.domain.repository;

import java.util.Optional;

import io.github.lucciani.ava.domain.model.Empresa;

public interface EmpresaRepository extends CustomJpaRepository<Empresa, Long> {
	
	Optional<Empresa> findByCnpj(String cnpj);
	
	Optional<Empresa> findByRazaoSocialContaining(String razaoSocial);

}
