package desafios;

public class Bracket {

	public static void main(String[] args) {

		String bracket = "([{}})";

		if (!bracket.isEmpty()) {
			System.out.println("1 Verdade: " + verificarBracket4(bracket));
		}

		bracket = "[]";
		if (!bracket.isEmpty()) {
			System.out.println("2 Verdade: " + verificarBracket4(bracket));
		}

		bracket = "[((]";
		if (!bracket.isEmpty()) {
			System.out.println("3 Falso: " + verificarBracket4(bracket));
		}

		bracket = "[(())]";
		if (!bracket.isEmpty()) {
			System.out.println("4 Vverdade: " + verificarBracket4(bracket));
		}

		bracket = "[()]({})";
		if (!bracket.isEmpty()) {
			System.out.println("5 Verdade: " + verificarBracket4(bracket));
		}
	
		bracket = "[()]({])";
		if (!bracket.isEmpty()) {
			System.out.println("6 Falso: " + verificarBracket4(bracket));
		}
		
		bracket = "[()]([})";
		if (!bracket.isEmpty()) {
			System.out.println("7 Falso " + verificarBracket4(bracket));
		}
		
		bracket = "[()}]({[})";
		if (!bracket.isEmpty()) {
			System.out.println("8 Falso: " + verificarBracket4(bracket));
		}
		
		bracket = "{[()]({})}";
		if (!bracket.isEmpty()) {
			System.out.println("9 Verdade: " + verificarBracket4(bracket));
		}
		
		bracket = "{[()]{}({})}";
		if (!bracket.isEmpty()) {
			System.out.println("10 Verdade: " + verificarBracket4(bracket));
		}
		
	}


		static boolean verificarBracket4(String s) {
		//	System.out.println(s);
			if(s.length()%2==1) {
				return false;
			}
			if(s.isEmpty()) {
				return true;
			}else {
				if(s.contains("{}")) {
				  return verificarBracket4(s.replace("{}", ""));
				}else if(s.contains("[]")) {
					  return verificarBracket4(s.replace("[]", ""));
					}else if (s.contains("()")) {
						  return verificarBracket4(s.replace("()", ""));
					}else {
						return false;}
				
					}
				
				
				
			}
			
			
		}
		
	
	
	
