package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class Caixa extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricaoProduto;
	private JTextField txtValorProduto;
	private JTextField txtQuantidade;
	private JFormattedTextField txtCodigo;
	private JTextField txtSubTotal;
	private MaskFormatter mCodigo;
	String codigoAchado, produtoAchado, valorAchado;
	double total;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caixa frame = new Caixa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Caixa() {
		try {
			mCodigo = new MaskFormatter("###");

		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		setTitle("Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(565, 184, 609, 555);
				contentPane.add(scrollPane);
				
						JTextArea txtAreaLista = new JTextArea();
						txtAreaLista.setFont(new Font("Monospaced", Font.PLAIN, 14));
						scrollPane.setViewportView(txtAreaLista);

		JLabel lblDescricaoproduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblDescricaoproduto.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblDescricaoproduto.setBounds(21, 29, 263, 25);
		contentPane.add(lblDescricaoproduto);

		txtDescricaoProduto = new JTextField();
		txtDescricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescricaoProduto.setEditable(false);
		txtDescricaoProduto.setBounds(10, 65, 448, 70);
		contentPane.add(txtDescricaoProduto);
		txtDescricaoProduto.setColumns(10);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblValor.setBounds(281, 146, 151, 29);
		contentPane.add(lblValor);

		txtValorProduto = new JTextField();
		txtValorProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtValorProduto.setEditable(false);
		txtValorProduto.setBounds(291, 186, 180, 38);
		contentPane.add(txtValorProduto);
		txtValorProduto.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblQuantidade.setBounds(364, 246, 151, 36);
		contentPane.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtQuantidade.setText("1");
		txtQuantidade.setBounds(400, 310, 120, 80);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JLabel lblX = new JLabel(" X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblX.setBounds(325, 310, 36, 48);
		contentPane.add(lblX);

		JLabel lblCodigoDoProduto = new JLabel("Codigo do Produto");
		lblCodigoDoProduto.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblCodigoDoProduto.setBounds(21, 231, 220, 40);
		contentPane.add(lblCodigoDoProduto);

		txtCodigo = new JFormattedTextField(mCodigo);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtCodigo.setBounds(37, 310, 120, 80);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnIncluirItem = new JButton("Incluir Item na Lista");
		btnIncluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caminho = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProduto.txt";
				String codigoAchado, produtoAchado, valorAchado,linha;
				double subTotal,quantidade,valorProduto;
				try {
					FileReader fr = new FileReader(caminho);
					BufferedReader br = new BufferedReader(fr);
					while(br.ready()) {
						
						linha = br.readLine();
						
						codigoAchado = linha.substring(0, linha.indexOf("|"));
						linha = linha.substring(linha.indexOf("|") + 1);

						produtoAchado = linha.substring(0, linha.indexOf("|"));
						linha = linha.substring(linha.indexOf("|") + 1);

						valorAchado = linha.substring(0);
						
						if(codigoAchado.equals(txtCodigo.getText())) {
							//Codigo    /     Produto    /   Quantidade   /    ValorUni  /   Valor Total
							quantidade = Double.parseDouble(txtQuantidade.getText());				 
							valorProduto = Double.parseDouble(valorAchado);
							subTotal=valorProduto*quantidade;
							total=subTotal+total;
							
							String.valueOf(valorAchado);
							
							
							txtAreaLista.append("Cod:"+codigoAchado+"  "+"Produto:"+produtoAchado+"  "+"Quantidade:"+txtQuantidade.getText()+"  "+"Valor uni:"+"R$"+valorAchado+"  "+"Total:"+"R$"+subTotal+"\n");
//							try {
//								FileReader = new FileReader(caminho);
//								BufferedReader br = new BufferedReader(new FileReader());
//							}catch(exception e)
//							System.out.println(e);
						}
						txtSubTotal.setText("R$"+String.valueOf(total));
					}					
					br.close();
				}catch(IOException e1) {
					JOptionPane.showMessageDialog(null,"ERRO!");
				}
				
//				txtQuantidade.getText();
//				 quantidade = Double.parseDouble(txtQuantidade.getText());				 
//				 
//				 valorProduto = Double.parseDouble(valorAchado);
//				 
//				 subTotal=valorProduto*quantidade;				
				 //Double.toString(subTotal);
				 // OU
				// txtSubTotal.setText(String.valueOf(subTotal));
				// txtSubTotal.setText(Double.toString(subTotal));
				 //txtAreaLista.append(String.valueOf(subTotal));
				 
			}
		});
		
				JButton btnLocalizarProduto = new JButton("Localizar Produto");
				btnLocalizarProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String caminho = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProduto.txt";
							//FileReader fr = new FileReader(caminho);
							BufferedReader br = new BufferedReader(new FileReader(caminho));

							
							String codigo=txtCodigo.getText();
							String codigoAchado, produtoAchado, valorAchado,linha;
							if (codigo.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Codigo esta vazio, favor preencher");
							} else {
								while (br.ready()) {

									linha = br.readLine();
									
									codigoAchado = linha.substring(0, linha.indexOf("|"));
									linha = linha.substring(linha.indexOf("|") + 1);

									produtoAchado = linha.substring(0, linha.indexOf("|"));
									linha = linha.substring(linha.indexOf("|") + 1);

									valorAchado = linha.substring(0);

									if (codigo.equals(codigoAchado)) {
										
										txtCodigo.setText(codigoAchado);
										txtDescricaoProduto.setText(produtoAchado);
										txtValorProduto.setText(valorAchado);
										
									}
								}
							}

							br.close();

						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "ERRO!");
						}	

					}
				});
				btnLocalizarProduto.setBackground(Color.GREEN);
				btnLocalizarProduto.setBounds(174, 310, 120, 80);
				contentPane.add(btnLocalizarProduto);
		btnIncluirItem.setBackground(Color.CYAN);
		btnIncluirItem.setBounds(295, 413, 180, 60);
		contentPane.add(btnIncluirItem);

		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.setBackground(Color.GREEN);
		btnFinalizarCompra.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Total: R$"+total);
				FinalizarVendas fv = new FinalizarVendas(txtSubTotal.getText());
				
				fv.show();
			}
		});
		btnFinalizarCompra.setBounds(325, 526, 150, 90);
		contentPane.add(btnFinalizarCompra);

		JButton btnCancelarCompras = new JButton("Cancelar Compras");
		btnCancelarCompras.setBackground(Color.RED);
		btnCancelarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = JOptionPane.showInputDialog(null, "Digite a senha!");
				if (senha.equals("12345")) {

					txtCodigo.setText("");
					txtValorProduto.setText("");
					txtSubTotal.setText("");
					txtDescricaoProduto.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Senha invalida!");
				}
			}
		});
		btnCancelarCompras.setBounds(21, 425, 150, 90);
		contentPane.add(btnCancelarCompras);

		JButton btnCancelarItem = new JButton("Cancelar Item");
		btnCancelarItem.setBackground(Color.ORANGE);
		btnCancelarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelarItem.setBounds(21, 526, 150, 90);
		contentPane.add(btnCancelarItem);

		JButton btnLimparItem = new JButton("Limpar Item");
		btnLimparItem.setBackground(Color.YELLOW);
		btnLimparItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setText("");
				txtDescricaoProduto.setText("");
				txtValorProduto.setText("");
			}
		});
		btnLimparItem.setBounds(21, 649, 150, 90);
		contentPane.add(btnLimparItem);

		JLabel lblSubtotal = new JLabel("SubTotal: ");
		lblSubtotal.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblSubtotal.setBounds(715, 17, 133, 48);
		contentPane.add(lblSubtotal);

		txtSubTotal = new JTextField();
		txtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(858, 11, 316, 48);
		contentPane.add(txtSubTotal);

		JLabel lblListaDeCompras = new JLabel("Lista de Compras");
		lblListaDeCompras.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblListaDeCompras.setBounds(557, 81, 206, 27);
		contentPane.add(lblListaDeCompras);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarProdutos cp = new CadastrarProdutos();
				cp.show();
			}
		});
		btnCadastrarProduto.setBackground(Color.PINK);
		btnCadastrarProduto.setBounds(325, 649, 150, 90);
		contentPane.add(btnCadastrarProduto);

		JLabel lblCodigo = new JLabel("Codigo    /     Produto    /   Quantidade   /    ValorUni  /   Valor Total");
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCodigo.setBounds(557, 119, 617, 29);
		contentPane.add(lblCodigo);
	}
}
