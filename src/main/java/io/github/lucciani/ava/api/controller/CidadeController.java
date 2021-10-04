package io.github.lucciani.ava.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lucciani.ava.api.assembler.CidadeInputDiassembler;
import io.github.lucciani.ava.api.assembler.CidadeModelAssembler;
import io.github.lucciani.ava.api.model.CidadeCompactModel;
import io.github.lucciani.ava.api.model.CidadeModel;
import io.github.lucciani.ava.api.model.input.CidadeInput;
import io.github.lucciani.ava.api.model.input.CidadeNotIdInput;
import io.github.lucciani.ava.domain.exception.EstadoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.exception.RegiaoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.repository.CidadeRepository;
import io.github.lucciani.ava.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@Autowired
	private CidadeModelAssembler cidadeModelAssembler;

	@Autowired
	private CidadeInputDiassembler cidadeInputDiassembler;

	@GetMapping
	public List<CidadeCompactModel> listar() {
		return cidadeModelAssembler.toCollectionCompactModel(cidadeRepository.findAll());
	}

	@GetMapping(value = "/{cidadeId}")
	public CidadeModel buscar(@PathVariable Long cidadeId) {
		return cidadeModelAssembler.toModel(cadastroCidade.buscarSeExistir(cidadeId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
		try {
			Cidade cidade = cidadeInputDiassembler.toDomainObject(cidadeInput);
			
			return cidadeModelAssembler.toModel(cadastroCidade.salvar(cidade));
		} catch (EstadoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		} catch (RegiaoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping(value = "/{cidadeId}")
	public CidadeModel atualizar(@PathVariable Long cidadeId, @RequestBody CidadeNotIdInput cidadeNotIdInput) {
		try {
			Cidade cidadeAtual = cadastroCidade.buscarSeExistir(cidadeId);

			cidadeInputDiassembler.copyToDomainObject(cidadeNotIdInput, cidadeAtual);

			return cidadeModelAssembler.toModel(cadastroCidade.salvar(cidadeAtual));
		} catch (EstadoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		} catch (RegiaoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping(value = "/{cidadeId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidade.remover(cidadeId);
	}

}
