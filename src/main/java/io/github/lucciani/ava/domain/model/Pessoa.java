package io.github.lucciani.ava.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Pessoa {

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = true, name = "nome_social")
	private String nomeSocial;

	@ManyToOne
	@JoinColumn(name = "sexo_id", nullable = false)
	private Sexo sexo;

	@ManyToOne
	@JoinColumn(name = "genero_id", nullable = false)
	private Genero genero;
	
	@Column(nullable = false, name = "dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(nullable = false, name = "senha")
	private String senha;

}
