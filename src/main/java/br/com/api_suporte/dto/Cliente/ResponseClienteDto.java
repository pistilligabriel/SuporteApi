package br.com.api_suporte.dto.Cliente;

import java.util.Date;

import br.com.api_suporte.model.enums.Autorizacao;
import br.com.api_suporte.model.enums.Classe;
import br.com.api_suporte.model.enums.Produto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseClienteDto {
    private Long codigo;
    private String status;
    private String tipo;
    private String nome;
    private String documento;
    private String email;
    private int quantidadeUsuarios;
    private Autorizacao autorizacao;
    private Classe classe;
    private Date versao;
    private String java;
    private Produto produto;
    
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
    
    
}
