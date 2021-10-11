package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EnderecoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.model.Endereco;
import io.github.lucciani.ava.domain.model.Estado;
import io.github.lucciani.ava.domain.model.Regiao;
import io.github.lucciani.ava.domain.repository.EnderecoRepository;

@Service
public class CadastroEnderecoService {

	private static final String MSG_ENDERECO_EM_USO 
			= "Endereco de código %d não pode ser removido, pois está em uso.";

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@Autowired
	private CadastroRegiaoService cadastroRegiao;

	@Transactional
	public Endereco salvar(Endereco endereco) {
		Long cidadeId = endereco.getCidade().getId();
		Long estadoId = endereco.getCidade().getEstado().getId();
		Long regiaoId = endereco.getCidade().getEstado().getRegiao().getId();
		
		
		Cidade cidade = cadastroCidade.buscarSeExistir(cidadeId);
		Estado estado = cadastroEstado.buscarSeExistir(estadoId);
		Regiao regiao = cadastroRegiao.buscarSeExistir(regiaoId);
		
		endereco.setCidade(cidade);
		endereco.getCidade().setEstado(estado);
		endereco.getCidade().getEstado().setRegiao(regiao);
		
		return enderecoRepository.save(endereco);
	}

	@Transactional
	public void remover(Long enderecoId) {
		try {
			enderecoRepository.deleteById(enderecoId);
			enderecoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EnderecoNaoEncontradaException(enderecoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENDERECO_EM_USO, enderecoId));
		}
	}
	
	public Endereco buscarSeExistir(Long enderecoId) {
		return enderecoRepository.findById(enderecoId).orElseThrow(
				() -> new EnderecoNaoEncontradaException(enderecoId));
	}
}
