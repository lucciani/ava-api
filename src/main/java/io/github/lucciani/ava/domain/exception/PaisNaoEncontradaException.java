package io.github.lucciani.ava.domain.exception;

public class PaisNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public PaisNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public PaisNaoEncontradaException(Long paisId) {
		this(String.format("Não existe um cadastro de pais com o código %d", paisId));
	}

}
