package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.LocalizacaoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Localizacao;
import io.github.lucciani.ava.domain.repository.LocalizacaoRepository;

@Service
public class CadastroLocalizacaoService {

	private static final String MSG_LOCALIZACAO_EM_USO = 
			"Localização de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private LocalizacaoRepository localRepository;

	@Transactional
	public Localizacao salvar(Localizacao localizacao) {
		return localRepository.save(localizacao);
	}

	@Transactional
	public void remover(Long localizacaoId) {
		try {
			localRepository.deleteById(localizacaoId);
			localRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new LocalizacaoNaoEncontradaException(localizacaoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_LOCALIZACAO_EM_USO, localizacaoId));
		}

	}

	public Localizacao buscarSeExistir(Long localizacaoId) {
		return localRepository.findById(localizacaoId)
				.orElseThrow(() -> new LocalizacaoNaoEncontradaException(localizacaoId));
	}

}
