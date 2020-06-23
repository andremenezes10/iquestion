package br.com.prototipo.domain.dto;

public class AlunoDTO extends PessoaDTO {

	public AlunoDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Aluno [getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getEmail()="
				+ getEmail() + ", getSenha()=" + getSenha() + ", getTelefone()=" + getTelefone() + ", getSexo()="
				+ getSexo() + "]";
	}

}