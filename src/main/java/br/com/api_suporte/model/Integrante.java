package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.model.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "integrantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Integrante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO")
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USUARIO_CODIGO", referencedColumnName = "CODIGO")
    private Usuario usuario;

    @Column(name="TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.CLIENTE;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "DOCUMENTO", length = 11)
    private String documento;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Integrante that)) return false;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
