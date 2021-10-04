package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.CidadeInput;
import io.github.lucciani.ava.api.model.input.CidadeNotIdInput;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.model.Estado;

@Component
public class CidadeInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Cidade toDomainObject(CidadeInput cidadeInput) {
		return modelMapper.map(cidadeInput, Cidade.class);
	}

	public void copyToDomainObject(CidadeNotIdInput cidadeInput, Cidade cidade) {
		// Para evitar - org.hibernate.HibernateException: identifier of an instance of
		// io.github.lucciani.ava.domain.model.Regiao was altered from 2 to 5
		cidade.setEstado(new Estado());

		modelMapper.map(cidadeInput, cidade);
	}

}
