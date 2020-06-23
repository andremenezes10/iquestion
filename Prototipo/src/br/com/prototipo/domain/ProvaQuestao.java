package br.com.prototipo.domain;

public class ProvaQuestao {
	
	public Long id;
	public Long idQuestao;
	public Long idProva;
	
	public ProvaQuestao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	@Override
	public String toString() {
		return "ProvaQuestao [id=" + id + ", idQuestao=" + idQuestao + ", idProva=" + idProva + "]";
	}
	
	
}
