package io.github.lucciani.ava.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoModel {
	
	private Long id;
	private String sigla;
	private String nome;
	private RegiaoModel regiao;

}
