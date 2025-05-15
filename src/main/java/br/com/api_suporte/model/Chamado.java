package br.com.api_suporte.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.utils.DateFormatter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chamados")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "SETOR")
    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Column(name = "SOLICITANTE")
    private String solicitante;

    @Column(name = "DESCRICAO")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RESPONSAVEL_ID")
    @JsonIgnore
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

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();


}
