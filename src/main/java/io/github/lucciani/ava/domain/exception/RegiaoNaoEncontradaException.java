package io.github.lucciani.ava.domain.exception;

public class RegiaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public RegiaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public RegiaoNaoEncontradaException(Long regiaoId) {
		this(String.format("Não existe um cadastro de região com o código %d", regiaoId));
	}

}
