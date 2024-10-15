package br.com.api_suporte.dto.Integrante;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseIntegranteDto {
    private Long codigo;
    private String status;
    private String tipo;
    private String nome;
    private String sobrenome;
}
