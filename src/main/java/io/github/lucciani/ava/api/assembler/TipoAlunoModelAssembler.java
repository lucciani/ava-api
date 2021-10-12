package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.TipoAlunoModel;
import io.github.lucciani.ava.domain.model.TipoAluno;

@Component
public class TipoAlunoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TipoAlunoModel toModel(TipoAluno tipoAluno) {
		return modelMapper.map(tipoAluno, TipoAlunoModel.class);
	}
	
	public List<TipoAlunoModel> toCollectionModel(List<TipoAluno> tiposAluno){
		return tiposAluno.stream()
				.map(tipoAluno -> toModel(tipoAluno))
				.collect(Collectors.toList());
	}

}
