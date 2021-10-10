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

import io.github.lucciani.ava.api.assembler.CategoriaAdministrativaInputDiassembler;
import io.github.lucciani.ava.api.assembler.CategoriaAdministrativaModelAssembler;
import io.github.lucciani.ava.api.model.CategoriaAdministrativaModel;
import io.github.lucciani.ava.api.model.input.CategoriaAdministrativaInput;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;
import io.github.lucciani.ava.domain.repository.CategoriaAdministrativaRepository;
import io.github.lucciani.ava.domain.service.CadastroCategoriaAdministrativaService;

@RestController
@RequestMapping(value = "/categorias-administrativa")
public class CategoriaAdministrativaController {

	@Autowired
	private CategoriaAdministrativaRepository categoriaAdministrativaRepository;

	@Autowired
	private CadastroCategoriaAdministrativaService cadastroCategoriaAdministrativa;
	
	@Autowired
	private CategoriaAdministrativaModelAssembler categoriaAdministrativaModelAssembler;
	
	@Autowired
	private CategoriaAdministrativaInputDiassembler categoriaAdministrativaInputDiassembler;

	@GetMapping
	public List<CategoriaAdministrativaModel> listar() {
		return categoriaAdministrativaModelAssembler
				.toCollectionModel(categoriaAdministrativaRepository.findAll());
	}

	@GetMapping(value = "/{categoriaAdministrativaId}")
	public CategoriaAdministrativaModel buscar(@PathVariable Long categoriaAdministrativaId) {
		return categoriaAdministrativaModelAssembler
				.toModel(cadastroCategoriaAdministrativa
						.buscarSeExistir(categoriaAdministrativaId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CategoriaAdministrativaModel adicionar(
			@RequestBody @Valid CategoriaAdministrativaInput categoriaAdministrativaInput) {
		CategoriaAdministrativa categoriaAdministrativa = categoriaAdministrativaInputDiassembler
				.toDomainObject(categoriaAdministrativaInput);
		return categoriaAdministrativaModelAssembler
				.toModel(cadastroCategoriaAdministrativa.salvar(categoriaAdministrativa));
	}

	@PutMapping(value = "/{categoriaAdministrativaId}")
	public CategoriaAdministrativaModel atualizar(@PathVariable Long categoriaAdministrativaId, 
			@RequestBody @Valid CategoriaAdministrativaInput categoriaAdministrativaInput) {

		CategoriaAdministrativa categoriaAdministrativaAtual = cadastroCategoriaAdministrativa
				.buscarSeExistir(categoriaAdministrativaId);
		categoriaAdministrativaInputDiassembler
				.copyToDomainObject(categoriaAdministrativaInput, categoriaAdministrativaAtual);

		return categoriaAdministrativaModelAssembler
				.toModel(cadastroCategoriaAdministrativa.salvar(categoriaAdministrativaAtual));
	}

	@DeleteMapping(value = "/{categoriaAdministrativaId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long categoriaAdministrativaId) {
		cadastroCategoriaAdministrativa.remover(categoriaAdministrativaId);
	}
}
