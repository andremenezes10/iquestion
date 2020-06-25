package br.com.prototipo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.Disciplina;
import br.com.prototipo.domain.Materia;
import br.com.prototipo.util.ListaEncadeadaProva;
import br.com.prototipo.util.ManipuladorArquivo;

public class TelaDeRanking extends JFrame {

	private JPanel contentPane;
	private Materia[] materias;
	private Disciplina[] disciplinas;
	private Aluno aluno;

	public TelaDeRanking(Aluno aluno) {
		this.aluno = aluno;
		ManipuladorArquivo manipula = new ManipuladorArquivo();
		try {
			materias = manipula.pegarTodasMaterias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Tela de Ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 5, 105, 15);
		contentPane.add(btnVoltar);
		
		JComboBox comboBox_disciplina = new JComboBox();
		comboBox_disciplina.setBounds(198, 93, 225, 27);
		contentPane.add(comboBox_disciplina);

		JLabel lblDisciplina = new JLabel("Escolha uma Disciplina");
		lblDisciplina.setBounds(24, 97, 162, 16);
		contentPane.add(lblDisciplina);

		JLabel lblMateria = new JLabel("Escolha uma Matéria");
		lblMateria.setBounds(24, 47, 162, 16);
		contentPane.add(lblMateria);

		JComboBox comboBox_materia = new JComboBox();
		comboBox_materia.setBounds(198, 43, 225, 27);
		for (Materia materia : materias) {
			comboBox_materia.addItem(materia.getNome());
		}
		contentPane.add(comboBox_materia);

		JButton btnNewButton = new JButton("Mostrar ranking");
		btnNewButton.setBounds(130, 214, 200, 29);
		contentPane.add(btnNewButton);

		comboBox_materia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				for (Materia materia : materias) {
					if (materia.getNome().equals(comboBox_materia.getSelectedItem().toString())) {
						try {
							disciplinas = manipula.pegarDisciplinaPorMateria((int) (long) materia.getId());
							comboBox_disciplina.removeAllItems();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Erro. Não foi possivel carregar disciplinas");
							e.printStackTrace();
						}
						for (Disciplina disciplina : disciplinas) {

							comboBox_disciplina.addItem(disciplina.getNome());
						}
					}
				}

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBox_materia.getSelectedIndex() == -1) || (comboBox_materia.getSelectedIndex() == -1)) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					System.out.println("entrou");
					Long idDisciplina = null;
					for (Disciplina disciplina : disciplinas) {
						if (disciplina.getNome().equals(comboBox_disciplina.getSelectedItem().toString())) {
							idDisciplina = disciplina.getId();
						}
					}

					ListaEncadeadaProva provas = new ListaEncadeadaProva();

					
						try {
							provas = manipula.ranking((int) (long) idDisciplina);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				
					if (provas.size() > 10) {
						for (int i = 1; i < 10; i++) {
							String conteudo = i + "° " + provas.show(i).getAluno().getNome() + " - nota: "
									+ provas.show(i).getNota();
							System.out.println(conteudo);
							JLabel ranking = new JLabel(conteudo);
							ranking.setBounds(24, 47, 162, 16);
							contentPane.add(ranking);
						}
					} else if (provas.size() > 1) {
						for (int i = 1; i < provas.size(); i++) {
							String conteudo = i + "° " + provas.show(i).getAluno().getNome() + " - nota: "
									+ provas.show(i).getNota();
							System.out.println(conteudo);
							JLabel ranking = new JLabel(conteudo);
							ranking.setBounds(24, 47, 162, 16);
							contentPane.add(ranking);

						}
						
					}else{
						for (int i = 1; i <= provas.size(); i++) {
							String conteudo = i + "° " + provas.show(i).getAluno().getNome() + " - nota: "
									+ provas.show(i).getNota();
							System.out.println(conteudo);
							JLabel ranking = new JLabel(conteudo);
							ranking.setBounds(24, 47, 162, 16);
							contentPane.add(ranking);
						}
					}

				}

			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new MenuAluno(aluno).setVisible(true);
			}
		});
	}

	public void CloseFrame() {
		super.dispose();
	}
}