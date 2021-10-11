package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.OcupacaoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Ocupacao;
import io.github.lucciani.ava.domain.repository.OcupacaoRepository;

@Service
public class CadastroOcupacaoService {

	private static final String MSG_OCUPACAO_EM_USO = 
			"Ocupacao de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private OcupacaoRepository ocupacaoRepository;

	@Transactional
	public Ocupacao salvar(Ocupacao ocupacao) {
		return ocupacaoRepository.save(ocupacao);
	}

	@Transactional
	public void remover(Long ocupacaoId) {
		try {
			ocupacaoRepository.deleteById(ocupacaoId);
			ocupacaoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new OcupacaoNaoEncontradaException(ocupacaoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_OCUPACAO_EM_USO, ocupacaoId));
		}

	}

	public Ocupacao buscarSeExistir(Long ocupacaoId) {
		return ocupacaoRepository.findById(ocupacaoId)
				.orElseThrow(() -> new OcupacaoNaoEncontradaException(ocupacaoId));
	}

}
