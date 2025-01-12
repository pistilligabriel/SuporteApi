package br.com.api_suporte.model.enums;

public enum Status {
    NOVO("Novo"),
    EM_ANDAMENTO("Em_Andamento"),
    CONCLUIDO("Concluido"),
    CANCELADO("Cancelado"),
    ATIVO("Ativo"),
    DESATIVADO("Desativado");

    private final String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
    
}
