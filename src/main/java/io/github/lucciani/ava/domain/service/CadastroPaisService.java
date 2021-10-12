package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.PaisNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Pais;
import io.github.lucciani.ava.domain.repository.PaisRepository;

@Service
public class CadastroPaisService {

	private static final String MSG_PAIS_EM_USO 
			= "Pais de código %d não pode ser removida, pois está em uso.";
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Transactional
	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}

	@Transactional
	public void remover(Long paisId) {
		try {
			paisRepository.deleteById(paisId);
			paisRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PaisNaoEncontradaException(paisId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_PAIS_EM_USO, paisId));
		}

	}
	
	public Pais buscarSeExistir(Long paisId) {
		return paisRepository.findById(paisId).orElseThrow(
				() -> new PaisNaoEncontradaException(paisId));
	}

}
