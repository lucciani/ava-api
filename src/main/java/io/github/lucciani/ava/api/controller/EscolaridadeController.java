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

import io.github.lucciani.ava.api.assembler.EscolaridadeInputDiassembler;
import io.github.lucciani.ava.api.assembler.EscolaridadeModelAssembler;
import io.github.lucciani.ava.api.model.EscolaridadeModel;
import io.github.lucciani.ava.api.model.input.EscolaridadeInput;
import io.github.lucciani.ava.domain.model.Escolaridade;
import io.github.lucciani.ava.domain.repository.EscolaridadeRepository;
import io.github.lucciani.ava.domain.service.CadastroEscolaridadeService;

@RestController
@RequestMapping(value = "/escolaridades")
public class EscolaridadeController {

	@Autowired
	private EscolaridadeRepository escolaridadeRepository;

	@Autowired
	private CadastroEscolaridadeService cadastroEscolaridade;
	
	@Autowired
	private EscolaridadeModelAssembler escolaridadeModelAssembler;
	
	@Autowired
	private EscolaridadeInputDiassembler escolaridadeInputDiassembler;

	@GetMapping
	public List<EscolaridadeModel> listar() {
		return escolaridadeModelAssembler.toCollectionModel(escolaridadeRepository.findAll());
	}

	@GetMapping(value = "/{escolaridadeId}")
	public EscolaridadeModel buscar(@PathVariable Long escolaridadeId) {
		return escolaridadeModelAssembler.toModel(cadastroEscolaridade.buscarSeExistir(escolaridadeId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EscolaridadeModel adicionar(@RequestBody @Valid EscolaridadeInput escolaridadeInput) {
		Escolaridade escolaridade = escolaridadeInputDiassembler.toDomainObject(escolaridadeInput);
		return escolaridadeModelAssembler.toModel(cadastroEscolaridade.salvar(escolaridade));
	}

	@PutMapping(value = "/{escolaridadeId}")
	public EscolaridadeModel atualizar(@PathVariable Long escolaridadeId, 
			@RequestBody @Valid EscolaridadeInput escolaridadeInput) {

		Escolaridade escolaridadeAtual = cadastroEscolaridade.buscarSeExistir(escolaridadeId);
		escolaridadeInputDiassembler.copyToDomainObject(escolaridadeInput, escolaridadeAtual);

		return escolaridadeModelAssembler.toModel(cadastroEscolaridade.salvar(escolaridadeAtual));
	}

	@DeleteMapping(value = "/{escolaridadeId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long escolaridadeId) {
		cadastroEscolaridade.remover(escolaridadeId);
	}
}
