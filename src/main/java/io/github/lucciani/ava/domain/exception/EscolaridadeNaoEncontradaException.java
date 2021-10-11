package io.github.lucciani.ava.domain.exception;

public class EscolaridadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public EscolaridadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public EscolaridadeNaoEncontradaException(Long escolaridadeId) {
		this(String.format("Não existe um cadastro de escolaridade com o código %d", escolaridadeId));
	}

}
