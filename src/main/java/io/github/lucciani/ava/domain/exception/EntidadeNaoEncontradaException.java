package io.github.lucciani.ava.domain.exception;

public abstract class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
