package br.com.api_suporte.dto.Integrante;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateIntegranteDto {
    private String nome;
    private String sobrenome;
    private String documento;
}
