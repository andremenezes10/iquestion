package br.com.prototipo.domain;

public class Aluno extends Pessoa {

	public Aluno() {
		super();
	}

	@Override
	public String toString() {
		return "Aluno [getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getEmail()="
				+ getEmail() + ", getSenha()=" + getSenha() + ", getTelefone()=" + getTelefone() + ", getSexo()="
				+ getSexo() + "]";
	}

}