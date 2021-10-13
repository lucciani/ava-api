package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.PermissaoInput;
import io.github.lucciani.ava.domain.model.Permissao;

@Component
public class PermissaoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Permissao toDomainObject(PermissaoInput permissaoInput) {
		return modelMapper.map(permissaoInput, Permissao.class);
	}

	public void copyToDomainObject(PermissaoInput permissaoInput, Permissao permissao) {
		modelMapper.map(permissaoInput, permissao);
	}

}
