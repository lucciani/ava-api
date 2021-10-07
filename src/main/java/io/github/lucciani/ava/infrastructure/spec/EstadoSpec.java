package io.github.lucciani.ava.infrastructure.spec;

import org.springframework.data.jpa.domain.Specification;

import io.github.lucciani.ava.domain.model.Estado;

public class EstadoSpec {

	public static Specification<Estado> comSigla(String sigla) {
		return (root, query, builder) -> builder.equal(root.get("sigla"), sigla);
	}

	public static Specification<Estado> comNome(String nome) {
		return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
	}

}
