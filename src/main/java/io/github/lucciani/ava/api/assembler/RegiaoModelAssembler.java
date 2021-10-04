package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.RegiaoModel;
import io.github.lucciani.ava.domain.model.Regiao;

@Component
public class RegiaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RegiaoModel toModel(Regiao regiao) {
		return modelMapper.map(regiao, RegiaoModel.class);
	}
	
	public List<RegiaoModel> toCollectionModel(List<Regiao> regioes){
		return regioes.stream()
				.map(regiao -> toModel(regiao))
				.collect(Collectors.toList());
	}

}
