package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.enums.Setor;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseChamadoDto {
	private Long codigo;
	private Setor setorId;
	private String solicitante;
	private String titulo;
	private String descricao;
	private String prioridade;
	private String status;
	private String responsavel;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
}
