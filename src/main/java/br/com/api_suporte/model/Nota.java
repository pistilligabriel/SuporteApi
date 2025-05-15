package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.utils.DateFormatter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "nota")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "CONTEUDO")
    private String conteudo;

    @Column(name="AUTOR")
    private String autor;

    @Column(name = "DATA_CRIACAO")
    private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

    @ManyToOne
    @JoinColumn(name = "chamado_codigo", nullable = false)
    @JsonIgnore
    private Chamado chamado;


}
