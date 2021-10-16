package io.github.lucciani.ava.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lucciani.ava.api.model.input.CatalogoEscolaInput;
import io.github.lucciani.ava.domain.model.CatalogoEscola;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;
import io.github.lucciani.ava.domain.model.Crede;
import io.github.lucciani.ava.domain.model.Localizacao;
import io.github.lucciani.ava.domain.model.Pais;
import io.github.lucciani.ava.domain.model.SituacaoEscola;

@Component
public class CatalogoEscolaInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;

	public CatalogoEscola toDomainObject(CatalogoEscolaInput catalogoEscolaInput) {
		return modelMapper.map(catalogoEscolaInput, CatalogoEscola.class);
	}

	public void copyToDomainObject(CatalogoEscolaInput catalogoEscolaInput, CatalogoEscola catalogoEscola) {
		if (catalogoEscola.getDadosEndereco().getLocalizacao() != null
				|| catalogoEscola.getDadosEndereco().getPais() != null) {
			catalogoEscola.getDadosEndereco().setLocalizacao(new Localizacao());
			catalogoEscola.getDadosEndereco().setPais(new Pais());
		}

		catalogoEscola.setCategoriaAdministrativa(new CategoriaAdministrativa());
		catalogoEscola.setSituacaoEscola(new SituacaoEscola());
		catalogoEscola.setCrede(new Crede());

		modelMapper.map(catalogoEscolaInput, catalogoEscola);
	}

}
