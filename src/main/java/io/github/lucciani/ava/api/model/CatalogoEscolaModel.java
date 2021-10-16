package io.github.lucciani.ava.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogoEscolaModel {

	private Long id;
	private String nome;
	private EnderecoCompactModel endereco;
	private Long codigoEscola;
	private CredeModel crede;
	private String categoriaAdministrativa;
	private String situacaoEscola;
	private Boolean ativo;

}
