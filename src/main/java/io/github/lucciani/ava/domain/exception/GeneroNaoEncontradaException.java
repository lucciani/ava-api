package io.github.lucciani.ava.domain.exception;

public class GeneroNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public GeneroNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public GeneroNaoEncontradaException(Long generoId) {
		this(String.format("Não existe um cadastro de genero com o código %d", generoId));
	}

}
