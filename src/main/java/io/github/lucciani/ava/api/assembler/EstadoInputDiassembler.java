package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.EstadoInput;
import io.github.lucciani.ava.api.model.input.EstadoNotIdInput;
import io.github.lucciani.ava.domain.model.Estado;
import io.github.lucciani.ava.domain.model.Regiao;

@Component
public class EstadoInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Estado toDomainObject(EstadoInput estadoInput) {
		return modelMapper.map(estadoInput, Estado.class);
	}

	public void copyToDomainObject(EstadoNotIdInput estadoNotIdInput, Estado estado) {
		// Para evitar - org.hibernate.HibernateException: identifier of an instance of
		// io.github.lucciani.ava.domain.model.Regiao was altered from 2 to 5
		estado.setRegiao(new Regiao());

		modelMapper.map(estadoNotIdInput, estado);
	}

}
