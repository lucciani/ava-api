package io.github.lucciani.ava.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Pessoa {

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = true, name = "nome_social")
	private String nomeSocial;

	@Column(nullable = false, name = "sexo")
	private String sexo;

	@Column(nullable = true, name = "genero")
	private String genero;
	
	@Column(nullable = false, name = "dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(nullable = false, name = "senha")
	private String senha;

}
