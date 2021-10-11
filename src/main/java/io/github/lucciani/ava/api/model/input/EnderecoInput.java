package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String bairro;
	
	@JsonIgnoreProperties(value = {"nome", "codigoIbge"}, allowGetters = true)
	@Valid
	@NotNull
	private CidadeIdInput cidade;

}
