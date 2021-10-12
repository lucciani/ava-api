package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.SituacaoEscolaInput;
import io.github.lucciani.ava.domain.model.SituacaoEscola;

@Component
public class SituacaoEscolaInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public SituacaoEscola toDomainObject(SituacaoEscolaInput situacaoEscolaInput) {
		return modelMapper.map(situacaoEscolaInput, SituacaoEscola.class);
	}

	public void copyToDomainObject(SituacaoEscolaInput situacaoEscolaInput, SituacaoEscola situacaoEscola) {
		modelMapper.map(situacaoEscolaInput, situacaoEscola);
	}

}
