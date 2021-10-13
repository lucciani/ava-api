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

import io.github.lucciani.ava.api.assembler.UsuarioInputDiassembler;
import io.github.lucciani.ava.api.assembler.UsuarioModelAssembler;
import io.github.lucciani.ava.api.model.UsuarioModel;
import io.github.lucciani.ava.api.model.input.SenhaInput;
import io.github.lucciani.ava.api.model.input.UsuarioComSenhaInput;
import io.github.lucciani.ava.api.model.input.UsuarioInput;
import io.github.lucciani.ava.domain.model.Usuario;
import io.github.lucciani.ava.domain.repository.UsuarioRepository;
import io.github.lucciani.ava.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private UsuarioInputDiassembler usuarioInputDiassembler;

	@GetMapping
	public List<UsuarioModel> listar() {
		return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll());
	}

	@GetMapping(value = "/{usuarioId}")
	public UsuarioModel buscar(@PathVariable Long usuarioId) {
		return usuarioModelAssembler.toModel(cadastroUsuario.buscarSeExistir(usuarioId));
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput) {
		Usuario usuario = usuarioInputDiassembler.toDomainObject(usuarioInput);
		return usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuario));
	}

	@PutMapping(value = "/{usuarioId}")
	public UsuarioModel atualizar(@PathVariable Long usuarioId, 
			@RequestBody @Valid UsuarioInput usuarioInput) {

		Usuario usuarioAtual = cadastroUsuario.buscarSeExistir(usuarioId);
		usuarioInputDiassembler.copyToDomainObject(usuarioInput, usuarioAtual);

		return usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuarioAtual));
	}
	
	@PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInput senha) {
        cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    } 

	@DeleteMapping(value = "/{usuarioId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long usuarioId) {
		cadastroUsuario.remover(usuarioId);
	}
}
