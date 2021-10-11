package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.EscolaridadeInput;
import io.github.lucciani.ava.domain.model.Escolaridade;

@Component
public class EscolaridadeInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Escolaridade toDomainObject(EscolaridadeInput escolaridadeInput) {
		return modelMapper.map(escolaridadeInput, Escolaridade.class);
	}

	public void copyToDomainObject(EscolaridadeInput escolaridadeInput, Escolaridade escolaridade) {
		modelMapper.map(escolaridadeInput, escolaridade);
	}

}
