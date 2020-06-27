package desafios;

public class AcumuloAgua {

	public static void main(String[] args) {
	int vet[] = new int[10];
		
	
		// criando randomicamente valores
		for(int i=0; i<vet.length;i++) {
			vet[i] = (int) (Math.random()*5);// altere o nivel 
			System.out.print(vet[i]);
		}

		// localizar maior indice no vetor
				int maiorNivel=-1;
				for (int i =0; i<vet.length; i++) {
					if(vet[i]>maiorNivel) {
						maiorNivel=vet[i];
					}
				
				}
		
		
		// desenhar grafico
		for(int j=maiorNivel; j>=0;j--) {
			System.out.println();
			for(int i=0; i<vet.length;i++) {
							
				if(vet[i]>j) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
				
			}
			
		}
		
		
		int acumulado=0;
		int indI=-1,indF=-1;
		for(int n = maiorNivel; n>=0;n--) {
			for(int i = 0; i<vet.length;i++) {
						
				if(vet[i]==n) {
					
					if(indI==-1) {
						indI=i;
					}else {
						indF=i;//so para referenciar
						int r = indF-indI-1;
						if(r>0) {
						acumulado += r;
						
						vet[indI]= n-1;
						indI=i;
						}else {
							
						vet[indI]= n-1;
						indI=i;
						}
					}
					
					
				}

		}
			if(indI>=0) {
			vet[indI]=n-1;
			}
			indI=-1;
		
	}
		System.out.println("\n\nO acumulado:  "+ acumulado);

}
}
