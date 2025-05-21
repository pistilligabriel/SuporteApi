package br.com.api_suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api_suporte.model.Chamado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    @Query(value = """
    SELECT 
        c.status, 
        DATE_FORMAT(c.data_criacao, '%Y-%m') AS mes, 
        COUNT(*) AS total
    FROM chamados c
    GROUP BY c.status, mes
    ORDER BY mes ASC
""", nativeQuery = true)
    List<Object[]> contarChamadosPorStatusEMesRaw();
}
