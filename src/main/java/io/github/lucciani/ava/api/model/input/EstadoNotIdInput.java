package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoNotIdInput {
	
	@NotBlank
	private String sigla;
	
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private RegiaoIdInput regiao;

}
