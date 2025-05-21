package br.com.api_suporte.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "NOME_EMPRESA")
    private String nomeEmpresa;

    @Column(name = "LOGO")
    @Lob
    private byte[] logo;
}
