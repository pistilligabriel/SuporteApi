package br.com.api_suporte.dto.Usuario;

<<<<<<< HEAD
import br.com.api_suporte.model.Integrante;
import lombok.*;

@Getter
@Setter
=======
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;



>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUsuarioDto {
<<<<<<< HEAD
    private Integrante integrante;
    private String login;
    private String password;
=======
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
    
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
}
