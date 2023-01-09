package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conex {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/rh?useTimezone=true&serverTimezoneUTC";
	private String user = "root";
	private String password = "";
	
	
	public Connection conectar () {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void Testarconexao () {
		try { 
			Connection con = conectar ();
			System.out.println(con);
			con.close();
			
		}catch (Exception erro) {
			
			System.out.println(erro);
		}
	}
	
}
