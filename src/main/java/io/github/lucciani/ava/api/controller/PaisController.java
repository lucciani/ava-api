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

import io.github.lucciani.ava.api.assembler.PaisInputDiassembler;
import io.github.lucciani.ava.api.assembler.PaisModelAssembler;
import io.github.lucciani.ava.api.model.PaisModel;
import io.github.lucciani.ava.api.model.input.PaisInput;
import io.github.lucciani.ava.api.model.input.PaisNotIdInput;
import io.github.lucciani.ava.domain.model.Pais;
import io.github.lucciani.ava.domain.repository.PaisRepository;
import io.github.lucciani.ava.domain.service.CadastroPaisService;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private CadastroPaisService cadastroPais;
	
	@Autowired
	private PaisModelAssembler paisModelAssembler;
	
	@Autowired
	private PaisInputDiassembler paisInputDiassembler;

	@GetMapping
	public List<PaisModel> listar() {
		return paisModelAssembler.toCollectionModel(paisRepository.findAll());
	}

	@GetMapping(value = "/{paisId}")
	public PaisModel buscar(@PathVariable Long paisId) {
		return paisModelAssembler.toModel(cadastroPais.buscarSeExistir(paisId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaisModel adicionar(@RequestBody @Valid PaisInput paisInput) {
		Pais pais = paisInputDiassembler.toDomainObject(paisInput);
		return paisModelAssembler.toModel(cadastroPais.salvar(pais));
	}

	@PutMapping(value = "/{paisId}")
	public PaisModel atualizar(@PathVariable Long paisId, 
			@RequestBody @Valid PaisNotIdInput paisNotIdInput) {

		Pais paisAtual = cadastroPais.buscarSeExistir(paisId);
		
		paisInputDiassembler.copyToDomainObjectNotId(paisNotIdInput, paisAtual);

		return paisModelAssembler.toModel(cadastroPais.salvar(paisAtual));
	}

	@DeleteMapping(value = "/{paisId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long paisId) {
		cadastroPais.remover(paisId);
	}
}
