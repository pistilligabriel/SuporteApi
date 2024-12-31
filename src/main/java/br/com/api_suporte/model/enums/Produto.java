package br.com.api_suporte.model.enums;

public enum Produto {
	MASTERCOMMERCE("MasterCommerce"),
	MASTERCLINIC("MasterClinic"),
	MASTERCOMMERCE_LITE("MasterCommerce-Lite");
	
	private final String descricao;

	Produto(String descricao){
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
	
}
