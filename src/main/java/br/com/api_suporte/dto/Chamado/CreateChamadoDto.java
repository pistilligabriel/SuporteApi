package br.com.api_suporte.dto.Chamado;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChamadoDto {
    private String titulo;
    private String descricao;
    private String prioridade;
    private String responsavel;
    
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
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
    
    
}
