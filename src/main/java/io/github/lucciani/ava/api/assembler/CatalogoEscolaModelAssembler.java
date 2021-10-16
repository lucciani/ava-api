package io.github.lucciani.ava.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.CatalogoEscolaModel;
import io.github.lucciani.ava.domain.model.CatalogoEscola;

@Component
public class CatalogoEscolaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CatalogoEscolaModel toModel(CatalogoEscola catalogoEscola) {
		return modelMapper.map(catalogoEscola, CatalogoEscolaModel.class);
	}

	public List<CatalogoEscolaModel> toCollectionModel(Collection<CatalogoEscola> catalogoEscolas) {
		return catalogoEscolas.stream().map(catalogoEscola -> toModel(catalogoEscola)).collect(Collectors.toList());
	}

}
