package io.github.lucciani.ava.domain.exception;

public class GrupoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public GrupoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public GrupoNaoEncontradaException(Long grupoId) {
		this(String.format("Não existe um cadastro de grupo com o código %d", grupoId));
	}

}
