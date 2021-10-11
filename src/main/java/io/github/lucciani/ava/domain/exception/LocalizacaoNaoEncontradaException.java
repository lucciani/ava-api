package io.github.lucciani.ava.domain.exception;

public class LocalizacaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public LocalizacaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public LocalizacaoNaoEncontradaException(Long localizacaoId) {
		this(String.format("Não existe um cadastro de localização com o código %d", localizacaoId));
	}

}
