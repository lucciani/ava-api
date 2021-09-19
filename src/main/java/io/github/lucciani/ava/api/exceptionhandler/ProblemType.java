package io.github.lucciani.ava.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido."),
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema."),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado."),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso."),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio."),
	MENSAGEM_INCROMPREENSIVEL("/mensagem-incrompreensivel", "Mensagem incompreensível.");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "http://api.ava.local"+path;
		this.title = title;
	}

}
