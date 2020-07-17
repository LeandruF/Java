package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import controle.Pessoa;

public class TelaAlterarPessoa extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtSalario;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtRg;
	private JInternalFrame atual;
	private JTextField txtCodigo;
	//private JLabel lblNome,lblSalario,lblRg,lblCpf,lblCodigo,lblDataDeNascimento,lblDataDeAdmissao,lblDataDeDemissao;
	private JDateChooser dataDeNascimento,dataDeDemissao,dataDeAdmissao;
	private JTextField txtDiferencaAnoMes;
	private MaskFormatter mCpf, mRg; 
	static  JInternalFrame  internalAnterior=null;
	
	public TelaAlterarPessoa(Frame inicio) {
		Pessoa pessoa = new Pessoa();
		
		
		
		
		try {
			mCpf = new MaskFormatter("###.###.###-##");
			mRg = new MaskFormatter("##.###.###-#");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		getContentPane().setBackground(new Color(250, 240, 230));
		setBounds(0, 0, 1200, 800);
		getContentPane().setLayout(null);
		
		JDateChooser dataAdmissao = new JDateChooser();
		dataAdmissao.setBounds(385, 289, 200, 60);
		getContentPane().add(dataAdmissao);
		
		JDateChooser dataDemissao = new JDateChooser();
		dataDemissao.setBounds(385, 392, 200, 60);
		getContentPane().add(dataDemissao);
		
		JDateChooser dataNascimento = new JDateChooser();
		dataNascimento.setBounds(38, 479, 200, 60);
		getContentPane().add(dataNascimento);
		
		txtNome = new JTextField();
		txtNome.setText(" ");
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNome.setColumns(10);
		txtNome.setBounds(38, 156, 509, 60);
		getContentPane().add(txtNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblNome.setBounds(38, 125, 103, 20);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCpf.setBounds(38, 227, 103, 20);
		getContentPane().add(lblCpf);
		
		txtCpf = new JFormattedTextField(mCpf);
		txtCpf.setText(" ");
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCpf.setColumns(10);
		txtCpf.setBounds(38, 258, 256, 60);
		getContentPane().add(txtCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblRg.setBounds(38, 329, 103, 20);
		getContentPane().add(lblRg);
		
		txtRg = new JFormattedTextField(mRg);
		txtRg.setText(" ");
		txtRg.setHorizontalAlignment(SwingConstants.CENTER);
		txtRg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRg.setColumns(10);
		txtRg.setBounds(38, 360, 256, 60);
		getContentPane().add(txtRg);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeNascimento.setBounds(38, 448, 190, 20);
		getContentPane().add(lblDataDeNascimento);
		
		txtSalario = new JTextField();
		txtSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSalario.setColumns(10);
		txtSalario.setBounds(38, 607, 287, 60);
		getContentPane().add(txtSalario);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSalario.setBounds(38, 564, 103, 20);
		getContentPane().add(lblSalario);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaAlterarPessoa.class.getResource("/imagen/TelaCalculoInicio.png")));
		lblLogo.setBounds(793, 11, 381, 392);
		getContentPane().add(lblLogo);
		
		JLabel lblDataDeDemissao = new JLabel("Data de Demiss\u00E3o:");
		lblDataDeDemissao.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeDemissao.setBounds(385, 361, 159, 20);
		getContentPane().add(lblDataDeDemissao);
		
		JLabel lblDataDeAdmissao = new JLabel("Data de Adimiss\u00E3o:");
		lblDataDeAdmissao.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeAdmissao.setBounds(385, 258, 159, 20);
		getContentPane().add(lblDataDeAdmissao);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		
		lblCodigo.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCodigo.setBounds(38, 59, 65, 20);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();				
		txtCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String linha=pessoa.localizar(txtCodigo.getText());
				txtNome.setText(pessoa.pegarNome(linha));
				txtCpf.setText(pessoa.pegarCpf(linha));
				txtRg.setText(pessoa.pegarRg(linha));
				//pessoa.pegarDataNascimento(linha);
				txtSalario.setText(pessoa.pegarSalario(linha));
				//pessoa.pegarDataAdmissao(linha);
				//pessoa.pegarDataDemissao(linha);
				//pessoa.pegarTempoDeTrabalho(linha);
				
			}
		});
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(113, 38, 287, 60);
		getContentPane().add(txtCodigo);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaAlterarPessoa.class.getResource("/imagen/voltar.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atual.dispose();
			}
		});
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1062, 671, 80, 45);
		getContentPane().add(btnVoltar);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			
				pessoa.alterarPessoa(txtCodigo.getText(), txtNome.getText(), txtCpf.getText(), txtRg.getText(), dataNascimento.getDate(), 
					 txtSalario.getText(),dataAdmissao.getDate(),dataDemissao.getDate(),txtDiferencaAnoMes.getText()) ;
				
							
				
			}
			
		});
		btnAlterar.setIcon(new ImageIcon(TelaAlterarPessoa.class.getResource("/imagen/alterar.png")));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(250, 240, 230));
		btnAlterar.setBounds(842, 591, 190, 125);
		getContentPane().add(btnAlterar);
		
		txtDiferencaAnoMes = new JTextField();
		txtDiferencaAnoMes.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiferencaAnoMes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiferencaAnoMes.setColumns(10);
		txtDiferencaAnoMes.setBounds(356, 479, 287, 60);
		getContentPane().add(txtDiferencaAnoMes);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diferença = pessoa.calcularDias(dataAdmissao.getDate(), dataDemissao.getDate());
				txtDiferencaAnoMes.setText(diferença);
			}
		});
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(629, 360, 90, 60);
		getContentPane().add(btnCalcular);

		atual = this;
	}
}
