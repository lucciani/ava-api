package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.CredeNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.model.Crede;
import io.github.lucciani.ava.domain.repository.CredeRepository;

@Service
public class CadastroCredeService {

	private static final String MSG_CREDE_EM_USO 
			= "Crede de código %d não pode ser removida, pois está em uso.";
	
	@Autowired
	private CredeRepository credeRepository;
	
	@Transactional
	public Crede salvar(Crede crede) {
		return credeRepository.save(crede);
	}

	@Transactional
	public void remover(Long credeId) {
		try {
			credeRepository.deleteById(credeId);
			credeRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CredeNaoEncontradaException(credeId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CREDE_EM_USO, credeId));
		}

	}
	
	public Crede buscarSeExistir(Long credeId) {
		return credeRepository.findById(credeId).orElseThrow(
				() -> new CredeNaoEncontradaException(credeId));
	}

}
