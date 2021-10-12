package io.github.lucciani.ava.domain.exception;

public class TipoAlunoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public TipoAlunoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TipoAlunoNaoEncontradaException(Long tipoAlunoId) {
		this(String.format("Não existe um cadastro do tipo aluno com o código %d", tipoAlunoId));
	}

}
