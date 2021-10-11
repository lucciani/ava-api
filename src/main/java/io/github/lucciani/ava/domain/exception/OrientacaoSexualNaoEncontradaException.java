package io.github.lucciani.ava.domain.exception;

public class OrientacaoSexualNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public OrientacaoSexualNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public OrientacaoSexualNaoEncontradaException(Long orientacaoSexualId) {
		this(String.format("Não existe um cadastro da orientação sexual com o código %d", orientacaoSexualId));
	}

}
