package io.github.lucciani.ava.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pais {

	@EqualsAndHashCode.Include
	@Id
	private Long id;

	@Column(nullable = false)
	private String sigla;
	
	@Column(nullable = false)
	private String nome;


}
