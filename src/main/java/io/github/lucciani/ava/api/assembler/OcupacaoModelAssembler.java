package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.OcupacaoModel;
import io.github.lucciani.ava.domain.model.Ocupacao;

@Component
public class OcupacaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OcupacaoModel toModel(Ocupacao ocupacao) {
		return modelMapper.map(ocupacao, OcupacaoModel.class);
	}
	
	public List<OcupacaoModel> toCollectionModel(List<Ocupacao> ocupacoes){
		return ocupacoes.stream()
				.map(ocupacao -> toModel(ocupacao))
				.collect(Collectors.toList());
	}

}
