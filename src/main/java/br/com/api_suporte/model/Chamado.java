package br.com.api_suporte.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.utils.DateFormatter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chamado implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "SETOR")
    private Setor setor;

    @Column(name = "SOLICITANTE")
    private String solicitante;

    @Column(name = "DESCRICAO")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPONSAVEL_ID")
    private Usuario responsavel;

    @Column(name = "PRIORIDADE")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.NORMAL;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOVO;

    @Column(name = "DATA_CRIACAO")
    private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

    @Column(name = "DATA_VERSAO")
    private String dataVersao = DateFormatter.formatLocalDateTime(LocalDateTime.now()) ;

    @Column(name = "DATA_CONCLUSAO")
    private String dataConclusao;

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
