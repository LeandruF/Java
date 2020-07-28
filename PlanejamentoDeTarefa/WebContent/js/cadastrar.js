

function verificarNome(){
	nome = document.getElementById("idNome").value;
	if(nome=="" || nome==null){
		document.getElementById("nomeMsg").innerHTML ="";
		document.getElementById("nomeMsg").innerHTML += "Nome em branco.<br>";
	}else{
		document.getElementById("nomeMsg").innerHTML ="";
		}	
}
function verificarCpf(){
	cpf = document.getElementById("idCpf").value;
	if(cpf=="" || cpf==null || cpf.length!=14){
		document.getElementById("cpfMsg").innerHTML ="";
		document.getElementById("cpfMsg").innerHTML += "Cpf invalido.<br>";
	}else{
	document.getElementById("cpfMsg").innerHTML ="";
	}	

}

function verificarCell(){
	cell = document.getElementById("idCell").value;
	if(cell=="" || cell==null || cell.length!=14){
		document.getElementById("cellMsg").innerHTML ="";
		document.getElementById("cellMsg").innerHTML += "Cell invalido.<br>";
	}else{
	document.getElementById("cellMsg").innerHTML ="";
	}	

}
function verificarEmail(){
	email = document.getElementById("idEmail").value;
	indiceEmail = email.indexOf('@');//Tem @ ?
	if(email == "" || email == null){
		document.getElementById("emailMsg").innerHTML = "";
		document.getElementById("emailMsg").innerHTML += "Email em Branco.<br>";
	}else if(indiceEmail>0){
		document.getElementById("emailMsg").innerHTML = "";

		}else{
			document.getElementById("emailMsg").innerHTML = "";
			document.getElementById("emailMsg").innerHTML += "Email invalido.<br>";
	}
}
function verificarPassword(){
	password = document.getElementById("idPassword").value;
	
		 validacao = false;
		up=false; // VAI SER TESTADO NA VERIFICA��O DO CHARACTER MAIUSCULO
		low=false;// VAI SER TESTADO NA VERIFICA��O DO CHARACTER MINUSCULO
	 
	if(password!="" || password != null) {
		if(password.length<8) {
			document.getElementById("passwordMsg").innerHTML ="";
			document.getElementById("passwordMsg").innerHTML += "Precisa ter mais que 8 caracter.<br>";
			
		}
		else {
			//	REGEX			UPPER MIN 1        LOWER MIN 1        NUMBER MIN 1
			var regex = /^(?=(?:.*?[A-Z]){1})(?=(?:.*?[a-z]){1})(?=(?:.*?[0-9]){1})[0-9a-zA-Z!@#$%;*(){}_+^&]*$/;
			 if(!regex.exec(password)){
				 document.getElementById("passwordMsg").innerHTML ="";
				document.getElementById("passwordMsg").innerHTML += "Precisa ter pelomenos 1 Maiusculo 1 Minusculo e 1 Numero.<br>";
			}else{
				document.getElementById("passwordMsg").innerHTML ="";
			}
				
		}
	}
}

function btnVoltarIndex(){
	window.location.href = "index.html"
}
function btnCadastrarPessoa(){
	window.location.href = "cadastrar.html"
}



function repetirPassword(){
	senha = document.getElementById("idPassword").value;
	repetirSenha = document.getElementById("idRepetirPassword").value;
	if(senha == repetirSenha){
		document.getElementById("repetirPasswordMsg").innerHTML ="";
	}else{
		document.getElementById("repetirPasswordMsg").innerHTML ="";
		 document.getElementById("repetirPasswordMsg").innerHTML += "Senhas diferentes.<br>";
		 		
	}
}