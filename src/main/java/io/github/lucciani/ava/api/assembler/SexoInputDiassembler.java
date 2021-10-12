package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.SexoInput;
import io.github.lucciani.ava.domain.model.Sexo;

@Component
public class SexoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Sexo toDomainObject(SexoInput sexoInput) {
		return modelMapper.map(sexoInput, Sexo.class);
	}

	public void copyToDomainObject(SexoInput sexoInput, Sexo sexo) {
		modelMapper.map(sexoInput, sexo);
	}

}
