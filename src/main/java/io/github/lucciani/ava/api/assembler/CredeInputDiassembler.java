package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.CredeInput;
import io.github.lucciani.ava.domain.model.Crede;

@Component
public class CredeInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Crede toDomainObject(CredeInput credeInput) {
		return modelMapper.map(credeInput, Crede.class);
	}

	public void copyToDomainObject(CredeInput credeInput, Crede crede) {
		modelMapper.map(credeInput, crede);
	}

}
