package br.com.prototipo.domain.dto;

public class AdminDTO extends PessoaDTO{

	public AdminDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getEmail()="
				+ getEmail() + ", getSenha()=" + getSenha() + ", getTelefone()=" + getTelefone() + ", getSexo()="
				+ getSexo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
