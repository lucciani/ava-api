package io.github.lucciani.ava.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Aluno {

	@EqualsAndHashCode.Include
	@EmbeddedId
	private AlunoId id;

	@Column(name = "documento", insertable = false, updatable = false)
	private String documento;

	@MapsId(value = "tipoDocumento")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_documento_id", nullable = false, insertable = false, updatable = false)
	private TipoDocumento tipoDocumento;

	@Embedded
	private Pessoa pessoa;

	@Embedded
	private DadosEndereco dadosEndereco;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
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

	@MapsId(value = "tipoAluno")
	@ManyToOne
	@JoinColumn(name = "tipo_aluno_id", nullable = false, insertable = false, updatable = false)
	private TipoAluno tipoAluno;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "escola_id", nullable = false)
	private CatalogoEscola catalogoEscola;
	
	@ManyToMany
	@JoinTable(name = "aluno_grupo", 
				joinColumns={
						@JoinColumn(name = "tipo_documento_id"),
						@JoinColumn(name = "tipo_aluno_id"),
						@JoinColumn(name = "documento")
				},
				inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();

	@CreationTimestamp
	@Column(nullable = false, name = "dt_inclusao", columnDefinition = "datetime(0)")
	private OffsetDateTime dataInclusao;

	@UpdateTimestamp
	@Column(nullable = false, name = "dt_atualizacao", columnDefinition = "datetime(0)")
	private OffsetDateTime dataAtualizacao;

}
