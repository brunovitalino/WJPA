package br.com.bv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory
{
	
	public Connection getConexao()
	{
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/wjpa", "root", "");
			}
			catch (SQLException e)
			{
				System.out.println("Nao foi possivel se conectar.");
				throw new RuntimeException(e);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Nome jdbc nao achado..");
			e1.printStackTrace();
		}
		
		return conexao;
	}

}
