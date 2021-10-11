package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.EscolaridadeNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Escolaridade;
import io.github.lucciani.ava.domain.repository.EscolaridadeRepository;

@Service
public class CadastroEscolaridadeService {

	private static final String MSG_ESCOLARIDADE_EM_USO = 
			"Escolaridade de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private EscolaridadeRepository escolaridadeRepository;

	@Transactional
	public Escolaridade salvar(Escolaridade escolaridade) {
		return escolaridadeRepository.save(escolaridade);
	}

	@Transactional
	public void remover(Long escolaridadeId) {
		try {
			escolaridadeRepository.deleteById(escolaridadeId);
			escolaridadeRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EscolaridadeNaoEncontradaException(escolaridadeId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ESCOLARIDADE_EM_USO, escolaridadeId));
		}

	}

	public Escolaridade buscarSeExistir(Long escolaridadeId) {
		return escolaridadeRepository.findById(escolaridadeId)
				.orElseThrow(() -> new EscolaridadeNaoEncontradaException(escolaridadeId));
	}

}
