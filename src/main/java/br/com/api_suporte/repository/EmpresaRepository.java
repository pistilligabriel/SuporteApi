package br.com.api_suporte.repository;

import br.com.api_suporte.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
