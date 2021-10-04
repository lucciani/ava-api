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

import io.github.lucciani.ava.api.assembler.RegiaoInputDiassembler;
import io.github.lucciani.ava.api.assembler.RegiaoModelAssembler;
import io.github.lucciani.ava.api.model.RegiaoModel;
import io.github.lucciani.ava.api.model.input.RegiaoInput;
import io.github.lucciani.ava.domain.model.Regiao;
import io.github.lucciani.ava.domain.repository.RegiaoRepository;
import io.github.lucciani.ava.domain.service.CadastroRegiaoService;

@RestController
@RequestMapping(value = "/regioes")
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@Autowired
	private CadastroRegiaoService cadastroRegiao;
	
	@Autowired
	private RegiaoModelAssembler regiaoModelAssembler;
	
	@Autowired
	private RegiaoInputDiassembler regiaoInputDiassembler;

	@GetMapping
	public List<RegiaoModel> listar() {
		return regiaoModelAssembler.toCollectionModel(regiaoRepository.findAll());
	}

	@GetMapping(value = "/{regiaoId}")
	public RegiaoModel buscar(@PathVariable Long regiaoId) {
		return regiaoModelAssembler.toModel(cadastroRegiao.buscarSeExistir(regiaoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public RegiaoModel adicionar(@RequestBody @Valid RegiaoInput regiaoInput) {
		Regiao regiao = regiaoInputDiassembler.toDomainObject(regiaoInput);
		return regiaoModelAssembler.toModel(cadastroRegiao.salvar(regiao));
	}

	@PutMapping(value = "/{regiaoId}")
	public RegiaoModel atualizar(@PathVariable Long regiaoId, 
			@RequestBody @Valid RegiaoInput regiaoInput) {

		Regiao regiaoAtual = cadastroRegiao.buscarSeExistir(regiaoId);
		
		regiaoInputDiassembler.copyToDomainObject(regiaoInput, regiaoAtual);

		return regiaoModelAssembler.toModel(cadastroRegiao.salvar(regiaoAtual));
	}

	@DeleteMapping(value = "/{regiaoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long regiaoId) {
		cadastroRegiao.remover(regiaoId);
	}
}
