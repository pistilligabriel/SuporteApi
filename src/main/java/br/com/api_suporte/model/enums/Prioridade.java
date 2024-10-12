package br.com.api_suporte.model.enums;

import lombok.Getter;

@Getter
public enum Prioridade {
    ALTA("Alta"),
    NORMAL("Normal"),
    BAIXA("Baixa");

    private final String descricao;

    Prioridade(String descricao){
        this.descricao = descricao;
    }

}
