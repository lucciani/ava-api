package io.github.lucciani.ava.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.lucciani.ava.api.model.CidadeCompactModel;
import io.github.lucciani.ava.api.model.EstadoModel;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.model.Estado;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		var cidadeToCidadeCompactModelTypeMap = 
				modelMapper.createTypeMap(Cidade.class, CidadeCompactModel.class);
		
		var estadoToEstadoModelTypeMap = 
				modelMapper.createTypeMap(Estado.class, EstadoModel.class);
		
		cidadeToCidadeCompactModelTypeMap.<String>addMapping(
				cidadeSrc -> cidadeSrc.getEstado().getNome(), 
				(cidadeDest, value) -> cidadeDest.setEstado(value));
		
		estadoToEstadoModelTypeMap.<String>addMapping(
				estadoSrc -> estadoSrc.getRegiao().getNome(), 
				(estadoModelDest, value) -> estadoModelDest.setRegiao(value));
		
		return modelMapper;
	}

}
