package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.LocalizacaoModel;
import io.github.lucciani.ava.domain.model.Localizacao;

@Component
public class LocalizacaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LocalizacaoModel toModel(Localizacao localizacao) {
		return modelMapper.map(localizacao, LocalizacaoModel.class);
	}
	
	public List<LocalizacaoModel> toCollectionModel(List<Localizacao> localizacoes){
		return localizacoes.stream()
				.map(localizacao -> toModel(localizacao))
				.collect(Collectors.toList());
	}

}
