package io.github.lucciani.ava.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.lucciani.ava.domain.exception.AlunoNaoEncontradaException;
import io.github.lucciani.ava.domain.model.Aluno;
import io.github.lucciani.ava.domain.model.AlunoId;
import io.github.lucciani.ava.domain.model.Endereco;
import io.github.lucciani.ava.domain.model.Escolaridade;
import io.github.lucciani.ava.domain.model.Genero;
import io.github.lucciani.ava.domain.model.Localizacao;
import io.github.lucciani.ava.domain.model.Ocupacao;
import io.github.lucciani.ava.domain.model.Pais;
import io.github.lucciani.ava.domain.model.Sexo;
import io.github.lucciani.ava.domain.model.TipoAluno;
import io.github.lucciani.ava.domain.model.TipoDocumento;
import io.github.lucciani.ava.domain.repository.AlunoRepository;

@Service
public class CadastroAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CadastroEnderecoService cadastroEndereco;
	@Autowired
	private CadastroEscolaridadeService cadastroEscolaridade;
	@Autowired
	private CadastroOcupacaoService cadastroOcupacao;
	@Autowired
	private CadastroTipoAlunoService cadastroTipoAluno;
	@Autowired
	private CadastroSexoService cadastroSexo;
	@Autowired
	private CadastroGeneroService cadastroGenero;
	@Autowired
	private CadastroLocalizacaoService cadastroLocalizacao;
	@Autowired
	private CadastroPaisService cadastroPais;
	@Autowired
	private CadastroTipoDocumentoService cadastroTipoDocumento;

	@Transactional
	public Aluno salvar(Aluno aluno) {

		Optional<Aluno> alunoAtual = alunoRepository.findById(
				aluno.getChave().getDocumento(), aluno.getChave().getTipoDocumento(), aluno.getChave().getTipoAluno());
		
		if (alunoAtual.isPresent()) {
			aluno.setDataInclusao(alunoAtual.get().getDataInclusao());
			aluno.setId(alunoAtual.get().getId());
		}
		
		Long enderecoId = aluno.getEndereco().getId();
		Long escolaridadeId = aluno.getEscolaridade().getId();
		Long ocupacaoId = aluno.getOcupacao().getId();
		Long tipoAlunoId = aluno.getTipoAluno().getId();
		Long sexoId = aluno.getPessoa().getSexo().getId();
		Long generoId = aluno.getPessoa().getGenero().getId();
		Long localizacaoId = aluno.getDadosEndereco().getLocalizacao().getId();
		Long paisId = aluno.getDadosEndereco().getPais().getId();
		Long tipoDocumentoId = aluno.getTipoDocumento().getId();

		Endereco endereco = cadastroEndereco.buscarSeExistir(enderecoId);
		Escolaridade escolaridade = cadastroEscolaridade.buscarSeExistir(escolaridadeId);
		Ocupacao ocupacao = cadastroOcupacao.buscarSeExistir(ocupacaoId);
		TipoAluno tipoAluno = cadastroTipoAluno.buscarSeExistir(tipoAlunoId);
		Sexo sexo = cadastroSexo.buscarSeExistir(sexoId);
		Genero genero = cadastroGenero.buscarSeExistir(generoId);
		Localizacao localizacao = cadastroLocalizacao.buscarSeExistir(localizacaoId);
		Pais pais = cadastroPais.buscarSeExistir(paisId);
		TipoDocumento tipoDocumento = cadastroTipoDocumento.buscarSeExistir(tipoDocumentoId);

		aluno.setEndereco(endereco);
		aluno.setEscolaridade(escolaridade);
		aluno.setOcupacao(ocupacao);
		aluno.setTipoAluno(tipoAluno);
		aluno.getPessoa().setSexo(sexo);
		aluno.getPessoa().setGenero(genero);
		aluno.getDadosEndereco().setLocalizacao(localizacao);
		aluno.getDadosEndereco().setPais(pais);
		aluno.setTipoDocumento(tipoDocumento);
		
		return alunoRepository.save(aluno);
	}

//	@Transactional
//    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
//        Usuario usuario = buscarSeExistir(usuarioId);
//        
//        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
//            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
//        }
//        
//        usuario.setSenha(novaSenha);
//    }
//	
//	@Transactional
//	public void desassociarGrupo(Long usuarioId, Long grupoId) {
//	    Usuario usuario = buscarSeExistir(usuarioId);
//	    Grupo grupo = cadastroAluno.buscarSeExistir(grupoId);
//	    
//	    usuario.removerGrupo(grupo);
//	}
//
//	@Transactional
//	public void associarGrupo(Long usuarioId, Long grupoId) {
//	    Usuario usuario = buscarSeExistir(usuarioId);
//	    Grupo grupo = cadastroAluno.buscarSeExistir(grupoId);
//	    
//	    usuario.adicionarGrupo(grupo);
//	}

	public Aluno buscarSeExistir(AlunoId alunoId) {
		return alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNaoEncontradaException("alunoId"));
	}

	public Aluno buscarSeExistir(Long alunoId) {
		return alunoRepository.buscaIdIncremental(alunoId).orElseThrow(() -> new AlunoNaoEncontradaException(alunoId));
	}

	@Transactional
	public void ativar(Long alunoId) {
		Aluno aluno = buscarSeExistir(alunoId);
		aluno.ativar();
	}

	@Transactional
	public void inativar(Long alunoId) {
		Aluno aluno = buscarSeExistir(alunoId);
		aluno.inativar();
	}

	@Transactional
	public void ativar(List<Long> alunoIds) {
		alunoIds.forEach(this::ativar);
	}

	@Transactional
	public void inativar(List<Long> alunoIds) {
		alunoIds.forEach(this::inativar);
	}

}
