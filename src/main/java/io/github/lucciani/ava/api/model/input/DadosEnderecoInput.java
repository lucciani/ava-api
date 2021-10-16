package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosEnderecoInput {

	@NotBlank
	private String numero;
	
	private String complemento;

	@NotNull
	@Valid
	private LocalizacaoIdInput localizacao;

	@NotNull
	@Valid
	private PaisIdInput pais;

}
