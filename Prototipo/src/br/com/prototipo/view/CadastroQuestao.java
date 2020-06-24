package br.com.prototipo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CadastroQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuestao frame = new CadastroQuestao();
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
	public CadastroQuestao() {
		setTitle("Cadastro de Quest\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enunciado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 50, 80, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 50, 258, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Status:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(312, 12, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ativada", "Desativada"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(368, 9, 86, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Dificuldade:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 121, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Disciplina:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 146, 80, 20);
		contentPane.add(lblNewLabel_4);
		
		JComboBox<?> comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Algoritmo", "Administra\u00E7\u00E3o"}));
		comboBox_1.setBounds(100, 146, 163, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Contador:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(100, 12, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 11, 56, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("segundos");
		lblNewLabel_6.setBounds(235, 12, 56, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 177, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Dissertativa", "Objetiva"}));
		comboBox_2.setBounds(100, 177, 162, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Baixa", "M\u00E9dia", "Alta"}));
		comboBox_3.setBounds(100, 118, 162, 20);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(331, 183, 123, 23);
		contentPane.add(btnNewButton);
	}
}
