package br.com.api_suporte.model.enums;

public enum Tipo {
    CLIENTE("Cliente"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
    
}
