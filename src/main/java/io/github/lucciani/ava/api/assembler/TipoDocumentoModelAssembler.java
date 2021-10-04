package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.TipoDocumentoModel;
import io.github.lucciani.ava.domain.model.TipoDocumento;

@Component
public class TipoDocumentoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TipoDocumentoModel toModel(TipoDocumento tipoDocumento) {
		return modelMapper.map(tipoDocumento, TipoDocumentoModel.class);
	}
	
	public List<TipoDocumentoModel> toCollectionModel(List<TipoDocumento> tiposDocumentos){
		return tiposDocumentos.stream()
				.map(tipoDocumento -> toModel(tipoDocumento))
				.collect(Collectors.toList());
	}

}
