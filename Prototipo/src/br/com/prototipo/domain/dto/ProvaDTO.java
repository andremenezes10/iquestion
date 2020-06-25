package br.com.prototipo.domain.dto;

import java.util.Arrays;

public class ProvaDTO {
	private Long id;
	private String data;
	private Double nota;
	private AlunoDTO aluno;
	private QuestaoDTO questoes[];
	private DisciplinaDTO disciplinaDTO;

	public ProvaDTO() {
		AlunoDTO aluno = new AlunoDTO();
		this.aluno = aluno;
	}
	
	public ProvaDTO(ProvaDTO prova) {
		this.id = prova.id;
		this.data = prova.data;
		this.nota = prova.nota;
		this.aluno = prova.aluno;
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

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public QuestaoDTO[] getQuestoes() {
		return questoes;
	}

	public void setQuestoes(QuestaoDTO[] questoes) {
		this.questoes = questoes;
	}

	public DisciplinaDTO getDisciplinaDTO() {
		return disciplinaDTO;
	}

	public void setDisciplinaDTO(DisciplinaDTO disciplinaDTO) {
		this.disciplinaDTO = disciplinaDTO;
	}

	@Override
	public String toString() {
		return "ProvaDTO [id=" + id + ", data=" + data + ", nota=" + nota + ", aluno=" + aluno + ", questoes="
				+ Arrays.toString(questoes) + ", disciplinaDTO=" + disciplinaDTO + "]";
	}

}
