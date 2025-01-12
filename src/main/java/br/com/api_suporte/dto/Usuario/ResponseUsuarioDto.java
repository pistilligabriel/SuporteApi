package br.com.api_suporte.dto.Usuario;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseUsuarioDto {
	private Long codigo;
	private String status;
	private String login;
	private String dataCriacao;
}
