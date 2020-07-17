package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;



public class CulpaReciproca extends Calculo{

	public CulpaReciproca() {
		
	}

	public double salarioProporcional(double salario, int diasTrabalhados) {
		double salarioPorDia = 0;

			
				// salario dividido por 30, vai dar quanto que ganha por dia.
				salarioPorDia = salario / 30;

				// salarioPorDia * diasTrabalhados pra dar o quanto ele deve receber num
				// determinado quantidade de dias
				// salarioPorDia = salarioPorDia * diasTrabalhados;

				return salarioPorDia;		

	}

	public double feriasVencidas(double salario, int quantidadeDeFerias) {
		double total = salario = quantidadeDeFerias;
		return total;
	}

	
	// 50%
	public double feriasProporcionais(double salario, int mesesTrabalhados) {
		// ESTA CALCULADO FERIAS PROPORCIONAL
		// PARA CALCULAR O TOTAL = FERIAS 1/3 + FERIASPROPORCIONAIS

		double valorFerias, valorPorMes; // result, valor;

		// valor mensal = salario / meses do ano (12)
		valorPorMes = salario / 12;

		// Ferias proporcionais = valor mensal * numero de meses trabalhados
		valorFerias = (valorPorMes * mesesTrabalhados)*0.5;

		// Um terço constitucional(1/3) = valorFerias / 3
		// valor = feriasUmTerco(salario);

		// Todal devido = valor das ferias + 1/3
		// result = valorFerias + valor;
		return valorFerias;

	}

	
	public double feriasUmTerco(double salario) {
		// ou chamado ferias + 1/3
		double feriasValor;

			feriasValor = salario / 3;
			feriasValor = salario + feriasValor;

			return feriasValor;		
	}

	//50%
	public double calcularDecimoTerceiro(double salario, double mesesTrabalhados) {
		double decimoTerceiro = 0;
		if (mesesTrabalhados <= 12 || mesesTrabalhados < 0) {
			// salario dividido por 12 * meses trabalhados

			decimoTerceiro = ((salario / 12) * mesesTrabalhados)*0.5;
			return decimoTerceiro;
		} else {
			return decimoTerceiro;
		}

	}

	
	//50% FAZER NO VALOR
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
	
	//50%
	public double multaFgts(double salario) {
		double multaFgts; //fgts;
	

		//fgts = salario * 0.08;
		multaFgts = (salario * 0.4)*0.5;

		return multaFgts;

	}

	
	
	public void escreverCalculo(String texto,String nome) {
		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\Culpa Reciproca\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + " CulpaReciproca" + ".txt";
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
