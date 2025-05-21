package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.enums.Setor;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseChamadoDto {
	private Long codigo;
	private Setor setor;
	private String solicitante;
	private String titulo;
	private String descricao;
	private String prioridade;
	private String status;
	private String responsavel;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCriacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataConclusao;
	private List<NotaResponseDto> notas;
}
