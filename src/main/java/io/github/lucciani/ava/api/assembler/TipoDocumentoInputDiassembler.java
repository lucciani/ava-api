package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.TipoDocumentoInput;
import io.github.lucciani.ava.domain.model.TipoDocumento;

@Component
public class TipoDocumentoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public TipoDocumento toDomainObject(TipoDocumentoInput tipoDocumentoInput) {
		return modelMapper.map(tipoDocumentoInput, TipoDocumento.class);
	}

	public void copyToDomainObject(TipoDocumentoInput tipoDocumentoInput, TipoDocumento tipoDocumento) {
		modelMapper.map(tipoDocumentoInput, tipoDocumento);
	}

}
