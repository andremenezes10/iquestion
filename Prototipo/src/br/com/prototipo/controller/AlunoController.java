package br.com.prototipo.controller;

import java.io.IOException;

import br.com.prototipo.domain.Aluno;
import br.com.prototipo.exception.InvalidLoginOrPassword;
import br.com.prototipo.util.ManipuladorArquivo;

public class AlunoController {
	public Aluno login(String key, String password) throws IOException {

		ManipuladorArquivo arq = new ManipuladorArquivo();

		Aluno aluno = arq.loginAluno(key, password);
		if (aluno.getId() == null) {
			throw new InvalidLoginOrPassword();
		}
		System.out.println(aluno);
		return aluno;
	}
}
