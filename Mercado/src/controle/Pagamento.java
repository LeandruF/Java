package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import telas.FinalizarVendas;

public class Pagamento {
	
private String subTotal,tipoPagamento;

String caminho="D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\registraPagamento.txt";

public String getSubTotal() {
	return subTotal;
}

public void setSubTotal(String subTotal) {
	this.subTotal = subTotal;
}

public String getTipoPagamento() {
	return tipoPagamento;
}

public void setTipoPagamento(String tipoPagamento) {
	this.tipoPagamento = tipoPagamento;
}
public void verificarArquivo() {
	try {
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		File arquivo = new File(caminho);
		if(arquivo.exists()) {
			// coloquei o display da msg assim pra nao ficar enchendo de janela e dar um feedback
			System.out.println("Arquivo localizado! ");
			if(br.ready()) {

			}else {				

					BufferedWriter bw = new BufferedWriter(new FileWriter(caminho,true));
					bw.write("Valor |  Tipo de Pagamento");
					bw.newLine();
					bw.close();
				}
			}
			
		 else if (arquivo.createNewFile()) {
			System.out.println("Arquivo criado com sucesso! ");
		}else {
			System.out.println("ERRO ao criar o arquivo! ");
		}
		br.close();
	}catch(Exception e) {
	JOptionPane.showMessageDialog(null, "ERRO! ");	
	}	
	}

public void salvarArquivo(String subTotal,String tipoPagamento) {
	try {
		//FileWriter fw = new FileWriter(caminho,true);
			Produto p = new Produto();
			p.verificarArquivo();
		BufferedWriter bw = new BufferedWriter(new FileWriter(caminho,true));
		bw.write(subTotal+"|"+tipoPagamento);
		bw.newLine();
		bw.close();
		JOptionPane.showMessageDialog(null,"Pagamento realizado com " +tipoPagamento+", no valor de R$"+subTotal+"! ");
		}
		catch(Exception e) {
			JOptionPane.showInputDialog(null, "ERRO! ");
		}
}
}
