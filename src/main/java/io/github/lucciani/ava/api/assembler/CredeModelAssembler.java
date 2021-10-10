package io.github.lucciani.ava.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.CredeModel;
import io.github.lucciani.ava.domain.model.Crede;

@Component
public class CredeModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CredeModel toModel(Crede crede) {
		return modelMapper.map(crede, CredeModel.class);
	}
	
	public List<CredeModel> toCollectionModel(List<Crede> credes){
		return credes.stream()
				.map(crede -> toModel(crede))
				.collect(Collectors.toList());
	}

}
