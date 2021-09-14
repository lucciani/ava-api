package io.github.lucciani.ava.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.lucciani.ava.domain.exception.EntidadeEmUsoException;
import io.github.lucciani.ava.domain.exception.EntidadeNaoEncontradaException;
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
	public ResponseEntity<TipoDocumento> buscar(@PathVariable Long tipoDocumentoId) {
		Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(tipoDocumentoId);

		if (tipoDocumento.isPresent()) {
			return ResponseEntity.ok(tipoDocumento.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TipoDocumento adicionar(@RequestBody TipoDocumento tipoDocumento) {
		return cadastroTipoDocumento.salvar(tipoDocumento);
	}

	@PutMapping(value = "/{tipoDocumentoId}")
	public ResponseEntity<TipoDocumento> atualizar(@PathVariable Long tipoDocumentoId, @RequestBody TipoDocumento tipoDocumento) {

		Optional<TipoDocumento> tipoDocumentoAtual = tipoDocumentoRepository.findById(tipoDocumentoId);

		if (tipoDocumentoAtual.isPresent()) {
			BeanUtils.copyProperties(tipoDocumento, tipoDocumentoAtual.get(), "id");
			TipoDocumento tipoDocumentoSalvo = cadastroTipoDocumento.salvar(tipoDocumentoAtual.get());
			return ResponseEntity.ok(tipoDocumentoSalvo);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{tipoDocumentoId}")
	public ResponseEntity<?> remover(@PathVariable Long tipoDocumentoId) {
		try {
			cadastroTipoDocumento.remover(tipoDocumentoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
