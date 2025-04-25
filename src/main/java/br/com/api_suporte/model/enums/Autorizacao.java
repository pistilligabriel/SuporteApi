package br.com.api_suporte.model.enums;

import lombok.Getter;

@Getter
public enum Autorizacao {
	EMAIL,
	TELEFONE,
	EMAIL_OU_TELEFONE;
}
