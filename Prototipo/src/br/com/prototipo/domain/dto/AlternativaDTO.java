package br.com.prototipo.domain.dto;

public class AlternativaDTO {

	private Long id;
	private String alternativa;
	private Boolean correta;

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

	@Override
	public String toString() {
		return "AlternativaDTO [id=" + id + ", alternativa=" + alternativa + ", correta=" + correta + "]";
	}

}
