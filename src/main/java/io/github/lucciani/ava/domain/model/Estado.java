package io.github.lucciani.ava.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estado {

	@EqualsAndHashCode.Include
	@Id
	private Long id;

	@Column(nullable = false)
	private String sigla;
	
	@Column(nullable = false)
	private String nome;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable = false)
	private Regiao regiao;

}
