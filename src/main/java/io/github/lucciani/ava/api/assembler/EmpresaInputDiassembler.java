package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.EmpresaInput;
import io.github.lucciani.ava.domain.model.Empresa;

@Component
public class EmpresaInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Empresa toDomainObject(EmpresaInput empresaInput) {
		return modelMapper.map(empresaInput, Empresa.class);
	}

	public void copyToDomainObject(EmpresaInput empresaInput, Empresa empresa) {
		modelMapper.map(empresaInput, empresa);
	}

}
