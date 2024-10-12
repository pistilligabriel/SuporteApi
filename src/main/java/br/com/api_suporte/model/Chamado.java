package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "responsavel")
    private String responsavel;

    @Column(name = "prioridade")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.NORMAL;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOVO;

    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "dataVersao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataVersao = LocalDateTime.now() ;

    @Column(name = "dataConclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataConclusao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return Objects.equals(codigo, chamado.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
