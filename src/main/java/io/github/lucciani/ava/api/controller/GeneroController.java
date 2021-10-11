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

import io.github.lucciani.ava.api.assembler.GeneroInputDiassembler;
import io.github.lucciani.ava.api.assembler.GeneroModelAssembler;
import io.github.lucciani.ava.api.model.GeneroModel;
import io.github.lucciani.ava.api.model.input.GeneroInput;
import io.github.lucciani.ava.domain.model.Genero;
import io.github.lucciani.ava.domain.repository.GeneroRepository;
import io.github.lucciani.ava.domain.service.CadastroGeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroController {

	@Autowired
	private GeneroRepository generoRepository;

	@Autowired
	private CadastroGeneroService cadastroGenero;
	
	@Autowired
	private GeneroModelAssembler generoModelAssembler;
	
	@Autowired
	private GeneroInputDiassembler generoInputDiassembler;

	@GetMapping
	public List<GeneroModel> listar() {
		return generoModelAssembler.toCollectionModel(generoRepository.findAll());
	}

	@GetMapping(value = "/{generoId}")
	public GeneroModel buscar(@PathVariable Long generoId) {
		return generoModelAssembler.toModel(cadastroGenero.buscarSeExistir(generoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public GeneroModel adicionar(@RequestBody @Valid GeneroInput generoInput) {
		Genero genero = generoInputDiassembler.toDomainObject(generoInput);
		return generoModelAssembler.toModel(cadastroGenero.salvar(genero));
	}

	@PutMapping(value = "/{generoId}")
	public GeneroModel atualizar(@PathVariable Long generoId, 
			@RequestBody @Valid GeneroInput generoInput) {

		Genero generoAtual = cadastroGenero.buscarSeExistir(generoId);
		generoInputDiassembler.copyToDomainObject(generoInput, generoAtual);

		return generoModelAssembler.toModel(cadastroGenero.salvar(generoAtual));
	}

	@DeleteMapping(value = "/{generoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long generoId) {
		cadastroGenero.remover(generoId);
	}
}
