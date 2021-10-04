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

import io.github.lucciani.ava.api.assembler.EstadoInputDiassembler;
import io.github.lucciani.ava.api.assembler.EstadoModelAssembler;
import io.github.lucciani.ava.api.model.EstadoModel;
import io.github.lucciani.ava.api.model.input.EstadoInput;
import io.github.lucciani.ava.api.model.input.EstadoNotIdInput;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.exception.RegiaoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Estado;
import io.github.lucciani.ava.domain.repository.EstadoRepository;
import io.github.lucciani.ava.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@Autowired
	private EstadoModelAssembler estadoModelAssembler;
	
	@Autowired
	private EstadoInputDiassembler estadoInputDiassembler;

	@GetMapping
	public List<EstadoModel> listar() {
		return estadoModelAssembler.toCollectionModel(estadoRepository.findAll());
	}

	@GetMapping(value = "/{estadoId}")
	public EstadoModel buscar(@PathVariable Long estadoId) {
		Estado estado = cadastroEstado.buscarSeExistir(estadoId);
		return estadoModelAssembler.toModel(estado);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		try {
			Estado estado = estadoInputDiassembler.toDomainObject(estadoInput);
			return estadoModelAssembler.toModel(cadastroEstado.salvar(estado));
		} catch (RegiaoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping(value = "/{estadoId}")
	public EstadoModel atualizar(
			@PathVariable Long estadoId, 
			@RequestBody @Valid EstadoNotIdInput estadoNotIdInput) {
		
		try {
			Estado estadoAtual = cadastroEstado.buscarSeExistir(estadoId);
		
			estadoInputDiassembler.copyToDomainObject(estadoNotIdInput, estadoAtual);

			return estadoModelAssembler.toModel(cadastroEstado.salvar(estadoAtual));
		} catch (RegiaoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@DeleteMapping(value = "/{estadoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		cadastroEstado.remover(estadoId);
	}

}
