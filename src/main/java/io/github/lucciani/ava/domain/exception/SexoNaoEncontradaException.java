package io.github.lucciani.ava.domain.exception;

public class SexoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public SexoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public SexoNaoEncontradaException(Long sexoId) {
		this(String.format("Não existe um cadastro de sexo com o código %d", sexoId));
	}

}
