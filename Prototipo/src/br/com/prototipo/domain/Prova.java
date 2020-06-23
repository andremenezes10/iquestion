package br.com.prototipo.domain;

public class Prova {
	private Long id;
	private String data;
	private Double nota;
	private Aluno aluno;

	public Prova() {
		Aluno aluno = new Aluno();
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", data=" + data + ", nota=" + nota + ", aluno=" + aluno + "]";
	}

}
