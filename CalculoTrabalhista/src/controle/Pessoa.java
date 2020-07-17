package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.swing.JOptionPane;

public  class Pessoa  implements Interface {
	private String nome, cpf, dataNascimento, rg;
	private double salario;
	public String caminho = "C:\\CalculoTrabalhista\\Acesso Restrito\\calculoTrabalhista.txt";
	String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\calculo.txt";

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {

		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String calcularDias(Date dateAdmissao, Date dateDemissao) {
		// AQUI
		String data = null;

		// dateAdmissao.getDate().getDate();
		if (dateAdmissao == null || dateDemissao == null) {
			JOptionPane.showMessageDialog(null, "Data de Admissão ou Demissão está em branco!");
			return data;
		} else {
			LocalDate localDataIni = LocalDate.of(dateAdmissao.getYear() + 1900, dateAdmissao.getMonth() + 1,	dateAdmissao.getDate());

//			LocalDate localDataIni = LocalDate.of(dateAdmissao.getDate(),
//			 dateAdmissao.getMonth() + 1,
//			dateAdmissao.getYear() + 1900);

		LocalDate localDateFim = LocalDate.of(dateDemissao.getYear() + 1900, dateDemissao.getMonth() + 1,dateDemissao.getDate());
			/* LocalDate localDateFim = LocalDate.of(dateDemissao.getDate(),
			 dateDemissao.getMonth() + 1,
			 dateDemissao.getYear() + 1900);*/

			// Calcular diferença de datas.
			Period periodo = Period.between(localDataIni, localDateFim);
			if (periodo.getYears() == 0) {
				if (periodo.getMonths() == 1) {
					data = periodo.getMonths() + ", Mes";
					return data;
				} else {
					data = periodo.getMonths() + ", Meses";
					return data;
				}
			} else if (periodo.getMonths() == 0) {
				if (periodo.getYears() == 1) {
					data = periodo.getYears() + ", Ano";
					return data;
				} else {
					data = periodo.getYears() + ", Anos";
					return data;
				}

			} else {
				data = periodo.getYears() + ", anos|" + periodo.getMonths() + ", meses";
				return data;
			}
		}
	}

	public Pessoa() {

	}

	// TXT NA PASTA CALCULOS
// FALTA TRATAR PRA NAO ESCREVER VARIAS VEZES A MESMA COISA
	public void escreverCalculoPessoa(String codigo, String nome, String cpf, String rg, String dataNascimento,
			String valor, String dataAdmissao, String dataDemissao, String diferencaAnoMes) {
		int cont = 0;
		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + ".txt";
		try {
			File arquivo = new File(caminhoCalculo);
			if (arquivo.exists()) {
				// JOptionPane.showMessageDialog(null,"Arquivo ja está criado!");
			} else {
				File diretorio = new File(caminhoCalculo.substring(0, caminhoCalculo.lastIndexOf("\\")));

				if (!diretorio.exists()) {
					diretorio.mkdirs();
					
				}
				arquivo.createNewFile();
				System.out.println("Arquivo Criado, na pasta Calculo! ");
			}

		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a base de dados:" + e);

		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(caminhoCalculo));
			String ler, codigoAchado;
			while (br.ready()) {
				ler = br.readLine();
				codigoAchado = ler.substring(0, ler.indexOf("|"));

				if (codigoAchado.equals(codigo)) {
					cont++;
					break;
				}
				br.close();
			}
			if(cont == 0) {
			try {

				FileWriter fw = new FileWriter(caminhoCalculo, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write("Codigo: " + codigo);
				bw.newLine();

				bw.write("Nome: " + nome.trim());
				bw.newLine();

				bw.write("Cpf: " + cpf);
				bw.newLine();

				bw.write("Rg: " + rg);
				bw.newLine();

				bw.write("Data de Nascimento: " + dataNascimento);
				bw.newLine();

				bw.write("Salario: R$" + valor);
				bw.newLine();

				bw.write("Data de Admissão: " + dataAdmissao);
				bw.newLine();

				bw.write("Data de Demissão: " + dataDemissao);
				bw.newLine();

				bw.write("Tempo trabalhado: " + diferencaAnoMes);
				bw.newLine();

				bw.close();

				bw.close();
				fw.close();
				
				JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso no TXT Calculo!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Não foi escrito no txt. ERRO:" + e);
			}
			}
			
		} catch (Exception e) {
			System.out.println("Nome ja foi escrito no txt.");
			//JOptionPane.showMessageDialog(null, "Erro, ao localizar se tem ou nao arquivo existente!");
		}

	}

	public void verificarArquivoTxt(String caminho) {
		try {

			File arquivo = new File(caminho);
			if (arquivo.exists()) {
				// JOptionPane.showMessageDialog(null,"Arquivo ja está criado!");
				System.out.println("Arquivo já esta criado! ");
			} else {
				File diretorio = new File(caminho.substring(0, caminho.lastIndexOf("\\")));

				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}
				arquivo.createNewFile();
				System.out.println("Arquivo Criado");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a base de dados:" + caminho);

		}
	}

	public void escreverNoArquivo(String nome, String cpf, String rg, Date dataNascimento, String valor,
			Date dataAdmissao, Date dataDemissao, String diferencaAnoMes) {
			
		try {

			FileWriter fw = new FileWriter(caminho, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String linha;

			if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, NOME! ");
				bw.close();

			} else if (((String) cpf).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, CPF! ");
				bw.close();

			} else if (((String) rg).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, RG! ");
				bw.close();

			} else if (valor.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, SALARIO! ");
				bw.close();
			} else if (dataNascimento == null) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, Data de Nascimento! ");
				bw.close();
			} else if (diferencaAnoMes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor Calcular, Preenchendo Admissão e Demissão! ");
				bw.close();
			}

			else {
				nome.trim();

				@SuppressWarnings("deprecation")
				LocalDate dataNasc = LocalDate.of(dataNascimento.getYear() + 1900, dataNascimento.getMonth() + 1,
						dataNascimento.getDate());

				@SuppressWarnings("deprecation")
				LocalDate dataAd = LocalDate.of(dataAdmissao.getYear() + 1900, dataAdmissao.getMonth() + 1,dataAdmissao.getDate());

				@SuppressWarnings("deprecation")
				LocalDate dataDem = LocalDate.of(dataDemissao.getYear() + 1900, dataDemissao.getMonth() + 1,
						dataDemissao.getDate());

				String codigo = proximoCodigo(caminho);
				linha = codigo + "|" + nome + "|" + cpf + "|" + rg + "|" + dataNasc + "|" + valor + "|" + dataAd + "|"+
						 dataDem+ "|" + diferencaAnoMes+"|";
				bw.write(linha);
				bw.newLine();
				bw.close();
				JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi escrito no txt. ERRO:" + e);

		}

	}

	
	public void alterarPessoa(String codigo, String nome, String cpf, String rg, Date dataNascimento, String salario,
			Date dataAdmissao, Date dataDemissao, String diferencaAnoMes) {
		String caminho = "C:\\CalculoTrabalhista\\Acesso Restrito\\calculoTrabalhista.txt";
		String linha = "";
		String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";
		int cont = 0;
		try {

			BufferedReader arq1 = new BufferedReader(new FileReader(caminho));
			BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminhoTemp));

			String codigoAchado;
			String aux;
			if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, NOME! ");
				arq2.close();

			} else if (((String) cpf).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, CPF! ");
				arq2.close();

			} else if (((String) rg).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, RG! ");
				arq2.close();

			} else if (salario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, SALARIO! ");
				arq2.close();
			} else if (dataNascimento == null) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, Data de Nascimento! ");
				arq2.close();
			} else if (diferencaAnoMes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor Calcular, Preenchendo Admissão e Demissão! ");
				arq2.close();
			}

			else {
				nome.trim();
				while (arq1.ready()) {
					aux = linha = arq1.readLine();

					codigoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(linha.indexOf("|") + 1);

					if (codigo.equals(codigoAchado)) {
						LocalDate dataNasc = LocalDate.of(dataNascimento.getYear() + 1900,
								dataNascimento.getMonth() + 1, dataNascimento.getDate());
						LocalDate dataAd = LocalDate.of(dataAdmissao.getYear() + 1900, dataAdmissao.getMonth() + 1,
								dataAdmissao.getDate());
						LocalDate dataDem = LocalDate.of(dataDemissao.getYear() + 1900, dataDemissao.getMonth() + 1,
								dataDemissao.getDate());

						aux = codigo + "|" + nome + "|" + cpf + "|" + rg + "|" + dataNasc + "|" + salario + "|" + dataAd
								+ "|" + dataDem + "|" + diferencaAnoMes + "|";
						cont++;
					}
					arq2.write(aux);
					arq2.newLine();

				}

				arq1.close();
				arq2.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro!Ao copiar");
		}
		if (cont == 1) {
			try {

				BufferedReader br = new BufferedReader(new FileReader(caminhoTemp));
				BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));

				while (br.ready()) {
					linha = br.readLine();
					bw.write(linha);
					bw.newLine();
				}
				bw.close();
				br.close();
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO!Ao escrever");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Não Achei!");
		}
	}
	
	
	/*public void alterarPessoa(String codigo, String nome, String cpf, String rg, Date dataNascimento, String salario,
			Date dataAdmissao, Date dataDemissao, String diferencaAnoMes) {

		String linha = "";
		String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";
		int cont = 0;
		try {

			BufferedReader arq1 = new BufferedReader(new FileReader(caminho));
			BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminhoTemp));

			String codigoAchado;
			String aux;
			if(codigo.isEmpty()){
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, CODIGO! ");
				arq2.close();
			}
			else if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, NOME! ");
				arq2.close();

			} else if (cpf.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, CPF! ");
				arq2.close();

			} else if (rg.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, RG! ");
				arq2.close();

			} else if (salario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, SALARIO! ");
				arq2.close();
			} else if (dataNascimento == null) {
				JOptionPane.showMessageDialog(null, "Favor completar o campo obrigatorio, Data de Nascimento! ");
				arq2.close();
			} else if (diferencaAnoMes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor Calcular, Preenchendo Admissão e Demissão! ");
				arq2.close();
			}

			else {
				nome.trim();
				while (arq1.ready()) {
					aux = linha = arq1.readLine();

					codigoAchado = linha.substring(0, linha.indexOf("|"));
					linha = linha.substring(linha.indexOf("|") + 1);

					if (codigo.equals(codigoAchado)) {
						LocalDate dataNasc = LocalDate.of(dataNascimento.getYear() + 1900,
								dataNascimento.getMonth() + 1, dataNascimento.getDate());
						LocalDate dataAd = LocalDate.of(dataAdmissao.getYear() + 1900, dataAdmissao.getMonth() + 1,
								dataAdmissao.getDate());
						LocalDate dataDem = LocalDate.of(dataDemissao.getYear() + 1900, dataDemissao.getMonth() + 1,
								dataDemissao.getDate());

						aux = codigo + "|" + nome + "|" + cpf + "|" + rg + "|" + dataNasc + "|" + salario + "|" + dataAd
								+ "|" + dataDem + "|" + diferencaAnoMes + "|";
						cont++;
						break;
					}
					arq2.write(aux);
					arq2.newLine();

				}

				arq1.close();
				arq2.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro!Ao copiar");
		}
		if (cont == 1) {
			try {

				BufferedReader br = new BufferedReader(new FileReader(caminhoTemp));
				BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));

				while (br.ready()) {
					linha = br.readLine();
					bw.write(linha);
					bw.newLine();
				}
				bw.close();
				br.close();
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO!Ao escrever");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Não Achei!");
		}
	}*/

	public void deletarPessoa(String codigo) {
		String caminho = "C:\\CalculoTrabalhista\\Acesso Restrito\\calculoTrabalhista.txt";
		String caminhoTemp = caminho.substring(0, caminho.length() - 4) + "Temp.txt";
		try {
			BufferedReader arq1 = new BufferedReader(new FileReader(caminho));
			BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminhoTemp));

			String linha, codigoAchado;
			int cont = 0;
			if (codigo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Codigo em branco favor preencher alguma coisa!");
			} else {
				while (arq1.ready()) {
					linha = arq1.readLine();
					codigoAchado = linha.substring(0, linha.indexOf("|"));
					if (codigoAchado.equals(codigo)) {
						cont++;
					} else {
						arq2.write(linha);
						arq2.newLine();
					}
				}
				arq1.close();
				arq2.close();
				if (cont == 0) {
					JOptionPane.showMessageDialog(null, "Não achei o codigo a ser deletado!");
				} else
					JOptionPane.showMessageDialog(null, "Codigo deletado com sucesso!");
				try {

					BufferedReader br = new BufferedReader(new FileReader(caminhoTemp));
					BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
					 
					while (br.ready()) {
						linha = br.readLine();
						bw.write(linha);
						bw.newLine();
					}
					bw.close();
					br.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO! Ao escrever na lista nova! ");
				}
			
			
			}
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO! Ao deletar!");
		}
		
	}

	//Gerar Codigo Automatico
	public static String proximoCodigo(String caminho) {
		int proximo = 100;
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			String linha, codigo;

			while (br.ready()) {
				linha = br.readLine();
				if (!linha.isEmpty()) {
					codigo = linha.substring(0, linha.indexOf("|"));

					int aux = Integer.parseInt(codigo);
					if (proximo <= aux) {
						proximo = Integer.parseInt(codigo);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
		++proximo;
		return Integer.toString(proximo);

	}

	public String localizar(String codigo) {
		String caminho = "C:\\CalculoTrabalhista\\Acesso Restrito\\calculoTrabalhista.txt";
		String linha = null;
		try {
			int cont = 0;
			String codigoAchado;
			BufferedReader br = new BufferedReader(new FileReader(caminho));

			while (br.ready()) {
				linha = br.readLine();

				codigoAchado = linha.substring(0, linha.indexOf("|"));
				linha.substring(0, linha.indexOf("|") + 1);

				if (codigoAchado.equals(codigo)) {
					cont++;
					br.close();
					break;
				
				}
			}		
			if (cont == 0) {			
				linha = null;
			} else if (cont >= 1) {
			//	JOptionPane.showMessageDialog(null, "Achei!");
			}
		} catch (IOException args0) {
			System.out.println("Erro ao localizar!");
		}
		return linha;

	}
	
	
	

	
	/*
	 * public static String[] lerArquivo(String caminhoCompleto) {
		verificaArquivo(caminhoCompleto);
		String _return[] = new String[linhasTotal(caminhoCompleto) + 1];
		try {
			int cont = 0;
			BufferedReader br = new BufferedReader(new FileReader(diretorio + arquivo + extensao));
			while (br.ready()) {
				_return[cont] = br.readLine();
				cont++;
			}

			br.close();
		} catch (Exception ex) {

		}
		return _return;
	}

	 */
	
	public String pegarCodigo(String linha) {
		String codigo;

		codigo = linha.substring(0, linha.indexOf("|"));

		return codigo;
	}

	public String pegarNome(String linha) {
		String nome="";

		linha = linha.substring(linha.indexOf("|") + 1);
		nome = linha.substring(0, linha.indexOf("|"));
		
		return nome;
		}

	 public String pegarCpf(String linha) {
		String cpf;
		linha = linha.substring(linha.indexOf("|") + 1);

		linha = linha.substring(linha.indexOf("|") + 1);

		cpf = linha.substring(0, linha.indexOf("|"));

		return cpf;
	}

	 public String pegarRg(String linha) {
		String rg;

		linha = linha.substring(linha.indexOf("|") + 1);

		linha = linha.substring(linha.indexOf("|") + 1);

		linha = linha.substring(linha.indexOf("|") + 1);

		rg = linha.substring(0, linha.indexOf("|"));

		return rg;
	}

	 public String pegarDataNascimento(String linha) {
		String dataNascimento;

		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		dataNascimento = linha.substring(0, linha.indexOf("|"));
		return dataNascimento;
	}

	 public String pegarSalario(String linha) {
		String salario;
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);

		salario = linha.substring(0, linha.indexOf("|"));

		return salario;
	}

	 public String pegarDataAdmissao(String linha) {
		String dataAdmissao;
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		dataAdmissao = linha.substring(0, linha.indexOf("|"));

		return dataAdmissao;
	}

	 public String pegarDataDemissao(String linha) {
		String dataDemissao;
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		linha = linha.substring(linha.indexOf("|") + 1);
		dataDemissao = linha.substring(0, linha.indexOf("|"));
		return dataDemissao;
	}

	 public String pegarTempoDeTrabalho(String linha) {
		String diferencaAnoMes;
		
		//cod
		linha = linha.substring(linha.indexOf("|") + 1);
		//nome
		linha = linha.substring(linha.indexOf("|") + 1);
		//cpf
		linha = linha.substring(linha.indexOf("|") + 1);
		//rg
		linha = linha.substring(linha.indexOf("|") + 1);
		//nasci
		linha = linha.substring(linha.indexOf("|") + 1);
		//salario
		linha = linha.substring(linha.indexOf("|") + 1);
		//admissao
		linha = linha.substring(linha.indexOf("|") + 1);
		//demissao
		linha = linha.substring(linha.indexOf("|") + 1);
		//tempoTrab
		diferencaAnoMes = linha.substring(0, linha.indexOf("|"));
		return diferencaAnoMes;
	}
}
