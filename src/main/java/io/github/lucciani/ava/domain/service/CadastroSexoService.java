package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.SexoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Sexo;
import io.github.lucciani.ava.domain.repository.SexoRepository;

@Service
public class CadastroSexoService {

	private static final String MSG_SEXO_EM_USO = 
			"Sexo de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private SexoRepository sexoRepository;

	@Transactional
	public Sexo salvar(Sexo sexo) {
		return sexoRepository.save(sexo);
	}

	@Transactional
	public void remover(Long sexoId) {
		try {
			sexoRepository.deleteById(sexoId);
			sexoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new SexoNaoEncontradaException(sexoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_SEXO_EM_USO, sexoId));
		}

	}

	public Sexo buscarSeExistir(Long sexoId) {
		return sexoRepository.findById(sexoId)
				.orElseThrow(() -> new SexoNaoEncontradaException(sexoId));
	}

}
