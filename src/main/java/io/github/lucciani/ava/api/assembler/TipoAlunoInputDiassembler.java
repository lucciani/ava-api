package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.TipoAlunoInput;
import io.github.lucciani.ava.domain.model.TipoAluno;

@Component
public class TipoAlunoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public TipoAluno toDomainObject(TipoAlunoInput tipoAlunoInput) {
		return modelMapper.map(tipoAlunoInput, TipoAluno.class);
	}

	public void copyToDomainObject(TipoAlunoInput tipoAlunoInput, TipoAluno tipoAluno) {
		modelMapper.map(tipoAlunoInput, tipoAluno);
	}

}
