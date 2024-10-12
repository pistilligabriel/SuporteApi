package br.com.api_suporte.model.enums;

import lombok.Getter;

@Getter
public enum Status {
    NOVO("Novo"),
    EM_ANDAMENTO("Em_Andamento"),
    CONCLUIDO("Concluido"),
    CANCELADO("Cancelado");

    private final String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }
}
