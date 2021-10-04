package io.github.lucciani.ava.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoIdInput {
	
	@NotNull
	@Positive
	private Long id;

}
