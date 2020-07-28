package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelAdmin {
	public String msg = "";
	Connection conn;

	public ModelAdmin() { 	//TODAS AS  TABELAS AQUI 
		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			String url = "jdbc:mysql://localhost:3306/";

			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);

			String sql = "CREATE DATABASE IF NOT EXISTS PlanningTask;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.execute();

			String use = "USE PlanningTask;";
			st = conn.prepareStatement(use);
			st.execute();

			// CRIA TABELA PESSOA VARCHAR nome, cpf ,cell, email, password,nomeEquipe
			String tabelaPessoa = "CREATE TABLE IF NOT EXISTS Pessoa(id int PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(100) NOT NULL,cpf VARCHAR(14)UNIQUE,cell VARCHAR(14)NOT NULL,email VARCHAR(100)NOT NULL, password VARCHAR(50) NOT NULL , nomeEquipe VARCHAR(50));";
			st = conn.prepareStatement(tabelaPessoa); 											
			st.execute();
			
		

		} catch (SQLException e) {
			msg = "SQL ERROR Err 1: "+e.toString();
		} catch (ClassNotFoundException e) {
			msg="Not found Exce Err 2: "+e.toString();
		}

	}

}
