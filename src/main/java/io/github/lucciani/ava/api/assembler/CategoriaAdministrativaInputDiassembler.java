package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.CategoriaAdministrativaInput;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;

@Component
public class CategoriaAdministrativaInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public CategoriaAdministrativa toDomainObject(CategoriaAdministrativaInput categoriaAdministrativaInput) {
		return modelMapper.map(categoriaAdministrativaInput, CategoriaAdministrativa.class);
	}

	public void copyToDomainObject(CategoriaAdministrativaInput categoriaAdministrativaInput, 
			CategoriaAdministrativa categoriaAdministrativa) {
		modelMapper.map(categoriaAdministrativaInput, categoriaAdministrativa);
	}

}
