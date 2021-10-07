package io.github.lucciani.ava.domain.repository;

import java.util.List;

import io.github.lucciani.ava.domain.model.Estado;

public interface EstadoRepositoryQueries {

	List<Estado> find(String nome, String sigla);

}