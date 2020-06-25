package br.com.prototipo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Aluno;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAluno extends JFrame {

	private JPanel contentPane;
	private Aluno aluno;

	public MenuAluno(Aluno aluno) {
		this.aluno = aluno;
		setTitle("Menu Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 10, 109, 23);
		contentPane.add(btnVoltar);

		JButton btnProva = new JButton("Prova");
		btnProva.setBounds(170, 60, 109, 23);
		contentPane.add(btnProva);

		JButton btnRanking = new JButton("Ranking");
		btnRanking.setBounds(170, 120, 109, 23);
		contentPane.add(btnRanking);

		btnProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new GerarProva(aluno).setVisible(true);
			}
		});

		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				 new TelaDeRanking(aluno).setVisible(true);
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				new TelaDeLogin().setVisible(true);

			}
		});
	}

	public void CloseFrame() {
		super.dispose();
	}
}