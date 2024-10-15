package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chamado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name="CLIENTE")
    private String cliente;

    @Column(name = "SOLICITANTE")
    private String solicitante;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "RESPONSAVEL")
    private String responsavel;

    @Column(name = "PRIORIDADE")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.NORMAL;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOVO;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "DATA_VERSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataVersao = LocalDateTime.now() ;

    @Column(name = "DATA_CONCLUSAO")
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
