package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import controle.Pessoa;

public class TelaLocalizarPessoa extends JInternalFrame {
	private JInternalFrame atual;

	
	public TelaLocalizarPessoa(Frame inicio) {
	
		 String caminho = "C:\\CalculoTrabalhista\\ACESSO RESTRITO\\calculoTrabalhista.txt";
		Pessoa pessoa = new Pessoa();
	
		JInternalFrame janela = new JInternalFrame();
		((BasicInternalFrameUI)janela.getUI()).setNorthPane(null);
		
		
		getContentPane().setBackground(new Color(250, 240, 230));
		
		setBounds(0, 0, 1200, 800);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 46, 755, 664);
		getContentPane().add(scrollPane);
		
		JTextArea textResultados = new JTextArea();
		textResultados.setEditable(false);
		textResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(textResultados);
		

		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLocalizarPessoa.class.getResource("/imagen/BalancaDaJusticaLogoP.png")));
		lblLogo.setBounds(793, 11, 381, 392);
		getContentPane().add(lblLogo);
		
		JButton btnLocaliza = new JButton("");
		btnLocaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					textResultados.setText("");
					BufferedReader br = new BufferedReader(new FileReader(caminho));
					String linha;
					
					while(br.ready()) {
						linha = br.readLine();
						String.format("%-40.20s", linha);
						textResultados.append(linha+"\n");
					}
					br.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao imprimir!");
				}
			}
		});
		btnLocaliza.setIcon(new ImageIcon(TelaLocalizarPessoa.class.getResource("/imagen/LupaLocalizar.png")));
		btnLocaliza.setBorder(null);
		btnLocaliza.setBackground(new Color(250, 240, 230));
		btnLocaliza.setBounds(819, 585, 190, 125);
		getContentPane().add(btnLocaliza);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaLocalizarPessoa.class.getResource("/imagen/voltar.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1042, 665, 80, 45);
		getContentPane().add(btnVoltar);
		
		JLabel lblCodigoNome = new JLabel("Codigo | Nome | Cpf  | Rg | Data De Nascimento | Salario | Admissao | Demiss\u00E3o | Tempo Trabalhado");
		lblCodigoNome.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCodigoNome.setBounds(25, 11, 770, 24);
		getContentPane().add(lblCodigoNome);
		
		

		atual=this;
	}

}
