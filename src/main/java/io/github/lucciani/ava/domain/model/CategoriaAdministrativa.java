package io.github.lucciani.ava.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CategoriaAdministrativa {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@CreationTimestamp
	@Column(nullable = false, name = "dt_inclusao", columnDefinition = "datetime(0)")
	private LocalDateTime dataInclusao;

	@UpdateTimestamp
	@Column(nullable = false, name = "dt_atualizacao", columnDefinition = "datetime(0)")
	private LocalDateTime dataAtualizacao;
}
