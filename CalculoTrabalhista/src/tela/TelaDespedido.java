package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Despedido;
import controle.Pessoa;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaDespedido extends JInternalFrame {
	JInternalFrame atual;
	private JTextField txtCodigo;
	Despedido dp = new Despedido();
	Pessoa pessoa = new Pessoa();
	private JTextField txtMesesTrabalhadoNoAno;
	private JTextField txtDiasDeTrabalhoNoMes;
	private JTextField txtAntePenultimoSalario;
	private JTextField txtPenultimoSalario;
	private JTextField txtUltimoSalario;
	private JTextField txtMesesDoze;
	private JTextField txtMesesTrintaSeis;

	public TelaDespedido(Frame inicio, String codigo) {
		getContentPane().setBackground(new Color(250, 240, 230));
		setBounds(0, 0, 1200, 800);
		atual = this;
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 287, 394, 439);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);

		textArea.setText("");

		String linha = pessoa.localizar(codigo);

		String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

		codigo = dp.pegarCodigo(linha);
		nome = dp.pegarNome(linha);
		cpf = dp.pegarCpf(linha);
		rg = dp.pegarRg(linha);
		dataNascimento = dp.pegarDataNascimento(linha);
		salario = dp.pegarSalario(linha);
		dataAdmissao = dp.pegarDataAdmissao(linha);
		dataDemissao = dp.pegarDataDemissao(linha);
		tempoDeTrabalho = dp.pegarTempoDeTrabalho(linha);

		String mesOuAno = tempoDeTrabalho.substring(linha.indexOf("|"));

		textArea.append("\nCodigo: " + codigo + "\n\nNome: " + nome + "\n\nCpf: " + cpf + "\n\nRg: " + rg
				+ "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: " + salario + "\n\nData de Admissão: "
				+ dataAdmissao + "\n\nData de Demissão: " + dataDemissao + "\n\nTempo de Trabalho: " + tempoDeTrabalho);

		JComboBox comboNumSal = new JComboBox();
		comboNumSal.setModel(new DefaultComboBoxModel(new String[] { "", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboNumSal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboNumSal.setBounds(580, 13, 133, 45);
		getContentPane().add(comboNumSal);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(26, 13, 65, 20);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setText(codigo);
		txtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				textArea.setText("");
				String linha = pessoa.localizar(txtCodigo.getText());

				String nome, cpf, rg, dataNascimento, salario, dataAdmissao, dataDemissao, tempoDeTrabalho;

				nome = dp.pegarNome(linha);
				cpf = dp.pegarCpf(linha);
				rg = dp.pegarRg(linha);
				dataNascimento = dp.pegarDataNascimento(linha);
				salario = dp.pegarSalario(linha);
				dataAdmissao = dp.pegarDataAdmissao(linha);
				dataDemissao = dp.pegarDataDemissao(linha);
				tempoDeTrabalho = dp.pegarTempoDeTrabalho(linha);

				String tempo = tempoDeTrabalho;

				tempo = tempoDeTrabalho.substring(0, tempoDeTrabalho.indexOf(","));

				textArea.append("\nCodigo: " + txtCodigo.getText() + "\n\nNome: " + nome + "\n\nCpf: " + cpf
						+ "\n\nRg: " + rg + "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: " + salario
						+ "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
						+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);
			}
		});
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(101, 11, 231, 27);
		getContentPane().add(txtCodigo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaDespedido.class.getResource("/imagen/LogoDespedido.png")));
		lblLogo.setBounds(854, 11, 320, 260);
		getContentPane().add(lblLogo);

		JLabel lblQtdSalariosVencidos = new JLabel("Quantos Salarios Vencidos:");
		lblQtdSalariosVencidos.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblQtdSalariosVencidos.setBounds(356, 26, 220, 20);
		getContentPane().add(lblQtdSalariosVencidos);

		JLabel lblMesesTrabalhadoNoAno = new JLabel("Meses de Trabalho no ano:");
		lblMesesTrabalhadoNoAno.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblMesesTrabalhadoNoAno.setBounds(10, 59, 231, 20);
		getContentPane().add(lblMesesTrabalhadoNoAno);

		txtMesesTrabalhadoNoAno = new JTextField();
		txtMesesTrabalhadoNoAno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				int meses = Integer.parseInt(txtMesesTrabalhadoNoAno.getText());
				if (meses > 12 || meses < 0) {
					JOptionPane.showMessageDialog(null, "So temos 12 meses no ano!");
					txtMesesTrabalhadoNoAno.setText("");
				}
			}
		});
		txtMesesTrabalhadoNoAno.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesTrabalhadoNoAno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesTrabalhadoNoAno.setColumns(10);
		txtMesesTrabalhadoNoAno.setBounds(230, 53, 102, 27);
		getContentPane().add(txtMesesTrabalhadoNoAno);

		JLabel lblDiasDeTrabalhoNoMes = new JLabel("Dias de Trabalho no m\u00EAs:");
		lblDiasDeTrabalhoNoMes.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDiasDeTrabalhoNoMes.setBounds(10, 96, 231, 20);
		getContentPane().add(lblDiasDeTrabalhoNoMes);

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
		txtDiasDeTrabalhoNoMes.setBounds(221, 90, 111, 27);
		getContentPane().add(txtDiasDeTrabalhoNoMes);

		JLabel lblQtdFeriasVencidas = new JLabel("Quantas Ferias Vencidas: ");
		lblQtdFeriasVencidas.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblQtdFeriasVencidas.setBounds(371, 79, 220, 27);
		getContentPane().add(lblQtdFeriasVencidas);

		JComboBox comboFeriasVencidas = new JComboBox();
		comboFeriasVencidas.setModel(new DefaultComboBoxModel(new String[] { "", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		comboFeriasVencidas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboFeriasVencidas.setBounds(580, 68, 133, 45);
		getContentPane().add(comboFeriasVencidas);

		JLabel lblAntepenltimoSalrio = new JLabel("Antepen\u00FAltimo sal\u00E1rio:");
		lblAntepenltimoSalrio.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblAntepenltimoSalrio.setBounds(10, 251, 231, 20);
		getContentPane().add(lblAntepenltimoSalrio);

		txtAntePenultimoSalario = new JTextField();
		txtAntePenultimoSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtAntePenultimoSalario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtAntePenultimoSalario.setColumns(10);
		txtAntePenultimoSalario.setBounds(193, 245, 125, 31);
		getContentPane().add(txtAntePenultimoSalario);

		JLabel lblPenltimoSalrio = new JLabel("Pen\u00FAltimo sal\u00E1rio:");
		lblPenltimoSalrio.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblPenltimoSalrio.setBounds(329, 251, 148, 20);
		getContentPane().add(lblPenltimoSalrio);

		txtPenultimoSalario = new JTextField();
		txtPenultimoSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtPenultimoSalario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPenultimoSalario.setColumns(10);
		txtPenultimoSalario.setBounds(472, 245, 125, 31);
		getContentPane().add(txtPenultimoSalario);

		JLabel lblltimoSalrio = new JLabel("\u00DAltimo sal\u00E1rio:");
		lblltimoSalrio.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblltimoSalrio.setBounds(607, 251, 148, 20);
		getContentPane().add(lblltimoSalrio);

		txtUltimoSalario = new JTextField();
		txtUltimoSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUltimoSalario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUltimoSalario.setColumns(10);
		txtUltimoSalario.setBounds(722, 245, 125, 31);
		getContentPane().add(txtUltimoSalario);

		JLabel label = new JLabel(
				"=========================================================================================================");
		label.setBounds(0, 120, 844, 14);
		getContentPane().add(label);

		JLabel lblSeguroDesemprego = new JLabel("Seguro Desemprego");
		lblSeguroDesemprego.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSeguroDesemprego.setBounds(341, 136, 173, 20);
		getContentPane().add(lblSeguroDesemprego);

		JLabel lblQuantosMesesVoc = new JLabel("Quantos meses voc\u00EA trabalhou nos \u00FAltimos 18 Meses:");
		lblQuantosMesesVoc.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblQuantosMesesVoc.setBounds(10, 174, 444, 20);
		getContentPane().add(lblQuantosMesesVoc);

		txtMesesDoze = new JTextField();
		txtMesesDoze.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesDoze.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesDoze.setColumns(10);
		txtMesesDoze.setBounds(451, 167, 125, 31);
		getContentPane().add(txtMesesDoze);

		JLabel lblQuantosMesesVoc_1 = new JLabel("Quantos meses voc\u00EA trabalhou nos \u00FAltimos 36 Meses:");
		lblQuantosMesesVoc_1.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblQuantosMesesVoc_1.setBounds(10, 209, 444, 20);
		getContentPane().add(lblQuantosMesesVoc_1);

		txtMesesTrintaSeis = new JTextField();
		txtMesesTrintaSeis.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesTrintaSeis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesTrintaSeis.setColumns(10);
		txtMesesTrintaSeis.setBounds(451, 209, 125, 31);
		getContentPane().add(txtMesesTrintaSeis);

		JLabel lblSolicitaes = new JLabel("Solicita\u00E7\u00F5es:");
		lblSolicitaes.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSolicitaes.setBounds(586, 178, 102, 20);
		getContentPane().add(lblSolicitaes);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});

		JComboBox comboSolicitacoes = new JComboBox();
		comboSolicitacoes.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J\u00E1 esta bom n\u00E9" }));
		comboSolicitacoes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboSolicitacoes.setBounds(686, 167, 133, 37);
		getContentPane().add(comboSolicitacoes);

		JScrollPane scrollResult = new JScrollPane();
		scrollResult.setBounds(430, 287, 402, 439);
		getContentPane().add(scrollResult);

		JTextArea result = new JTextArea();
		result.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollResult.setViewportView(result);

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
				double feriasProporcional = dp.feriasProporcionais(money, mesesTrabalhadosNoAno);

				// Ferias Vencidas
				int feriasVencidas = Integer.parseInt(comboFeriasVencidas.getSelectedItem().toString());

				double totalFeriasVencidas = feriasVencidas * money;

				// 13 Proporcional
				double decimoTerceiroProporcional = dp.calcularDecimoTerceiro(money, mesesTrabalhadosNoAno);

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
					avisoPrevio = dp.avisoPrevio(tempoTotalDeTrabalho);
				}

				// Aviso previo Quanto receber

				// salarioProporcional * avisoPrevio

				double valorAvisoPrevio = (avisoPrevio * dp.salarioProporcional(money, 1)); // Quanto custa o dia de
																							

				// FGTS
				double fgtsSaldo;
				if (mesOuAno.equals("Ano") || mesOuAno.equals("Anos")) {
					tempoTotalDeTrabalho *= 12; // Quantidade de meses do ano
					fgtsSaldo = dp.fgts(money, tempoTotalDeTrabalho);
				} else {
					fgtsSaldo = dp.fgts(money, tempoTotalDeTrabalho);
				}
				// MULTA FGTS 40%
				double multaFgts = dp.multaFgts(money);

				// ferias 1/3
				double feriasUmTerco = 0;
				String feriasUmTercoNegativo = null;

				// Seguro Desemprego valor
				double ultimo, penultimo, antePenultimo;
				ultimo = Double.parseDouble(txtUltimoSalario.getText());
				penultimo = Double.parseDouble(txtPenultimoSalario.getText());
				antePenultimo = Double.parseDouble(txtAntePenultimoSalario.getText());
				double seguroDesempregoValor = 0;

				int solicitacao = Integer.parseInt(comboSolicitacoes.getSelectedItem().toString());
				int mesesDoze = Integer.parseInt(txtMesesDoze.getText());
				int mesesTrintaSeis = Integer.parseInt(txtMesesTrintaSeis.getText());
				int quantidaDeSeguroDesemprego = 0;

				String resposta = "";
				int cont = 0;
				// Seguro Desemprego parcelas so vai ter alguma coisa se for no ELSE
				if (solicitacao == 1 && mesesDoze < 12) {
					resposta = "Sem direito de receber seguro desemprego\r\n"
							+ "É NECESSÁRIO TER TRABALHADO PELO MENOS 12 MESES NO ÚLTIMOS 18 MESES";

				} else if (solicitacao == 2 && mesesDoze < 9) {

					resposta = "Sem direito de receber seguro desemprego\r\n"
							+ "É NECESSÁRIO TER TRABALHADO PELO MENOS 9 MESES NO ÚLTIMOS 12 MESES";
				} else if (solicitacao >= 3 && mesesDoze < 6) {
					resposta = "Sem direito de receber seguro desemprego\r\n"
							+ "É NECESSÁRIO TER TRABALHADO PELO MENOS 6 MESES NO ÚLTIMOS 6 MESES";
				} else {

					quantidaDeSeguroDesemprego = dp.seguroDesempregoQuantidade(mesesDoze, mesesTrintaSeis, solicitacao);
					seguroDesempregoValor = dp.seguroDesempregoValor(ultimo, penultimo, antePenultimo);

					++cont;

				}

				double totalSeguroDesemprego = seguroDesempregoValor * quantidaDeSeguroDesemprego;

				double total;

				if (cont > 0) {
					if (tempoTotalDeTrabalho >= 12) {
						feriasUmTerco = dp.feriasUmTerco(money);

						// SOMA DE TUDO
						total = money + vencido + feriasProporcional + totalFeriasVencidas + decimoTerceiroProporcional
								+ valorAvisoPrevio +fgtsSaldo + multaFgts + feriasUmTerco + totalSeguroDesemprego;

						result.append("Nome:" + nome + "\nSalario: R$" + String.format("%.2f", money) +

								"\n\nTotal em Salarios vencidos a ser pagos: "
								+ comboNumSal.getSelectedItem().toString() + " Salarios Vencidos" + "  R$"
								+ String.format("%.2f", vencido) +

								"\n\nSalario Proporcional a Receber: " + dias + " Meses trabalhados no Mês  R$"
								+ String.format("%.2f", money) +

								"\n\nFerias Vencidas: " + feriasVencidas + " Ferias" + "  R$" + totalFeriasVencidas +

								"\n\nFerias Proporcional: " + mesesTrabalhadosNoAno + " Meses" + "  R$"
								+ feriasProporcional +

								"\n\nFerias 1/3:  R$" + String.format("%.2f", feriasUmTerco) +

								"\n\n13º Salario: " + mesesTrabalhadosNoAno + " Meses " + "  R$"
								+ String.format("%.2f", decimoTerceiroProporcional) +

								"\n\nDias de Aviso Previo: " + avisoPrevio + " Dias" +

								"\n\nValor a receber de Aviso Previo:  R$" + String.format("%.2f", valorAvisoPrevio) +

								"\n\nFgts: Tempo de Contribuição " + tempoTotalDeTrabalho + mesOuAno + "  R$ "
								+ String.format("%.2f", fgtsSaldo) +

								"\n\nMulta Fgts 40% : R$ " + String.format("%.2f", multaFgts) +

								"\n\nSeguro Desemprego: Numero de Parcelas " + quantidaDeSeguroDesemprego + " parcelas"
								+

								"\n\nSeguro Desemprego: Valor de cada parcela R$ " + seguroDesempregoValor +

								"\n\nSeguro Desemprego: Valor TOTAL R$ " + totalSeguroDesemprego +

								"\n\nValor total a receber:  R$" + String.format("%.2f", total) + "\n\n");

					} else { // SEM FERIAS 1/ POIS NAO TEM 1 ANO.

						feriasUmTercoNegativo = "Não Tem Direito a Ferias 1/3! So para quem tem mais de 1ano.";
						// SOMA DE TUDO SEM FERIAS 1/3 E SEGURO DESEMPREGO
						total = money + vencido + feriasProporcional + totalFeriasVencidas + decimoTerceiroProporcional
								+valorAvisoPrevio +fgtsSaldo + multaFgts;

						result.append("Nome:" + nome + "\nSalario: R$" + String.format("%.2f", money) +

								"\n\nTotal em Salarios vencidos a ser pagos: "
								+ comboNumSal.getSelectedItem().toString() + " Salarios Vencidos" + "  R$"
								+ String.format("%.2f", vencido) +

								"\n\nSalario Proporcional a Receber:" + dias + " Meses trabalhados no Mês " + "  R$"
								+ String.format("%.2f", money) +

								"\n\nFerias Vencidas: " + feriasVencidas + " Ferias" + "\n  R$"
								+ String.format("%.2f", totalFeriasVencidas) +

								"\n\nFerias Proporcional: " + mesesTrabalhadosNoAno + " Meses" + "  R$"
								+ String.format("%.2f", feriasProporcional) +

								"\n\nFerias 1/3: " + feriasUmTercoNegativo +

								"\n\n13º Salario: " + mesesTrabalhadosNoAno + " Meses " + "  R$"
								+ String.format("%.2f", decimoTerceiroProporcional) +

								"\n\nDias de Aviso Previo: " + avisoPrevio + " Dias" +

								"\n\nValor a receber de Aviso Previo:  R$" + String.format("%.2f", valorAvisoPrevio) +

								"\n\nFgts: Tempo de Contribuição " + tempoTotalDeTrabalho + "  R$"
								+ String.format("%.2f", fgtsSaldo) +

								"\n\n" + resposta +

								"\n\nMulta Fgts 40% : R$" + String.format("%.2f", multaFgts) +

								"\n\nValor total a receber:  R$" + String.format("%.2f", total) + "\n\n");
					}

				} else {
					total = money + vencido + feriasProporcional + totalFeriasVencidas + decimoTerceiroProporcional
							+valorAvisoPrevio +fgtsSaldo + multaFgts;

					result.append("Nome:" + nome + "\nSalario: R$" + String.format("%.2f", money) +

							"\n\nTotal em Salarios vencidos a ser pagos: " + comboNumSal.getSelectedItem().toString()
							+ " Salarios Vencidos" + "  R$" + String.format("%.2f", vencido) +

							"\n\nSalario Proporcional a Receber: " + dias + " Meses trabalhados no Mês  R$"
							+ String.format("%.2f", money) +

							"\n\nFerias Vencidas: " + feriasVencidas + " Ferias" + "  R$" + totalFeriasVencidas +

							"\n\nFerias Proporcional: " + mesesTrabalhadosNoAno + " Meses" + "  R$" + feriasProporcional
							+

							"\n\nFerias 1/3:  R$" + String.format("%.2f", feriasUmTerco) +

							"\n\n13º Salario: " + mesesTrabalhadosNoAno + " Meses " + "  R$"
							+ String.format("%.2f", decimoTerceiroProporcional) +

							"\n\nDias de Aviso Previo: " + avisoPrevio + " Dias" +

							"\n\nValor a receber de Aviso Previo:  R$" + String.format("%.2f", valorAvisoPrevio) +

							"\n\nFgts: Tempo de Contribuição " + tempoTotalDeTrabalho + mesOuAno + "  R$ "
							+ String.format("%.2f", fgtsSaldo) +

							"\n\nMulta Fgts 40% : R$ " + String.format("%.2f", multaFgts) +

							"\n\nSeguro Desemprego: " + resposta +

							"\n\nValor total a receber:  R$" + String.format("%.2f", total) + "\n\n");
				}
			}
		});
		btnCalcular.setIcon(new ImageIcon(TelaDespedido.class.getResource("/imagen/btnconfirma.png")));
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(851, 283, 80, 45);
		getContentPane().add(btnCalcular);

		JButton btnConfirma = new JButton("");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dp.escreverCalculo(result.getText(), nome);
			}
		});
		btnConfirma.setIcon(new ImageIcon(TelaDespedido.class.getResource("/imagen/confirma.png")));
		btnConfirma.setBorder(null);
		btnConfirma.setBackground(new Color(250, 240, 230));
		btnConfirma.setBounds(878, 601, 190, 125);
		getContentPane().add(btnConfirma);
		btnVoltar.setIcon(new ImageIcon(TelaDespedido.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1094, 681, 80, 45);
		getContentPane().add(btnVoltar);

	}
}
