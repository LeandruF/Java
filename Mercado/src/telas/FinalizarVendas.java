package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Pagamento;

public class FinalizarVendas extends JFrame {

	private JPanel contentPane;
	private JTextField txtTotal;
	String caminho = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\registraPagamento.txt";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FinalizarVendas frame = new FinalizarVendas();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FinalizarVendas(String valor) {
		setTitle("Finalizar Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSubtotal = new JLabel("Total: ");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSubtotal.setBounds(25, 102, 92, 24);
		contentPane.add(lblSubtotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setBounds(127, 101, 216, 32);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setText(valor);
		
		

		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento");
		lblTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTipoPagamento.setBounds(25, 143, 216, 24);
		contentPane.add(lblTipoPagamento);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Cart\u00E3o de Debito", "Cart\u00E3o de Credito", "Vale", "Outros"}));
		comboBox.setBounds(27, 178, 214, 32);
		contentPane.add(comboBox);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pagamento p = new Pagamento();
				p.verificarArquivo();
				p.salvarArquivo(txtTotal.getText(), comboBox.getSelectedItem().toString());
				Caixa cx = new Caixa();
				cx.show();

			}

		});
		btnFinalizar.setBackground(Color.GREEN);
		btnFinalizar.setBounds(60, 252, 250, 90);
		contentPane.add(btnFinalizar);

		JLabel lblFinalizarVenda = new JLabel("Finalizar Venda");
		lblFinalizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFinalizarVenda.setBounds(160, 25, 299, 47);
		contentPane.add(lblFinalizarVenda);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = JOptionPane.showInputDialog(null, "Digite a senha!");
				if(senha.equals("12345")) {
					txtTotal.setText("");
					Caixa cx = new Caixa();
					cx.show();
				}else {
					JOptionPane.showMessageDialog(null,"Senha invalida!");
				}
			}
		});
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(356, 252, 250, 90);
		contentPane.add(btnCancelar);
	}
}
