package io.github.lucciani.ava.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Aluno {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String documento;

	@ManyToOne
	@JoinColumn(name = "tipo_documento_id", nullable = false)
	private TipoDocumento tipoDocumento;

	@Embedded
	private Pessoa pessoa;

	@Embedded
	private Endereco endereco;

	@Embedded
	private Contato contato;

	@ManyToOne
	@JoinColumn(name = "escolaridade_id", nullable = false)
	private Escolaridade escolaridade;

	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = false)
	private Ocupacao ocupacao;
	
	private String foto;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_aluno")
	private final static TipoAluno tipoAluno = TipoAluno.SISTEMA;

	@CreationTimestamp
	@Column(nullable = false, name = "dt_inclusao", columnDefinition = "datetime(0)")
	private LocalDateTime dataInclusao;

	@UpdateTimestamp
	@Column(nullable = false, name = "dt_atualizacao", columnDefinition = "datetime(0)")
	private LocalDateTime dataAtualizacao;

}
