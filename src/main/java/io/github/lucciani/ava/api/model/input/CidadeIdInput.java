package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeIdInput {
	
	@NotNull
	private Long id;

	@JsonIgnoreProperties(value = {"sigla", "nome"}, allowGetters = true)
	@Valid
	@NotNull
	private EstadoIdCompactInput estado;

}
