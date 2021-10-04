package io.github.lucciani.ava.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeModel {
	
	private Long id;
	private String nome;
	private Long codigoIbge;
	private EstadoModel estado;

}
