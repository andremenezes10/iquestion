package br.com.prototipo.domain.dto;

import java.util.Arrays;

public class QuestaoDTO {

	private Long id;
	private Boolean status;
	private String tipo;
	private String dissetacao;
	private Integer contador;
	private Integer dificuldade;
	private DisciplinaDTO disciplina;
	private AlternativaDTO alternativas[];

	public QuestaoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDissetacao() {
		return dissetacao;
	}

	public void setDissetacao(String dissetacao) {
		this.dissetacao = dissetacao;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Integer getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Integer dificuldade) {
		this.dificuldade = dificuldade;
	}

	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	public AlternativaDTO[] getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(AlternativaDTO[] alternativas) {
		this.alternativas = alternativas;
	}

	@Override
	public String toString() {
		return "QuestaoDTO [id=" + id + ", status=" + status + ", tipo=" + tipo + ", dissetacao=" + dissetacao
				+ ", contador=" + contador + ", dificuldade=" + dificuldade + ", disciplina=" + disciplina
				+ ", alternativas=" + Arrays.toString(alternativas) + "]";
	}

}
