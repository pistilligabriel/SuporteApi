package br.com.api_suporte.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChamadoDto {
    private String titulo;
    private String descricao;
    private String prioridade;
    private String responsavel;
}
