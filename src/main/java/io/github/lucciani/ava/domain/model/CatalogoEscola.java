package io.github.lucciani.ava.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
public class CatalogoEscola {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Embedded
	private Endereco endereco;

	private Long codigoInep;

	@ManyToOne
	@JoinColumn(name = "crede_id")
	private Crede crede;

	@ManyToOne
	@JoinColumn(name = "categoria_administrativa_id")
	private CategoriaAdministrativa categoriaAdministrativa;

	@ManyToOne
	@JoinColumn(name = "situacao_escola")
	private SituacaoEscola situacaoEscola;

	@CreationTimestamp
	@Column(nullable = false, name = "dt_inclusao", columnDefinition = "datetime(0)")
	private OffsetDateTime dataInclusao;

	@UpdateTimestamp
	@Column(nullable = false, name = "dt_atualizacao", columnDefinition = "datetime(0)")
	private OffsetDateTime dataAtualizacao;
}
