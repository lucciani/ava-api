package io.github.lucciani.ava.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SexoIdInput {

	@NotNull
	private Long id;

}
