package io.github.lucciani.ava.domain.exception;

public class UsuarioNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public UsuarioNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradaException(Long usuarioId) {
		this(String.format("Não existe um cadastro de usuario com o código %d", usuarioId));
	}

}
