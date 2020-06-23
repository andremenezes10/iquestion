package br.com.prototipo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

import br.com.prototipo.domain.Alternativa;
import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.Disciplina;
import br.com.prototipo.domain.Materia;
import br.com.prototipo.domain.Prova;
import br.com.prototipo.domain.ProvaQuestao;
import br.com.prototipo.domain.Questao;
import br.com.prototipo.domain.dto.ProvaDTO;
import br.com.prototipo.domain.dto.QuestaoDTO;
import br.com.prototipo.exception.InvalidLoginOrPassword;

public class ManipuladorArquivo {

	Conversor conversor = new Conversor();

	// Pega todas as informações da prova feita
	public ProvaDTO pegaProva(Integer id) {

		ProvaDTO provaDTO = new ProvaDTO();
		try {
			Prova prova = leitorDeProva(id);
			Questao[] questoes = pegaQuestoes(id);

			QuestaoDTO[] questoesDTO = new QuestaoDTO[questoes.length];
			Integer count = 0;
			for (Questao questao : questoes) {

				Alternativa[] alternativasQ = pegaAlternativas(questao.getId());

				QuestaoDTO questaoDTO = conversor.questaoConverter(questao, alternativasQ);
				questoesDTO[count] = questaoDTO;
				count++;
			}

			provaDTO = conversor.provaConverter(prova, questoesDTO);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(provaDTO);
		return provaDTO;
	};

	// retorna dados da prova (apenas prova) por id
	public Prova leitorDeProva(Integer idProva) throws IOException {
		BufferedReader buffReadProva = new BufferedReader(new FileReader("files/Prova.txt"));
		String linhaProva = buffReadProva.readLine();

		Prova prova = new Prova();
		while (true) {

			if (linhaProva != null) {

				String segments[] = linhaProva.split(";");
				if (Integer.parseInt(segments[0]) == idProva) {

					prova.setId(Long.parseLong(segments[0]));
					prova.setData(segments[1]);
					if (!segments[2].isEmpty()) {
						prova.setNota(Double.parseDouble(segments[2]));
					}
					prova.setAluno(pegaAluno(Integer.parseInt(segments[3])));

				}

			} else
				break;
			linhaProva = buffReadProva.readLine();
		}
		buffReadProva.close();
		return prova;
	}

	// retorna dados do aluno por id
	public Aluno pegaAluno(Integer idAluno) throws IOException {
		BufferedReader buffReadAluno = new BufferedReader(new FileReader("files/Aluno.txt"));
		String linhaAluno = buffReadAluno.readLine();

		Aluno aluno = new Aluno();
		while (true) {

			if (linhaAluno != null) {

				String segments[] = linhaAluno.split(";");

				if (Integer.parseInt(segments[0]) == idAluno) {

					aluno.setId(Long.parseLong(segments[0]));
					aluno.setNome(segments[1]);
					aluno.setCpf(segments[2]);
					aluno.setEmail(segments[3]);
					aluno.setSenha(segments[4]);
					aluno.setTelefone(segments[5]);
					aluno.setSexo(segments[6]);
				}

			} else
				break;
			linhaAluno = buffReadAluno.readLine();
		}
		buffReadAluno.close();
		return aluno;
	}

	// retorna aluno atraves do (cpf || email) && senha
	public Aluno login(String key, String password) throws IOException {
		BufferedReader buffReadAluno = new BufferedReader(new FileReader("files/Aluno.txt"));
		String linhaAluno = buffReadAluno.readLine();

		Aluno aluno = new Aluno();
		while (true) {

			if (linhaAluno != null) {

				String segments[] = linhaAluno.split(";");

				if (key.contains("@")) {
					if (segments[3].equals(key) && segments[4].equals(password)) {

						aluno.setId(Long.parseLong(segments[0]));
						aluno.setNome(segments[1]);
						aluno.setCpf(segments[2]);
						aluno.setEmail(segments[3]);
						aluno.setSenha(segments[4]);
						aluno.setTelefone(segments[5]);
						aluno.setSexo(segments[6]);
					} else if (segments[3].equals(key) && !segments[4].equals(password)) {
						throw new InvalidLoginOrPassword();
					}
				} else {
					if (segments[2].equals(key) && segments[4].equals(password)) {

						aluno.setId(Long.parseLong(segments[0]));
						aluno.setNome(segments[1]);
						aluno.setCpf(segments[2]);
						aluno.setEmail(segments[3]);
						aluno.setSenha(segments[4]);
						aluno.setTelefone(segments[5]);
						aluno.setSexo(segments[6]);
					} else if (segments[2].equals(key) && !segments[4].equals(password)) {
						throw new InvalidLoginOrPassword();
					}

				}

			} else
				break;
			linhaAluno = buffReadAluno.readLine();
		}
		buffReadAluno.close();
		return aluno;
	}

	// Retorna quantidade (integer) de questoes da prova
	public Integer pegaQuantidadeQuestoes(Integer idProva) throws IOException {
		BufferedReader buffReadProvaQ = new BufferedReader(new FileReader("files/ProvaQuestao.txt"));
		String linhaProvaQuestao = buffReadProvaQ.readLine();

		Integer count = 0;

		while (true) {

			if (linhaProvaQuestao != null) {

				String segments[] = linhaProvaQuestao.split(";");

				if (Integer.parseInt(segments[2]) == idProva) {

					count++;
				}

			} else
				break;
			linhaProvaQuestao = buffReadProvaQ.readLine();
		}
		buffReadProvaQ.close();
		return count;
	}

	// Pega todas as questoes da prova;
	public Questao[] pegaQuestoes(Integer idProva) throws IOException {

		BufferedReader buffReadProvaQ = new BufferedReader(new FileReader("files/ProvaQuestao.txt"));
		String linhaProvaQuestao = buffReadProvaQ.readLine();
		int quantQuestoes = pegaQuantidadeQuestoes(idProva);
		String[] ids = new String[quantQuestoes];
		int count = 0;
		while (true) {

			if (linhaProvaQuestao != null) {

				String segments[] = linhaProvaQuestao.split(";");

				if (Integer.parseInt(segments[2]) == idProva) {

					ids[count] = segments[1];

					count++;
				}

			} else
				break;
			linhaProvaQuestao = buffReadProvaQ.readLine();
		}
		buffReadProvaQ.close();

		Questao[] questoes = new Questao[quantQuestoes];
		for (int i = 0; i < ids.length; i++) {
			questoes[i] = pegaQuestao(Integer.parseInt(ids[i]));
		}

		return questoes;
	}

	// Retorna questao por id;
	public Questao pegaQuestao(Integer idQuestao) throws IOException {

		BufferedReader buffReadQuestao = new BufferedReader(new FileReader("files/Questao.txt"));
		String linhaQuestao = buffReadQuestao.readLine();

		Questao questao = new Questao();
		while (true) {

			if (linhaQuestao != null) {

				String segments[] = linhaQuestao.split(";");

				if (Integer.parseInt(segments[0]) == idQuestao) {

					questao.setId(Long.parseLong(segments[0]));
					questao.setStatus(Boolean.valueOf(segments[1]));
					questao.setTipo(segments[2]);
					questao.setDissetacao(segments[3]);
					questao.setContador(Integer.parseInt(segments[4]));
					questao.setDificuldade(Integer.parseInt(segments[5]));
					questao.setDisciplina(pegaDisciplina(Integer.parseInt(segments[6])));
				}

			} else
				break;
			linhaQuestao = buffReadQuestao.readLine();
		}
		buffReadQuestao.close();

		return questao;
	}

	// Retorna materia por id;
	public Materia pegaMateria(int idMateria) throws IOException {
		BufferedReader buffReadMateria = new BufferedReader(new FileReader("files/Disciplina.txt"));
		String linhaMateria = buffReadMateria.readLine();

		Materia materia = new Materia();
		while (true) {

			if (linhaMateria != null) {

				String segments[] = linhaMateria.split(";");

				if (Integer.parseInt(segments[0]) == idMateria) {

					materia.setId(Long.parseLong(segments[0]));
					materia.setNome(segments[1]);
				}

			} else
				break;
			linhaMateria = buffReadMateria.readLine();
		}
		buffReadMateria.close();

		return materia;
	}

	// retorna disciplina por id
	public Disciplina pegaDisciplina(long idDisciplina) throws IOException {
		BufferedReader buffReadDisciplina = new BufferedReader(new FileReader("files/Disciplina.txt"));
		String linhaDisciplina = buffReadDisciplina.readLine();

		Disciplina disciplina = new Disciplina();
		while (true) {

			if (linhaDisciplina != null) {

				String segments[] = linhaDisciplina.split(";");

				if (Integer.parseInt(segments[0]) == idDisciplina) {

					disciplina.setId(Long.parseLong(segments[0]));
					disciplina.setNome(segments[1]);
					disciplina.setMateria(pegaMateria(Integer.parseInt(segments[2])));
				}

			} else
				break;
			linhaDisciplina = buffReadDisciplina.readLine();
		}
		buffReadDisciplina.close();

		return disciplina;
	}

	// retorna todas as alternativas vinculadas à uma questao (ate 5);
	public Alternativa[] pegaAlternativas(Long idQuestao) throws IOException {

		BufferedReader buffReadAlternativa = new BufferedReader(new FileReader("files/Alternativa.txt"));
		String linhaProvaAlternativa = buffReadAlternativa.readLine();
		int count = 0;
		Alternativa[] alternativas = new Alternativa[5];
		while (true) {

			if (linhaProvaAlternativa != null) {

				String segments[] = linhaProvaAlternativa.split(";");

				if (Integer.parseInt(segments[3]) == idQuestao) {

					Alternativa alternativa = new Alternativa();
					alternativa.setId(Long.parseLong(segments[0]));
					alternativa.setAlternativa(segments[1]);
					alternativa.setCorreta(Boolean.valueOf((segments[2])));

					alternativa.getQuestao().setId(Long.parseLong(segments[3]));

					alternativas[count] = alternativa;

					count++;
				}

			} else
				break;
			linhaProvaAlternativa = buffReadAlternativa.readLine();
		}
		buffReadAlternativa.close();

		return alternativas;

	}

	// retorna inteiro com o numero de disciplinas vinculadas a uma materia
	public Integer pegaNumeroDeDiscpPorIdMateria(Integer idMateria) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("files/Disciplina.txt"));
		String linha = buffRead.readLine();

