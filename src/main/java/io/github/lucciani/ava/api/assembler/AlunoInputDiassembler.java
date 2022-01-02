package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.AlunoInput;
import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.model.Escolaridade;
import io.github.lucciani.ava.domain.model.Ocupacao;
import io.github.lucciani.ava.domain.model.TipoAluno;
import io.github.lucciani.ava.domain.model.TipoDocumento;

@Component
public class AlunoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Aluno toDomainObject(AlunoInput alunoInput) {
		return modelMapper.map(alunoInput, Aluno.class);
	}

	public void copyToDomainObject(AlunoInput alunoInput, Aluno aluno) {
		aluno.setTipoDocumento(new TipoDocumento());
		aluno.setTipoAluno(new TipoAluno());
		aluno.setEscolaridade(new Escolaridade());
		aluno.setOcupacao(new Ocupacao());
		
		modelMapper.map(alunoInput, aluno);
	}

}
