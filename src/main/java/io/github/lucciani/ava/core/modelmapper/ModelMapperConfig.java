package io.github.lucciani.ava.core.modelmapper;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.lucciani.ava.api.model.AlunoModel;
import io.github.lucciani.ava.api.model.CatalogoEscolaModel;
import io.github.lucciani.ava.api.model.CidadeCompactModel;
import io.github.lucciani.ava.api.model.EstadoModel;
import io.github.lucciani.ava.api.model.input.AlunoInput;
import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.model.CatalogoEscola;
import io.github.lucciani.ava.domain.model.Cidade;
import io.github.lucciani.ava.domain.model.Estado;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		var cidadeToCidadeCompactModelTypeMap = 
				modelMapper.createTypeMap(Cidade.class, CidadeCompactModel.class);
		cidadeToCidadeCompactModelTypeMap.<String>addMapping(
				cidadeSrc -> cidadeSrc.getEstado().getNome(), 
				(cidadeDest, value) -> cidadeDest.setEstado(value));
		
		var estadoToEstadoModelTypeMap = 
				modelMapper.createTypeMap(Estado.class, EstadoModel.class);
		estadoToEstadoModelTypeMap.<String>addMapping(
				estadoSrc -> estadoSrc.getRegiao().getNome(), 
				(estadoModelDest, value) -> estadoModelDest.setRegiao(value));
		
		var catalogoEscolaToCatalogoEscolaModelModelTypeMap = 
				modelMapper.createTypeMap(CatalogoEscola.class, CatalogoEscolaModel.class);
		
		catalogoEscolaToCatalogoEscolaModel(catalogoEscolaToCatalogoEscolaModelModelTypeMap);
		
		
		var alunoToAlunoModelTypeMap = modelMapper
				.createTypeMap(Aluno.class, AlunoModel.class);
		
		alunoToAlunoModel(alunoToAlunoModelTypeMap);
		
		var alunoInputToAlunoTypeMap = modelMapper
				.createTypeMap(AlunoInput.class, Aluno.class);
		
		alunoInputToAluno(alunoInputToAlunoTypeMap);
		
		return modelMapper;
	}

	private void catalogoEscolaToCatalogoEscolaModel(
			TypeMap<CatalogoEscola, CatalogoEscolaModel> catalogoEscolaToCatalogoEscolaModelModelTypeMap) {
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getDadosEndereco().getLocalizacao().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setLocalizacao(value));
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getDadosEndereco().getPais().getNome(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setPais(value));
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getEndereco().getCidade().getNome(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.getEndereco().setCidade(value) );
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getCategoriaAdministrativa().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.setCategoriaAdministrativa(value) );
		
		catalogoEscolaToCatalogoEscolaModelModelTypeMap.<String>addMapping(
				catalogoEscolaSrc -> catalogoEscolaSrc.getSituacaoEscola().getDescricao(), 
				(catalogoEscolaModelDest, value) -> catalogoEscolaModelDest.setSituacaoEscola(value) );
	}

	private void alunoToAlunoModel(TypeMap<Aluno, AlunoModel> alunoToAlunoModelTypeMap) {
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getContato().getEmail(), 
				(alunoModelDest, value) -> alunoModelDest.setEmail(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getContato().getCelular(), 
				(alunoModelDest, value) -> alunoModelDest.setCelular(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getContato().getWhatsapp(), 
				(alunoModelDest, value) -> alunoModelDest.setWhatsapp(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getEscolaridade().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setEscolaridade(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getOcupacao().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setOcupacao(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getTipoAluno().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setTipoAluno(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getPessoa().getNome(), 
				(alunoModelDest, value) -> alunoModelDest.setNome(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getPessoa().getNomeSocial(), 
				(alunoModelDest, value) -> alunoModelDest.setNomeSocial(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getPessoa().getGenero().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setGenero(value));
		
		alunoToAlunoModelTypeMap.<LocalDate>addMapping(
				alunoSrc -> alunoSrc.getPessoa().getDataNascimento(), 
				(alunoModelDest, value) -> alunoModelDest.setDataNascimento(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getPessoa().getSexo().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setSexo(value));
		
		alunoToAlunoModelTypeMap.<String>addMapping(
				alunoSrc -> alunoSrc.getTipoDocumento().getDescricao(), 
				(alunoModelDest, value) -> alunoModelDest.setTipoDocumento(value));
	}

	private void alunoInputToAluno(TypeMap<AlunoInput, Aluno> alunoInputToAlunoTypeMap) {
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getCelular(), 
				(alunoDest,value) -> alunoDest.getContato().setCelular(value));
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getEmail(), 
				(alunoDest,value) -> alunoDest.getContato().setEmail(value));
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getWhatsapp(), 
				(alunoDest,value) -> alunoDest.getContato().setWhatsapp(value));
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getOutroTelefone(), 
				(alunoDest,value) -> alunoDest.getContato().setOutroTelefone(value));
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getTelefone(), 
				(alunoDest,value) -> alunoDest.getContato().setTelefone(value));
		
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getNome(), 
				(alunoDest,value) -> alunoDest.getPessoa().setNome(value));
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getNomeSocial(), 
				(alunoDest,value) -> alunoDest.getPessoa().setNomeSocial(value));
		alunoInputToAlunoTypeMap.<LocalDate>addMapping(
				alunoInputSrc -> alunoInputSrc.getDataNascimento(), 
				(alunoDest,value) -> alunoDest.getPessoa().setDataNascimento(value));
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getSexo().getId(), 
				(alunoDest,value) -> alunoDest.getPessoa().getSexo().setId(value));
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getGenero().getId(), 
				(alunoDest,value) -> alunoDest.getPessoa().getGenero().setId(value));
		
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getEndereco().getLocalizacao().getId(), 
				(alunoDest,value) -> alunoDest.getDadosEndereco().getLocalizacao().setId(value));
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getEndereco().getPais().getId(), 
				(alunoDest,value) -> alunoDest.getDadosEndereco().getPais().setId(value));
		
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getSenha(), 
				(alunoDest,value) -> alunoDest.getPessoa().setSenha(value));
		
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getTipoAluno().getId(), 
				(alunoDest,value) -> alunoDest.getChave().setTipoAluno(value));
		
		alunoInputToAlunoTypeMap.<Long>addMapping(
				alunoInputSrc -> alunoInputSrc.getTipoDocumento().getId(), 
				(alunoDest,value) -> alunoDest.getChave().setTipoDocumento(value));
		
		alunoInputToAlunoTypeMap.<String>addMapping(
				alunoInputSrc -> alunoInputSrc.getDocumento(), 
				(alunoDest,value) -> alunoDest.getChave().setDocumento(value));
	}

}
