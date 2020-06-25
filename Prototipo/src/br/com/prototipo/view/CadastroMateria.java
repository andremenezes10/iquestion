package br.com.prototipo.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Materia;
import br.com.prototipo.util.ManipuladorArquivo;

public class CadastroMateria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMateria frame = new CadastroMateria();
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
	public CadastroMateria() {
		setTitle("Cadastro de Materia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 109, 23);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("Materia");
		lblNewLabel.setBounds(20, 119, 61, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(93, 114, 325, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(167, 201, 117, 29);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() == null || textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					Materia materia = new Materia();
					materia.setNome(textField.getText());

					ManipuladorArquivo manipula = new ManipuladorArquivo();
					try {
						manipula.insereMateria(materia);
						JOptionPane.showMessageDialog(null, "Materia cadastrada com sucesso.");
						CloseFrame();
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro. Revise os dados e tente novamente");
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