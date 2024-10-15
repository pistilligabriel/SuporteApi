package br.com.api_suporte.repository;

import br.com.api_suporte.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
