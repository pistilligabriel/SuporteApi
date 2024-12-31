package br.com.api_suporte.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.api_suporte.model.enums.Prioridade;
import br.com.api_suporte.model.enums.Status;
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

@Entity
@Table(name = "chamados")

@NoArgsConstructor
@AllArgsConstructor
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "RESPONSAVEL")
    private String responsavel;

    @Column(name = "PRIORIDADE")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.NORMAL;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOVO;

    @Column(name = "DATA_CRIACAO")
    private String dataCriacao = DateFormatter.formatLocalDateTime(LocalDateTime.now());

    @Column(name = "DATA_VERSAO")
    private String dataVersao = DateFormatter.formatLocalDateTime(LocalDateTime.now()) ;

    @Column(name = "DATA_CONCLUSAO")
    private String dataConclusao;
    

    public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataVersao() {
		return dataVersao;
	}

	public void setDataVersao(String dataVersao) {
		this.dataVersao = dataVersao;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return Objects.equals(codigo, chamado.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
