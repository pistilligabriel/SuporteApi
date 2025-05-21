package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "DATA_VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataVersao = LocalDateTime.now();

    @Column(name = "DATA_CONCLUSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataConclusao;

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();


}
