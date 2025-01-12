package br.com.api_suporte.dto.Cliente;

import java.util.Date;

import br.com.api_suporte.model.enums.Autorizacao;
import br.com.api_suporte.model.enums.Classe;
import br.com.api_suporte.model.enums.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseClienteDto {
    private Long codigo;
    private String status;
    private String tipo;
    private String nome;
    private String documento;
    private String email;
    private int quantidadeUsuarios;
    private Autorizacao autorizacao;
    private Classe classe;
    private Date versao;
    private String java;
    private Produto produto;  
    
}
