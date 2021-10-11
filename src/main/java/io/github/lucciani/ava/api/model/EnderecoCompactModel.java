package io.github.lucciani.ava.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoCompactModel {
	
	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private CidadeIdCompactModel cidade;

}
