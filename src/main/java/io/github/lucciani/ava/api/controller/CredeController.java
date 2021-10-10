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

import io.github.lucciani.ava.api.assembler.CredeInputDiassembler;
import io.github.lucciani.ava.api.assembler.CredeModelAssembler;
import io.github.lucciani.ava.api.model.CredeModel;
import io.github.lucciani.ava.api.model.input.CredeInput;
import io.github.lucciani.ava.domain.model.Crede;
import io.github.lucciani.ava.domain.repository.CredeRepository;
import io.github.lucciani.ava.domain.service.CadastroCredeService;

@RestController
@RequestMapping(value = "/credes")
public class CredeController {

	@Autowired
	private CredeRepository credeRepository;

	@Autowired
	private CadastroCredeService cadastroCrede;
	
	@Autowired
	private CredeModelAssembler credeModelAssembler;
	
	@Autowired
	private CredeInputDiassembler credeInputDiassembler;

	@GetMapping
	public List<CredeModel> listar() {
		return credeModelAssembler.toCollectionModel(credeRepository.findAll());
	}

	@GetMapping(value = "/{credeId}")
	public CredeModel buscar(@PathVariable Long credeId) {
		return credeModelAssembler.toModel(cadastroCrede.buscarSeExistir(credeId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CredeModel adicionar(@RequestBody @Valid CredeInput credeInput) {
		Crede crede = credeInputDiassembler.toDomainObject(credeInput);
		return credeModelAssembler.toModel(cadastroCrede.salvar(crede));
	}

	@PutMapping(value = "/{credeId}")
	public CredeModel atualizar(@PathVariable Long credeId, 
			@RequestBody @Valid CredeInput credeInput) {

		Crede credeAtual = cadastroCrede.buscarSeExistir(credeId);
		
		credeInputDiassembler.copyToDomainObject(credeInput, credeAtual);

		return credeModelAssembler.toModel(cadastroCrede.salvar(credeAtual));
	}

	@DeleteMapping(value = "/{credeId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long credeId) {
		cadastroCrede.remover(credeId);
	}
}
