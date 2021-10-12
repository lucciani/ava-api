package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.SituacaoEscolaModel;
import io.github.lucciani.ava.domain.model.SituacaoEscola;

@Component
public class SituacaoEscolaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SituacaoEscolaModel toModel(SituacaoEscola situacaoEscola) {
		return modelMapper.map(situacaoEscola, SituacaoEscolaModel.class);
	}
	
	public List<SituacaoEscolaModel> toCollectionModel(List<SituacaoEscola> situacoesEscolares){
		return situacoesEscolares.stream()
				.map(situacaoEscolar -> toModel(situacaoEscolar))
				.collect(Collectors.toList());
	}

}
