package io.github.lucciani.ava.domain.exception;

public class CategoriaAdministrativaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public CategoriaAdministrativaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CategoriaAdministrativaNaoEncontradaException(Long categoriaAdministrativaId) {
		this(String.format(
				"Não existe um cadastro de categoria administrativa com o código %d", 
				categoriaAdministrativaId));
	}

}
