package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.utils.DateFormatter;
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

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DATA_CRIACAO")
	private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

	@Column(name = "SETOR")
	@Enumerated(EnumType.STRING)
	private Setor setor;

	@OneToMany(mappedBy = "responsavel")
	private List<Chamado> chamados = new ArrayList<>();

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
