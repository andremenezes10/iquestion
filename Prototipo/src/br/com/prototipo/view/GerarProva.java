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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.Disciplina;
import br.com.prototipo.domain.Materia;
import br.com.prototipo.domain.Prova;
import br.com.prototipo.domain.dto.ProvaDTO;
import br.com.prototipo.util.ManipuladorArquivo;

public class GerarProva extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQuantidade;
	private Materia[] materias;
	private Disciplina[] disciplinas;
	private Aluno aluno;

	public GerarProva(Aluno aluno) {
		this.aluno = aluno;
		ManipuladorArquivo manipula = new ManipuladorArquivo();
		try {
			materias = manipula.pegarTodasMaterias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Gerar Prova");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 109, 23);
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

		JLabel lblQuantidade = new JLabel("Numero de questões");
		lblQuantidade.setBounds(25, 140, 160, 16);
		contentPane.add(lblQuantidade);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(198, 140, 225, 26);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);

		JButton btnNewButton = new JButton("Gerar Prova");
		btnNewButton.setBounds(167, 214, 117, 29);
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
				if ((textFieldQuantidade.getText() == null || textFieldQuantidade.getText().isEmpty())
						|| (comboBox_materia.getSelectedIndex() == -1) || (comboBox_materia.getSelectedIndex() == -1)) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					
					Prova prova = new Prova();
					prova.setData("25/06/2020");
					prova.setNota(null);
					prova.setAluno(aluno);

					Long idDisciplina = null;
					for (Disciplina disciplina : disciplinas) {
						if (disciplina.getNome().equals(comboBox_disciplina.getSelectedItem().toString())) {
							idDisciplina = disciplina.getId();
						}
					}

					try {
					Prova provaCriada = manipula.gerarProva(prova, (int) (long) idDisciplina,
								Integer.parseInt(textFieldQuantidade.getText()));
					ProvaDTO provaDTO = manipula.pegaProva((int) (long)prova.getId());
					CloseFrame();
					new RealizaProva(provaDTO, 0, 0, aluno).setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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