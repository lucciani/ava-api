package io.github.lucciani.ava.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.CatalogoEscolaNaoEncontradaException;
import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.model.CatalogoEscola;
import io.github.lucciani.ava.domain.model.CategoriaAdministrativa;
import io.github.lucciani.ava.domain.model.Crede;
import io.github.lucciani.ava.domain.model.Endereco;
import io.github.lucciani.ava.domain.model.Localizacao;
import io.github.lucciani.ava.domain.model.Pais;
import io.github.lucciani.ava.domain.model.SituacaoEscola;
import io.github.lucciani.ava.domain.repository.CatalogoEscolaRepository;

@Service
public class CadastroCatalogoEscolaService {

	private static final String MSG_CATALOGO_ESCOLA_EM_USO = "Catalogo da escola de código %d não pode ser removida, pois está em uso.";

	@Autowired
	private CatalogoEscolaRepository catalogoEscolaRepository;

	@Autowired
	private CadastroCredeService cadastroCrede;

	@Autowired
	private CadastroEnderecoService cadastroEndereco;

	@Autowired
	private CadastroCategoriaAdministrativaService cadastroCategoriaAdministrativa;

	@Autowired
	private CadastroSituacaoEscolaService cadastroSituacaoEscola;
	
	@Autowired
	private CadastroLocalizacaoService cadastroLocalizacao;
	
	@Autowired
	private CadastroPaisService cadastroPais;

	@Transactional
	public CatalogoEscola salvar(CatalogoEscola catalogoEscola) {
		if (catalogoEscola.getCrede() != null) {
			Long credeId = catalogoEscola.getCrede().getId();
			Crede crede = cadastroCrede.buscarSeExistir(credeId);
			catalogoEscola.setCrede(crede);
		}
		Long enderecoId = catalogoEscola.getEndereco().getId();
		Long categoriaAdministrativaId = catalogoEscola.getCategoriaAdministrativa().getId();
		Long situacaoEscolaId = catalogoEscola.getSituacaoEscola().getId();
		Long localizacaoId = catalogoEscola.getDadosEndereco().getLocalizacao().getId();
		Long paisId = catalogoEscola.getDadosEndereco().getPais().getId();

		Endereco endereco = cadastroEndereco.buscarSeExistir(enderecoId);
		CategoriaAdministrativa categoriaAdministrativa = cadastroCategoriaAdministrativa
				.buscarSeExistir(categoriaAdministrativaId);
		SituacaoEscola situacaoEscola = cadastroSituacaoEscola.buscarSeExistir(situacaoEscolaId);
		Localizacao localizacao = cadastroLocalizacao.buscarSeExistir(localizacaoId);
		Pais pais = cadastroPais.buscarSeExistir(paisId);
		

		catalogoEscola.setCategoriaAdministrativa(categoriaAdministrativa);
		catalogoEscola.setEndereco(endereco);
		catalogoEscola.setSituacaoEscola(situacaoEscola);
		catalogoEscola.getDadosEndereco().setLocalizacao(localizacao);
		catalogoEscola.getDadosEndereco().setPais(pais);

		return catalogoEscolaRepository.save(catalogoEscola);
	}

	@Transactional
	public void remover(Long catalogoEscolaId) {
		try {
			catalogoEscolaRepository.deleteById(catalogoEscolaId);
			catalogoEscolaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CatalogoEscolaNaoEncontradaException(catalogoEscolaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_CATALOGO_ESCOLA_EM_USO, catalogoEscolaId));
		}

	}
	
	@Transactional
	public void ativar(Long catalogoEscolaId) {
		CatalogoEscola catalogoEscolaAtual = buscarSeExistir(catalogoEscolaId);
		catalogoEscolaAtual.ativar();
	}
	
	@Transactional
	public void inativar(Long catalogoEscolaId) {
		CatalogoEscola catalogoEscolaAtual = buscarSeExistir(catalogoEscolaId);
		catalogoEscolaAtual.inativar();
	}

	public CatalogoEscola buscarSeExistir(Long catalogoEscolaId) {
		return catalogoEscolaRepository.findById(catalogoEscolaId)
				.orElseThrow(() -> new CatalogoEscolaNaoEncontradaException(catalogoEscolaId));
	}

}
