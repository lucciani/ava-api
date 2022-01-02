package io.github.lucciani.ava.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private DadosEndereco dadosEndereco;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	private Long codigoEscola;

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
	
	private Boolean ativo = Boolean.TRUE;
	
	@OneToMany(mappedBy = "catalogoEscola", fetch = FetchType.LAZY)
	private List<Aluno> alunos = new ArrayList<>();
	
	public void ativar() {
		setAtivo(true);
	}
	
	public void inativar() {
		setAtivo(false);
	}
}
