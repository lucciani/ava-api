package io.github.lucciani.ava.api.model.input;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoInput {

	private String documento;

	@NotNull
	@Valid
	private TipoDocumentoIdInput tipoDocumento;

	@NotBlank
	private String nome;
	private String nomeSocial;

	@NotNull
	@Valid
	private SexoIdInput sexo;

	@NotNull
	@Valid
	private GeneroIdInput genero;

	private LocalDate dataNascimento;

	@NotBlank
	private String celular;

	@NotBlank
	@Email
	private String email;
	private String telefone;
	private String outroTelefone;
	private String whatsapp;
	private String foto;
	
	@NotBlank
	private String senha;

	@Valid
	private EnderecoCompactInput endereco;

	@NotNull
	@Valid
	private EscolaridadeIdInput escolaridade;

	@NotNull
	@Valid
	private OcupacaoIdInput ocupacao;

	@NotNull
	@Valid
	private TipoAlunoIdInput tipoAluno;

}
