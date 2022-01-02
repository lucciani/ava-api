package io.github.lucciani.ava.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.AlunoModel;
import io.github.lucciani.ava.domain.model.Aluno;

@Component
public class AlunoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AlunoModel toModel(Aluno aluno) {
		return modelMapper.map(aluno, AlunoModel.class);
	}
	
	public List<AlunoModel> toCollectionModel(Collection<Aluno> alunos){
		return alunos.stream()
				.map(aluno -> toModel(aluno))
				.collect(Collectors.toList());
	}

}
