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

import io.github.lucciani.ava.api.assembler.TipoAlunoInputDiassembler;
import io.github.lucciani.ava.api.assembler.TipoAlunoModelAssembler;
import io.github.lucciani.ava.api.model.TipoAlunoModel;
import io.github.lucciani.ava.api.model.input.TipoAlunoInput;
import io.github.lucciani.ava.domain.model.TipoAluno;
import io.github.lucciani.ava.domain.repository.TipoAlunoRepository;
import io.github.lucciani.ava.domain.service.CadastroTipoAlunoService;

@RestController
@RequestMapping(value = "/tipos-aluno")
public class TipoAlunoController {

	@Autowired
	private TipoAlunoRepository tipoAlunoRepository;

	@Autowired
	private CadastroTipoAlunoService cadastroTipoAluno;
	
	@Autowired
	private TipoAlunoModelAssembler tipoAlunoModelAssembler;
	
	@Autowired
	private TipoAlunoInputDiassembler tipoAlunoInputDiassembler;

	@GetMapping
	public List<TipoAlunoModel> listar() {
		return tipoAlunoModelAssembler.toCollectionModel(tipoAlunoRepository.findAll());
	}

	@GetMapping(value = "/{tipoAlunoId}")
	public TipoAlunoModel buscar(@PathVariable Long tipoAlunoId) {
		return tipoAlunoModelAssembler.toModel(cadastroTipoAluno.buscarSeExistir(tipoAlunoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TipoAlunoModel adicionar(@RequestBody @Valid TipoAlunoInput tipoAlunoInput) {
		TipoAluno tipoAluno = tipoAlunoInputDiassembler.toDomainObject(tipoAlunoInput);
		return tipoAlunoModelAssembler.toModel(cadastroTipoAluno.salvar(tipoAluno));
	}

	@PutMapping(value = "/{tipoAlunoId}")
	public TipoAlunoModel atualizar(@PathVariable Long tipoAlunoId, 
			@RequestBody @Valid TipoAlunoInput tipoAlunoInput) {

		TipoAluno tipoAlunoAtual = cadastroTipoAluno.buscarSeExistir(tipoAlunoId);
		tipoAlunoInputDiassembler.copyToDomainObject(tipoAlunoInput, tipoAlunoAtual);

		return tipoAlunoModelAssembler.toModel(cadastroTipoAluno.salvar(tipoAlunoAtual));
	}

	@DeleteMapping(value = "/{tipoAlunoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long tipoAlunoId) {
		cadastroTipoAluno.remover(tipoAlunoId);
	}
}
