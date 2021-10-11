package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.LocalizacaoInput;
import io.github.lucciani.ava.domain.model.Localizacao;

@Component
public class LocalizacaoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Localizacao toDomainObject(LocalizacaoInput localizacaoInput) {
		return modelMapper.map(localizacaoInput, Localizacao.class);
	}

	public void copyToDomainObject(LocalizacaoInput localizacaoInput, Localizacao localizacao) {
		modelMapper.map(localizacaoInput, localizacao);
	}

}
