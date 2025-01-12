package br.com.api_suporte.dto.Chamado;

<<<<<<< HEAD
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
=======
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseChamadoDto {
    private Long codigo;
<<<<<<< HEAD
    private String cliente;
    private String solicitante;
=======
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status;
    private String responsavel;
<<<<<<< HEAD
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
=======
    private String dataCriacao;
    
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
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
    
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
}
