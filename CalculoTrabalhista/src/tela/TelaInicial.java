package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import controle.Pessoa;

public class TelaInicial extends JFrame {
	static Frame inicio;
	static JInternalFrame atual = null, anterior = null;
	private JPanel contentPane;
	private String caminho = "C:\\CalculoTrabalhista\\ACESSO RESTRITO\\calculoTrabalhista.txt";
	public JDesktopPane desktopPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					inicio = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {

		Pessoa pessoa = new Pessoa();
		// cria arquivo e verifica
		pessoa.verificarArquivoTxt(caminho);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(250, 240, 230));
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JButton btnCadastrarPessoa = new JButton("");
		btnCadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String senha;
					senha = JOptionPane.showInputDialog("Digite a senha!");
					if (senha.equals("admin") || senha.equals("Admin") || senha.equals("ADMIN")) {
						TelaCadastrarPessoa cp = new TelaCadastrarPessoa(inicio);
						((BasicInternalFrameUI) cp.getUI()).setNorthPane(null);
						cp.setBorder(null);
						desktopPane.add(cp);

						atual = cp;
						atual.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Cadastrar Pessoa! " + e4);
				}

			}
		});
		btnCadastrarPessoa.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagen/Pessoa.png")));
		btnCadastrarPessoa.setBorder(null);
		btnCadastrarPessoa.setBackground(new Color(250, 240, 230));
		btnCadastrarPessoa.setBounds(65, 99, 300, 250);
		desktopPane.add(btnCadastrarPessoa);

		JButton btnLocalizarPessoa = new JButton("");
		btnLocalizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

						TelaLocalizarPessoa lp = new TelaLocalizarPessoa(inicio);
						((BasicInternalFrameUI) lp.getUI()).setNorthPane(null);
						lp.setBorder(null);
						desktopPane.add(lp);
						anterior = atual;
						atual = lp;
						atual.setVisible(true);
				
				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Localizar Pessoa! " + e5);
				}

			}
		});
		btnLocalizarPessoa.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagen/Lupa.png")));
		btnLocalizarPessoa.setBorder(null);
		btnLocalizarPessoa.setBackground(new Color(250, 240, 230));
		btnLocalizarPessoa.setBounds(406, 99, 300, 250);
		desktopPane.add(btnLocalizarPessoa);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCalculoInicio calculo = new TelaCalculoInicio(inicio);
				((BasicInternalFrameUI) calculo.getUI()).setNorthPane(null);
				calculo.setBorder(null);

				desktopPane.add(calculo);

				anterior = atual;
				atual = calculo;
				atual.setVisible(true);
			}
		});
		btnCalcular.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagen/localizarPessoaLogo.png")));
		btnCalcular.setBorder(null);
		btnCalcular.setBackground(new Color(250, 240, 230));
		btnCalcular.setBounds(406, 393, 300, 250);
		desktopPane.add(btnCalcular);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagen/BalancaDaJusticaLogoP.png")));
		lblLogo.setBounds(794, 31, 380, 396);
		desktopPane.add(lblLogo);
		JButton btnDeletarPessoa = new JButton("");
		btnDeletarPessoa.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagen/deletarPessoaIni.png")));
		btnDeletarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha;

				senha = JOptionPane.showInputDialog("Digite a senha!");
				if (senha.equals("admin") || senha.equals("Admin") || senha.equals("ADMIN")) {
					TelaDeletarPessoa deletar = new TelaDeletarPessoa(inicio);

					((BasicInternalFrameUI) deletar.getUI()).setNorthPane(null);
					deletar.setBorder(null);

					desktopPane.add(deletar);

					anterior = atual;
					atual = deletar;
					atual.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Senha invalida!");
				}
			}
		});
		btnDeletarPessoa.setBorder(null);
		btnDeletarPessoa.setBackground(new Color(250, 240, 230));
		btnDeletarPessoa.setBounds(65, 393, 300, 250);
		desktopPane.add(btnDeletarPessoa);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);

		JMenuItem mntmInserirPessoa = new JMenuItem("Inserir Pessoa");
		mnAdmin.add(mntmInserirPessoa);

		JMenuItem mntmLocalizarPessoa = new JMenuItem("Localizar Pessoa");
		mnAdmin.add(mntmLocalizarPessoa);

		JMenuItem mntmAlterarPessoa = new JMenuItem("Alterar Pessoa");
		mnAdmin.add(mntmAlterarPessoa);

		JMenuItem mntmDeletarPessoa = new JMenuItem("Deletar Pessoa");
		mnAdmin.add(mntmDeletarPessoa);

		JMenu mnPessoa = new JMenu("Usuario");
		menuBar.add(mnPessoa);

		JMenu mnCalcular = new JMenu("Calcular");
		mnPessoa.add(mnCalcular);

		JMenuItem mntmDemisso = new JMenuItem("Demissão");
		mntmDemisso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String codigo = JOptionPane.showInputDialog(null, "Digite o codigo!");

					TelaDemissao td = new TelaDemissao(inicio, codigo);

					((BasicInternalFrameUI) td.getUI()).setNorthPane(null);
					td.setBorder(null);

					desktopPane.add(td);
					atual = td;
					atual.setVisible(true);

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Demissão! " + e3);
				}
			}
		});

		JMenuItem mntmDespedido = new JMenuItem("Despedido");
		mntmDespedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo = JOptionPane.showInputDialog(null, "Digite o codigo!");
					if (codigo.isEmpty()) {

					} else {
						TelaDespedido dp = new TelaDespedido(inicio, codigo);

						((BasicInternalFrameUI) dp.getUI()).setNorthPane(null);
						dp.setBorder(null);

						desktopPane.add(dp);
						atual = dp;
						atual.setVisible(true);
					}
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Despedido! " + e4);
				}
			}
		});
		mnCalcular.add(mntmDespedido);
		mnCalcular.add(mntmDemisso);

		JMenuItem mntmJustaCausa = new JMenuItem("Justa Causa");
		mntmJustaCausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String codigo = JOptionPane.showInputDialog(null, "Digite o codigo!");
					if (codigo.isEmpty()) {

					} else {
						TelaJustaCausa jc = new TelaJustaCausa(inicio, codigo);

						((BasicInternalFrameUI) jc.getUI()).setNorthPane(null);
						jc.setBorder(null);

						desktopPane.add(jc);
						atual = jc;
						atual.setVisible(true);
					}
				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Justa Causa! " + e5);
				}
			}
		});
		mnCalcular.add(mntmJustaCausa);
		
		JMenuItem mntmCulpaReciproca = new JMenuItem("Culpa Reciproca");
		mntmCulpaReciproca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String codigo = JOptionPane.showInputDialog(null, "Digite o codigo!");
					if (codigo.isEmpty()) {

					} else {
						TelaCulpaReciproca crp = new TelaCulpaReciproca(inicio, codigo);

						((BasicInternalFrameUI) crp.getUI()).setNorthPane(null);
						crp.setBorder(null);

						desktopPane.add(crp);
						atual = crp;
						atual.setVisible(true);
					}
				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Justa Causa! " + e5);
				}
			
				
			}
		});
		mnCalcular.add(mntmCulpaReciproca);
		
		JMenuItem menuLocalizarPessoa = new JMenuItem("Localizar Pessoa");
		menuLocalizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLocalizarPessoa lp = new TelaLocalizarPessoa(inicio);
				((BasicInternalFrameUI) lp.getUI()).setNorthPane(null);
				lp.setBorder(null);
				desktopPane.add(lp);
				anterior = atual;
				atual = lp;
				atual.setVisible(true);
			}
		
		});
		mnPessoa.add(menuLocalizarPessoa);
		mntmDeletarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String senha;
					senha = JOptionPane.showInputDialog("Digite a senha!");
					if (senha.equals("admin") || senha.equals("Admin") || senha.equals("ADMIN")) {
						TelaDeletarPessoa deletar = new TelaDeletarPessoa(inicio);

						((BasicInternalFrameUI) deletar.getUI()).setNorthPane(null);
						deletar.setBorder(null);

						desktopPane.add(deletar);

						anterior = atual;
						atual = deletar;
						atual.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para Tela Deletar! " + e2);
				}
			}
		});
		mntmAlterarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String senha;
					senha = JOptionPane.showInputDialog("Digite a senha!");
					if (senha.equals("admin") || senha.equals("Admin") || senha.equals("ADMIN")) {
						TelaAlterarPessoa ap = new TelaAlterarPessoa(inicio);

						((BasicInternalFrameUI) ap.getUI()).setNorthPane(null);
						ap.setBorder(null);

						desktopPane.add(ap);
						anterior = atual;
						atual = ap;
						atual.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Alterar Pessoa! " + e1);
				}

			}
		});
		mntmLocalizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						TelaLocalizarPessoa lp = new TelaLocalizarPessoa(inicio);
						((BasicInternalFrameUI) lp.getUI()).setNorthPane(null);
						lp.setBorder(null);
						desktopPane.add(lp);
						anterior = atual;
						atual = lp;
						atual.setVisible(true);
			}
		});
		mntmInserirPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String senha;
					senha = JOptionPane.showInputDialog("Digite a senha!");
					if (senha.equals("admin") || senha.equals("Admin") || senha.equals("ADMIN")) {
						TelaCadastrarPessoa cp = new TelaCadastrarPessoa(inicio);
						((BasicInternalFrameUI) cp.getUI()).setNorthPane(null);
						cp.setBorder(null);
						desktopPane.add(cp);

						atual = cp;
						atual.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "Erro ao ir para tela Cadastrar Pessoa! " + e4);
				}
			}
		});

	}
}