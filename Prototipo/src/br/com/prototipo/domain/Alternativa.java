package br.com.prototipo.domain;

public class Alternativa {

	private Long id;
	private String alternativa;
	private Boolean correta;
	private Questao questao;

	public Alternativa() {
		Questao questao = new Questao();
		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public Boolean getCorreta() {
		return correta;
	}

	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	@Override
	public String toString() {
		return "Alternativa [id=" + id + ", alternativa=" + alternativa + ", correta=" + correta + ", questao="
				+ questao + "]";
	}

}
