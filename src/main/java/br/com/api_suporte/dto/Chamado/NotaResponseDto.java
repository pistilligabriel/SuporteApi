package br.com.api_suporte.dto.Chamado;

import br.com.api_suporte.model.Chamado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponseDto {
    private String conteudo;
    private String autor;
    private String dataCriacao;
}
