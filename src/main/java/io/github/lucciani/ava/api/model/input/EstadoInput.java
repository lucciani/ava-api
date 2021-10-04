package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput {
	
	@NotNull
	@Positive
	private Long id;
	
	@NotBlank
	private String sigla;
	
	@NotBlank
	private String nome;
	
	@JsonIgnoreProperties(value = {"sigla", "nome"}, allowGetters = true)
	@Valid
	@NotNull
	private RegiaoIdInput regiao;
	

}
