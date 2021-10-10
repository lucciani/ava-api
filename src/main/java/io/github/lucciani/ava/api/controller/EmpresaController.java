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

import io.github.lucciani.ava.api.assembler.EmpresaInputDiassembler;
import io.github.lucciani.ava.api.assembler.EmpresaModelAssembler;
import io.github.lucciani.ava.api.model.EmpresaModel;
import io.github.lucciani.ava.api.model.input.EmpresaInput;
import io.github.lucciani.ava.domain.model.Empresa;
import io.github.lucciani.ava.domain.repository.EmpresaRepository;
import io.github.lucciani.ava.domain.service.CadastroEmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private CadastroEmpresaService cadastroEmpresa;
	
	@Autowired
	private EmpresaModelAssembler empresaModelAssembler;
	
	@Autowired
	private EmpresaInputDiassembler empresaInputDiassembler;

	@GetMapping
	public List<EmpresaModel> listar() {
		return empresaModelAssembler.toCollectionModel(empresaRepository.findAll());
	}

	@GetMapping(value = "/{empresaId}")
	public EmpresaModel buscar(@PathVariable Long empresaId) {
		return empresaModelAssembler.toModel(cadastroEmpresa.buscarSeExistir(empresaId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmpresaModel adicionar(@RequestBody @Valid EmpresaInput empresaInput) {
		Empresa empresa = empresaInputDiassembler.toDomainObject(empresaInput);
		return empresaModelAssembler.toModel(cadastroEmpresa.salvar(empresa));
	}

	@PutMapping(value = "/{empresaId}")
	public EmpresaModel atualizar(@PathVariable Long empresaId, 
			@RequestBody @Valid EmpresaInput empresaInput) {

		Empresa empresaAtual = cadastroEmpresa.buscarSeExistir(empresaId);
		empresaInputDiassembler.copyToDomainObject(empresaInput, empresaAtual);

		return empresaModelAssembler.toModel(cadastroEmpresa.salvar(empresaAtual));
	}

	@DeleteMapping(value = "/{empresaId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long empresaId) {
		cadastroEmpresa.remover(empresaId);
	}
}
