package io.github.lucciani.ava.api.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel {
	
	private String nome;
	private String nomeSocial;
	private String sexo;
	private String genero;
	private LocalDate dataNascimento;
	private String senha;

}
