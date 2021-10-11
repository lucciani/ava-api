package io.github.lucciani.ava.domain.exception;

public class OcupacaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public OcupacaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public OcupacaoNaoEncontradaException(Long ocupacaoId) {
		this(String.format("Não existe um cadastro de ocupacao com o código %d", ocupacaoId));
	}

}
