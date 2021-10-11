package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.EnderecoCompactModel;
import io.github.lucciani.ava.api.model.EnderecoModel;
import io.github.lucciani.ava.domain.model.Endereco;

@Component
public class EnderecoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EnderecoModel toModel(Endereco endereco) {
		return modelMapper.map(endereco, EnderecoModel.class);
	}
	
	public EnderecoCompactModel toCompactModel(Endereco endereco) {
		return modelMapper.map(endereco, EnderecoCompactModel.class);
	}
	
	public List<EnderecoModel> toCollectionModel(List<Endereco> enderecos){
		return enderecos.stream()
				.map(endereco -> toModel(endereco))
				.collect(Collectors.toList());
	}
	
	public List<EnderecoCompactModel> toCollectionCompactModel(List<Endereco> enderecos){
		return enderecos.stream()
				.map(endereco -> toCompactModel(endereco))
				.collect(Collectors.toList());
	}

}
