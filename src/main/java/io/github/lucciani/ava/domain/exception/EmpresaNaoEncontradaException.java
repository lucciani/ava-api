package io.github.lucciani.ava.domain.exception;

public class EmpresaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public EmpresaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public EmpresaNaoEncontradaException(Long empresaid) {
		this(String.format("Não existe um cadastro de empresa com o código %d", empresaid));
	}

}
