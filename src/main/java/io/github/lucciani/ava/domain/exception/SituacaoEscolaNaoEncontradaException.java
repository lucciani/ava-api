package io.github.lucciani.ava.domain.exception;

public class SituacaoEscolaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public SituacaoEscolaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public SituacaoEscolaNaoEncontradaException(Long situacaoEscolaId) {
		this(String.format("Não existe um cadastro de situação da escola com o código %d", situacaoEscolaId));
	}

}
