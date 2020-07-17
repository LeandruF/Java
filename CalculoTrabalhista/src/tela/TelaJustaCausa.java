package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Calculo;
import controle.JustaCausa;
import controle.Pessoa;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaJustaCausa extends JInternalFrame {
	JInternalFrame atual;
	private JTextField txtCodigo;
	private JTextField txtDiasDeTrabalho;
		
	private JTextField txtMesesTrabalhadosNoAno;
	private JTextField txtFeriasVencidas;
	
	public TelaJustaCausa(Frame inicio,String codigo) {		
		Pessoa pessoa = new Pessoa();
		JustaCausa jc = new JustaCausa();
		getContentPane().setBackground(new Color(250, 240, 230));
		setBounds(0, 0, 1200, 800);

		
		atual = this;
		getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(TelaJustaCausa.class.getResource("/imagen/JustaCausa.png")));
		logo.setBounds(853, 11, 320, 260);
		getContentPane().add(logo);
		
		JLabel lblSalarioVencido = new JLabel("Quantos Salarios Vencidos:");
		lblSalarioVencido.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSalarioVencido.setBounds(404, 21, 231, 20);
		getContentPane().add(lblSalarioVencido);
		
		JComboBox comboNumSal = new JComboBox();
		comboNumSal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboNumSal.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", ""}));
		comboNumSal.setBounds(622, 15, 136, 44);
		getContentPane().add(comboNumSal);
		
		JLabel lblDiasDeTrabalho = new JLabel("Salario Proporcional Dias de Trabalho:");
		lblDiasDeTrabalho.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDiasDeTrabalho.setBounds(87, 158, 309, 20);
		getContentPane().add(lblDiasDeTrabalho);
		
		txtDiasDeTrabalho = new JTextField();
		txtDiasDeTrabalho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int dias = Integer.parseInt(txtDiasDeTrabalho.getText());
				if(dias>31 || dias<0) {
					JOptionPane.showMessageDialog(null,"Não temos essa quantidade de dias no mes!");
					txtDiasDeTrabalho.setText("");
				
			}
			}
		});
		txtDiasDeTrabalho.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasDeTrabalho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiasDeTrabalho.setColumns(10);
		txtDiasDeTrabalho.setBounds(391, 141, 270, 50);
		getContentPane().add(txtDiasDeTrabalho);
		
		JLabel lblMeseDeTrabalho_1 = new JLabel("Meses de Trabalho no ano:");
		lblMeseDeTrabalho_1.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblMeseDeTrabalho_1.setBounds(21, 96, 216, 20);
		getContentPane().add(lblMeseDeTrabalho_1);
		
		txtMesesTrabalhadosNoAno = new JTextField();
		txtMesesTrabalhadosNoAno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int meses = Integer.parseInt(txtMesesTrabalhadosNoAno.getText());
				if(meses>13 || meses < 0 ) {
					JOptionPane.showMessageDialog(null,"So temos 12 meses no ano!");
					txtMesesTrabalhadosNoAno.setText("");
				}
			}
		});
		txtMesesTrabalhadosNoAno.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesesTrabalhadosNoAno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMesesTrabalhadosNoAno.setColumns(10);
		txtMesesTrabalhadosNoAno.setBounds(247, 82, 110, 44);
		getContentPane().add(txtMesesTrabalhadosNoAno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 230, 352, 482);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		
		textArea.setText("");
		
		
		String linha = pessoa.localizar(codigo);
		
		String  nome,cpf,rg,dataNascimento,salario,dataAdmissao,dataDemissao,tempoDeTrabalho;
		
		codigo = jc.pegarCodigo(linha);		
		nome = jc.pegarNome(linha);
		cpf = jc.pegarCpf(linha);
		rg = jc.pegarRg(linha);
		dataNascimento = jc.pegarDataNascimento(linha);
		salario = jc.pegarSalario(linha);
		dataAdmissao = jc.pegarDataAdmissao(linha);
		dataDemissao = jc.pegarDataDemissao(linha);
		tempoDeTrabalho = jc.pegarTempoDeTrabalho(linha);
		
		textArea.append("\nCodigo: "+codigo+ "\n\nNome: "+nome + "\n\nCpf: "+ cpf
				+ "\n\nRg: " + rg + "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: "
				+ salario + "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
				+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});
		
		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				textArea.setText("");
								
				String linha = pessoa.localizar(txtCodigo.getText());
				
				String  nome,cpf,rg,dataNascimento,salario,dataAdmissao,dataDemissao,tempoDeTrabalho;
									
				nome = jc.pegarNome(linha);
				cpf = jc.pegarCpf(linha);
				rg = jc.pegarRg(linha);
				dataNascimento = jc.pegarDataNascimento(linha);
				salario = jc.pegarSalario(linha);
				dataAdmissao = jc.pegarDataAdmissao(linha);
				dataDemissao = jc.pegarDataDemissao(linha);
				tempoDeTrabalho = jc.pegarTempoDeTrabalho(linha);
				
				textArea.append("\nCodigo: "+txtCodigo.getText()+ "\n\nNome: "+nome + "\n\nCpf: "+ cpf
						+ "\n\nRg: " + rg + "\n\nDataNascimento: " + dataNascimento + "\n\nSalario: "
						+ salario + "\n\nData de Admissão: " + dataAdmissao + "\n\nData de Demissão: " + dataDemissao
						+ "\n\nTempo de Trabalho: " + tempoDeTrabalho);
			}
		});
			
						
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			lblCodigo.setBounds(25, 21, 65, 20);
			getContentPane().add(lblCodigo);
		
			txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(87, 14, 270, 45);
			getContentPane().add(txtCodigo);
			txtCodigo.setText(codigo);
		btnVoltar.setIcon(new ImageIcon(TelaJustaCausa.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1093, 667, 80, 45);
		getContentPane().add(btnVoltar);
		
		JScrollPane resultado = new JScrollPane();
		resultado.setBounds(404, 230, 343, 482);
		getContentPane().add(resultado);
		
		JTextArea result = new JTextArea();
		result.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		resultado.setViewportView(result);
		result.setEditable(false);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				int dias = Integer.parseInt(txtDiasDeTrabalho.getText());
				double money = Double.parseDouble(salario); // Salario
				
				double salarioProporcional =  jc.salarioProporcional(money,dias); // Salario proporcional
				salarioProporcional *=dias;
				
				double numeroDeSalarioVencidos = Integer.parseInt(comboNumSal.getSelectedItem().toString());
				double vencido = money * numeroDeSalarioVencidos;// Salario Vencido
				
				int mesesTrabalhadosNoAno = Integer.parseInt(txtMesesTrabalhadosNoAno.getText());
				double feriasProporcional = jc.feriasProporcionais(money, mesesTrabalhadosNoAno);
				
				
				
				double total = vencido + salarioProporcional + feriasProporcional; // Total =salario vencido +  salario proporcional + ferias vencidas
				
			result.append("Nome:"+nome+"\nSalario: R$"+String.format("%.2f",money)+
					"\n\nTotal em Salarios vencidos a ser pagos: "+comboNumSal.getSelectedItem().toString()+
					"\nSalarios Vencidos"+"  R$"+String.format("%.2f",vencido)+
					"\n\nSalario Proporcional a Receber: Meses trabalhados no Mês "+dias+ "\n  R$"+String.format("%.2f",salarioProporcional)+
					"\n\nFerias Proporcional: "+mesesTrabalhadosNoAno+" Meses"+"\n  R$"+feriasProporcional+
					"\n\nFerias Vencidas: "+txtFeriasVencidas.getText()+" Ferias"+"\n  R$"+(money*Integer.parseInt(txtFeriasVencidas.getText()))+
					"\n\nValor total a receber:  R$"+String.format("%.2f",total));
			}
		});
		btnCalcular.setIcon(new ImageIcon(TelaJustaCausa.class.getResource("/imagen/btnconfirma.png")));
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(757, 242, 80, 45);
		getContentPane().add(btnCalcular);
		
		JButton btnConfirma = new JButton("");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jc.escreverCalculo(result.getText(),nome);
				
				String linha = pessoa.localizar(txtCodigo.getText());
				
				
				String nome = jc.pegarNome(linha);
				
				String salario = jc.pegarSalario(linha);
				
				if(txtCodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Preencher o campo CODIGO! ");
				}else if(txtDiasDeTrabalho.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Preencher o campo DIAS TRABALHADO! ");
				}else if (comboNumSal.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null,"Selecionar o campo SALARIO VENCIDOS! ");
				}else if (txtMesesTrabalhadosNoAno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Preencher o campo MESES TRABALHADOS NO ANO! ");
				}
				else {					

							String texto = result.getText().toString();
					jc.escreverCalculo(texto, nome);
				
				}
				
			}
		});
		btnConfirma.setIcon(new ImageIcon(TelaJustaCausa.class.getResource("/imagen/confirma.png")));
		btnConfirma.setBorder(null);
		btnConfirma.setBackground(new Color(250, 240, 230));
		btnConfirma.setBounds(893, 587, 190, 125);
		getContentPane().add(btnConfirma);
		
		JLabel lblFeriasVencidas = new JLabel("Numero de Ferias Vencidas: ");
		lblFeriasVencidas.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblFeriasVencidas.setBounds(391, 96, 231, 20);
		getContentPane().add(lblFeriasVencidas);
		
		txtFeriasVencidas = new JTextField();
		txtFeriasVencidas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int feriasVencidas = Integer.parseInt(txtFeriasVencidas.getText());
				if(feriasVencidas<0) {
					JOptionPane.showMessageDialog(null,"Valor negativo! ");
					txtFeriasVencidas.setText("");
				
			}
			}
		});
		txtFeriasVencidas.setHorizontalAlignment(SwingConstants.CENTER);
		txtFeriasVencidas.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtFeriasVencidas.setColumns(10);
		txtFeriasVencidas.setBounds(617, 82, 141, 45);
		getContentPane().add(txtFeriasVencidas);
	}
}
