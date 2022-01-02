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

import io.github.lucciani.ava.api.assembler.AlunoInputDiassembler;
import io.github.lucciani.ava.api.assembler.AlunoModelAssembler;
import io.github.lucciani.ava.api.model.AlunoModel;
import io.github.lucciani.ava.api.model.input.AlunoInput;
import io.github.lucciani.ava.domain.exception.AlunoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EnderecoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EscolaridadeNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.GeneroNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.exception.OcupacaoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.SexoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.TipoAlunoNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.TipoDocumentoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.repository.AlunoRepository;
import io.github.lucciani.ava.domain.service.CadastroAlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoModelAssembler alunoModelAssembler;

	@Autowired
	private AlunoInputDiassembler alunoInputDiassembler;

	@Autowired
	private CadastroAlunoService cadastroAluno;

	@GetMapping
	public List<AlunoModel> listar() {
		return alunoModelAssembler.toCollectionModel(alunoRepository.findAll());
	}

	@GetMapping(value = "/{alunoId}")
	public AlunoModel buscar(@PathVariable Long alunoId) {
		return alunoModelAssembler.toModel(cadastroAluno.buscarSeExistir(alunoId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AlunoModel adicionar(@RequestBody @Valid AlunoInput alunoInput) {
		try {
			Aluno aluno = alunoInputDiassembler.toDomainObject(alunoInput);
			System.err.println(aluno);
			return alunoModelAssembler.toModel(cadastroAluno.salvar(aluno));
		} catch (TipoDocumentoNaoEncontradaException | SexoNaoEncontradaException
				| GeneroNaoEncontradaException | EnderecoNaoEncontradaException
				| EscolaridadeNaoEncontradaException | OcupacaoNaoEncontradaException 
				| TipoAlunoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@PutMapping(value = "/{alunoId}/ativo")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long alunoId) {
		cadastroAluno.ativar(alunoId);
	}

	@PutMapping(value = "/ativacoes")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void ativarEmMassa(@RequestBody List<Long> alunoIds) {
		try {
			cadastroAluno.ativar(alunoIds);
		} catch (AlunoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping(value = "/{alunoId}/ativo")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long alunoId) {
		cadastroAluno.inativar(alunoId);
	}

	@DeleteMapping(value = "/ativacoes")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void inativarEmMassa(@RequestBody List<Long> alunoIds) {
		try {
			cadastroAluno.inativar(alunoIds);
		} catch (AlunoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

}
