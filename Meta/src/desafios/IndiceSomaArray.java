package desafios;

import java.util.Scanner;

public class IndiceSomaArray {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		System.out.println(" Digite um número inteiro positivo maior > 0");
		int num = ler.nextInt();
		
		// gerar numeros randomicos
		int vet[] = new int[25];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * 20);
			System.out.println("Indice " + i + ", Valor " + vet[i]);

		}

		int r[] = indicesArray(num, vet);
		if (r != null) {
			System.out.println("Para o número " + num + ", some os indices " + r[0] + " e " + r[1]);
		} else {
			System.out.println("Combinação não encontrada");
		}
		ler.close();
	}

	static int[] indicesArray(int n, int vet[]) {
		int resultado[] = new int[2];

		for (int i = 0; i < vet.length - 1; i++) {

			for (int j = i; j < vet.length; j++) {

				if (vet[i] <= n) {

					if (vet[i] + vet[j] == n) {

						resultado[0] = i;
						resultado[1] = j;
						
			
						return resultado;

					}

				}

			}

		}
		return null;
	}
}
