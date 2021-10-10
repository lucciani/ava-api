package io.github.lucciani.ava.api.model.input;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaInput {
	
	@CNPJ
	private String cnpj;
	
	@NotBlank
	private String razaoSocial;

}
