package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.EntidadeNaoEncontradaException;
import io.github.lucciani.ava.domain.model.TipoDocumento;
import io.github.lucciani.ava.domain.repository.TipoDocumentoRepository;

@Service
public class CadastroTipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public TipoDocumento salvar(TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}

	public void remover(Long tipoDocumentoId) {
		try {
			tipoDocumentoRepository.deleteById(tipoDocumentoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro do tipo documento com o código %d", tipoDocumentoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Tipo documento de código %d não pode ser removida, pois está em uso.", tipoDocumentoId));
		}

	}

}
