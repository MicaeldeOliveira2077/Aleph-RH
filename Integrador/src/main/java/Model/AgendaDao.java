package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.Conex;

public class AgendaDao {
	Connection con;
	ResultSet rs;
	
	public void Salvar(Agenda1 agd) {
		
		String sql = "INSERT INTO agenda (data_agd, assunto, texto) VALUES (?,?, ?)";
		
		try {
			con = new Conex().conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, agd.getData_agd());
			stmt.setString(2, agd.getAssunto());
			stmt.setString(3, agd.getTexto());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException erro) {
			
			System.out.println(erro);
			
		}
		
	}
	
	public void BuscaAgd(Agenda1 agd) {
		
		try {
			
			con = new Conex().conectar();
			String sql ="SELECT * FROM agenda WHERE agd_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, agd.getAgd_id());
			rs = stmt.executeQuery();
			while (rs.next()) {
				agd.setAgd_id(rs.getInt("agd_id"));
				agd.setAssunto(rs.getString("assunto"));
				agd.setData_agd(rs.getString("data_agd"));
				agd.setTexto(rs.getString("texto"));
			}
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	}
	
	public ArrayList<Agenda1> Listar(){
		
		try {
			con = new Conex().conectar();
			String sql = "SELECT * FROM agenda";
			ArrayList<Agenda1> agds = new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();		
			
		while (rs.next()) {
			
		int Agd_id = rs.getInt("agd_id");
		String Data_agd = rs.getString("data_agd");
		String Assunto = rs.getString("assunto");
		String Texto = rs.getString("texto");
		
		agds.add(new Agenda1(Agd_id,Data_agd,Assunto, Texto));
			
		}
		
		return agds;
		
		} catch (SQLException erro) {
			System.out.println(erro);
			return null; }
		}
	
		public void Editar(Agenda1 agd) {

			
			String sql = "UPDATE agenda SET assunto = ?, data_agd = ?, texto= ? WHERE agd_id = ?";
			try {
				con = new Conex().conectar();
				
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, agd.getAssunto() );
				stmt.setString(2, agd.getData_agd());
				stmt.setString(3, agd.getTexto());
				stmt.setInt(4, agd.getAgd_id());
				
				
				stmt.executeUpdate();
				con.close();

			} catch (SQLException erro) {

				System.out.println(erro);

			}

		}
		
		public void Excluir(Agenda1 agd) {
			
			try {
				con = new Conex().conectar();
				String sql = "DELETE FROM agenda WHERE agd_id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, agd.getAgd_id());
				
				stmt.executeUpdate();
				con.close();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
}
