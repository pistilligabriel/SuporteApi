package br.com.api_suporte.dto.Chamado;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChamadoDto {
    private String cliente;
    private String titulo;
    private String solicitante;
    private String descricao;
    private String prioridade;
    private String responsavel;
}
