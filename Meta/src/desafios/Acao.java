package desafios;

public class Acao {

	public static void main(String[] args) {
		
		int vet[] = new int[30];
		
		for(int i=0; i<vet.length;i++) {
			vet[i] = (int) (Math.random()*20)+1;
		}
		
		maiorLucro(vet);
		
		int vet2[] = {5,4,3,2};
		maiorLucro(vet2);
		
		int vet3[]={9,1,3,1,8,2};
		maiorLucro(vet3);
		
				
	}
	
	static void maiorLucro(int vet[]) {
		
		int diaC=0; // dia compra
		int diaV=0; // dia venda
		int lucro=0;
		if(vet!=null ) {
		System.out.print("\nDias    ");
		for(int i=0; i<vet.length;i++) {
			System.out.print(String.format("%-4d", i+1));
		}
		System.out.print("\nValores ");
		for(int i=0; i<vet.length;i++) {
			System.out.print(String.format("%-4d", vet[i]));
		}
		
		
		for (int i =0; i<vet.length-1;i++){
			
			for( int j=i+1; j<vet.length;j++) {
				
				
				if(vet[j]-vet[i]>lucro) {
					
					lucro = vet[j]-vet[i];
					diaC=i;
					diaV=j;
				}
			  				
			}
		}
		
		if(lucro!=0) {
			System.out.println("\n O maior lucro: " + lucro);
			System.out.println(" Dia de compra: " + (diaC+1));
			System.out.println(" Dia de venda: " + (diaV+1));
			
		}else {
			System.out.println("\n Não houve lucro maximoooooooo.");
		}
		
		}else {
			System.out.println("\n Vetor vazio.");
		}

	}

}
