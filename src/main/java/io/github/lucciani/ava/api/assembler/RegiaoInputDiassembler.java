package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.RegiaoInput;
import io.github.lucciani.ava.domain.model.Regiao;

@Component
public class RegiaoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Regiao toDomainObject(RegiaoInput regiaoInput) {
		return modelMapper.map(regiaoInput, Regiao.class);
	}

	public void copyToDomainObject(RegiaoInput regiaoInput, Regiao regiao) {
		modelMapper.map(regiaoInput, regiao);
	}

}
