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

import io.github.lucciani.ava.domain.model.TipoDocumento;
import io.github.lucciani.ava.domain.repository.TipoDocumentoRepository;
import io.github.lucciani.ava.domain.service.CadastroTipoDocumentoService;

@RestController
@RequestMapping(value = "/tipos-documentos")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private CadastroTipoDocumentoService cadastroTipoDocumento;

	@GetMapping
	public List<TipoDocumento> listar() {
		return tipoDocumentoRepository.findAll();
	}

	@GetMapping(value = "/{tipoDocumentoId}")
	public TipoDocumento buscar(@PathVariable Long tipoDocumentoId) {
		return cadastroTipoDocumento.buscarSeExistir(tipoDocumentoId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TipoDocumento adicionar(@RequestBody TipoDocumento tipoDocumento) {
		return cadastroTipoDocumento.salvar(tipoDocumento);
	}

	@PutMapping(value = "/{tipoDocumentoId}")
	public TipoDocumento atualizar(@PathVariable Long tipoDocumentoId, @RequestBody TipoDocumento tipoDocumento) {

		TipoDocumento tipoDocumentoAtual = cadastroTipoDocumento.buscarSeExistir(tipoDocumentoId);

		BeanUtils.copyProperties(tipoDocumento, tipoDocumentoAtual, "id");
		return cadastroTipoDocumento.salvar(tipoDocumentoAtual);
	}

	@DeleteMapping(value = "/{tipoDocumentoId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long tipoDocumentoId) {
		cadastroTipoDocumento.remover(tipoDocumentoId);
	}
}
