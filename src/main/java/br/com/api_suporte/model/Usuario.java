package br.com.api_suporte.model;

<<<<<<< HEAD
import br.com.api_suporte.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

=======
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

<<<<<<< HEAD
@Entity
@Table(name = "usuarios")
@Getter
@Setter
=======
import br.com.api_suporte.model.enums.Status;
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
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario implements Serializable {
<<<<<<< HEAD
    @Id
=======

	private static final long serialVersionUID = 1L;

	@Id
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO")
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

<<<<<<< HEAD
    @OneToOne(mappedBy = "usuario")
    private Integrante integrante;

=======
    @Column(name="TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.FUNCIONARIO;
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DATA_CRIACAO")
<<<<<<< HEAD
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Override
=======
    private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());
    

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(codigo, usuario.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
