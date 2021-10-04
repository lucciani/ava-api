package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.TipoDocumentoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.TipoDocumento;
import io.github.lucciani.ava.domain.repository.TipoDocumentoRepository;

@Service
public class CadastroTipoDocumentoService {

	private static final String MSG_TIPO_DOCUMENTO_EM_USO = "Tipo documento de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Transactional
	public TipoDocumento salvar(TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}

	@Transactional
	public void remover(Long tipoDocumentoId) {
		try {
			tipoDocumentoRepository.deleteById(tipoDocumentoId);
			tipoDocumentoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new TipoDocumentoNaoEncontradaException(tipoDocumentoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_TIPO_DOCUMENTO_EM_USO, tipoDocumentoId));
		}

	}

	public TipoDocumento buscarSeExistir(Long tipoDOcumentoId) {
		return tipoDocumentoRepository.findById(tipoDOcumentoId)
				.orElseThrow(() -> new TipoDocumentoNaoEncontradaException(tipoDOcumentoId));
	}

}
