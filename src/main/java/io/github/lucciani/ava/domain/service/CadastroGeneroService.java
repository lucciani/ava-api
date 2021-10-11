package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.GeneroNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Genero;
import io.github.lucciani.ava.domain.repository.GeneroRepository;

@Service
public class CadastroGeneroService {

	private static final String MSG_GENERO_EM_USO = 
			"Genero de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private GeneroRepository generoRepository;

	@Transactional
	public Genero salvar(Genero genero) {
		return generoRepository.save(genero);
	}

	@Transactional
	public void remover(Long generoId) {
		try {
			generoRepository.deleteById(generoId);
			generoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new GeneroNaoEncontradaException(generoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_GENERO_EM_USO, generoId));
		}

	}

	public Genero buscarSeExistir(Long generoId) {
		return generoRepository.findById(generoId)
				.orElseThrow(() -> new GeneroNaoEncontradaException(generoId));
	}

}
