package br.com.api_suporte.dto.Chamado;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoStatusMesDto {
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private YearMonth mes;
    private Long quantidade;
}
