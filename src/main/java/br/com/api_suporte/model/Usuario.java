package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Status;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.utils.DateFormatter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo = Tipo.FUNCIONARIO;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DATA_CRIACAO")
	private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Usuario usuario))
			return false;
		return Objects.equals(codigo, usuario.codigo);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(codigo);
	}
}
