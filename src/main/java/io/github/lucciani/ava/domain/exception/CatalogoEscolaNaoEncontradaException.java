package io.github.lucciani.ava.domain.exception;

public class CatalogoEscolaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public CatalogoEscolaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CatalogoEscolaNaoEncontradaException(Long catalogoEscolaId) {
		this(String.format(
				"Não existe um cadastro no catalogo de escola com o código %d", 
				catalogoEscolaId));
	}

}
