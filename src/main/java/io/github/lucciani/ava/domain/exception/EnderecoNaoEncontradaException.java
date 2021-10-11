package io.github.lucciani.ava.domain.exception;

public class EnderecoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public EnderecoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public EnderecoNaoEncontradaException(Long enderecoId) {
		this(String.format("Não existe um cadastro de endereço com o código %d", enderecoId));
	}

}
