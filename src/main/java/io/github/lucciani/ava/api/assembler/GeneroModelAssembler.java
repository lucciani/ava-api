package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.GeneroModel;
import io.github.lucciani.ava.domain.model.Genero;

@Component
public class GeneroModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public GeneroModel toModel(Genero genero) {
		return modelMapper.map(genero, GeneroModel.class);
	}
	
	public List<GeneroModel> toCollectionModel(List<Genero> generos){
		return generos.stream()
				.map(genero -> toModel(genero))
				.collect(Collectors.toList());
	}

}
