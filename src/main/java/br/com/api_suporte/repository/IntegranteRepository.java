package br.com.api_suporte.repository;

import br.com.api_suporte.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Cliente, Long> {
}
