package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Calculo;
import controle.Pessoa;

public class TelaCalculoInicio extends JInternalFrame {
	Frame telaInicial;
	JInternalFrame atual = null, anterior = null;

	private JTextField txtCodigo;
	// private String caminhoCalculo =
	// "C:\\CalculoTrabalhista\\Calculos\\calculo.txt";
	Pessoa pessoa = new Pessoa();

	public TelaCalculoInicio(Frame inicio) {
		Calculo calc = new Calculo();
		telaInicial = inicio;
		// TelaJustaCausa jc = new TelaJustaCausa(inicio,txtCodigo.getText());

		getContentPane().setBackground(new Color(250, 240, 230));
		setBounds(0, 0, 1200, 800);

		atual = this;
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 120, 745, 593);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		scrollPane.setViewportView(textArea);

		txtCodigo = new JTextField();
		txtCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(txtCodigo.getText().isEmpty()) {
					
				}else {
				textArea.setText("");
				String linha = null;
				linha = pessoa.localizar(txtCodigo.getText());
				if (linha == null) {
					JOptionPane.showMessageDialog(null, "Não achei nada!");
				} else {
					String codigo, nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

					codigo = pessoa.pegarCodigo(linha);

					nome = pessoa.pegarNome(linha);
					cpf = pessoa.pegarCpf(linha);
					rg = pessoa.pegarRg(linha);
					dataNascimento = pessoa.pegarDataAdmissao(linha);
					salario = pessoa.pegarSalario(linha);
					dataAdmissao = pessoa.pegarDataAdmissao(linha);
					dataDemissao = pessoa.pegarDataDemissao(linha);
					tempoDeTrabalho = pessoa.pegarTempoDeTrabalho(linha);

					textArea.append("\nCodigo: " + codigo + "\n\nNome: " + nome + "\n\nCpf: " + cpf + "\n\nRg: " + rg
							+ "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: " + salario
							+ "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
							+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);
						calc.escreverCalculo(textArea.getText(), nome);
				}
			}
			}
		});


		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCalculoInicio.class.getResource("/imagen/TelaCalculoInicio.png")));
		lblLogo.setBounds(851, 11, 323, 396);
		getContentPane().add(lblLogo);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(97, 31, 287, 60);
		getContentPane().add(txtCodigo);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(22, 52, 65, 20);
		getContentPane().add(lblCodigo);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});

		btnVoltar.setIcon(new ImageIcon(TelaCalculoInicio.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1024, 668, 80, 45);
		getContentPane().add(btnVoltar);
		
		
		
/* DA MANEIRA Q EU QUERIA FAZER MAS DEU RUIM UNS BUGS LOUCOS
 * 
 * 
 * 
		JButton btnConfirma = new JButton("");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String linha = pessoa.localizar(txtCodigo.getText());
				// pessoa.ArquivoPessoa(caminhoCalculo, pegarNome(linha));

				// int op = comboBoxOpcao.getSelectedIndex();

				if (comboBoxOpcao.getSelectedIndex() == 1) {
					TelaDespedido dp = new TelaDespedido(telaInicial, txtCodigo.getText());
					((BasicInternalFrameUI) dp.getUI()).setNorthPane(null);
					dp.setBorder(null);

					anterior = atual;

					telaInicial.add(dp);
					atual = dp;
					atual.setVisible(true);
					anterior.dispose();

				} else if (comboBoxOpcao.getSelectedIndex() == 2) {// passando o indice do vetor ["", "Demissão","Despedido", "Justa Causa"]
					TelaDemissao dm = new TelaDemissao(telaInicial, txtCodigo.getText());
					((BasicInternalFrameUI) dm.getUI()).setNorthPane(null);
					dm.setBorder(null);

					anterior = atual;

					telaInicial.add(dm);
					atual = dm;
					atual.setVisible(true);
					anterior.dispose();											
																	
				} else if (comboBoxOpcao.getSelectedIndex() == 3) { // 0 , 1 , 2 , 3
																	// .getSelectedItem().toString().equals("JustaCausa")
																	//  Ou dessa forma passando o nome do campo

					TelaJustaCausa jc = new TelaJustaCausa(telaInicial, txtCodigo.getText());
					((BasicInternalFrameUI) jc.getUI()).setNorthPane(null);
					jc.setBorder(null);

					anterior = atual;

					telaInicial.add(jc);
					atual = jc;
					atual.setVisible(true);
					anterior.dispose();
				}

			}
		});
		btnConfirma.setIcon(new ImageIcon(TelaCalculoInicio.class.getResource("/imagen/confirma.png")));
		btnConfirma.setBorder(null);
		btnConfirma.setBackground(new Color(250, 240, 230));
		btnConfirma.setBounds(879, 588, 190, 125);
		getContentPane().add(btnConfirma);
*/
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setText("");
				textArea.setText("");
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaCalculoInicio.class.getResource("/imagen/limparCalculo.png")));
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(new Color(250, 240, 230));
		btnLimpar.setBounds(777, 668, 80, 45);
		getContentPane().add(btnLimpar);

		atual = this;
	}
}
