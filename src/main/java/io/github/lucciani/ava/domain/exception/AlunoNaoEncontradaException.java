package io.github.lucciani.ava.domain.exception;

public class AlunoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 8617616315371574805L;
	
	public AlunoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public AlunoNaoEncontradaException(Long alunoId) {
		this(String.format("Não existe um cadastro de aluno com o código %d", alunoId));
	}

}
