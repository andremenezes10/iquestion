package br.com.prototipo.domain.dto;

import br.com.prototipo.domain.Disciplina;

public class MateriaDTO {

	private Long id;
	private String nome;

	public MateriaDTO() {
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

	@Override
	public String toString() {
		return "MateriaDTO [id=" + id + ", nome=" + nome + "]";
	}

}
