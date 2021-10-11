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

import io.github.lucciani.ava.api.assembler.OcupacaoInputDiassembler;
import io.github.lucciani.ava.api.assembler.OcupacaoModelAssembler;
import io.github.lucciani.ava.api.model.OcupacaoModel;
import io.github.lucciani.ava.api.model.input.OcupacaoInput;
import io.github.lucciani.ava.domain.model.Ocupacao;
import io.github.lucciani.ava.domain.repository.OcupacaoRepository;
import io.github.lucciani.ava.domain.service.CadastroOcupacaoService;

@RestController
@RequestMapping(value = "/ocupacoes")
public class OcupacaoController {

	@Autowired
	private OcupacaoRepository ocupacaoRepository;

	@Autowired
	private CadastroOcupacaoService cadastroOcupacao;
	
	@Autowired
	private OcupacaoModelAssembler ocupacaoModelAssembler;
	
	@Autowired
	private OcupacaoInputDiassembler ocupacaoInputDiassembler;

	@GetMapping
	public List<OcupacaoModel> listar() {
		return ocupacaoModelAssembler.toCollectionModel(ocupacaoRepository.findAll());
	}

	@GetMapping(value = "/{ocupacaoId}")
	public OcupacaoModel buscar(@PathVariable Long ocupacaoId) {
		return ocupacaoModelAssembler.toModel(cadastroOcupacao.buscarSeExistir(ocupacaoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OcupacaoModel adicionar(@RequestBody @Valid OcupacaoInput ocupacaoInput) {
		Ocupacao ocupacao = ocupacaoInputDiassembler.toDomainObject(ocupacaoInput);
		return ocupacaoModelAssembler.toModel(cadastroOcupacao.salvar(ocupacao));
	}

	@PutMapping(value = "/{ocupacaoId}")
	public OcupacaoModel atualizar(@PathVariable Long ocupacaoId, 
			@RequestBody @Valid OcupacaoInput ocupacaoInput) {

		Ocupacao ocupacaoAtual = cadastroOcupacao.buscarSeExistir(ocupacaoId);
		ocupacaoInputDiassembler.copyToDomainObject(ocupacaoInput, ocupacaoAtual);

		return ocupacaoModelAssembler.toModel(cadastroOcupacao.salvar(ocupacaoAtual));
	}

	@DeleteMapping(value = "/{ocupacaoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long ocupacaoId) {
		cadastroOcupacao.remover(ocupacaoId);
	}
}
