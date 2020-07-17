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

public class TelaCadastrarPessoa extends JInternalFrame {
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtRg;
	//private JFormattedTextField txtDataDeNascimento;
	private JTextField txtSalario;
	private JTextField txtDiferencaAnoMes;
	String caminho = "C:\\CalculoTrabalhista\\ACESSO RESTRITO\\calculoTrabalhista.txt";
	private MaskFormatter mCpf, mRg;
	private JDateChooser dateAdmissao,dateDemissao, dataNascimento;
	private JInternalFrame atual;
		
	
	public TelaCadastrarPessoa(Frame inicio) {
				
		
		Pessoa pessoa = new Pessoa();
		
		
		
		try {
			mCpf = new MaskFormatter("###.###.###-##");
			mRg = new MaskFormatter("##.###.###-#");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getContentPane().setBackground(new Color(250, 240, 230));
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastrarPessoa.class.getResource("/imagen/TelaCalculoInicio.png")));
		lblLogo.setBounds(793, 11, 381, 392);
		getContentPane().add(lblLogo);
		
		txtNome = new JTextField();
		txtNome.setText(" ");
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 62, 509, 60);
		getContentPane().add(txtNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblNome.setBounds(10, 35, 103, 20);
		getContentPane().add(lblNome);
		
		txtCpf = new JFormattedTextField(mCpf);
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 175, 287, 60);
		getContentPane().add(txtCpf);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblCpf.setBounds(10, 148, 103, 20);
		getContentPane().add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblRg.setBounds(10, 257, 103, 20);
		getContentPane().add(lblRg);
		
		txtRg = new JFormattedTextField(mRg);
		txtRg.setHorizontalAlignment(SwingConstants.CENTER);
		txtRg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRg.setColumns(10);
		txtRg.setBounds(10, 284, 287, 60);
		getContentPane().add(txtRg);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeNascimento.setBounds(10, 376, 190, 20);
		getContentPane().add(lblDataDeNascimento);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setDateFormatString("d MMM  yyyy");
		dataNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dataNascimento.setBounds(10, 403, 287, 60);
		getContentPane().add(dataNascimento);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblSalario.setBounds(10, 504, 103, 20);
		getContentPane().add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSalario.setColumns(10);
		txtSalario.setBounds(10, 531, 287, 60);
		getContentPane().add(txtSalario);
		
		JDateChooser dataAdmissao = new JDateChooser();
		dataAdmissao.setDateFormatString("d MMM  yyyy");
			dataAdmissao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dataAdmissao.setBounds(560, 89, 175, 45);
		getContentPane().add(dataAdmissao);
		
		JLabel lblDataDeAdmissao = new JLabel("Data de Adimiss\u00E3o:");
		lblDataDeAdmissao.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeAdmissao.setBounds(560, 62, 159, 20);
		getContentPane().add(lblDataDeAdmissao);
		
		JDateChooser dataDemissao = new JDateChooser();
		dataDemissao.setDateFormatString("d MMM  yyyy");
		dataDemissao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dataDemissao.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dataDemissao.setBounds(560, 220, 175, 45);
		getContentPane().add(dataDemissao);
		
		JLabel lblDataDeDemissao = new JLabel("Data de Demiss\u00E3o:");
		lblDataDeDemissao.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblDataDeDemissao.setBounds(560, 175, 159, 20);
		getContentPane().add(lblDataDeDemissao);
		
		txtDiferencaAnoMes = new JTextField();
		txtDiferencaAnoMes.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiferencaAnoMes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiferencaAnoMes.setColumns(10);
		txtDiferencaAnoMes.setBounds(416, 388, 362, 60);
		getContentPane().add(txtDiferencaAnoMes);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atual.dispose();
			}
		});
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diferença = pessoa.calcularDias(dataAdmissao.getDate(), dataDemissao.getDate());
				txtDiferencaAnoMes.setText(diferença);
			}
		});
		btnCalc.setBorder(null);
		btnCalc.setBackground(new Color(250, 240, 230));
		btnCalc.setBounds(597, 317, 90, 60);
		getContentPane().add(btnCalc);
		btnVoltar.setIcon(new ImageIcon(TelaCadastrarPessoa.class.getResource("/imagen/voltar.png")));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(250, 240, 230));
		btnVoltar.setBounds(1047, 665, 80, 45);
		getContentPane().add(btnVoltar);
		
		JButton btnConfirmar = new JButton("");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			pessoa.escreverNoArquivo(txtNome.getText().trim(), txtCpf.getValue().toString(), txtRg.getValue().toString(), dataNascimento.getDate() ,txtSalario.getText(), dataAdmissao.getDate(), dataDemissao.getDate(),txtDiferencaAnoMes.getText());
limparCampos(txtNome, txtCpf, txtRg, dataDemissao, txtSalario, dataAdmissao, dataDemissao, txtDiferencaAnoMes);

//				txtNome.setText("");
//				txtCpf.setText("");
//				txtRg.setText("");
//				dataNascimento.setToolTipText("");
//				dataAdmissao.setToolTipText("");
//				dataDemissao.setToolTipText("");
//				txtSalario.setText("");
//				txtDiferencaAnoMes.setText("");
			}
		});
		btnConfirmar.setIcon(new ImageIcon(TelaCadastrarPessoa.class.getResource("/imagen/confirma.png")));
		btnConfirmar.setBorder(null);
		btnConfirmar.setBackground(new Color(250, 240, 230));
		btnConfirmar.setBounds(803, 581, 190, 125);
		getContentPane().add(btnConfirmar);
		
	
		setBounds(0, 0, 1200, 800);

		atual=this;
	}
	static void limparCampos(JTextField txtNome,JFormattedTextField txtCpf,JFormattedTextField txtRg, JDateChooser dataNascimento,JTextField txtSalario,JDateChooser dataAdmissao,JDateChooser dataDemissao,JTextField txtDiferencaAnoMes) {
		txtNome.setText("");
		txtCpf.setText("");
		txtRg.setText("");
//		dataNascimento.setDate(0);;
//		dataAdmissao.setDate(0);;
//		dataDemissao.setDate(0);
		txtSalario.setText("");
		txtDiferencaAnoMes.setText("");
	}
}
