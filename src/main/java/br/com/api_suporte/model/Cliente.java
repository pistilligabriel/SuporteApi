package br.com.api_suporte.model;

import br.com.api_suporte.model.enums.Autorizacao;
import br.com.api_suporte.model.enums.Classe;
import br.com.api_suporte.model.enums.Produto;
import br.com.api_suporte.model.enums.Status;
import br.com.api_suporte.model.enums.Tipo;
import br.com.api_suporte.utils.DateFormatter;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO")
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name="TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.CLIENTE;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DOCUMENTO", length = 11)
    private String documento;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="QUANTIDADE_USUARIOS")
    private int quantidadeUsuarios;
    
    @Column(name="AUTORIZACAO")
    private Autorizacao autorizacao;
    
    @Column(name = "CLASSE")
    private Classe classe;
    
    @Column(name = "VERSAO")
    private Date versao;
    
    @Column(name = "JAVA")
    private String java;
    
    @Column(name="PRODUTO")
    private Produto produto;

    @Column(name = "DATA_CRIACAO")
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}

	public void setQuantidadeUsuarios(int quantidadeUsuarios) {
		this.quantidadeUsuarios = quantidadeUsuarios;
	}

	public Autorizacao getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(Autorizacao autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Date getVersao() {
		return versao;
	}

	public void setVersao(Date versao) {
		this.versao = versao;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente that)) return false;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
