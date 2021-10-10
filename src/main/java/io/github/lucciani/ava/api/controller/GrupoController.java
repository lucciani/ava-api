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

import io.github.lucciani.ava.api.assembler.GrupoInputDiassembler;
import io.github.lucciani.ava.api.assembler.GrupoModelAssembler;
import io.github.lucciani.ava.api.model.GrupoModel;
import io.github.lucciani.ava.api.model.input.GrupoInput;
import io.github.lucciani.ava.domain.model.Grupo;
import io.github.lucciani.ava.domain.repository.GrupoRepository;
import io.github.lucciani.ava.domain.service.CadastroGrupoService;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoController {

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private CadastroGrupoService cadastroGrupo;
	
	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@Autowired
	private GrupoInputDiassembler grupoInputDiassembler;

	@GetMapping
	public List<GrupoModel> listar() {
		return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
	}

	@GetMapping(value = "/{grupoId}")
	public GrupoModel buscar(@PathVariable Long grupoId) {
		return grupoModelAssembler.toModel(cadastroGrupo.buscarSeExistir(grupoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public GrupoModel adicionar(@RequestBody @Valid GrupoInput grupoInput) {
		Grupo grupo = grupoInputDiassembler.toDomainObject(grupoInput);
		return grupoModelAssembler.toModel(cadastroGrupo.salvar(grupo));
	}

	@PutMapping(value = "/{grupoId}")
	public GrupoModel atualizar(@PathVariable Long grupoId, 
			@RequestBody @Valid GrupoInput grupoInput) {

		Grupo grupoAtual = cadastroGrupo.buscarSeExistir(grupoId);
		
		grupoInputDiassembler.copyToDomainObject(grupoInput, grupoAtual);

		return grupoModelAssembler.toModel(cadastroGrupo.salvar(grupoAtual));
	}

	@DeleteMapping(value = "/{grupoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		cadastroGrupo.remover(grupoId);
	}
}
