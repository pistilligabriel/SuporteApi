package br.com.api_suporte.model.enums;

<<<<<<< HEAD
import lombok.Getter;

@Getter
=======
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
public enum Tipo {
    CLIENTE("Cliente"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }
<<<<<<< HEAD
=======

	public String getDescricao() {
		return descricao;
	}
    
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
}
