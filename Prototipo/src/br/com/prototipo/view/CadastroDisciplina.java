package br.com.prototipo.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
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
import br.com.prototipo.util.ManipuladorArquivo;

public class CadastroDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Materia[] materias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDisciplina frame = new CadastroDisciplina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroDisciplina() {
		ManipuladorArquivo manipula = new ManipuladorArquivo();
		try {
			materias = manipula.pegarTodasMaterias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possivel recuperar matérias");
			e.printStackTrace();
		}
		setTitle("Cadastro de Disciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 109, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Nome da Disciplina:");
		lblNewLabel.setBounds(80, 70, 141, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(80, 90, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		for (Materia materia : materias) {
			comboBox.addItem(materia.getNome());
		}
		comboBox.setBounds(80, 160, 141, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Matéria:");
		lblNewLabel_1.setBounds(80, 140, 80, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(157, 220, 112, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textField.getText() == null || textField.getText().isEmpty())
						|| (comboBox.getSelectedIndex() == -1)) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					for (Materia materia : materias) {
						if (materia.getNome() == comboBox.getSelectedItem().toString()) {
							Disciplina disciplina = new Disciplina();
							disciplina.setMateria(materia);
							disciplina.setNome(textField.getText());

							try {
								manipula.insereDisciplina(disciplina);
								JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso.");
								CloseFrame();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Erro. Revise os dados e tente novamente");
								e1.printStackTrace();

							}
						}
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
