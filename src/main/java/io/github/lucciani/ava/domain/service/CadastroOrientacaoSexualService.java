package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.OrientacaoSexualNaoEncontradaException;
import io.github.lucciani.ava.domain.model.OrientacaoSexual;
import io.github.lucciani.ava.domain.repository.OrientacaoSexualRepository;

@Service
public class CadastroOrientacaoSexualService {

	private static final String MSG_ORIENTACAO_SEXUAL_EM_USO = 
			"Orientação sexual de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private OrientacaoSexualRepository orientacaoSexualRepository;

	@Transactional
	public OrientacaoSexual salvar(OrientacaoSexual orientacaoSexual) {
		return orientacaoSexualRepository.save(orientacaoSexual);
	}

	@Transactional
	public void remover(Long orientacaoSexualId) {
		try {
			orientacaoSexualRepository.deleteById(orientacaoSexualId);
			orientacaoSexualRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new OrientacaoSexualNaoEncontradaException(orientacaoSexualId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ORIENTACAO_SEXUAL_EM_USO, orientacaoSexualId));
		}

	}

	public OrientacaoSexual buscarSeExistir(Long orientacaoSexualId) {
		return orientacaoSexualRepository.findById(orientacaoSexualId)
				.orElseThrow(() -> new OrientacaoSexualNaoEncontradaException(orientacaoSexualId));
	}

}
