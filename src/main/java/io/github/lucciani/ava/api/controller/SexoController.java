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

import io.github.lucciani.ava.api.assembler.SexoInputDiassembler;
import io.github.lucciani.ava.api.assembler.SexoModelAssembler;
import io.github.lucciani.ava.api.model.SexoModel;
import io.github.lucciani.ava.api.model.input.SexoInput;
import io.github.lucciani.ava.domain.model.Sexo;
import io.github.lucciani.ava.domain.repository.SexoRepository;
import io.github.lucciani.ava.domain.service.CadastroSexoService;

@RestController
@RequestMapping(value = "/sexos")
public class SexoController {

	@Autowired
	private SexoRepository sexoRepository;

	@Autowired
	private CadastroSexoService cadastroSexo;
	
	@Autowired
	private SexoModelAssembler sexoModelAssembler;
	
	@Autowired
	private SexoInputDiassembler sexoInputDiassembler;

	@GetMapping
	public List<SexoModel> listar() {
		return sexoModelAssembler.toCollectionModel(sexoRepository.findAll());
	}

	@GetMapping(value = "/{sexoId}")
	public SexoModel buscar(@PathVariable Long sexoId) {
		return sexoModelAssembler.toModel(cadastroSexo.buscarSeExistir(sexoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public SexoModel adicionar(@RequestBody @Valid SexoInput sexoInput) {
		Sexo sexo = sexoInputDiassembler.toDomainObject(sexoInput);
		return sexoModelAssembler.toModel(cadastroSexo.salvar(sexo));
	}

	@PutMapping(value = "/{sexoId}")
	public SexoModel atualizar(@PathVariable Long sexoId, 
			@RequestBody @Valid SexoInput sexoInput) {

		Sexo sexoAtual = cadastroSexo.buscarSeExistir(sexoId);
		sexoInputDiassembler.copyToDomainObject(sexoInput, sexoAtual);

		return sexoModelAssembler.toModel(cadastroSexo.salvar(sexoAtual));
	}

	@DeleteMapping(value = "/{sexoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long sexoId) {
		cadastroSexo.remover(sexoId);
	}
}
