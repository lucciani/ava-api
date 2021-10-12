package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.PaisModel;
import io.github.lucciani.ava.domain.model.Pais;

@Component
public class PaisModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PaisModel toModel(Pais pais) {
		return modelMapper.map(pais, PaisModel.class);
	}
	
	public List<PaisModel> toCollectionModel(List<Pais> paises){
		return paises.stream()
				.map(pais -> toModel(pais))
				.collect(Collectors.toList());
	}

}
