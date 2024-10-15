package br.com.api_suporte.dto.Usuario;

import br.com.api_suporte.model.Integrante;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUsuarioDto {
    private Integrante integrante;
    private String login;
    private String password;
}
