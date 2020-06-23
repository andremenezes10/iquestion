package br.com.prototipo.domain;

public class Admin extends Pessoa{

	public Admin() {
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
