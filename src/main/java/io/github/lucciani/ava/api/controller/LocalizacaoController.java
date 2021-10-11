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

import io.github.lucciani.ava.api.assembler.LocalizacaoInputDiassembler;
import io.github.lucciani.ava.api.assembler.LocalizacaoModelAssembler;
import io.github.lucciani.ava.api.model.LocalizacaoModel;
import io.github.lucciani.ava.api.model.input.LocalizacaoInput;
import io.github.lucciani.ava.domain.model.Localizacao;
import io.github.lucciani.ava.domain.repository.LocalizacaoRepository;
import io.github.lucciani.ava.domain.service.CadastroLocalizacaoService;

@RestController
@RequestMapping(value = "/localizacoes")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Autowired
	private CadastroLocalizacaoService cadastroLocalizacao;
	
	@Autowired
	private LocalizacaoModelAssembler localizacaoModelAssembler;
	
	@Autowired
	private LocalizacaoInputDiassembler localizacaoInputDiassembler;

	@GetMapping
	public List<LocalizacaoModel> listar() {
		return localizacaoModelAssembler.toCollectionModel(localizacaoRepository.findAll());
	}

	@GetMapping(value = "/{localizacaoId}")
	public LocalizacaoModel buscar(@PathVariable Long localizacaoId) {
		return localizacaoModelAssembler.toModel(cadastroLocalizacao.buscarSeExistir(localizacaoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public LocalizacaoModel adicionar(@RequestBody @Valid LocalizacaoInput localizacaoInput) {
		Localizacao localizacao = localizacaoInputDiassembler.toDomainObject(localizacaoInput);
		return localizacaoModelAssembler.toModel(cadastroLocalizacao.salvar(localizacao));
	}

	@PutMapping(value = "/{localizacaoId}")
	public LocalizacaoModel atualizar(@PathVariable Long localizacaoId, 
			@RequestBody @Valid LocalizacaoInput localizacaoInput) {

		Localizacao localizacaoAtual = cadastroLocalizacao.buscarSeExistir(localizacaoId);
		localizacaoInputDiassembler.copyToDomainObject(localizacaoInput, localizacaoAtual);

		return localizacaoModelAssembler.toModel(cadastroLocalizacao.salvar(localizacaoAtual));
	}

	@DeleteMapping(value = "/{localizacaoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long localizacaoId) {
		cadastroLocalizacao.remover(localizacaoId);
	}
}
