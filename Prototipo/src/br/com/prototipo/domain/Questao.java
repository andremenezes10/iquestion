package br.com.prototipo.domain;

public class Questao {
	
	private Long id;
	private Boolean status;
	private String tipo;
	private String dissetacao;
	private Integer contador;
	private Integer dificuldade;
	private Disciplina disciplina;
	
	public Questao() {
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", status=" + status + ", tipo=" + tipo + ", dissetacao=" + dissetacao
				+ ", contador=" + contador + ", dificuldade=" + dificuldade + ", disciplina=" + disciplina + "]";
	}
	

}
