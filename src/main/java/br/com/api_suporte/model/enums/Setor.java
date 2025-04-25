package br.com.api_suporte.model.enums;

import lombok.Getter;

@Getter
public enum Setor {
    ADMINISTRACAO("Administração"),
    COMPRAS("Compras"),
    CPD("CPD"),
    JURIDICO("Juridico"),
    FINANCAS("Financas"),
    GESTAO_DE_CONTRATOS("Gestão de Contratos"),
    OBRAS("Obras");

    private String descricao;

    Setor(String descricao) {
        this.descricao = descricao;
    }
}
