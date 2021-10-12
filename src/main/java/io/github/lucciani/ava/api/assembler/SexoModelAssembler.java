package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.SexoModel;
import io.github.lucciani.ava.domain.model.Sexo;

@Component
public class SexoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SexoModel toModel(Sexo sexo) {
		return modelMapper.map(sexo, SexoModel.class);
	}
	
	public List<SexoModel> toCollectionModel(List<Sexo> sexos){
		return sexos.stream()
				.map(sexo -> toModel(sexo))
				.collect(Collectors.toList());
	}

}
