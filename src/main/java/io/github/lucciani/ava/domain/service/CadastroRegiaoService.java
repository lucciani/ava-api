package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.RegiaoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Regiao;
import io.github.lucciani.ava.domain.repository.RegiaoRepository;

@Service
public class CadastroRegiaoService {

	private static final String MSG_TIPO_DOCUMENTO_EM_USO 
			= "Regiao de código %d não pode ser removida, pois está em uso.";
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Transactional
	public Regiao salvar(Regiao regiao) {
		return regiaoRepository.save(regiao);
	}

	@Transactional
	public void remover(Long regiaoId) {
		try {
			regiaoRepository.deleteById(regiaoId);
			regiaoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new RegiaoNaoEncontradaException(regiaoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_TIPO_DOCUMENTO_EM_USO, regiaoId));
		}

	}
	
	public Regiao buscarSeExistir(Long regiaoId) {
		return regiaoRepository.findById(regiaoId).orElseThrow(
				() -> new RegiaoNaoEncontradaException(regiaoId));
	}

}
