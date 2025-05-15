package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.Chamado;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotaChamadoDto {
    private String conteudo;
    private String autor;
}
