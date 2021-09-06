package io.github.lucciani.ava.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Contato {

	@Column(nullable = false, name = "celular")
	private String celular;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "outro_telefone")
	private String outroTelefone;

	@Column(name = "whatsapp")
	private String whatsapp;

}
