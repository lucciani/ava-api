package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.CategoriaAdministrativaNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;
import io.github.lucciani.ava.domain.repository.CategoriaAdministrativaRepository;

@Service
public class CadastroCategoriaAdministrativaService {

	private static final String MSG_CATEGORIA_ADMINISTRATIVA_EM_USO = 
			"Categoria administrativa de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private CategoriaAdministrativaRepository categoriaAdministrativaRepository;

	@Transactional
	public CategoriaAdministrativa salvar(CategoriaAdministrativa categoriaAdministrativa) {
		return categoriaAdministrativaRepository.save(categoriaAdministrativa);
	}

	@Transactional
	public void remover(Long categoriaAdministrativaId) {
		try {
			categoriaAdministrativaRepository.deleteById(categoriaAdministrativaId);
			categoriaAdministrativaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CategoriaAdministrativaNaoEncontradaException(categoriaAdministrativaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CATEGORIA_ADMINISTRATIVA_EM_USO, categoriaAdministrativaId));
		}

	}

	public CategoriaAdministrativa buscarSeExistir(Long categoriaAdministrativaId) {
		return categoriaAdministrativaRepository.findById(categoriaAdministrativaId)
				.orElseThrow(() -> new CategoriaAdministrativaNaoEncontradaException(categoriaAdministrativaId));
	}

}
