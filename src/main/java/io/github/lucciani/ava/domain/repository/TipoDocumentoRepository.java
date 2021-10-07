package io.github.lucciani.ava.domain.repository;

import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends CustomJpaRepository<TipoDocumento, Long> {

}
