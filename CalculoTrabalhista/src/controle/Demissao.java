package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Demissao extends Calculo {
	
	@Override
	public double salarioProporcional(double salario, int diasTrabalhados) {
		double salarioPorDia = 0;
				// salario dividido por 30, vai dar quanto que ganha por dia.
				salarioPorDia = salario / 30;

				// salarioPorDia * diasTrabalhados pra dar o quanto ele deve receber num
				// determinado quantidade de dias
				// salarioPorDia = salarioPorDia * diasTrabalhados;

				return salarioPorDia;

	}
		
	@Override
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

	public double calcularDecimoTerceiro(double salario, double mesesTrabalhados) {
		double decimoTerceiro = 0 ;

			// salario dividido por 12 * meses trabalhados

			decimoTerceiro = (salario / 12) * mesesTrabalhados;
			return decimoTerceiro;
	}

	public int avisoPrevio() {	
		int avisoPrevio = 30;		
			// Demissao tem direito a 30 dias

			return avisoPrevio;
		} 
		
		
	public void escreverCalculo(String texto,String nome) {
		String caminhoCalculo = "C:\\CalculoTrabalhista\\Calculos\\Demissão\\calculo.txt";
		caminhoCalculo = caminhoCalculo.substring(0, caminhoCalculo.length() - 11) + nome.trim() + " Demissão" + ".txt";
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
