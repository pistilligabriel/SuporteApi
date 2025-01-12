package br.com.api_suporte.dto.Usuario;

import lombok.*;

<<<<<<< HEAD
@Getter
@Setter
=======

>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseUsuarioDto {
    private Long codigo;
    private String status;
    private String login;
    private String dataCriacao;
<<<<<<< HEAD
=======
    
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
    
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
}
