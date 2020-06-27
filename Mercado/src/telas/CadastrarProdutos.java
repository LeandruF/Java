package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.Produto;

public class CadastrarProdutos extends JFrame {

	private JPanel panel;
	private JFormattedTextField txtCodigoProduto;
	private JTextField txtDescricaoProduto;
	private JTextField txtValor;
	private JButton btnSalvar;
	private JButton btnLocalizar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JLabel lblCadastrarProduto;
	String caminho ="D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProduto.txt";
	//String caminhoTemp ="D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProdutoTemp.txt";
	private MaskFormatter mCodigoProduto;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastrarProdutos frame = new CadastrarProdutos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public CadastrarProdutos() {
		try {
			mCodigoProduto = new MaskFormatter("###");

		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		setTitle("Cadastrar Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 529);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JLabel lblDescricaoProduto = new JLabel("Descr do Produto:");
		lblDescricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescricaoProduto.setBounds(10, 184, 248, 30);
		panel.add(lblDescricaoProduto);

		txtDescricaoProduto = new JTextField();
		txtDescricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescricaoProduto.setColumns(10);
		txtDescricaoProduto.setBounds(217, 186, 384, 30);
		panel.add(txtDescricaoProduto);

		JLabel lblCodigoProduto = new JLabel("Codigo do Produto:");
		lblCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCodigoProduto.setBounds(22, 121, 236, 30);
		panel.add(lblCodigoProduto);

		txtCodigoProduto = new JFormattedTextField(mCodigoProduto);
		txtCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoProduto.setBounds(243, 123, 358, 30);
		panel.add(txtCodigoProduto);

		txtCodigoProduto.setColumns(10);
		panel.add(txtCodigoProduto);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblValor.setBounds(124, 238, 89, 30);
		panel.add(lblValor);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValor.setColumns(10);
		txtValor.setBounds(195, 244, 248, 30);
		panel.add(txtValor);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				p.verificarArquivo();
				p.salvarArquivo(txtCodigoProduto.getText(), txtDescricaoProduto.getText(), txtValor.getText());
				txtCodigoProduto.setText("");
				txtDescricaoProduto.setText("");
				txtValor.setText("");

			}
		});
		btnSalvar.setBounds(10, 389, 150, 90);
		panel.add(btnSalvar);

		btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBackground(Color.ORANGE);
		btnLocalizar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					txtCodigoProduto.setText("");
					txtDescricaoProduto.setText("");
					txtValor.setText("");
					FileReader fr = new FileReader(caminho);
					BufferedReader br = new BufferedReader(fr);
					String codigoAchado, produtoAchado, valorAchado;
					// valorAchado caso queira procurar por preço futuramente
					int op;
					op = Integer.parseInt(JOptionPane.showInputDialog("Digite para 1 - codigo ou 2 - nome?"));

					switch (op) {
					case 1:
						String codigo = JOptionPane.showInputDialog("Digite o codigo!");
						
							while (br.ready()) {
								String linha = br.readLine();
								linha.substring(0, linha.indexOf("|") + 1);

								codigoAchado = linha.substring(0, linha.indexOf("|"));
								linha = linha.substring(linha.indexOf("|") + 1);

								produtoAchado = linha.substring(0, linha.indexOf("|"));
								linha = linha.substring(linha.indexOf("|") + 1);

								valorAchado = linha.substring(0);

								if (codigoAchado.equals(codigo)) {
									txtCodigoProduto.setText(codigoAchado);
									txtDescricaoProduto.setText(produtoAchado);
									txtValor.setText(valorAchado);
								}
							}
						 

						break;
					case 2:
						String descricao = JOptionPane.showInputDialog("Digite o produto!");
						while(br.ready()) {
							String linha = br.readLine();
							codigoAchado = linha.substring(0,linha.indexOf("|"));
							linha=linha.substring(0,linha.indexOf("|")+1);
							produtoAchado = linha.substring(0,linha.indexOf("|"));
							linha = linha.substring(0,linha.indexOf("|")+1);
							valorAchado = linha.substring(0);
							
							if(descricao.equalsIgnoreCase(produtoAchado)) {
								txtCodigoProduto.setText(codigoAchado);
								txtDescricaoProduto.setText(produtoAchado);
								txtValor.setText(valorAchado);	
							}						
						}
						JOptionPane.showMessageDialog(null,"Produto Não localizado!");
					 break;

					default:

					}
					br.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "ERRO!");
				}
			}
		});
		btnLocalizar.setBounds(173, 389, 150, 90);
		panel.add(btnLocalizar);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.CYAN);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Produto p = new Produto();
				p.alterarProduto(caminho);
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditar.setBounds(344, 389, 150, 90);
		panel.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					Produto p = new Produto();
					p.deletarProduto(caminho);
					
			}		
		});
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnExcluir.setBounds(504, 389, 150, 90);
		panel.add(btnExcluir);

		lblCadastrarProduto = new JLabel("Cadastrar Produto");
		lblCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCadastrarProduto.setBounds(168, 37, 321, 47);
		panel.add(lblCadastrarProduto);
	}

}
