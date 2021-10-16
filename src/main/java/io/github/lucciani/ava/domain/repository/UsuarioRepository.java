package io.github.lucciani.ava.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
