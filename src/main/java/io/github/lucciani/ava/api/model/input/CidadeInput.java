package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput {

	@NotBlank
	private String nome;

	private Long codigoIbge;

	@JsonIgnoreProperties(value = {"sigla", "nome"}, allowGetters = true)
	@Valid
	@NotNull
	private EstadoInput estado;

}
