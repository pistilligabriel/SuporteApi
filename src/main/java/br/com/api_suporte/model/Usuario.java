package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Setor;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.model.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.api_suporte.utils.DateFormatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "DATA_CRIACAO")
	private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

	@Column(name = "SETOR")
	@Enumerated(EnumType.STRING)
	private Setor setor;

	@OneToMany(mappedBy = "responsavel")
	@JsonIgnore
	private List<Chamado> chamados = new ArrayList<>();


//    Metodos do UserDetails


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
}
