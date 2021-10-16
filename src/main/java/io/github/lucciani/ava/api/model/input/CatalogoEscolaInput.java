package io.github.lucciani.ava.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogoEscolaInput {

	@NotBlank
	private String nome;

	@Valid
	private DadosEnderecoInput dadosEndereco;

	@Valid
	@NotNull
	private EnderecoIdInput endereco;

	@NotNull
	private Long codigoEscola;

	private CredeIdInput crede;

	@NotNull
	@Valid
	private CategoriaAdministrativaIdInput categoriaAdministrativa;

	@NotNull
	@Valid
	private SituacaoEscolaIdInput situacaoEscola;

}
