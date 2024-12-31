package br.com.api_suporte.dto.Usuario;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseUsuarioDto {
    private Long codigo;
    private String status;
    private String login;
    private String dataCriacao;
    
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
    
    
}
