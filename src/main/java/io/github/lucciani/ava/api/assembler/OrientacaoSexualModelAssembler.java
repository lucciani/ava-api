package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.OrientacaoSexualModel;
import io.github.lucciani.ava.domain.model.OrientacaoSexual;

@Component
public class OrientacaoSexualModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OrientacaoSexualModel toModel(OrientacaoSexual orientacaoSexual) {
		return modelMapper.map(orientacaoSexual, OrientacaoSexualModel.class);
	}
	
	public List<OrientacaoSexualModel> toCollectionModel(List<OrientacaoSexual> orietacoes){
		return orietacoes.stream()
				.map(orientacao -> toModel(orientacao))
				.collect(Collectors.toList());
	}

}
