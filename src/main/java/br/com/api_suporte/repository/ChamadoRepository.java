package br.com.api_suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api_suporte.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
