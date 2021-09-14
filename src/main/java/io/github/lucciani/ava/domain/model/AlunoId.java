package io.github.lucciani.ava.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class AlunoId implements Serializable {

	private static final long serialVersionUID = -5018207370199369465L;

	@Column(name = "documento")
	private String documento;

	@Column(name = "tipo_documento_id")
	private Long tipoDocumento;
	
	@Column(name = "tipo_aluno_id")
	private Long tipoAluno;

}
