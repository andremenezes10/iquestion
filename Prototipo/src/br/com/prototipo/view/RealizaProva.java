package br.com.prototipo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.com.prototipo.domain.Aluno;
import br.com.prototipo.domain.dto.AlternativaDTO;
import br.com.prototipo.domain.dto.ProvaDTO;
import br.com.prototipo.domain.dto.QuestaoDTO;
import br.com.prototipo.util.ManipuladorArquivo;

public class RealizaProva extends JFrame {

	private JPanel contentPane;
	private boolean isLast;
	private Aluno aluno;
		

	public RealizaProva(ProvaDTO prova, int posicao, int acertos, Aluno aluno) {
		
		this.aluno = aluno;
		if (prova.getQuestoes().length - 1 == posicao) {
			isLast = true;
		}
		QuestaoDTO[] questoes = prova.getQuestoes();
		for (QuestaoDTO questaoDTO : questoes) {
			System.out.println(questaoDTO);
		}
		QuestaoDTO questao = questoes[posicao];
		setTitle("RealizaProva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnunciado = new JLabel();
		lblEnunciado.setText(questao.getDissetacao());
		lblEnunciado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnunciado.setBounds(30, 50, 300, 50);
		contentPane.add(lblEnunciado);

		JLabel lbl1 = new JLabel("1)");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl1.setBounds(30, 222, 46, 14);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("2)");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBounds(30, 247, 46, 14);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("3)");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl3.setBounds(30, 272, 46, 14);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("4)");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl4.setBounds(30, 297, 46, 14);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("5)");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl5.setBounds(30, 322, 46, 14);
		contentPane.add(lbl5);

		ButtonGroup group = new ButtonGroup();

		JRadioButton radioAlternativa1 = new JRadioButton("");
		radioAlternativa1.setBounds(10, 218, 20, 23);
		contentPane.add(radioAlternativa1);
		group.add(radioAlternativa1);

		JRadioButton radioAlternativa2 = new JRadioButton("");
		radioAlternativa2.setBounds(10, 243, 20, 23);
		contentPane.add(radioAlternativa2);
		group.add(radioAlternativa2);

		JRadioButton radioAlternativa3 = new JRadioButton("");
		radioAlternativa3.setBounds(10, 268, 20, 23);
		contentPane.add(radioAlternativa3);
		group.add(radioAlternativa3);

		JRadioButton radioAlternativa4 = new JRadioButton("");
		radioAlternativa4.setBounds(10, 293, 20, 23);
		contentPane.add(radioAlternativa4);
		group.add(radioAlternativa4);

		JRadioButton radioAlternativa5 = new JRadioButton("");
		radioAlternativa5.setBounds(10, 318, 20, 23);
		contentPane.add(radioAlternativa5);
		group.add(radioAlternativa5);

		AlternativaDTO[] alternativas = questao.getAlternativas();

		JLabel alternativa1 = new JLabel(alternativas[0].getAlternativa());
		alternativa1.setFont(new Font("Tahoma", Font.BOLD, 11));
		alternativa1.setBounds(50, 222, 380, 14);
		contentPane.add(alternativa1);

		JLabel alternativa2 = new JLabel(alternativas[1].getAlternativa());
		alternativa2.setFont(new Font("Tahoma", Font.BOLD, 11));
		alternativa2.setBounds(50, 247, 380, 14);
		contentPane.add(alternativa2);

		JLabel alternativa3 = new JLabel(alternativas[2].getAlternativa());
		alternativa3.setFont(new Font("Tahoma", Font.BOLD, 11));
		alternativa3.setBounds(50, 272, 380, 14);
		contentPane.add(alternativa3);

		JLabel alternativa4 = new JLabel(alternativas[3].getAlternativa());
		alternativa4.setFont(new Font("Tahoma", Font.BOLD, 11));
		alternativa4.setBounds(50, 297, 380, 14);
		contentPane.add(alternativa4);

		JLabel alternativa5 = new JLabel(alternativas[4].getAlternativa());
		alternativa5.setFont(new Font("Tahoma", Font.BOLD, 11));
		alternativa5.setBounds(50, 322, 380, 14);
		contentPane.add(alternativa5);
		JButton btnNewButton = new JButton("Proxima");
		btnNewButton.setBounds(331, 350, 123, 23);
		if (isLast == true) {
			btnNewButton.setText("Finalizar");
		}
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!radioAlternativa1.isSelected() && !radioAlternativa2.isSelected()
						&& !radioAlternativa3.isSelected() && !radioAlternativa4.isSelected()
						&& !radioAlternativa5.isSelected()) {
					JOptionPane.showMessageDialog(null, "Selecione uma alternativa");
				} else {
					Boolean acertou = false;
					if (radioAlternativa1.isSelected()) {
						acertou = alternativas[0].getCorreta();
					}
					if (radioAlternativa2.isSelected()) {
						acertou = alternativas[1].getCorreta();
					}

					if (radioAlternativa3.isSelected()) {
						acertou = alternativas[2].getCorreta();
					}

					if (radioAlternativa4.isSelected()) {
						acertou = alternativas[3].getCorreta();
					}

					if (radioAlternativa5.isSelected()) {
						acertou = alternativas[4].getCorreta();
					}
					ManipuladorArquivo manipula = new ManipuladorArquivo();
					if (isLast == true) {
						if (acertou == true) {
							Double nota = calcNota(acertos + 1, questoes.length);
							try {
								manipula.corrigirProva(nota, (int) (long) prova.getId());
								JOptionPane.showMessageDialog(null, "Você finalizou a prova e acertou " + (acertos + 1)
										+ " questoẽs\n Nota final: " + calcNota(acertos + 1, questoes.length));
								new TelaDeRanking(aluno).setVisible(true);
								CloseFrame();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else {
							Double nota = calcNota(acertos, questoes.length);
							try {
								manipula.corrigirProva(nota, (int) (long) prova.getId());
								JOptionPane.showMessageDialog(null, "Você finalizou a prova e acertou " + acertos
										+ " questoẽs\n Nota final: " + calcNota(acertos, questoes.length));
								new TelaDeRanking(aluno).setVisible(true);
								CloseFrame();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					} else {

						if (acertou == true) {
							new RealizaProva(prova, posicao + 1, acertos + 1,aluno).setVisible(true);
							;
						} else {

							new RealizaProva(prova, posicao + 1, acertos, aluno).setVisible(true);
						}
						CloseFrame();

					}
				}
			}
		});

	}

	public Double calcNota(Integer acertos, Integer quantidadeQuestoes) {
		Double notaFinal = (10.0 / quantidadeQuestoes) * acertos;

		return notaFinal;
	}

	public void CloseFrame() {
		super.dispose();
	}

}
