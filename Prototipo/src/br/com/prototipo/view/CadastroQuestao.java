package br.com.prototipo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Alternativa;
import br.com.prototipo.domain.Disciplina;
import br.com.prototipo.domain.Materia;
import br.com.prototipo.domain.Questao;
import br.com.prototipo.util.ManipuladorArquivo;

public class CadastroQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEnunciado;
	private Materia[] materias;
	private Disciplina[] disciplinas;
	private JTextField textAlternativa1;
	private JTextField textAlternativa2;
	private JTextField textAlternativa3;
	private JTextField textAlternativa4;
	private JTextField textAlternativa5;


	public CadastroQuestao() {
		ManipuladorArquivo manipula = new ManipuladorArquivo();
		try {
			materias = manipula.pegarTodasMaterias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Cadastro de Questões");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 109, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnunciado.setBounds(10, 60, 80, 14);
		contentPane.add(lblEnunciado);

		textFieldEnunciado = new JTextField();
		textFieldEnunciado.setBounds(100, 60, 258, 55);
		contentPane.add(textFieldEnunciado);
		textFieldEnunciado.setColumns(10);

		JLabel lblDificuldade = new JLabel("Dificuldade:");
		lblDificuldade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDificuldade.setBounds(10, 130, 80, 14);
		contentPane.add(lblDificuldade);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 160, 80, 20);
		contentPane.add(lblTipo);

		JLabel lblMateria = new JLabel("Matéria:");
		lblMateria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMateria.setBounds(10, 190, 70, 14);
		contentPane.add(lblMateria);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplina.setBounds(10, 220, 70, 14);
		contentPane.add(lblDisciplina);

		JComboBox comboBox_dificuldade = new JComboBox();
		comboBox_dificuldade.setModel(new DefaultComboBoxModel(new String[] { "Baixa", "M\u00E9dia", "Alta" }));
		comboBox_dificuldade.setBounds(100, 130, 162, 20);
		contentPane.add(comboBox_dificuldade);

		JComboBox comboBox_tipo = new JComboBox();
		comboBox_tipo.setModel(new DefaultComboBoxModel(new String[] { "Objetiva" }));
		comboBox_tipo.setBounds(100, 160, 163, 20);
		contentPane.add(comboBox_tipo);

		JComboBox comboBox_materia = new JComboBox();
		comboBox_materia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_materia.setBounds(100, 190, 162, 20);

		for (Materia materia : materias) {
			comboBox_materia.addItem(materia.getNome());
		}
		contentPane.add(comboBox_materia);

		JComboBox comboBox_disciplina = new JComboBox();
		comboBox_disciplina.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_disciplina.setBounds(100, 220, 162, 20);
		contentPane.add(comboBox_disciplina);

		JLabel lbl1 = new JLabel("1)");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl1.setBounds(10, 272, 46, 14);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("2)");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBounds(10, 297, 46, 14);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("3)");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl3.setBounds(10, 322, 46, 14);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("4)");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl4.setBounds(10, 347, 46, 14);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("5)");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl5.setBounds(10, 372, 46, 14);
		contentPane.add(lbl5);

		textAlternativa1 = new JTextField();
		textAlternativa1.setBounds(33, 272, 325, 20);
		contentPane.add(textAlternativa1);
		textAlternativa1.setColumns(10);

		textAlternativa2 = new JTextField();
		textAlternativa2.setColumns(10);
		textAlternativa2.setBounds(33, 297, 325, 20);
		contentPane.add(textAlternativa2);

		textAlternativa3 = new JTextField();
		textAlternativa3.setColumns(10);
		textAlternativa3.setBounds(33, 322, 325, 20);
		contentPane.add(textAlternativa3);

		textAlternativa4 = new JTextField();
		textAlternativa4.setColumns(10);
		textAlternativa4.setBounds(33, 347, 325, 20);
		contentPane.add(textAlternativa4);

		textAlternativa5 = new JTextField();
		textAlternativa5.setColumns(10);
		textAlternativa5.setBounds(33, 372, 325, 20);
		contentPane.add(textAlternativa5);

		ButtonGroup group = new ButtonGroup();

		JRadioButton radioAlternativa1 = new JRadioButton("");
		radioAlternativa1.setBounds(368, 272, 56, 23);
		contentPane.add(radioAlternativa1);
		group.add(radioAlternativa1);

		JRadioButton radioAlternativa2 = new JRadioButton("");
		radioAlternativa2.setBounds(368, 297, 56, 23);
		contentPane.add(radioAlternativa2);
		group.add(radioAlternativa2);

		JRadioButton radioAlternativa3 = new JRadioButton("");
		radioAlternativa3.setBounds(368, 322, 56, 23);
		contentPane.add(radioAlternativa3);
		group.add(radioAlternativa3);

		JRadioButton radioAlternativa4 = new JRadioButton("");
		radioAlternativa4.setBounds(368, 347, 56, 23);
		contentPane.add(radioAlternativa4);
		group.add(radioAlternativa4);

		JRadioButton radioAlternativa5 = new JRadioButton("");
		radioAlternativa5.setBounds(368, 372, 56, 23);
		contentPane.add(radioAlternativa5);
		group.add(radioAlternativa5);

		JLabel lblCorreta = new JLabel("Correta:");
		lblCorreta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreta.setBounds(368, 245, 86, 14);
		contentPane.add(lblCorreta);

		JLabel lblAlternativa = new JLabel("Alternativa:");
		lblAlternativa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlternativa.setBounds(30, 245, 86, 14);
		contentPane.add(lblAlternativa);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(331, 400, 123, 23);
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
				if ((textFieldEnunciado.getText() == null || textFieldEnunciado.getText().isEmpty())
						|| (comboBox_dificuldade.getSelectedIndex() == -1) || (comboBox_tipo.getSelectedIndex() == -1)
						|| (comboBox_materia.getSelectedIndex() == -1) || (comboBox_disciplina.getSelectedIndex() == -1)
						|| (textAlternativa1.getText() == null || textAlternativa1.getText().isEmpty())
						|| (textAlternativa1.getText() == null || textAlternativa1.getText().isEmpty())
						|| (textAlternativa1.getText() == null || textAlternativa1.getText().isEmpty())
						|| (textAlternativa1.getText() == null || textAlternativa1.getText().isEmpty())
						|| (textAlternativa1.getText() == null || textAlternativa1.getText().isEmpty())
						|| (!radioAlternativa1.isSelected() && !radioAlternativa2.isSelected()
								&& !radioAlternativa3.isSelected() && !radioAlternativa4.isSelected()
								&& !radioAlternativa5.isSelected())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					Questao questao = new Questao();

					questao.setContador(0);
					questao.setStatus(true);
					questao.setDissetacao(textFieldEnunciado.getText());
					questao.setTipo(comboBox_tipo.getSelectedItem().toString());
					questao.setDificuldade(comboBox_dificuldade.getSelectedIndex() + 1);
					for (Disciplina disciplina : disciplinas) {
						if (disciplina.getNome().equals(comboBox_disciplina.getSelectedItem().toString())) {
							questao.setDisciplina(disciplina);
						}
					}
					Questao questaoInserida = new Questao();
					try {
						questaoInserida = manipula.insereQuestao(questao);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Não foi possivel adicionar questão");
						e1.printStackTrace();
					}

					Alternativa alternativa1 = new Alternativa();
					alternativa1.setAlternativa(textAlternativa1.getText());
					if (radioAlternativa1.isSelected()) {
						alternativa1.setCorreta(true);
					} else {
						alternativa1.setCorreta(false);
					}
					alternativa1.setQuestao(questaoInserida);
					
					Alternativa alternativa2 = new Alternativa();
					alternativa2.setAlternativa(textAlternativa2.getText());
					if (radioAlternativa2.isSelected()) {
						alternativa2.setCorreta(true);
					} else {
						alternativa2.setCorreta(false);
					}
					
					alternativa2.setQuestao(questaoInserida);
					Alternativa alternativa3 = new Alternativa();
					alternativa3.setAlternativa(textAlternativa3.getText());
					if (radioAlternativa3.isSelected()) {
						alternativa3.setCorreta(true);
					} else {
						alternativa3.setCorreta(false);
					}
					alternativa3.setQuestao(questaoInserida);
					
					Alternativa alternativa4 = new Alternativa();
					alternativa4.setAlternativa(textAlternativa4.getText());
					if (radioAlternativa4.isSelected()) {
						alternativa4.setCorreta(true);
					} else {
						alternativa4.setCorreta(false);
					}
					alternativa4.setQuestao(questaoInserida);
					
					Alternativa alternativa5 = new Alternativa();
					alternativa5.setAlternativa(textAlternativa5.getText());
					if (radioAlternativa5.isSelected()) {
						alternativa5.setCorreta(true);
					} else {
						alternativa5.setCorreta(false);
					}
					alternativa5.setQuestao(questaoInserida);
				
					try {
						manipula.insereAlternativa(alternativa1);
						manipula.insereAlternativa(alternativa2);
						manipula.insereAlternativa(alternativa3);
						manipula.insereAlternativa(alternativa4);
						manipula.insereAlternativa(alternativa5);
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						CloseFrame();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Não foi possivel adicionar alternativa");
						e1.printStackTrace();
					}

				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				
			}
		});
		
		
	}
	public void CloseFrame() {
		super.dispose();
		new MenuAdmin().setVisible(true);
	}
}
