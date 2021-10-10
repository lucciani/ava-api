package io.github.lucciani.ava.domain.exception;

public class CredeNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public CredeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CredeNaoEncontradaException(Long credeId) {
		this(String.format("Não existe um cadastro de crede com o código %d", credeId));
	}

}
