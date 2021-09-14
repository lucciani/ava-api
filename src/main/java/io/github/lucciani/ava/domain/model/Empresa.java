package io.github.lucciani.ava.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Empresa {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "cnpj")
	private String cnpj;
	
	@Column(nullable = false, name = "razao_social")
	private String razaoSocial;
	
	@JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Aluno> alunos = new ArrayList<>();
	
	@CreationTimestamp
	@Column(nullable = false, name = "dt_inclusao", columnDefinition = "datetime(0)")
	private LocalDateTime dataInclusao;

	@UpdateTimestamp
	@Column(nullable = false, name = "dt_atualizacao", columnDefinition = "datetime(0)")
	private LocalDateTime dataAtualizacao;

}
