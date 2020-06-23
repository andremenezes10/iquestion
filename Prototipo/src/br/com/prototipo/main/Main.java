package br.com.prototipo.main;

import java.io.IOException;

import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.Prova;
import br.com.prototipo.domain.dto.AlternativaDTO;
import br.com.prototipo.domain.dto.QuestaoDTO;
import br.com.prototipo.util.ManipuladorArquivo;

public class Main {

	public static void main(String[] args) throws IOException {
		ManipuladorArquivo manipula = new ManipuladorArquivo();
		
		Aluno aluno = new Aluno();
		Prova prova = new Prova();
		
		aluno.setId((long) 1);
		prova.setData("23/06/2020");
		prova.setNota(null);
		prova.setAluno(aluno);
		manipula.gerarProva(prova, 1, 4);
	
		AlternativaDTO alternativa1 = new AlternativaDTO();
		alternativa1.setAlternativa("1");
		alternativa1.setCorreta(false);
		AlternativaDTO alternativa2 = new AlternativaDTO();
		alternativa2.setAlternativa("2");
		alternativa2.setCorreta(true);
		AlternativaDTO alternativa3 = new AlternativaDTO();
		alternativa3.setAlternativa("3");
		alternativa3.setCorreta(false);
		AlternativaDTO alternativa4 = new AlternativaDTO();
		alternativa4.setAlternativa("4");
		alternativa4.setCorreta(false);
		AlternativaDTO alternativa5 = new AlternativaDTO();
		alternativa5.setAlternativa("5");
		alternativa5.setCorreta(false);
		AlternativaDTO alternativas = new AlternativaDTO([alternativa1,alternativa2, alternativa3, alternativa4, alternativa5 ]);
		QuestaoDTO questao1 = new QuestaoDTO();
		questao1.setDissetacao("quanto é 1 + 1?");
	}
}
