package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.EstadoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Estado;
import io.github.lucciani.ava.domain.model.Regiao;
import io.github.lucciani.ava.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO 
			= "Estado de código %d não pode ser removido, pois está em uso.";

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroRegiaoService cadastroRegiao;

	@Transactional
	public Estado salvar(Estado estado) {
		Long regiaoId = estado.getRegiao().getId();
		Regiao regiao = cadastroRegiao.buscarSeExistir(regiaoId);
		
		estado.setRegiao(regiao);
		
		return estadoRepository.save(estado);
	}

	@Transactional
	public void remover(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
			estadoRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradaException(estadoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}
	
	public Estado buscarSeExistir(Long estadoId) {
		return estadoRepository.findById(estadoId).orElseThrow(
				() -> new EstadoNaoEncontradaException(estadoId));
	}
}
