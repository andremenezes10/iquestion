package br.com.prototipo.domain.dto;

public class DisciplinaDTO {
	private Long id;
	private String nome;
	private MateriaDTO materia;

	public DisciplinaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MateriaDTO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDTO materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "DisciplinaDTO [id=" + id + ", nome=" + nome + ", materia=" + materia + "]";
	}

}
