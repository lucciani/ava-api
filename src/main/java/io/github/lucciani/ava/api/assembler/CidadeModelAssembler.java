package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.CidadeCompactModel;
import io.github.lucciani.ava.api.model.CidadeModel;
import io.github.lucciani.ava.domain.model.Cidade;

@Component
public class CidadeModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CidadeModel toModel(Cidade cidade) {
		return modelMapper.map(cidade, CidadeModel.class);
	}
	
	public CidadeCompactModel toCompactModel(Cidade cidade) {
		return modelMapper.map(cidade, CidadeCompactModel.class);
	}
	
	public List<CidadeModel> toCollectionModel(List<Cidade> cidades){
		return cidades.stream()
				.map(cidade -> toModel(cidade))
				.collect(Collectors.toList());
	}
	
	public List<CidadeCompactModel> toCollectionCompactModel(List<Cidade> cidades){
		return cidades.stream()
				.map(cidade -> toCompactModel(cidade))
				.collect(Collectors.toList());
	}

}
