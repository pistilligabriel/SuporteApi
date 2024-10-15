package br.com.api_suporte.dto.Integrante;

import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.model.enums.Tipo;
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
