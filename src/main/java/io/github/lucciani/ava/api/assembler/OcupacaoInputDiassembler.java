package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.OcupacaoInput;
import io.github.lucciani.ava.domain.model.Ocupacao;

@Component
public class OcupacaoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Ocupacao toDomainObject(OcupacaoInput ocupacaoInput) {
		return modelMapper.map(ocupacaoInput, Ocupacao.class);
	}

	public void copyToDomainObject(OcupacaoInput ocupacaoInput, Ocupacao ocupacao) {
		modelMapper.map(ocupacaoInput, ocupacao);
	}

}
