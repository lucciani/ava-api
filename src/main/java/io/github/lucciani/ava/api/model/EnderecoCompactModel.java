package io.github.lucciani.ava.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoCompactModel {

	private String cep;
	private String logradouro;
	private String bairro;
	private String numero;
	private String complemento;
	private String localizacao;
	private String pais;
	private String cidade;

}
