package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.NegocioException;
import io.github.lucciani.ava.domain.exception.UsuarioNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Usuario;
import io.github.lucciani.ava.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	private static final String MSG_USUARIO_EM_USO = 
			"Usuario de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarSeExistir(usuarioId);
        
        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }
        
        usuario.setSenha(novaSenha);
    }

	@Transactional
	public void remover(Long sexoId) {
		try {
			usuarioRepository.deleteById(sexoId);
			usuarioRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradaException(sexoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_USUARIO_EM_USO, sexoId));
		}

	}

	public Usuario buscarSeExistir(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradaException(usuarioId));
	}

}
