package test;

import java.util.Scanner;

import view.ViewContato;

public class main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ViewContato vc = new ViewContato();

		vc.vMenuContato(ler);
	}

}
