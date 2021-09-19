package io.github.lucciani.ava.domain.exception;

public class TipoDocumentoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public TipoDocumentoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TipoDocumentoNaoEncontradaException(Long tipoDocumentoId) {
		this(String.format("Não existe um cadastro do tipo documento com o código %d", tipoDocumentoId));
	}

}
