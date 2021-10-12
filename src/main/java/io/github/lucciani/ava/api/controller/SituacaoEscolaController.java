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

import io.github.lucciani.ava.api.assembler.SituacaoEscolaInputDiassembler;
import io.github.lucciani.ava.api.assembler.SituacaoEscolaModelAssembler;
import io.github.lucciani.ava.api.model.SituacaoEscolaModel;
import io.github.lucciani.ava.api.model.input.SituacaoEscolaInput;
import io.github.lucciani.ava.domain.model.SituacaoEscola;
import io.github.lucciani.ava.domain.repository.SituacaoEscolaRepository;
import io.github.lucciani.ava.domain.service.CadastroSituacaoEscolaService;

@RestController
@RequestMapping(value = "/situacoes-escolares")
public class SituacaoEscolaController {

	@Autowired
	private SituacaoEscolaRepository situacaoEscolaRepository;

	@Autowired
	private CadastroSituacaoEscolaService cadastroSituacaoEscola;
	
	@Autowired
	private SituacaoEscolaModelAssembler situacaoEscolaModelAssembler;
	
	@Autowired
	private SituacaoEscolaInputDiassembler situacaoEscolaInputDiassembler;

	@GetMapping
	public List<SituacaoEscolaModel> listar() {
		return situacaoEscolaModelAssembler.toCollectionModel(situacaoEscolaRepository.findAll());
	}

	@GetMapping(value = "/{situacaoEscolaId}")
	public SituacaoEscolaModel buscar(@PathVariable Long situacaoEscolaId) {
		return situacaoEscolaModelAssembler.toModel(cadastroSituacaoEscola.buscarSeExistir(situacaoEscolaId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public SituacaoEscolaModel adicionar(@RequestBody @Valid SituacaoEscolaInput situacaoEscolaInput) {
		SituacaoEscola situacaoEscola = situacaoEscolaInputDiassembler.toDomainObject(situacaoEscolaInput);
		return situacaoEscolaModelAssembler.toModel(cadastroSituacaoEscola.salvar(situacaoEscola));
	}

	@PutMapping(value = "/{situacaoEscolaId}")
	public SituacaoEscolaModel atualizar(@PathVariable Long situacaoEscolaId, 
			@RequestBody @Valid SituacaoEscolaInput situacaoEscolaInput) {

		SituacaoEscola situacaoEscolaAtual = cadastroSituacaoEscola.buscarSeExistir(situacaoEscolaId);
		situacaoEscolaInputDiassembler.copyToDomainObject(situacaoEscolaInput, situacaoEscolaAtual);

		return situacaoEscolaModelAssembler.toModel(cadastroSituacaoEscola.salvar(situacaoEscolaAtual));
	}

	@DeleteMapping(value = "/{situacaoEscolaId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long situacaoEscolaId) {
		cadastroSituacaoEscola.remover(situacaoEscolaId);
	}
}
