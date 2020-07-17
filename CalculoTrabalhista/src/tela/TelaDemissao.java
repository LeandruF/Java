package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Demissao;
import controle.Pessoa;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaDemissao extends JInternalFrame {
	JInternalFrame atual, ante;
	private JTextField txtCodigo;
	private JTextField txtMesesTrabalhadoNoAno;
	private JTextField txtDiasDeTrabalhoNoMes;

	public TelaDemissao(Frame inicio, String codigo) {

		Demissao dm = new Demissao();
		Pessoa pessoa = new Pessoa();
		atual = this;

		getContentPane().setBackground(new Color(250, 240, 230));
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaDemissao.class.getResource("/imagen/Logodemissao.png")));
		label.setBounds(835, 12, 320, 260);
		getContentPane().add(label);

		JLabel lblSalariosVencidos = new JLabel("Quantos Salarios Vencidos:");
		lblSalariosVencidos.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSalariosVencidos.setBounds(382, 114, 220, 20);
		getContentPane().add(lblSalariosVencidos);

		JComboBox comboNumSal = new JComboBox();
		comboNumSal.setModel(new DefaultComboBoxModel(new String[] { "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboNumSal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboNumSal.setBounds(600, 101, 133, 45);
		getContentPane().add(comboNumSal);

		String linha = pessoa.localizar(codigo);

		String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

		codigo = dm.pegarCodigo(linha);
		nome = dm.pegarNome(linha);
		cpf = dm.pegarCpf(linha);
		rg = dm.pegarRg(linha);
		dataNascimento = dm.pegarDataNascimento(linha);
		salario = dm.pegarSalario(linha);
		dataAdmissao = dm.pegarDataAdmissao(linha);
		dataDemissao = dm.pegarDataDemissao(linha);
		tempoDeTrabalho = dm.pegarTempoDeTrabalho(linha);

		JLabel lblQuantasFeriasVencidas = new JLabel("Quantas Ferias Vencidas: ");
		lblQuantasFeriasVencidas.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblQuantasFeriasVencidas.setBounds(382, 177, 220, 27);
		getContentPane().add(lblQuantasFeriasVencidas);

		JLabel lblDiasDeTrabalho_1 = new JLabel("Meses de Trabalho no ano:");
		lblDiasDeTrabalho_1.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDiasDeTrabalho_1.setBounds(19, 126, 231, 20);
		getContentPane().add(lblDiasDeTrabalho_1);

		txtMesesTrabalhadoNoAno = new JTextField();
		txtMesesTrabalhadoNoAno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int meses = Integer.parseInt(txtMesesTrabalhadoNoAno.getText());
				if (meses > 13 || meses < 0) {
					JOptionPane.showMessageDialog(null, "So temos 12 meses no ano!");
					txtMesesTrabalhadoNoAno.setText("");
				}
			}
		});
		txtMesesTrabalhadoNoAno.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesTrabalhadoNoAno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesTrabalhadoNoAno.setColumns(10);
		txtMesesTrabalhadoNoAno.setBounds(238, 112, 125, 45);
		getContentPane().add(txtMesesTrabalhadoNoAno);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});

		JComboBox comboFeriasVencidas = new JComboBox();
		comboFeriasVencidas.setModel(new DefaultComboBoxModel(new String[] { "", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboFeriasVencidas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboFeriasVencidas.setBounds(585, 167, 148, 45);
		getContentPane().add(comboFeriasVencidas);

		JLabel lblDiasDeTrabalho = new JLabel("Dias de Trabalho no m\u00EAs:");
		lblDiasDeTrabalho.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDiasDeTrabalho.setBounds(19, 184, 231, 20);
		getContentPane().add(lblDiasDeTrabalho);

		txtDiasDeTrabalhoNoMes = new JTextField();
		txtDiasDeTrabalhoNoMes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int dias = Integer.parseInt(txtDiasDeTrabalhoNoMes.getText());
				if (dias > 31 || dias < 0) {
					JOptionPane.showMessageDialog(null, "Não temos essa quantidade de dias no mes!");
					txtDiasDeTrabalhoNoMes.setText("");

				}
			}
		});
		txtDiasDeTrabalhoNoMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasDeTrabalhoNoMes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiasDeTrabalhoNoMes.setColumns(10);
		txtDiasDeTrabalhoNoMes.setBounds(238, 168, 125, 45);
		getContentPane().add(txtDiasDeTrabalhoNoMes);

		JScrollPane scrollPaneResult = new JScrollPane();
		scrollPaneResult.setBounds(445, 230, 402, 482);
		getContentPane().add(scrollPaneResult);

		JTextArea result = new JTextArea();
		scrollPaneResult.setViewportView(result);
		result.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		result.setEditable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 230, 394, 482);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textArea.setText("");
		textArea.setEditable(false);
		textArea.setText("");

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(19, 26, 65, 20);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				textArea.setText("");

				String linha = pessoa.localizar(txtCodigo.getText());

				String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

				nome = dm.pegarNome(linha);
				cpf = dm.pegarCpf(linha);
				rg = dm.pegarRg(linha);
				dataNascimento = dm.pegarDataNascimento(linha);
				salario = dm.pegarSalario(linha);
				dataAdmissao = dm.pegarDataAdmissao(linha);
				dataDemissao = dm.pegarDataDemissao(linha);
				tempoDeTrabalho = dm.pegarTempoDeTrabalho(linha);

				textArea.append("\nCodigo: " + txtCodigo.getText() + "\n\nNome: " + nome + "\n\nCpf: " + cpf
						+ "\n\nRg: " + rg + "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: " + salario
						+ "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
						+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);

			}
		});
		txtCodigo.setText("<dynamic>");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(94, 11, 277, 46);
		txtCodigo.setText(codigo);
		getContentPane().add(txtCodigo);
		btnVoltar.setIcon(new ImageIcon(TelaDemissao.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1093, 667, 80, 45);
		getContentPane().add(btnVoltar);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Converte txtFeriasVencidas em inteiro
				int dias = Integer.parseInt(txtDiasDeTrabalhoNoMes.getText());

				// Converte salario de String para double
				double money = Double.parseDouble(salario); // Salario

				// Salario Vencidos
				double numeroDeSalarioVencidos = Integer.parseInt(comboNumSal.getSelectedItem().toString());
				double vencido = money * numeroDeSalarioVencidos;// Salario Vencido

				// FeriasProporcional
				int mesesTrabalhadosNoAno = Integer.parseInt(txtMesesTrabalhadoNoAno.getText());
				double feriasProporcional = dm.feriasProporcionais(money, mesesTrabalhadosNoAno);

				// Ferias Vencidas
				int feriasVencidas = Integer.parseInt(comboFeriasVencidas.getSelectedItem().toString());
				double totalFeriasVencidas = feriasVencidas * money;

				// 13 Proporcional
				double decimoTerceiroProporcional = dm.calcularDecimoTerceiro(money, mesesTrabalhadosNoAno);

				// AvisoPrevio
				int avisoPrevio = dm.avisoPrevio();

				
				// AvisoPrevio valor
				
				double valorAvisoPrevio = (avisoPrevio * dm.salarioProporcional(money, 1)); // Quanto custa o dia de
				
				// TOTAL
				double total = money + vencido + feriasProporcional +valorAvisoPrevio + decimoTerceiroProporcional; // Total =salario
																									// vencido + salario
																									// proporcional +
																									// ferias vencidas

				result.append("Nome:" + nome + "\nSalario: R$" + String.format("%.2f", money) +

						"\n\nTotal em Salarios vencidos a ser pagos: " + comboNumSal.getSelectedItem().toString()
						+ "\nSalarios Vencidos" + "  R$" + String.format("%.2f", vencido) +

						"\n\nSalario Proporcional a Receber: Meses trabalhados no Mês " + dias + "\n  R$"
						+ String.format("%.2f", money) +

						"\n\nFerias Vencidas: " + feriasVencidas + " Ferias" + "\n  R$" + totalFeriasVencidas +

						"\n\nFerias Proporcional: " + mesesTrabalhadosNoAno + " Meses" + "\n  R$" + feriasProporcional +

						"\n\n13º Salario: " + mesesTrabalhadosNoAno + " Meses " + "\n  R$" + decimoTerceiroProporcional+

						"\n\nDias de Aviso Previo: " + avisoPrevio + " Dias" +

						"\n\nValor a receber de Aviso Previo:  R$" + String.format("%.2f", valorAvisoPrevio) +

						"\n\nValor total a receber:  R$" + String.format("%.2f", total));
			}

		});
		btnCalcular.setIcon(new ImageIcon(TelaDemissao.class.getResource("/imagen/btnconfirma.png")));
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(753, 165, 80, 45);
		getContentPane().add(btnCalcular);

		JButton btnConfirma = new JButton("");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String linha = pessoa.localizar(txtCodigo.getText());

				String nome = dm.pegarNome(linha);

				if (txtCodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencher o campo CODIGO! ");
				} else if (comboNumSal.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecionar o campo SALARIO VENCIDOS! ");
				} else if (comboFeriasVencidas.getSelectedItem().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencher o campo FERIAS VENCIDAS! ");
				} else if (txtMesesTrabalhadoNoAno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencher o campo MESES TRABALHADOS NO ANO! ");
				} else {

					String texto = result.getText().toString();
					dm.escreverCalculo(texto, nome);

				}
			}
		});
		btnConfirma.setIcon(new ImageIcon(TelaDemissao.class.getResource("/imagen/confirma.png")));
		btnConfirma.setBorder(null);
		btnConfirma.setBackground(new Color(250, 240, 230));
		btnConfirma.setBounds(893, 587, 190, 125);
		getContentPane().add(btnConfirma);
		setBounds(0, 0, 1200, 800);

		atual = this;

	}
}
