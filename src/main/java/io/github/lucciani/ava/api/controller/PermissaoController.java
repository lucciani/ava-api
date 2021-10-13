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

import io.github.lucciani.ava.api.assembler.PermissaoInputDiassembler;
import io.github.lucciani.ava.api.assembler.PermissaoModelAssembler;
import io.github.lucciani.ava.api.model.PermissaoModel;
import io.github.lucciani.ava.api.model.input.PermissaoInput;
import io.github.lucciani.ava.domain.model.Permissao;
import io.github.lucciani.ava.domain.repository.PermissaoRepository;
import io.github.lucciani.ava.domain.service.CadastroPermissaoService;

@RestController
@RequestMapping(value = "/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Autowired
	private CadastroPermissaoService cadastroPermissao;
	
	@Autowired
	private PermissaoModelAssembler permissaoModelAssembler;
	
	@Autowired
	private PermissaoInputDiassembler permissaoInputDiassembler;

	@GetMapping
	public List<PermissaoModel> listar() {
		return permissaoModelAssembler.toCollectionModel(permissaoRepository.findAll());
	}

	@GetMapping(value = "/{permissaoId}")
	public PermissaoModel buscar(@PathVariable Long permissaoId) {
		return permissaoModelAssembler.toModel(cadastroPermissao.buscarSeExistir(permissaoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PermissaoModel adicionar(@RequestBody @Valid PermissaoInput permissaoInput) {
		Permissao permissao = permissaoInputDiassembler.toDomainObject(permissaoInput);
		return permissaoModelAssembler.toModel(cadastroPermissao.salvar(permissao));
	}

	@PutMapping(value = "/{permissaoId}")
	public PermissaoModel atualizar(@PathVariable Long permissaoId, 
			@RequestBody @Valid PermissaoInput permissaoInput) {

		Permissao permissaoAtual = cadastroPermissao.buscarSeExistir(permissaoId);
		
		permissaoInputDiassembler.copyToDomainObject(permissaoInput, permissaoAtual);

		return permissaoModelAssembler.toModel(cadastroPermissao.salvar(permissaoAtual));
	}

	@DeleteMapping(value = "/{permissaoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long permissaoId) {
		cadastroPermissao.remover(permissaoId);
	}
}
