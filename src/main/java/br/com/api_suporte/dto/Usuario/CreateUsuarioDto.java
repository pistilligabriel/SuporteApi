package br.com.api_suporte.dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUsuarioDto {
    private String login;
    private String password;
    
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
