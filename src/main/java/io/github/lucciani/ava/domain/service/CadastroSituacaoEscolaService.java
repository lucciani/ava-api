package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.SituacaoEscolaNaoEncontradaException;
import io.github.lucciani.ava.domain.model.SituacaoEscola;
import io.github.lucciani.ava.domain.repository.SituacaoEscolaRepository;

@Service
public class CadastroSituacaoEscolaService {

	private static final String MSG_SITUACAO_ESCOLA_EM_USO = 
			"Situação escolar de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private SituacaoEscolaRepository situacaoEscolaRepository;

	@Transactional
	public SituacaoEscola salvar(SituacaoEscola situacaoEscola) {
		return situacaoEscolaRepository.save(situacaoEscola);
	}

	@Transactional
	public void remover(Long situacaoEscolaId) {
		try {
			situacaoEscolaRepository.deleteById(situacaoEscolaId);
			situacaoEscolaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new SituacaoEscolaNaoEncontradaException(situacaoEscolaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_SITUACAO_ESCOLA_EM_USO, situacaoEscolaId));
		}

	}

	public SituacaoEscola buscarSeExistir(Long situacaoEscolaId) {
		return situacaoEscolaRepository.findById(situacaoEscolaId)
				.orElseThrow(() -> new SituacaoEscolaNaoEncontradaException(situacaoEscolaId));
	}

}
