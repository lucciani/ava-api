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

import io.github.lucciani.ava.api.assembler.CatalogoEscolaInputDiassembler;
import io.github.lucciani.ava.api.assembler.CatalogoEscolaModelAssembler;
import io.github.lucciani.ava.api.model.CatalogoEscolaModel;
import io.github.lucciani.ava.api.model.input.CatalogoEscolaInput;
import io.github.lucciani.ava.domain.exception.CategoriaAdministrativaNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.CredeNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EnderecoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.exception.SituacaoEscolaNaoEncontradaException;
import io.github.lucciani.ava.domain.model.CatalogoEscola;
import io.github.lucciani.ava.domain.repository.CatalogoEscolaRepository;
import io.github.lucciani.ava.domain.service.CadastroCatalogoEscolaService;

@RestController
@RequestMapping(value = "/catalogo-escolas")
public class CatalogoEscolaController {

	@Autowired
	private CatalogoEscolaRepository catalogoEscolaRepository;

	@Autowired
	private CadastroCatalogoEscolaService cadastroCatalogoEscola;

	@Autowired
	private CatalogoEscolaModelAssembler catalogoEscolaModelAssembler;

	@Autowired
	private CatalogoEscolaInputDiassembler catalogoEscolaInputDiassembler;

	@GetMapping
	public List<CatalogoEscolaModel> listar() {
		return catalogoEscolaModelAssembler.toCollectionModel(catalogoEscolaRepository.findAll());
	}

	@GetMapping(value = "/{catalogoEscolaId}")
	public CatalogoEscolaModel buscar(@PathVariable Long catalogoEscolaId) {
		return catalogoEscolaModelAssembler.toModel(cadastroCatalogoEscola.buscarSeExistir(catalogoEscolaId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CatalogoEscolaModel adicionar(@RequestBody @Valid CatalogoEscolaInput catalogoEscolaInput) {
		try {
			CatalogoEscola catalogoEscola = catalogoEscolaInputDiassembler.toDomainObject(catalogoEscolaInput);
			
			return catalogoEscolaModelAssembler
					.toModel(cadastroCatalogoEscola.salvar(catalogoEscola));
			
		} catch (CredeNaoEncontradaException
				| CategoriaAdministrativaNaoEncontradaException
				| SituacaoEscolaNaoEncontradaException
				| EnderecoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		} 
	}

	@PutMapping(value = "/{catalogoEscolaId}")
	public CatalogoEscolaModel atualizar(@PathVariable Long catalogoEscolaId, 
			@RequestBody @Valid CatalogoEscolaInput catalogoEscolaInput) {
		try {
			CatalogoEscola CatalogoEscolaAtual = cadastroCatalogoEscola.buscarSeExistir(catalogoEscolaId);

			catalogoEscolaInputDiassembler.copyToDomainObject(catalogoEscolaInput, CatalogoEscolaAtual);

			return catalogoEscolaModelAssembler.toModel(cadastroCatalogoEscola.salvar(CatalogoEscolaAtual));
		} catch (CredeNaoEncontradaException
				| CategoriaAdministrativaNaoEncontradaException
				| SituacaoEscolaNaoEncontradaException
				| EnderecoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		} 
	}

//	@DeleteMapping(value = "/{catalogoEscolaId}")
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	public void remover(@PathVariable Long catalogoEscolaId) {
//		cadastroCatalogoEscola.remover(catalogoEscolaId);
//	}
	
	@PutMapping(value = "/{catalogoEscolaId}/ativo")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long catalogoEscolaId) {
		cadastroCatalogoEscola.ativar(catalogoEscolaId);
	}
	
	@DeleteMapping(value = "/{catalogoEscolaId}/ativo")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long catalogoEscolaId) {
		cadastroCatalogoEscola.inativar(catalogoEscolaId);
	}
	
	

}
