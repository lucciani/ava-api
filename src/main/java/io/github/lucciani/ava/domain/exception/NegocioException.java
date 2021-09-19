package io.github.lucciani.ava.domain.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public NegocioException(String mensagem) {
		super(mensagem);
	}
	
	public NegocioException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
