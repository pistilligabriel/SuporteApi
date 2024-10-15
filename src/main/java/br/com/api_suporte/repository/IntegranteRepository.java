package br.com.api_suporte.repository;

import br.com.api_suporte.model.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante,Long> {
}
