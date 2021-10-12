package io.github.lucciani.ava.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SituacaoEscolaInput {
	
	@NotBlank
	private String descricao;

}