		Integer count = 0;

		while (true) {

			if (linha != null) {

				String segments[] = linha.split(";");

				if (Integer.parseInt(segments[2]) == idMateria) {
					count++;

				}

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();

		return count;
	}

	// retorna numero de linhas de um arquivo
	public Integer pegaNumeroDeLinhas(String nomeArquivo) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("files/" + nomeArquivo + ".txt"));
		String linha = buffRead.readLine();

		Integer count = 0;
		while (true) {

			if (linha != null) {

				count++;

			} else
				break;
			linha = buffRead.readLine();
		}
		return count;
	}

	// retorna todas as materias
	public Materia[] pegarTodasMaterias() throws IOException {
		BufferedReader buffReadMateria = new BufferedReader(new FileReader("files/Disciplina.txt"));

		String linhaMateria = buffReadMateria.readLine();

		Integer count = pegaNumeroDeLinhas("Materia");

		Integer aux = 0;
		Materia[] materias = new Materia[count];
		while (true) {

			if (linhaMateria != null) {
				Materia materia = new Materia();
				String segments[] = linhaMateria.split(";");

				materia.setId(Long.parseLong(segments[0]));
				materia.setNome(segments[1]);
				materias[aux] = materia;
				aux++;

			} else
				break;
			linhaMateria = buffReadMateria.readLine();
		}
		buffReadMateria.close();

		return materias;
	}

	// retorna todas as disciplinas
	public Disciplina[] pegarTodasDisciplinas() throws IOException {
		BufferedReader buffReadDisciplina = new BufferedReader(new FileReader("files/Disciplina.txt"));

		String linhaDisciplina = buffReadDisciplina.readLine();

		Integer count = pegaNumeroDeLinhas("Disciplina");

		Integer aux = 0;
		Disciplina[] disciplinas = new Disciplina[count];
		while (true) {

			if (linhaDisciplina != null) {
				Disciplina disciplina = new Disciplina();
				String segments[] = linhaDisciplina.split(";");

				disciplina.setId(Long.parseLong(segments[0]));
				disciplina.setNome(segments[1]);
				disciplina.setMateria(pegaMateria(Integer.parseInt(segments[2])));
				disciplinas[aux] = disciplina;
				aux++;

			} else
				break;
			linhaDisciplina = buffReadDisciplina.readLine();
		}
		buffReadDisciplina.close();

		return disciplinas;
	}

	// retorna todas as disciplinas vinculadas a uma materia
	public Disciplina[] pegarDisciplinaPorMateria(Integer idMateria) throws IOException {
		BufferedReader buffReadDisciplina = new BufferedReader(new FileReader("files/Disciplina.txt"));

		String linhaDisciplina = buffReadDisciplina.readLine();

		Integer count = pegaNumeroDeDiscpPorIdMateria(idMateria);

		Integer aux = 0;
		Disciplina[] disciplinas = new Disciplina[count];
		while (true) {

			if (linhaDisciplina != null) {

				String segments[] = linhaDisciplina.split(";");

				if (segments[2].equals(idMateria.toString())) {
					Disciplina disciplina = new Disciplina();
					disciplina.setId(Long.parseLong(segments[0]));
					disciplina.setNome(segments[1]);
					disciplina.setMateria(pegaMateria(Integer.parseInt(segments[2])));
					disciplinas[aux] = disciplina;
					aux++;
					System.out.println(disciplina);
				}

			} else
				break;
			linhaDisciplina = buffReadDisciplina.readLine();
		}
		buffReadDisciplina.close();

		return disciplinas;
	}

	// Adiciona materia no arquivo txt
	public void insereMateria(Materia materia) throws IOException {
		String nomeArquivo = "Materia.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + materia.getNome() + ";\n";
		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

	}

	// Adiciona disciplina no arquivo txt
	public void insereDisciplina(Disciplina disciplina) throws IOException {
		String nomeArquivo = "Disciplina.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + disciplina.getNome() + ";"
				+ disciplina.getMateria().getId() + ";\n";
		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();
	}

	// Adiciona aluno no arquivo txt
	public void insereAluno(Aluno aluno) throws IOException {
		String nomeArquivo = "Aluno.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + aluno.getNome() + ";" + aluno.getCpf() + ";"
				+ aluno.getEmail() + ";" + aluno.getSenha() + ";" + aluno.getTelefone() + ";" + aluno.getSexo() + "\n";
		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

	}

	// Adiciona questao no arquivo txt
	public void insereQuestao(Questao questao) throws IOException {
		String nomeArquivo = "Questao.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + questao.getStatus() + ";" + questao.getTipo() + ";"
				+ questao.getDissetacao() + ";" + questao.getContador() + ";" + questao.getDificuldade() + ";"
				+ questao.getDisciplina().getId() + "\n";
		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

	}

	// Adiciona alternativa no arquivo txt
	public void insereAlternativa(Alternativa alternativa) throws IOException {
		String nomeArquivo = "Alternativa.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + alternativa.getAlternativa() + ";"
				+ alternativa.getCorreta() + ";" + alternativa.getQuestao().getId() + "\n";

		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

	}

	// retorna todas as questoes gravadas
	public Questao[] pegaTodasQuestoes() throws IOException {

		String nomeArquivo = "Questao";
		BufferedReader buffReadProvaQ = new BufferedReader(new FileReader("files/" + nomeArquivo + ".txt"));
		String linhaProvaQuestao = buffReadProvaQ.readLine();
		Integer numQuestoes = pegaNumeroDeLinhas(nomeArquivo);
		String[] ids = new String[numQuestoes];
		int count = 0;
		while (true) {

			if (linhaProvaQuestao != null) {

				String segments[] = linhaProvaQuestao.split(";");
				ids[count] = segments[0];
				count++;
			} else
				break;
			linhaProvaQuestao = buffReadProvaQ.readLine();
		}
		buffReadProvaQ.close();

		Questao[] questoes = new Questao[numQuestoes];
		for (int i = 0; i < ids.length; i++) {
			questoes[i] = pegaQuestao(Integer.parseInt(ids[i]));
		}

		return questoes;
	}

	// retorna numero de questoes vinculadas a uma materia
	public Integer pegaNumeroDeQuestoesPorDisciplina(Integer idDisciplina) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader("files/Questao.txt"));
		String linha = buffRead.readLine();

		Integer count = 0;

		while (true) {

			if (linha != null) {

				String segments[] = linha.split(";");

				if (Integer.parseInt(segments[6]) == idDisciplina) {
					count++;

				}

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();

		return count;

	}

	public Questao[] pegarQuestoesPorMateria(Integer idDisciplina) throws IOException {

		Integer quantQuestoesEncontradas = pegaNumeroDeQuestoesPorDisciplina(idDisciplina);

		Questao[] todasQ = pegaTodasQuestoes();
		Questao[] questoesMateria = new Questao[quantQuestoesEncontradas];

		Integer count = 0;
		for (Questao questao : todasQ) {
			if (questao.getDisciplina().getId() != null && questao.getDisciplina().getId() == (long) idDisciplina) {
				questoesMateria[count] = questao;
				count++;
			}
		}
		return questoesMateria;
	}

	public Integer[] gerarListaAleatoria(Integer tamanhoLista) {

		Integer[] lista = new Integer[tamanhoLista];
		int find = 0;
		int c, i = 0;
		int[] num = new int[tamanhoLista];
		Random r = new Random();

		// contruindo o array sem repetição
		for (i = 0; i < num.length; i++) {
			find = r.nextInt(tamanhoLista) + 1;
			if (i == 0) {
				num[i] = find;
			} else {
				c = 0;
				while (c < i) {
					if (num[c] == find) {
						find = r.nextInt(tamanhoLista) + 1;
						c = 0;
					} else {
						c++;
					}
				}
				num[i] = find;
			}
		}

		for (i = 0; i < num.length; i++) {
			lista[i] = num[i] - 1;
		}

		return lista;
	}

	public Prova gerarProva(Prova prova, Integer idDisciplina, Integer quantQuestoes) throws IOException {

		String nomeArquivo = "Prova.txt";
		File arq = new File("files/", nomeArquivo);
		Integer id = retornarIdValido(nomeArquivo);

		String conteudo = id + ";" + prova.getData() + "; " + prova.getNota() + ";" + prova.getAluno().getId() + "\n";

		Questao[] questoesMaterias = pegarQuestoesPorMateria(idDisciplina);

		if (quantQuestoes > questoesMaterias.length) {
			// TODO erro
			System.out.println("erro");
		}
		for (Questao questao : questoesMaterias) {
			System.out.println("teste 1");
			System.out.println(questao);
		}

		Integer[] ordemAleatoria = gerarListaAleatoria(questoesMaterias.length);

		Questao[] questoesSelecionadas = new Questao[quantQuestoes];

		for (int i = 0; i < questoesSelecionadas.length; i++) {

			ProvaQuestao provaQuestao = new ProvaQuestao();
			provaQuestao.setIdQuestao(questoesMaterias[ordemAleatoria[i]].getId());
			provaQuestao.setIdProva((long) id);
			insereProvaQuestao(provaQuestao);
		}

		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

		return null;
	}

	// Adiciona vinculacao entra prova e questao;
	public void insereProvaQuestao(ProvaQuestao provaQuestao) throws IOException {
		String nomeArquivo = "ProvaQuestao.txt";
		File arq = new File("files/", nomeArquivo);

		String conteudo = retornarIdValido(nomeArquivo) + ";" + provaQuestao.getIdQuestao() + ";"
				+ provaQuestao.getIdProva() + "\n";

		FileWriter writer = new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);

		print.write(conteudo);
		print.flush();
		print.close();
		writer.close();

	}

	public Prova corrigirProva(Integer nota, Integer idProva) {

		String arquivo = "ARQUIVO";
		String arquivoTmp = "ARQUIVO-tmp";

		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		String linha;
		String segments[] = linha.split(";");
		/*
		 * if (Integer.parseInt(segments[0]) == idPRova) { while ((linha =
		 * reader.readLine()) != null) { if (linha.contains(palavraAntiga)) { linha =
		 * linha.replace(palavraAntiga, palavraNova); } writer.write(linha + "\n"); }
		 * 
		 * } writer.close(); reader.close();
		 * 
		 * new File(arquivo).delete(); new File(arquivoTmp).renameTo(new File(arquivo));
		 * }
		 */
	}

	public int retornarIdValido(String arq) {

		String ultimo = "";
		try {
			InputStream is = new FileInputStream("files/" + arq);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (ultimo == "") {
			return 1;
		}
		String segments[] = ultimo.split(";");
		return Integer.parseInt(segments[0]) + 1;
	}
}
