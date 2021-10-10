package io.github.lucciani.ava.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.lucciani.ava.domain.model.Crede;

@Repository
public interface CredeRepository extends JpaRepository<Crede, Long> {
	
	Optional<Crede> findBySigla(String sgila);

}
