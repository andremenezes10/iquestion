package br.com.prototipo.util;

import br.com.prototipo.domain.Alternativa;
import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.Disciplina;
import br.com.prototipo.domain.Materia;
import br.com.prototipo.domain.Prova;
import br.com.prototipo.domain.Questao;
import br.com.prototipo.domain.dto.AlternativaDTO;
import br.com.prototipo.domain.dto.AlunoDTO;
import br.com.prototipo.domain.dto.DisciplinaDTO;
import br.com.prototipo.domain.dto.MateriaDTO;
import br.com.prototipo.domain.dto.ProvaDTO;
import br.com.prototipo.domain.dto.QuestaoDTO;

public class Conversor {

	public AlternativaDTO alternativaConverter(Alternativa alternativa) {

		AlternativaDTO alternativaDTO = new AlternativaDTO();
		alternativaDTO.setId(alternativa.getId());
		alternativaDTO.setAlternativa(alternativa.getAlternativa());
		alternativaDTO.setCorreta(alternativa.getCorreta());

		return alternativaDTO;
	}

	public MateriaDTO materiaConverter(Materia materia) {

		MateriaDTO materiaDTO = new MateriaDTO();
		materiaDTO.setId(materia.getId());
		materiaDTO.setNome(materia.getNome());

		return materiaDTO;
	}

	public DisciplinaDTO disciplinaConverter(Disciplina disciplina) {

		DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
		disciplinaDTO.setId(disciplina.getId());
		disciplinaDTO.setNome(disciplina.getNome());
		disciplinaDTO.setMateria(materiaConverter(disciplina.getMateria()));

		return disciplinaDTO;
	}

	public QuestaoDTO questaoConverter(Questao questao, Alternativa alternativas[]) {
		QuestaoDTO questaoDTO = new QuestaoDTO();

		questaoDTO.setId(questao.getId());
		questaoDTO.setContador(questao.getContador());
		questaoDTO.setDificuldade(questao.getDificuldade());
		questaoDTO.setDisciplina(disciplinaConverter(questao.getDisciplina()));
		questaoDTO.setDissetacao(questao.getDissetacao());
		questaoDTO.setStatus(questao.getStatus());
		questaoDTO.setTipo(questao.getTipo());

		AlternativaDTO[] alternativasDTO = new AlternativaDTO[5];
		Integer count = 0;
		for (Alternativa alternativa : alternativas) {
			alternativasDTO[count] = alternativaConverter(alternativa);
			count ++;
		}
		questaoDTO.setAlternativas(alternativasDTO);

		return questaoDTO;
	}

	public AlunoDTO alunoConverter(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setId(aluno.getId());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setEmail(aluno.getEmail());
		alunoDTO.setSexo(aluno.getSexo());
		alunoDTO.setCpf(aluno.getCpf());
		alunoDTO.setTelefone(aluno.getTelefone());
		alunoDTO.setSenha(aluno.getSenha());

		return alunoDTO;
	}

	public ProvaDTO provaConverter(Prova prova, QuestaoDTO questoes[]) {

		ProvaDTO provaDTO = new ProvaDTO();

		provaDTO.setId(prova.getId());
		provaDTO.setData(prova.getData());
		provaDTO.setNota(prova.getNota());
		provaDTO.setAluno(alunoConverter(prova.getAluno()));
		provaDTO.setQuestoes(questoes);

		return provaDTO;
	}
	public ProvaDTO provaSimplesConverter(Prova prova) {

		ProvaDTO provaDTO = new ProvaDTO();

		provaDTO.setId(prova.getId());
		provaDTO.setData(prova.getData());
		provaDTO.setNota(prova.getNota());
		provaDTO.setAluno(alunoConverter(prova.getAluno()));
		return provaDTO;
	}
}
