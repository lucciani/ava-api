package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.EnderecoInput;
import io.github.lucciani.ava.domain.model.Endereco;

@Component
public class EnderecoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Endereco toDomainObject(EnderecoInput enderecoInput) {
		return modelMapper.map(enderecoInput, Endereco.class);
	}

	public void copyToDomainObject(EnderecoInput enderecoInput, Endereco endereco) {
		modelMapper.map(enderecoInput, endereco);
	}

}
