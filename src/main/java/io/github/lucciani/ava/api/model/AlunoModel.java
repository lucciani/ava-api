package io.github.lucciani.ava.api.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoModel {

	private String documento;
	private String tipoDocumento;
	private String nome;
	private String nomeSocial;
	private String sexo;
	private String genero;
	private LocalDate dataNascimento;
	private String celular;
	private String email;
	private String whatsapp;
	private String escolaridade;
	private String ocupacao;
	private String tipoAluno;
	private Boolean ativo;

}
