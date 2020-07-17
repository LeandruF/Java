package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Despedido extends Calculo {

	// Salario Proporcional
	public double salarioProporcional(double salario, int diasTrabalhados) {
		double salarioPorDia = 0;

			
				// salario dividido por 30, vai dar quanto que ganha por dia.
				salarioPorDia = salario / 30;

				// salarioPorDia * diasTrabalhados pra dar o quanto ele deve receber num
				// determinado quantidade de dias
				// salarioPorDia = salarioPorDia * diasTrabalhados;

				return salarioPorDia;		

	}

	// Ferias vencidas SALARIO * qtdFerias
	public double feriasVencidas(double salario, int quantidadeDeFerias) {
		double total = salario = quantidadeDeFerias;
		return total;
	}

	// Ferias Proporcional
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
	
	// Ferias 1/3 se tiver + de um ano
	public double feriasUmTerco(double salario) {
		// ou chamado ferias + 1/3
		double feriasValor;

			feriasValor = salario / 3;
			feriasValor = salario + feriasValor;

			return feriasValor;		
	}
	
	// 13º
	public double calcularDecimoTerceiro(double salario, double mesesTrabalhados) {
		double decimoTerceiro = 0;
		if (mesesTrabalhados <= 12 || mesesTrabalhados < 0) {
			// salario dividido por 12 * meses trabalhados

			decimoTerceiro = (salario / 12) * mesesTrabalhados;
			return decimoTerceiro;
		} else {
			return decimoTerceiro;
		}

	}

	// Aviso Previo
	public int avisoPrevio(int anosTrabalhados) {
		// Quantos dias de aviso previo
		/*
		 * Aviso previo proporcional <12meses | 30 dias 4 anos | 30+(4*3) = 42 20 anos
		 * |30+(20*3)= 90 // maximo
		 */
		int avisoPrevio = 30;

		int dias = 3;
		if (anosTrabalhados < 20) {
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
	
	
	// MultaFgts 40%
	public double multaFgts(double salario) {
		double multaFgts; //fgts;
	

		//fgts = salario * 0.08;
		multaFgts = salario * 0.4;

		return multaFgts;

	}

	// FGTS
	public double fgts(double salario, int anosTrabalhados) {
		// falta dias trabalhados
		double fgts;

		fgts = salario * 0.08;
		fgts = fgts * anosTrabalhados;
		return fgts;
	}

	// Seguro desemprego valor da parcela e numero da parcela ou total
	// Valor
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
	

	//Quantidade de Parcelas  
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
	
	// ESCREVER NO ARQUIVO 
	public void escreverCalculo(String texto,String nome) {
		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\Despedido\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + " Despedido" + ".txt";
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
			
		}
		catch(Exception e ) {
			JOptionPane.showMessageDialog(null,"Erro ao escrever! "+e);
		}
	}
	
	
}
