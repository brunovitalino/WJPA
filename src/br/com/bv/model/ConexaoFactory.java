package br.com.bv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe TESTE
public class ConexaoFactory
{	
	public Connection getConexaoSqlServer()
	{
		Connection conexao = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try
			{
				conexao = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=jdbc", "sa", "s3nh4nvst!");
				System.out.println("Conectado ao SQL Server.");
			}
			catch (SQLException e)
			{
				System.out.println("Nao foi possivel se conectar.");
				throw new RuntimeException(e);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Dependencia (lib) jdbc nao achada!");
			e1.printStackTrace();
		}
		
		return conexao;
	}
	
	public Connection getConexaoMySql()
	{
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/wjpa", "root", "");
				System.out.println("Conectado ao SQL Server.");
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
