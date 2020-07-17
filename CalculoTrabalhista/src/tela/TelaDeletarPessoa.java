package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.Pessoa;


public class TelaDeletarPessoa extends JInternalFrame {
	private JTextField txtCodigo;

	private JInternalFrame atual;

	public TelaDeletarPessoa(Frame inicio) {
		getContentPane().setBackground(new Color(250, 240, 230));
		
		Pessoa pessoa = new Pessoa();
		setBounds(0, 0, 1200, 800);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 187, 538, 529);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(49, 83, 65, 20);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(124, 62, 287, 60);
		getContentPane().add(txtCodigo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaDeletarPessoa.class.getResource("/imagen/TelaCalculoInicio.png")));
		lblLogo.setBounds(793, 11, 381, 392);
		getContentPane().add(lblLogo);
		
		JButton btnDeletarPessoa = new JButton("");
		btnDeletarPessoa.setIcon(new ImageIcon(TelaDeletarPessoa.class.getResource("/imagen/deletarPessoa.png")));
		btnDeletarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoa.deletarPessoa(txtCodigo.getText());
			}
		});
		btnDeletarPessoa.setBorder(null);
		btnDeletarPessoa.setBackground(new Color(250, 240, 230));
		btnDeletarPessoa.setBounds(857, 591, 190, 125);
		getContentPane().add(btnDeletarPessoa);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaDeletarPessoa.class.getResource("/imagen/voltar.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 atual.dispose();
			}
		});
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1070, 671, 80, 45);
		getContentPane().add(btnVoltar);
		
		JButton btnLocalizarPessoa = new JButton("");
		btnLocalizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String achei = pessoa.localizar(txtCodigo.getText());
				textArea.append(achei+"\n");
				
			}
		});
		btnLocalizarPessoa.setIcon(new ImageIcon(TelaDeletarPessoa.class.getResource("/imagen/LupaLocalizar.png")));
		btnLocalizarPessoa.setBorder(null);
		btnLocalizarPessoa.setBackground(new Color(250, 240, 230));
		btnLocalizarPessoa.setBounds(623, 591, 190, 125);
		getContentPane().add(btnLocalizarPessoa);
		
		JLabel label = new JLabel("Codigo | Nome | Cpf  | Rg | Data De Nascimento | Salario | Admissao | Demiss\u00E3o | Tempo Trabalhado");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label.setBounds(50, 152, 538, 24);
		getContentPane().add(label);
		
		
		atual = this;
	}
	
}
