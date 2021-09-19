package io.github.lucciani.ava.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lucciani.ava.domain.model.Regiao;
import io.github.lucciani.ava.domain.repository.RegiaoRepository;
import io.github.lucciani.ava.domain.service.CadastroRegiaoService;

@RestController
@RequestMapping(value = "/regioes")
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@Autowired
	private CadastroRegiaoService cadastroRegiao;

	@GetMapping
	public List<Regiao> listar() {
		return regiaoRepository.findAll();
	}

	@GetMapping(value = "/{regiaoId}")
	public Regiao buscar(@PathVariable Long regiaoId) {
		return cadastroRegiao.buscarSeExistir(regiaoId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Regiao adicionar(@RequestBody Regiao regiao) {
		return cadastroRegiao.salvar(regiao);
	}

	@PutMapping(value = "/{regiaoId}")
	public Regiao atualizar(@PathVariable Long regiaoId, @RequestBody Regiao regiao) {

		Regiao regiaoAtual = cadastroRegiao.buscarSeExistir(regiaoId);

		BeanUtils.copyProperties(regiao, regiaoAtual, "id");
		return cadastroRegiao.salvar(regiaoAtual);
	}

	@DeleteMapping(value = "/{regiaoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long regiaoId) {
		cadastroRegiao.remover(regiaoId);
	}
}
