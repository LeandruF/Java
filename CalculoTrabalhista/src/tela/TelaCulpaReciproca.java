package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.CulpaReciproca;
import controle.Pessoa;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;

public class TelaCulpaReciproca extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtMesesTrabalhadoNoAno;
	private JTextField txtDiasTrabalhadoNoMes;
	JInternalFrame atual;
	Pessoa pessoa = new Pessoa();
	CulpaReciproca crp = new CulpaReciproca();

	public TelaCulpaReciproca(Frame inicio, String codigo) {

		atual = this;
		getContentPane().setBackground(new Color(250, 240, 230));
		getContentPane().setLayout(null);

		txtCodigo = new JTextField();

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(26, 25, 65, 20);
		getContentPane().add(lblCodigo);
		txtCodigo.setText("<dynamic>");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(101, 23, 231, 27);
		txtCodigo.setText(codigo);
		getContentPane().add(txtCodigo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 181, 394, 522);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
		textArea.setText("");

		String linha = pessoa.localizar(codigo);

		String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

		codigo = crp.pegarCodigo(linha);
		nome = crp.pegarNome(linha);
		cpf = crp.pegarCpf(linha);
		rg = crp.pegarRg(linha);
		dataNascimento = crp.pegarDataNascimento(linha);
		salario = crp.pegarSalario(linha);
		dataAdmissao = crp.pegarDataAdmissao(linha);
		dataDemissao = crp.pegarDataDemissao(linha);
		tempoDeTrabalho = crp.pegarTempoDeTrabalho(linha);

		txtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				textArea.setText("");
				String linha = pessoa.localizar(txtCodigo.getText());

				String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

				nome = crp.pegarNome(linha);
				cpf = crp.pegarCpf(linha);
				rg = crp.pegarRg(linha);
				dataNascimento = crp.pegarDataNascimento(linha);
				salario = crp.pegarSalario(linha);
				dataAdmissao = crp.pegarDataAdmissao(linha);
				dataDemissao = crp.pegarDataDemissao(linha);
				tempoDeTrabalho = crp.pegarTempoDeTrabalho(linha);

				String tempo = tempoDeTrabalho;

				tempo = tempoDeTrabalho.substring(0, tempoDeTrabalho.indexOf(","));

				textArea.append("\nCodigo: " + txtCodigo.getText() + "\n\nNome: " + nome + "\n\nCpf: " + cpf
						+ "\n\nRg: " + rg + "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: " + salario
						+ "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
						+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);
			}
		});

		JScrollPane result = new JScrollPane();
		result.setBounds(435, 181, 402, 522);
		getContentPane().add(result);

		JTextArea resultado = new JTextArea();
		resultado.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		result.setViewportView(resultado);

		JLabel lblMesesTrabaloNoAno = new JLabel("Meses de Trabalho no ano:");
		lblMesesTrabaloNoAno.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblMesesTrabaloNoAno.setBounds(10, 71, 231, 20);
		getContentPane().add(lblMesesTrabaloNoAno);

		txtMesesTrabalhadoNoAno = new JTextField();
		txtMesesTrabalhadoNoAno.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesTrabalhadoNoAno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesTrabalhadoNoAno.setColumns(10);
		txtMesesTrabalhadoNoAno.setBounds(230, 65, 102, 27);
		getContentPane().add(txtMesesTrabalhadoNoAno);

		JLabel lblDiasDeTrabalhoNoMes = new JLabel("Dias de Trabalho no m\u00EAs:");
		lblDiasDeTrabalhoNoMes.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDiasDeTrabalhoNoMes.setBounds(10, 108, 231, 20);
		getContentPane().add(lblDiasDeTrabalhoNoMes);

		txtDiasTrabalhadoNoMes = new JTextField();
		txtDiasTrabalhadoNoMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasTrabalhadoNoMes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiasTrabalhadoNoMes.setColumns(10);
		txtDiasTrabalhadoNoMes.setBounds(221, 102, 111, 27);
		getContentPane().add(txtDiasTrabalhadoNoMes);

		JLabel lblFeriasVencidas = new JLabel("Quantas Ferias Vencidas: ");
		lblFeriasVencidas.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblFeriasVencidas.setBounds(371, 91, 220, 27);
		getContentPane().add(lblFeriasVencidas);

		JComboBox comboFeriasVencidas = new JComboBox();
		comboFeriasVencidas.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboFeriasVencidas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboFeriasVencidas.setBounds(580, 80, 133, 45);
		getContentPane().add(comboFeriasVencidas);

		JLabel lblSalarioVencidos = new JLabel("Quantos Salarios Vencidos:");
		lblSalarioVencidos.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSalarioVencidos.setBounds(356, 38, 220, 20);
		getContentPane().add(lblSalarioVencidos);

		JComboBox comboNumSal = new JComboBox();
		comboNumSal.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboNumSal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboNumSal.setBounds(580, 25, 133, 45);
		getContentPane().add(comboNumSal);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(TelaCulpaReciproca.class.getResource("/imagen/culpaReciproca.png")));
		label_5.setBounds(854, 23, 320, 260);
		getContentPane().add(label_5);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Converte txtFeriasVencidas em inteiro
				int dias = Integer.parseInt(txtDiasTrabalhadoNoMes.getText());

				// Converte salario de String para double
				double money = Double.parseDouble(salario); // Salario

				// Salario Vencidos
				double numeroDeSalarioVencidos = Integer.parseInt(comboNumSal.getSelectedItem().toString());
				double vencido = money * numeroDeSalarioVencidos;// Salario Vencido

				// FeriasProporcional
				int mesesTrabalhadosNoAno = Integer.parseInt(txtMesesTrabalhadoNoAno.getText());
				double feriasProporcional = crp.feriasProporcionais(money, mesesTrabalhadosNoAno);

				// Ferias Vencidas
				int feriasVencidas = Integer.parseInt(comboFeriasVencidas.getSelectedItem().toString());

				double totalFeriasVencidas = feriasVencidas * money;

				// 13 Proporcional
				double decimoTerceiroProporcional = crp.calcularDecimoTerceiro(money, mesesTrabalhadosNoAno);

				// AvisoPrevio
				tempoDeTrabalho.substring(0, tempoDeTrabalho.indexOf(" ")); // Pega so se é meses ou anos INT

				String mesOuAno = tempoDeTrabalho.substring(linha.indexOf("|"));// Pega se é Mes, Meses ou Ano, Anos

				int avisoPrevio;

				String tempo = tempoDeTrabalho;
				tempo = tempoDeTrabalho.substring(0, tempoDeTrabalho.indexOf(","));

				int tempoTotalDeTrabalho = (Integer.parseInt(tempo));

				if (mesOuAno.equals("Mes") || mesOuAno.equals("Meses")) {
					avisoPrevio = 30;
				} else {
					avisoPrevio = crp.avisoPrevio(tempoTotalDeTrabalho);
				}

				// Aviso previo Quanto receber

				// salarioProporcional * avisoPrevio

				double valorAvisoPrevio = (avisoPrevio * crp.salarioProporcional(money, 1))*0.5; // Quanto custa o dia de

				// MULTA FGTS 40%
				double multaFgts = crp.multaFgts(money);

				// ferias 1/3
				double feriasUmTerco = 0;
				String feriasUmTercoNegativo = null;
				double total;

				// SOMA DE TUDO
				total = money + vencido + feriasProporcional + totalFeriasVencidas + decimoTerceiroProporcional
						+ valorAvisoPrevio + multaFgts + feriasUmTerco;

				resultado.append("Nome:" + nome + "\nSalario: R$" + String.format("%.2f", money) +

						"\n\nTotal em Salarios vencidos a ser pagos: " + comboNumSal.getSelectedItem().toString()
						+ " Salarios Vencidos" + "  R$" + String.format("%.2f", vencido) +

						"\n\nSalario Proporcional a Receber: " + dias + " Meses trabalhados no Mês  R$"
						+ String.format("%.2f", money) +

						"\n\nFerias Vencidas: " + feriasVencidas + " Ferias" + "  R$" + totalFeriasVencidas +

						"\n\nFerias Proporcional: 50%, " + mesesTrabalhadosNoAno + " Meses" + "  R$" + feriasProporcional +

						"\n\nFerias 1/3:  R$" + String.format("%.2f", feriasUmTerco) +

						"\n\n13º Salario: 50%, " + mesesTrabalhadosNoAno + " Meses " + "  R$"
						+ String.format("%.2f", decimoTerceiroProporcional) +

						"\n\nDias de Aviso Previo: " + avisoPrevio + " Dias" +

						"\n\nValor a receber de Aviso Previo: 50%,  R$" + String.format("%.2f", valorAvisoPrevio) +


						"\n\nMulta Fgts 40% : 50%, R$ " + String.format("%.2f", multaFgts) +


						"\n\nValor total a receber:  R$" + String.format("%.2f", total) + "\n\n");

			}
		});
		btnCalcular.setIcon(new ImageIcon(TelaCulpaReciproca.class.getResource("/imagen/btnconfirma.png")));
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(724, 125, 80, 45);
		getContentPane().add(btnCalcular);

		JButton btnConfirma = new JButton("");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crp.escreverCalculo(resultado.getText(), nome);
			}
		});
		btnConfirma.setIcon(new ImageIcon(TelaCulpaReciproca.class.getResource("/imagen/confirma.png")));
		btnConfirma.setBorder(null);
		btnConfirma.setBackground(new Color(250, 240, 230));
		btnConfirma.setBounds(854, 577, 190, 125);
		getContentPane().add(btnConfirma);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atual.dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaCulpaReciproca.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1054, 658, 80, 45);
		getContentPane().add(btnVoltar);
		setBounds(0, 0, 1200, 800);

	}
}
