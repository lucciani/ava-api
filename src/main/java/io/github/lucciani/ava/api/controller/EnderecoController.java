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

import io.github.lucciani.ava.api.assembler.EnderecoInputDiassembler;
import io.github.lucciani.ava.api.assembler.EnderecoModelAssembler;
import io.github.lucciani.ava.api.model.EnderecoCompactModel;
import io.github.lucciani.ava.api.model.EnderecoModel;
import io.github.lucciani.ava.api.model.input.EnderecoInput;
import io.github.lucciani.ava.domain.exception.EnderecoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.model.Endereco;
import io.github.lucciani.ava.domain.repository.EnderecoRepository;
import io.github.lucciani.ava.domain.service.CadastroEnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CadastroEnderecoService cadastroEndereco;
	
	@Autowired
	private EnderecoModelAssembler enderecoModelAssembler;
	
	@Autowired
	private EnderecoInputDiassembler enderecoInputDiassembler;

	@GetMapping
	public List<EnderecoCompactModel> listar() {
		return enderecoModelAssembler.toCollectionCompactModel(enderecoRepository.findAll());
	}

	@GetMapping(value = "/{enderecoId}")
	public EnderecoModel buscar(@PathVariable Long enderecoId) {
		Endereco endereco = cadastroEndereco.buscarSeExistir(enderecoId);
		return enderecoModelAssembler.toModel(endereco);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EnderecoModel adicionar(@RequestBody @Valid EnderecoInput enderecoInput) {
		try {
			Endereco endereco = enderecoInputDiassembler.toDomainObject(enderecoInput);
			return enderecoModelAssembler.toModel(cadastroEndereco.salvar(endereco));
		} catch (EnderecoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping(value = "/{enderecoId}")
	public EnderecoModel atualizar(
			@PathVariable Long enderecoId, 
			@RequestBody @Valid EnderecoInput enderecoInput) {
		
		try {
			Endereco enderecoAtual = cadastroEndereco.buscarSeExistir(enderecoId);
		
			enderecoInputDiassembler.copyToDomainObject(enderecoInput, enderecoAtual);

			return enderecoModelAssembler.toModel(cadastroEndereco.salvar(enderecoAtual));
		} catch (EnderecoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@DeleteMapping(value = "/{enderecoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long enderecoId) {
		cadastroEndereco.remover(enderecoId);
	}

}
