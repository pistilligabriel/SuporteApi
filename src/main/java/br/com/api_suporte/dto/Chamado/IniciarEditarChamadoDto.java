package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IniciarEditarChamadoDto {
    private Status status;
    private String responsavel;
}
