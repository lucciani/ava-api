package io.github.lucciani.ava.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estado {

//	@NotNull(groups = Groups.EstadoId.class)
//	@Positive
	@EqualsAndHashCode.Include
	@Id
	private Long id;

//	@NotBlank
	@Column(nullable = false)
	private String sigla;
	
//	@NotBlank
	@Column(nullable = false)
	private String nome;
		
//	@Valid
//	@ConvertGroup(from = Default.class, to = Groups.RegiaoId.class)
//	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Regiao regiao;

}
