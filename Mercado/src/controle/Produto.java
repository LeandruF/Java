package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import telas.CadastrarProdutos;
import telas.Caixa;

public class Produto {
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private String descricao, valor;
	String caminho = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProduto.txt";
	//String caminhoTemp = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProdutoTemp.txt";

	CadastrarProdutos cp = new CadastrarProdutos();

	public void verificarArquivo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			File arquivo = new File(caminho);
			if (arquivo.exists()) {
				// coloquei o display da msg assim pra nao ficar enchendo de janela e dar um
				// feedback
				System.out.println("Arquivo localizado! ");
				if (br.ready()) {
				} else {

					BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true));
					bw.write("Cod|  Descrição Produto | Valor		");
					bw.newLine();
					bw.close();
				}
			}

			else if (arquivo.createNewFile()) {
				System.out.println("Arquivo criado com sucesso! ");
			} else {
				System.out.println("ERRO ao criar o arquivo! ");
			}
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO! ");
		}
	}

	public void salvarArquivo(String codigo, String descricaoProduto, String valor) {
		try {
			// FileWriter fw = new FileWriter(caminho,true);
			Produto p = new Produto();
			p.verificarArquivo();
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true));
			if (codigo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Codigo esta vazio");
			} else if (descricaoProduto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Descrição esta vazio");
			} else if (valor.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Valor esta vazio");
			} else {
				bw.write(codigo + "|" + descricaoProduto + "|" + valor);
				bw.newLine();
				bw.close();
				JOptionPane.showMessageDialog(null, "Produto " + descricaoProduto + " Cadastrado com Sucesso! ");
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog(null, "ERRO! ");
		}
	}

	public void localizarProduto(String codigo, String nome, String valor) {
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			String codigoAchado, produtoAchado, valorAchado, linha = br.readLine();
			// valorAchado caso queira procurar por preço futuramente
			String op;
			op = JOptionPane.showInputDialog("Digite para 1 - codigo ou 2 - nome?");
			while (br.ready()) {
				codigoAchado = linha.substring(0, linha.indexOf("|"));
				linha = linha.substring(0, linha.indexOf("|") + 1);
				produtoAchado = linha.substring(0, linha.indexOf("|"));
				linha = linha.substring(0, linha.indexOf("|") + 1);
				valorAchado = linha.substring(0);
			}
			switch (op) {
			case "1":
				codigo = JOptionPane.showInputDialog("Digite o codigo!");
				while (br.ready()) {
					codigoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(0, linha.indexOf("|") + 1);
					produtoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(0, linha.indexOf("|") + 1);
					valorAchado = linha.substring(0);

					if (codigo.equals(codigoAchado)) {

					}
				}
				JOptionPane.showMessageDialog(null, "Produto Não localizado!");

				break;
			case "2":
				while (br.ready()) {
					codigoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(0, linha.indexOf("|") + 1);
					produtoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(0, linha.indexOf("|") + 1);
					valorAchado = linha.substring(0);
					if (descricao.equals(produtoAchado)) {

					}
				}

				JOptionPane.showMessageDialog(null, "Produto Não localizado!");

				break;

			default:

			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
	}

	public void transferirArquivo(String caminho, String caminhoTemp) throws IOException {
		try {
			BufferedReader caminho1 = new BufferedReader(new FileReader(caminho));
			BufferedWriter caminho2 = new BufferedWriter(new FileWriter(caminhoTemp, true));
			String linha;
			while (caminho1.ready()) {
				linha = caminho1.readLine();
				caminho2.write(linha);
				caminho2.newLine();
			}
			JOptionPane.showMessageDialog(null, "Arquivo transferido! ");

			caminho1.close();
			caminho2.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarProduto(String caminho) {
		String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";
		try {

			String codigo = JOptionPane.showInputDialog(null, "Digite o codigo");

			BufferedReader arq1 = new BufferedReader(new FileReader(caminho));
			BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminhoTemp));
			String codigoAchado, produtoAchado, valorAchado;
			int cont = 0;
			String aux, linhaAlt, linha;
			while (arq1.ready()) {
				linha = aux = arq1.readLine();

				linha.substring(0, linha.indexOf("|") + 1);

				codigoAchado = linha.substring(0, linha.indexOf("|"));
				linha = linha.substring(linha.indexOf("|") + 1);

				produtoAchado = linha.substring(0, linha.indexOf("|"));
				linha = linha.substring(linha.indexOf("|") + 1);

				valorAchado = linha.substring(0);
//TESTE
//				System.out.println("Codigo: " + codigoAchado);
//				System.out.println("produto: " + produtoAchado);
//				System.out.println("valor: " + valorAchado);

				if (codigoAchado.equals(codigo)) {
					String senha = JOptionPane.showInputDialog(null, "Digite a senha para alterar algo do produto! ");
					if (senha.equals("12345")) {

						String op = JOptionPane.showInputDialog(null,"1 - Para aletar Codigo | 2 - Para alterar Descrição do produto | 3 - Para Alterar o valor do Produto ");
						if (op.equals("1")) {
							String codigoAlterado = JOptionPane.showInputDialog(null,"Digite o novo codigo do produto! O codigo antigo era: " + codigoAchado);
							linhaAlt = codigoAlterado + "|" + produtoAchado + "|" + valorAchado;
							arq2.write(linhaAlt);
							arq2.newLine();
							cont++;
						} else if (op.equals("2")) {
							String produtoAlterado = JOptionPane.showInputDialog(null,
									"Digite o novo nome do produto! Descrição antiga era: " + produtoAchado);
							linhaAlt = codigoAchado + "|" + produtoAlterado + "|" + valorAchado;
							arq2.write(linhaAlt);
							arq2.newLine();
							cont++;
						} else if (op.equals("3")) {
							String valorAlterado = JOptionPane.showInputDialog(null,"Digite o novo preço do produto! O preço antigo era: R$" + valorAchado);
							linhaAlt = codigoAchado + "|" + produtoAchado + "|" + valorAlterado;
							arq2.write(linhaAlt);
							arq2.newLine();
							cont++;
						} else {
							JOptionPane.showMessageDialog(null, "Opção invalida!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senha invalida!");
					}
				} else {
					arq2.write(aux);
					arq2.newLine();
				}
			}

			arq1.close();
			arq2.close();
			if (cont == 0) {
				JOptionPane.showMessageDialog(null, "Não achei o produto!");
			} else {
				JOptionPane.showMessageDialog(null, "Achei o produto e foi Alterado! ");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(caminhoTemp));
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
			String linha;
			while (br.ready()) {
				linha = br.readLine();
				bw.write(linha);
				bw.newLine();
			}
			bw.close();
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
	}

	public void deletarProduto(String caminho) {
		String caminhoTemp = "D:\\Curso de programação\\Programas\\Arquivos txt\\Mercado\\cadastroDeProdutoTemp.txt";
		try {
			//String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";
			String senha = JOptionPane.showInputDialog(null, "Digite a senha para alterar algo do produto! ");
			if (senha.equals("12345")) {
				String codigo = JOptionPane.showInputDialog(null, "Digite o codigo");

				BufferedReader arq1 = new BufferedReader(new FileReader(caminho));
				BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminhoTemp));
				String linha;
				int cont = 0;
				String aux;
				if (codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Codigo em branco favor preencher!");
				} else {
					while (arq1.ready()) {
						linha = arq1.readLine();

						 aux= linha.substring(0, linha.indexOf("|"));


						if (aux.equals(codigo)) {
							cont++;

						} else {
							arq2.write(linha);
							arq2.newLine();
						}
					}

					arq1.close();
					arq2.close();
					if (cont == 0) {
						JOptionPane.showMessageDialog(null, "Não achei o produto!");
					} else {
						JOptionPane.showMessageDialog(null, "Achei o produto e foi deletado! ");
					}
				}
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			//String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";

			BufferedReader br = new BufferedReader(new FileReader(caminhoTemp));
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
			String linha;
			while (br.ready()) {
				linha = br.readLine();
				bw.write(linha);
				bw.newLine();
			}
			bw.close();
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
	}


}
