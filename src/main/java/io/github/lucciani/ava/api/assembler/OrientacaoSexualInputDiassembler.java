package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.OrientacaoSexualInput;
import io.github.lucciani.ava.domain.model.OrientacaoSexual;

@Component
public class OrientacaoSexualInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public OrientacaoSexual toDomainObject(OrientacaoSexualInput orientacaoSexualInput) {
		return modelMapper.map(orientacaoSexualInput, OrientacaoSexual.class);
	}

	public void copyToDomainObject(OrientacaoSexualInput orientacaoSexualInput, 
			OrientacaoSexual orientacaoSexual) {
		modelMapper.map(orientacaoSexualInput, orientacaoSexual);
	}

}
