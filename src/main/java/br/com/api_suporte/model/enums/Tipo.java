package br.com.api_suporte.model.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
public enum Tipo {
    CLIENTE("Cliente"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }
}
