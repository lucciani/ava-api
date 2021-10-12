package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.TipoAlunoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.TipoAluno;
import io.github.lucciani.ava.domain.repository.TipoAlunoRepository;

@Service
public class CadastroTipoAlunoService {

	private static final String MSG_TIPO_ALUNO_EM_USO = 
			"Tipo aluno de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private TipoAlunoRepository tipoAlunoRepository;

	@Transactional
	public TipoAluno salvar(TipoAluno tipoAluno) {
		return tipoAlunoRepository.save(tipoAluno);
	}

	@Transactional
	public void remover(Long tipoAlunoId) {
		try {
			tipoAlunoRepository.deleteById(tipoAlunoId);
			tipoAlunoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new TipoAlunoNaoEncontradaException(tipoAlunoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_TIPO_ALUNO_EM_USO, tipoAlunoId));
		}

	}

	public TipoAluno buscarSeExistir(Long tipoAlunoId) {
		return tipoAlunoRepository.findById(tipoAlunoId)
				.orElseThrow(() -> new TipoAlunoNaoEncontradaException(tipoAlunoId));
	}

}
