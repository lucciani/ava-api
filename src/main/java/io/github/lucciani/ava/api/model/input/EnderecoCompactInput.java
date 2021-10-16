package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoCompactInput {

	@NotNull
	private Long id;
	
	@NotBlank
	private String numero;
	private String complemento;

	@NotNull
	@Valid
	private LocalizacaoIdInput localizacao;

	@NotNull
	@Valid
	private PaisIdInput pais;

//	@Valid
//	private DadosEnderecoInput dadosEndereco;

}
