package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.EscolaridadeModel;
import io.github.lucciani.ava.domain.model.Escolaridade;

@Component
public class EscolaridadeModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EscolaridadeModel toModel(Escolaridade escolaridade) {
		return modelMapper.map(escolaridade, EscolaridadeModel.class);
	}
	
	public List<EscolaridadeModel> toCollectionModel(List<Escolaridade> escolaridades){
		return escolaridades.stream()
				.map(escolaridade -> toModel(escolaridade))
				.collect(Collectors.toList());
	}

}
