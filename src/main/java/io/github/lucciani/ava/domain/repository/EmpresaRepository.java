package io.github.lucciani.ava.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.lucciani.ava.domain.model.Empresa;

public interface EmpresaRepository extends CustomJpaRepository<Empresa, Long> {
	
	Optional<Empresa> findByCnpj(String cnpj);
	
	List<Empresa> findByRazaoSocialContaining(String razaoSocial);

}
