package br.com.prototipo.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Admin;
import br.com.prototipo.domain.Aluno;
import br.com.prototipo.util.ManipuladorArquivo;

public class TelaDeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
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
	public TelaDeLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Email/CPF");
		lblLogin.setBounds(75, 62, 69, 16);
		contentPane.add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(156, 57, 212, 26);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(75, 100, 69, 16);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(156, 95, 212, 26);
		contentPane.add(passwordField);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar Senha");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('●');
				}
			}
		});
		chckbxNewCheckBox.setBounds(156, 121, 128, 23);
		contentPane.add(chckbxNewCheckBox);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(75, 172, 136, 29);
		contentPane.add(btnCadastrar);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(223, 172, 145, 29);
		contentPane.add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(passwordField.getPassword());
				if ((textFieldLogin.getText() == null || textFieldLogin.getText().isEmpty())
						|| (password == null || password.isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {

					ManipuladorArquivo manipula = new ManipuladorArquivo();

					try {
						Admin admin = manipula.loginAdmin(textFieldLogin.getText(), password);
						Aluno aluno = new Aluno();

						if (admin.getId() == null) {
							aluno = manipula.loginAluno(textFieldLogin.getText(), password);
							if (aluno.getId() != null) {
		
								CloseFrame();
								new MenuAluno(aluno).setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Erro. Revise os dados e tente novamente");
							}
						} else {
							CloseFrame();
							new MenuAdmin().setVisible(true);
						}

					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro. Revise os dados e tente novamente");
					}

				}
			}
		});
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new CadastroAluno().setVisible(true);
			}
		});
	}

	public void CloseFrame() {
		super.dispose();
	}

}