package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Calculo implements Interface {

	public double calcularDecimoTerceiro(double salario, double mesesTrabalhados) {
		double decimoTerceiro = 0;

		// salario dividido por 12 * meses trabalhados

		decimoTerceiro = (salario / 12) * mesesTrabalhados;
		return decimoTerceiro;

	}

	public double salarioHora(double salario, int horas) {
		double salarioHora;

		salario = salario / 30;
		salarioHora = salario / horas;
		return salarioHora;

	}

// salario por dia
	public double salarioProporcional(double salario, int diasTrabalhados) {
		double salarioPorDia = 0;

		// salario dividido por 30, vai dar quanto que ganha por dia.

		salarioPorDia = salario / 30;

		// salarioPorDia * diasTrabalhados pra dar o quanto ele deve receber num
		// determinado quantidade de dias
		// salarioPorDia = salarioPorDia * diasTrabalhados;

		return salarioPorDia;

	}

//Fundo de garantia por tempo de serviço
	public double adicionalNoturno(double salario, int horasNormais, int horasNoturnas) {

		// double valorHora,valorDia;
		double salarioHora, salarioAcrescimo, salarioNoturnoMes, salarioNoturnoDia;

		salarioHora = salario / horasNormais; // salario por hora normal

		salarioAcrescimo = (salarioHora * 0.2); // salario por hora com acrescimento de 20%

		salarioAcrescimo = salarioHora + salarioAcrescimo;

		salarioNoturnoDia = salarioAcrescimo * horasNoturnas; // saber quanto q ganha no adicional noturno por
																// hora
		System.out.println(salarioNoturnoDia);

		salarioNoturnoMes = salarioNoturnoDia * 30; // Sabe quanto q ganha no adicional noturno por dia

		return salarioNoturnoMes;

		// "Só é consideravel horas noturnas 21h as 05h, 8h por noite, vc nao pode
		// trabalhar mais que 8h por noite e menos que 0h"

	}

	public double horaExtraNormal(double salario, int horasTrabalhadas) {
		double salarioDia = salario;
		double horaDia = 8; // horas num dia
		// HoraExtra horario Normal

		// Somatorio valor de hora em dia de semana

		salarioDia = salario / horaDia;
		salarioDia = (salarioDia * 0.5) + horasTrabalhadas;
		return salarioDia; // so somar esse valor ao salario pra tirar o valor exato
	}

	// HoraExtra horario Final de semana e feriados

	// Somar os dois tipos de double total =
	// (calculo.horaExtraNormal(salario,horasTrabalhadas)+calculo.horaExtraFds(salario,horasTrabalhadas));

	public double horaExtraFds(double salario, int horasTrabalhadas) {
		double salarioDia = salario;
		double horaDia = 8; // horas num dia

		salarioDia = salario / horaDia;
		// salario 100% * horasTrabalhadas
		salario = (salarioDia + salarioDia) * horasTrabalhadas;
		return salario;
	}

	public double insalubridadeDez(double salario) {

		// Quanto custa 10% do salario da pessoa
		salario = salario * 0.1;
		// atribui o valor de 10% ao salario e somando eles.
		// salarioTotal += salario;
		return salario; // so atribuir esse valor ao salario
	}

	public double insalubridadeVinte(double salario) {

		salario = salario * 0.2;
		// salarioTotal += salario;
		return salario;
	}

	public double insalubridadeQuarenta(double salario) {

		salario = salario * 0.4;
		// salarioTotal += salario;
		return salario;

	}

	public double periculosidade(double salario) {
		// double salarioTotal = salario;

			// Quanto custa 30% do salario da pessoa
			salario = salario * 0.3;
			// atribui o valor de 30% ao salario e somando eles.
			// salarioTotal = salario + salarioTotal;

			return salario; // So atribuir esse valor no salario
		
	}

	public double seguroDesempregoValor(double salario, double salario2, double salario3) {
		double media, valorParcela, valorQueExcede, salarioMinimo;
		salarioMinimo = 998.00;
		media = (salario + salario2 + salario3) / 3;

			if (media < 1480.25 || media > 0) {

				valorParcela = media * 0.8;

				if (valorParcela < salarioMinimo) {
					valorParcela = salarioMinimo;
					return valorParcela;

				} else {
					return valorParcela;
				}

			} else if (media > 1480.26 || media < 2467.33) {

				valorQueExcede = media - 1480.25;
				valorParcela = (valorQueExcede * 0.5) + 1184.20;
				if (valorParcela > 2467.33) {
					valorParcela = 1677.74;
					return valorParcela;
				} else {
					return valorParcela;
				}
			} else {

				valorParcela = 1677.74;

				return valorParcela;
			}
		}

	public int seguroDesempregoQuantidade(int mesesDoze, int mesesTrintaSeis, int numeroVezes) {
		int parcelas = 0;
		if (numeroVezes == 1) {
			parcelas = 4;

			if (mesesDoze < 12) {
				parcelas = 0;
				return parcelas;
			} else {

				if (mesesTrintaSeis >= 24) {
					parcelas = 5;
					return parcelas;
				} else {
					parcelas = 4;
					return parcelas;
				}
			}
		}

		else if (numeroVezes == 2) {

			if (mesesDoze < 9) {
				parcelas = 0;
				return parcelas;

			} else {

				if (mesesTrintaSeis >= 24) {
					parcelas = 5;
					return parcelas;

				} else {

					parcelas = 4;
					return parcelas;
				}
				
			}

		} else if (numeroVezes >= 3) {
			if (mesesDoze < 6) {
				parcelas = 0;
				return parcelas;
			} else {
				if (mesesDoze >= 6 || mesesTrintaSeis <= 11) {
					parcelas = 3;
					return parcelas;
				} else if (mesesDoze >= 6 || mesesTrintaSeis <= 24) {
					parcelas = 4;
					return parcelas;
				} else {
					parcelas = 5;
					return parcelas;
				}
			}
		}
		return parcelas;
	}

	public double multaFgts(double salario, int anosTrabalhados) {
		double multaFgts, fgts;

		fgts = salario * 0.08;
		multaFgts = (fgts * anosTrabalhados) * 0.4;

		return multaFgts;

	}

	public double fgts(double salario, int anosTrabalhados) {
// falta dias trabalhados
		double fgts;

		fgts = salario * 0.08;
		fgts = fgts * anosTrabalhados;
		return fgts;
	}

//				QUANTO RECEBE DE AVISO PREVIO
//Para calcular quanto vai receber de aviso previo vai ser 
// chamar avisoPrevio(anosTrabalhados);
//Pegar salarioProporcional(salario,avisoPrevio); Salario normal e o // que é o return avisoPrevio;

	public int avisoPrevio(int anosTrabalhados) {
		// Quantos dias de aviso previo
		/*
		 * Aviso previo proporcional <12meses | 30 dias 4 anos | 30+(4*3) = 42 20 anos
		 * |30+(20*3)= 90 // maximo
		 */
		int avisoPrevio = 30;

		int dias = 3;
		if (anosTrabalhados < 0) {
			JOptionPane.showMessageDialog(null, "Anos trabalhados menor que 0.");
			return -1;
		} else if (anosTrabalhados < 20) {
			avisoPrevio = (avisoPrevio) + (dias * anosTrabalhados);
			return avisoPrevio;
		}

		else if (anosTrabalhados >= 20) {
			// se tiver mais de 20 anos o aviso previo e de no maximo 90 dias
			avisoPrevio = 90;
			return avisoPrevio;
		}
		return avisoPrevio;
	}

	public double feriasProporcionais(double salario, int mesesTrabalhados) {
		// ESTA CALCULADO FERIAS PROPORCIONAL
		// PARA CALCULAR O TOTAL = FERIAS 1/3 + FERIASPROPORCIONAIS

		double valorFerias, valorPorMes; // result, valor;

		// valor mensal = salario / meses do ano (12)
		valorPorMes = salario / 12;

		// Ferias proporcionais = valor mensal * numero de meses trabalhados
		valorFerias = valorPorMes * mesesTrabalhados;

		// Um terço constitucional(1/3) = valorFerias / 3
		// valor = feriasUmTerco(salario);

		// Todal devido = valor das ferias + 1/3
		// result = valorFerias + valor;
		return valorFerias;

	}

	// Fundo de garantia por tempo de serviço //Quanto que tem no fgts

	public void escreverCalculo(String texto, String nome) {
		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + ".txt";
		try {
			File arquivo = new File(caminhoCalculo);
			if (arquivo.exists()) {
				// JOptionPane.showMessageDialog(null,"Arquivo ja está criado!");
				System.out.println("Arquivo já esta criado! ");
			} else {
				File diretorio = new File(caminhoCalculo.substring(0, caminhoCalculo.lastIndexOf("\\")));

				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}
				arquivo.createNewFile();

				JOptionPane.showMessageDialog(null, "Arquivo Criado, na pasta Calculo Trabalhista");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a base de dados:" + e);

		}

		try {
			FileWriter fw = new FileWriter(caminhoCalculo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escrever! " + e);
		}
	}

	public void escreverCalculo(String codigo, String nome, String valor) {

		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + " Calculo" + ".txt";
		try {
			File arquivo = new File(caminhoCalculo);
			if (arquivo.exists()) {
				// JOptionPane.showMessageDialog(null,"Arquivo ja está criado!");
				System.out.println("Arquivo já esta criado! ");
			} else {
				File diretorio = new File(caminhoCalculo.substring(0, caminhoCalculo.lastIndexOf("\\")));

				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}
				arquivo.createNewFile();
				System.out.println("Arquivo Criado, na pasta Calculo Trabalhista");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a base de dados:" + e);

		}

		try {

			FileWriter fw = new FileWriter(caminhoCalculo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Codigo: " + codigo);
			bw.newLine();

			bw.write("Nome: " + nome.trim());
			bw.newLine();

			bw.write("Salario: R$" + valor);
			bw.newLine();

			bw.close();

			JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso no TXT Calculo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi escrito no txt. ERRO:" + e);
		}

	}

	public String pegarCodigo(String linha) {
		String codigo;

		codigo = linha.substring(0, linha.indexOf("|"));

		return codigo;
	}

	public String pegarNome(String linha) {
		String nome = "";

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

		// cod
		linha = linha.substring(linha.indexOf("|") + 1);
		// nome
		linha = linha.substring(linha.indexOf("|") + 1);
		// cpf
		linha = linha.substring(linha.indexOf("|") + 1);
		// rg
		linha = linha.substring(linha.indexOf("|") + 1);
		// nasci
		linha = linha.substring(linha.indexOf("|") + 1);
		// salario
		linha = linha.substring(linha.indexOf("|") + 1);
		// admissao
		linha = linha.substring(linha.indexOf("|") + 1);
		// demissao
		linha = linha.substring(linha.indexOf("|") + 1);
		// tempoTrab
		diferencaAnoMes = linha.substring(0, linha.indexOf("|"));
		return diferencaAnoMes;
	}
}
