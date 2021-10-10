package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EmpresaNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.model.Empresa;
import io.github.lucciani.ava.domain.repository.EmpresaRepository;

@Service
public class CadastroEmpresaService {

	private static final String MSG_EMPRESA_EM_USO = 
			"Empresa de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private EmpresaRepository empresaRepository;

	@Transactional
	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Transactional
	public void remover(Long empresaId) {
		try {
			empresaRepository.deleteById(empresaId);
			empresaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EmpresaNaoEncontradaException(empresaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_EMPRESA_EM_USO, empresaId));
		}

	}

	public Empresa buscarSeExistir(Long empresaId) {
		return empresaRepository.findById(empresaId)
				.orElseThrow(() -> new EmpresaNaoEncontradaException(empresaId));
	}

}
