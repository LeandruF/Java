package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class VeriProjetoTarefa {
	protected String msg;
	public boolean verificarNome(String nome) {
		nome.trim();
		if (nome.isEmpty() || nome.length() < 3) {
			msg = "Nome invalido.";
			return false;
		} else {
			return true;
		}
	}
	public boolean verificarDescricao(String descricao) {
		descricao.trim();
		if (descricao.isEmpty() ) {
			msg = "Descrição invalido.";
			return false;
		} else {
			return true;
		}
	}
	public boolean verificarHoraIni(String horaIni) { //Verifica Somente a quantidade de caracter
		if(horaIni.length()==5) {		
			String[] hora  = horaIni.split(":");
			int hh = Integer.parseInt(hora[0]);
			int mm = Integer.parseInt(hora[1]);
			int cont = 0;
			if(hh<24 && hh>-1  ) {
				//System.out.println("A hora ok");
				cont++;
			}
			if(mm>=0 && mm<60) {
			//	System.out.println("Os min ok");
				cont++;
			}
			System.out.println(cont);
			if(cont == 2) {
				//System.out.println(hh+":"+mm);
				return true;
			}else{
			
				//System.out.println("ERRO: "+hh+":"+mm);
				return false;
			}
			
		}else {
			return false;
		}
	}
	public boolean verificarHoraFim(String horaFim) { //Verifica Somente a quantidade de caracter
		if(horaFim.length()==5) {		
			String[] hora  = horaFim.split(":");
			int hh = Integer.parseInt(hora[0]);
			int mm = Integer.parseInt(hora[1]);
			int cont = 0;
			if(hh<24 && hh>-1  ) {
			//	System.out.println("A hora ok");
				cont++;
			}
			if(mm>=0 && mm<60) {
			//	System.out.println("Os min ok");
				cont++;
			}
			if(cont == 2) {
			//	System.out.println(hh+":"+mm);
				return true;
			}else{
				return false;
			}
			
		}else {
			return false;
		}
	}
	public boolean verificarDataIni(String dataIni) { //Verifica Somente a quantidade de caracter
		if(dataIni.length()==10) {		
			int cont = 0;
			 String[] data = dataIni.split("/");			 
				   int dia = Integer.parseInt(data[0]);
				   int mes = Integer.parseInt(data[1]);
				   int ano = Integer.parseInt(data[2]);
			 if(dia>0 && dia<32 ) {
				 cont++;
				 
				// System.out.println("DIA OK "+dia);
			 }
			 if(mes>0 && mes<13 ) {
				 cont++;
				// System.out.println("MES OK "+mes);
			 }
			 if(ano>=2020) {
				 cont++;
				// System.out.println("ANO OK "+ano);
			 }else {
				// System.out.println("ANO NÃO "+ano);
			 }
			 
			   
			   if(cont == 3) { // CONTADOR PARA SABER SE O DIA / MES / ANO  == true 
				   return true;
			   }else {
				   return false;
			   }
			}else {
				return false;
			}
	}
	public boolean verificarDataFim(String dataFim) { //Verifica Somente a quantidade de caracter
		if(dataFim.length()==10) {		
			int cont = 0;
			 String[] data = dataFim.split("/");
			 
				   int dia = Integer.parseInt(data[0]);
				   int mes = Integer.parseInt(data[1]);
				   int ano = Integer.parseInt(data[2]);
			 if(dia>0 && dia<32 ) {
				 cont++;
				 
				// System.out.println("DIA OK "+dia);
			 }
			 if(mes>0 && mes<13 ) {
				 cont++;
				// System.out.println("MES OK "+mes);
			 }
			 if(ano>=2020) {
				 cont++;
				// System.out.println("ANO OK "+ano);
			 }else {
				// System.out.println("ANO NÃO "+ano);
			 }
			 
			   
			   if(cont == 3) { // CONTADOR PARA SABER SE O DIA / MES / ANO  == true 
				   return true;
			   }else {
				   return false;
			   }
			}else {
				return false;
			}
	}

	/*Quanto tempo falta para terminar o projeto ou tarefa
	 * pega a data atual e subtrai a data prevista
	 * */
	//FALTA PEGAR A DATA FINAL NO BANCO DEDADOS E REMOVER A PASSAGEM DE PARAMETRO
	public int calcPrazo(String prazo) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 											
													 //15/07/2020 12:40:54
		Date data1 = new Date();
		
		String dia = dateFormat.format(data1).substring(0,2); // PEGA O DIA DO SISTEMA
		String mes = dateFormat.format(data1).substring(3,5); // PEGA O MES DO SISTEMA
		String ano = dateFormat.format(data1).substring(6,10); // PEGA O ANO DO SISTEMA
		
		
		String diaPra = prazo.substring(0,2); // DIA DO TERMINO (PRAZO)
		String mesPra = prazo.substring(3,5); // MES DO TERMINO
		String anoPra = prazo.substring(6,10); //ANO DO TERMINO

		Date data2 = new Date();
		
		Calendar c1 = Calendar.getInstance();
		
		//Pega a primeira data do sistema
		c1.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia)); //YYYY/MM/DD
		data1.setTime(c1.getTimeInMillis());
		
		//Pega a segunda data do prazo
		c1.set(Integer.parseInt(anoPra), Integer.parseInt(mesPra), Integer.parseInt(diaPra));//YYYY/MM/DD
		data2.setTime(c1.getTimeInMillis());
		
		// FAZ O CALCULO E RETORNA O NUMERO DE DIAS QUE FALTAM
		 long calc = (data2.getTime() - data1.getTime()) /1000/60/60/24; 
		 System.out.println("FALTAA: "+calc+" Dias");
		int faltaNumDias = (int)calc;
	
		return faltaNumDias;
		
	}
	//FALTA PEGAR A DATA FINAL NO BANCO DEDADOS E REMOVER A PASSAGEM DE PARAMETRO
	public void qtdTempComeca(String horaIni,int tempAviso) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 											
													//15/07/2020 12:40:54
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = new Date(); 
		
		String h = dateFormat.format(date).substring(11,13); // pega hora DO SISTEMA
		String m = dateFormat.format(date).substring(14,16); // pega o minuto DO SISTEMA
		
		
		    String hIni = horaIni.substring(0,2); // HORA PRA COMEÇAR
		    String mIni = horaIni.substring(3,5); // MINUTOS PARA COMEÇAR
		 
		    int hora = Integer.parseInt(hIni) - Integer.parseInt(h);
		    int min = Integer.parseInt(mIni) - Integer.parseInt(m);
		    if(hora <= 0) {
		    	
		     if(min>0) {
		    	System.out.println("Falta "+ min+" min.");
		    }else {
		    	if(min == 0) {
		    		System.out.println("STARTA LOGO ISSO!");
		    	}else {
		    		System.out.println("JA PASSOU "+min+"min.");
		    		
		    	}
		    }
		    }else if(hora<=tempAviso) {
		    	if(Integer.parseInt(mIni)<min) {
		    		min = Integer.parseInt(m) - Integer.parseInt(mIni);
		    		System.out.println("FALTA "+hora+":"+min);
		    	}else {
		    		String regex = "" + min;
		 		   regex = regex.replaceAll("[^0-9]", "");
		 		   int minCorri = Integer.parseInt(regex);
		 		   
		    		System.out.println("FALTAs "+hora+":"+minCorri);
		    	}
		    }else {
		    	System.out.println("Ainda falta muito");
		    }
	}
}
		    
	/*SE A HORA/DATA DE ALERTA FOR MENOR OU IGUAL A HORAINI/ DATAINI AVISAR*/
	/*Emitir alerta quanto tempo falta pra começar tarefa/projeto*/
	/*Emitir alerta quanto tempo falta pra terminar tarefa/projeto*/

