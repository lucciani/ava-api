package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.EmpresaModel;
import io.github.lucciani.ava.domain.model.Empresa;

@Component
public class EmpresaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmpresaModel toModel(Empresa empresa) {
		return modelMapper.map(empresa, EmpresaModel.class);
	}
	
	public List<EmpresaModel> toCollectionModel(List<Empresa> empresas){
		return empresas.stream()
				.map(empresa -> toModel(empresa))
				.collect(Collectors.toList());
	}

}
