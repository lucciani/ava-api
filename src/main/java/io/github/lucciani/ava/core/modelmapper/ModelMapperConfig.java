package io.github.lucciani.ava.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.lucciani.ava.api.model.CatalogoEscolaModel;
import io.github.lucciani.ava.api.model.CidadeCompactModel;
import io.github.lucciani.ava.api.model.EstadoModel;
import io.github.lucciani.ava.domain.model.CatalogoEscola;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.model.Estado;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		var cidadeToCidadeCompactModelTypeMap = 
				modelMapper.createTypeMap(Cidade.class, CidadeCompactModel.class);
		cidadeToCidadeCompactModelTypeMap.<String>addMapping(
				cidadeSrc -> cidadeSrc.getEstado().getNome(), 
				(cidadeDest, value) -> cidadeDest.setEstado(value));
		
		var estadoToEstadoModelTypeMap = 
				modelMapper.createTypeMap(Estado.class, EstadoModel.class);
		estadoToEstadoModelTypeMap.<String>addMapping(
				estadoSrc -> estadoSrc.getRegiao().getNome(), 
				(estadoModelDest, value) -> estadoModelDest.setRegiao(value));
		
		var catalogoEscolaToCatalogoEscolaModelModelTypeMap = 
				modelMapper.createTypeMap(CatalogoEscola.class, CatalogoEscolaModel.class);
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getDadosEndereco().getLocalizacao().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setLocalizacao(value));
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getDadosEndereco().getPais().getNome(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setPais(value));
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getEndereco().getCidade().getNome(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setCidade(value) );
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getCategoriaAdministrativa().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.setCategoriaAdministrativa(value) );
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getSituacaoEscola().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.setSituacaoEscola(value) );
		
		return modelMapper;
	}

}
