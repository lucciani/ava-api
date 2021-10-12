package io.github.lucciani.ava.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisInput {
	
	@NotNull
	private Long id;

	@NotBlank
	private String sigla;

	@NotBlank
	private String nome;

}
