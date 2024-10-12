package br.com.api_suporte.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseChamadoDto {
    private Long codigo;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status;
    private LocalDateTime dataCriacao;
}
