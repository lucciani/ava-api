package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.CategoriaAdministrativaModel;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;

@Component
public class CategoriaAdministrativaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaAdministrativaModel toModel(CategoriaAdministrativa categoriaAdministrativa) {
		return modelMapper.map(categoriaAdministrativa, CategoriaAdministrativaModel.class);
	}
	
	public List<CategoriaAdministrativaModel> toCollectionModel(List<CategoriaAdministrativa> categoriaAdministrativas){
		return categoriaAdministrativas.stream()
				.map(categoriaAdministrativa -> toModel(categoriaAdministrativa))
				.collect(Collectors.toList());
	}

}
