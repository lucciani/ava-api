package io.github.lucciani.ava.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.model.AlunoId;

@Repository
public interface AlunoRepository extends CustomJpaRepository<Aluno, AlunoId> {
	
	@Query("from Aluno a "
			+ "join fetch a.endereco "
			+ "join fetch a.escolaridade "
			+ "join fetch a.ocupacao "
			+ "join fetch a.tipoAluno "
			+ "join fetch a.tipoDocumento "
			+ "join fetch a.pessoa p left join fetch p.sexo left join fetch p.genero")
	List<Aluno> findAll();
	
	@Query("from Aluno a "
			+ "join fetch a.endereco "
			+ "join fetch a.escolaridade "
			+ "join fetch a.ocupacao "
			+ "join fetch a.tipoAluno "
			+ "join fetch a.tipoDocumento "
			+ "join fetch a.pessoa p left join fetch p.sexo left join fetch p.genero "
			+ "where a.id=:id")
	Optional<Aluno> buscaIdIncremental(Long id);
	
	@Query("from Aluno a "
			+ "join fetch a.endereco "
			+ "join fetch a.escolaridade "
			+ "join fetch a.ocupacao "
			+ "join fetch a.tipoAluno ta "
			+ "join fetch a.tipoDocumento td "
			+ "join fetch a.pessoa p left join fetch p.sexo left join fetch p.genero "
			+ "join fetch a.dadosEndereco de left join fetch de.localizacao left join fetch de.pais "
			+ "where a.documento=:documento and td.id=:tipoDocumentoId and ta.id=:tipoAlunoId")
	Optional<Aluno> findById(String documento, Long tipoDocumentoId, Long tipoAlunoId);

}
