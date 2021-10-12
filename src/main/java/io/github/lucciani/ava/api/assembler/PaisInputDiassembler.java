package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.PaisInput;
import io.github.lucciani.ava.api.model.input.PaisNotIdInput;
import io.github.lucciani.ava.domain.model.Pais;

@Component
public class PaisInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Pais toDomainObject(PaisInput paisInput) {
		return modelMapper.map(paisInput, Pais.class);
	}
	
	public Pais toDomainObjectNotId(PaisNotIdInput paisNotIdInput) {
		return modelMapper.map(paisNotIdInput, Pais.class);
	}

	public void copyToDomainObject(PaisInput paisInput, Pais pais) {
		modelMapper.map(paisInput, pais);
	}
	
	public void copyToDomainObjectNotId(PaisNotIdInput paisNotIdInput, Pais pais) {
		modelMapper.map(paisNotIdInput, pais);
	}

}
