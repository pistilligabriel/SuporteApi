package br.com.api_suporte.dto.Chamado;

import lombok.*;

<<<<<<< HEAD
@Getter
@Setter
=======

>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChamadoDto {
<<<<<<< HEAD
    private String cliente;
    private String titulo;
    private String solicitante;
    private String descricao;
    private String prioridade;
    private String responsavel;
=======
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
    
    
>>>>>>> 53e9479460c4d2d76f073f2aa6360be2166fcfc9
}
