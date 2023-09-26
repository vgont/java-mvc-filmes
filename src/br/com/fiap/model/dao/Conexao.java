/*
 * INTEGRANTES: VINICIUS GONTIJO SANTOS
 * RM: 550657
 * */
package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		final String USER = "rm550657";
		final String PASS = "260305";
		con = DriverManager.getConnection(url, USER, PASS);
		System.out.println("Conexao aberta!");
		return con;
	}
	
	public static void fecharConexao(Connection con) throws SQLException {
		con.close();
		System.out.println("Conexao fechada!");
	}
}

