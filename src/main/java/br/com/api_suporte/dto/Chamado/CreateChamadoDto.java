package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.enums.Setor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChamadoDto {
	private Setor setor;
	private String titulo;
	private String solicitante;
	private String descricao;
	private String prioridade;
}
