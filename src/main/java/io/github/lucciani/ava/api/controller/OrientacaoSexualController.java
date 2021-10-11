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

import io.github.lucciani.ava.api.assembler.OrientacaoSexualInputDiassembler;
import io.github.lucciani.ava.api.assembler.OrientacaoSexualModelAssembler;
import io.github.lucciani.ava.api.model.OrientacaoSexualModel;
import io.github.lucciani.ava.api.model.input.OrientacaoSexualInput;
import io.github.lucciani.ava.domain.model.OrientacaoSexual;
import io.github.lucciani.ava.domain.repository.OrientacaoSexualRepository;
import io.github.lucciani.ava.domain.service.CadastroOrientacaoSexualService;

@RestController
@RequestMapping(value = "/orientacoes-sexuais")
public class OrientacaoSexualController {

	@Autowired
	private OrientacaoSexualRepository orientacaoSexualRepository;

	@Autowired
	private CadastroOrientacaoSexualService cadastroOrientacaoSexual;
	
	@Autowired
	private OrientacaoSexualModelAssembler orientacaoSexualModelAssembler;
	
	@Autowired
	private OrientacaoSexualInputDiassembler orientacaoSexualInputDiassembler;

	@GetMapping
	public List<OrientacaoSexualModel> listar() {
		return orientacaoSexualModelAssembler.toCollectionModel(orientacaoSexualRepository.findAll());
	}

	@GetMapping(value = "/{orientacaoSexualId}")
	public OrientacaoSexualModel buscar(@PathVariable Long orientacaoSexualId) {
		return orientacaoSexualModelAssembler.toModel(cadastroOrientacaoSexual.buscarSeExistir(orientacaoSexualId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrientacaoSexualModel adicionar(@RequestBody @Valid OrientacaoSexualInput orientacaoSexualInput) {
		OrientacaoSexual orientacaoSexual = orientacaoSexualInputDiassembler.toDomainObject(orientacaoSexualInput);
		return orientacaoSexualModelAssembler.toModel(cadastroOrientacaoSexual.salvar(orientacaoSexual));
	}

	@PutMapping(value = "/{orientacaoSexualId}")
	public OrientacaoSexualModel atualizar(@PathVariable Long orientacaoSexualId, 
			@RequestBody @Valid OrientacaoSexualInput orientacaoSexualInput) {

		OrientacaoSexual orientacaoSexualAtual = cadastroOrientacaoSexual.buscarSeExistir(orientacaoSexualId);
		orientacaoSexualInputDiassembler.copyToDomainObject(orientacaoSexualInput, orientacaoSexualAtual);

		return orientacaoSexualModelAssembler.toModel(cadastroOrientacaoSexual.salvar(orientacaoSexualAtual));
	}

	@DeleteMapping(value = "/{orientacaoSexualId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long orientacaoSexualId) {
		cadastroOrientacaoSexual.remover(orientacaoSexualId);
	}
}
