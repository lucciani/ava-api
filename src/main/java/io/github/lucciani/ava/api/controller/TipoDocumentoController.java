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

import io.github.lucciani.ava.api.assembler.TipoDocumentoInputDiassembler;
import io.github.lucciani.ava.api.assembler.TipoDocumentoModelAssembler;
import io.github.lucciani.ava.api.model.TipoDocumentoModel;
import io.github.lucciani.ava.api.model.input.TipoDocumentoInput;
import io.github.lucciani.ava.domain.model.TipoDocumento;
import io.github.lucciani.ava.domain.repository.TipoDocumentoRepository;
import io.github.lucciani.ava.domain.service.CadastroTipoDocumentoService;

@RestController
@RequestMapping(value = "/tipos-documentos")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private CadastroTipoDocumentoService cadastroTipoDocumento;
	
	@Autowired
	private TipoDocumentoModelAssembler tipoDocumentoModelAssembler;
	
	@Autowired
	private TipoDocumentoInputDiassembler tipoDocumentoInputDiassembler;

	@GetMapping
	public List<TipoDocumentoModel> listar() {
		return tipoDocumentoModelAssembler.toCollectionModel(tipoDocumentoRepository.findAll());
	}

	@GetMapping(value = "/{tipoDocumentoId}")
	public TipoDocumentoModel buscar(@PathVariable Long tipoDocumentoId) {
		return tipoDocumentoModelAssembler.toModel(cadastroTipoDocumento.buscarSeExistir(tipoDocumentoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TipoDocumentoModel adicionar(@RequestBody @Valid TipoDocumentoInput tipoDocumentoInput) {
		TipoDocumento tipoDocumento = tipoDocumentoInputDiassembler.toDomainObject(tipoDocumentoInput);
		return tipoDocumentoModelAssembler.toModel(cadastroTipoDocumento.salvar(tipoDocumento));
	}

	@PutMapping(value = "/{tipoDocumentoId}")
	public TipoDocumentoModel atualizar(@PathVariable Long tipoDocumentoId, 
			@RequestBody @Valid TipoDocumentoInput tipoDocumentoInput) {

		TipoDocumento tipoDocumentoAtual = cadastroTipoDocumento.buscarSeExistir(tipoDocumentoId);
		tipoDocumentoInputDiassembler.copyToDomainObject(tipoDocumentoInput, tipoDocumentoAtual);

		return tipoDocumentoModelAssembler.toModel(cadastroTipoDocumento.salvar(tipoDocumentoAtual));
	}

	@DeleteMapping(value = "/{tipoDocumentoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long tipoDocumentoId) {
		cadastroTipoDocumento.remover(tipoDocumentoId);
	}
}
