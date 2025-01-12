package br.com.api_suporte.dto.Cliente;

import java.util.Date;

import br.com.api_suporte.model.enums.Autorizacao;
import br.com.api_suporte.model.enums.Classe;
import br.com.api_suporte.model.enums.Produto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateClienteDto {
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
