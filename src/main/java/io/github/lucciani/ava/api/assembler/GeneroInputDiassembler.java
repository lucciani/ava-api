package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.GeneroInput;
import io.github.lucciani.ava.domain.model.Genero;

@Component
public class GeneroInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Genero toDomainObject(GeneroInput generoInput) {
		return modelMapper.map(generoInput, Genero.class);
	}

	public void copyToDomainObject(GeneroInput generoInput, Genero genero) {
		modelMapper.map(generoInput, genero);
	}

}
