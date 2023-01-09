package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexao.Conex;


public class FunDao {

	Connection con;
	ResultSet rs;

	public void Salvar(Funcionario fun) {
		
		String sql = "INSERT INTO funcionario (nome, data_nascimento, cpf, tel, endereco, entrada) VALUES (?,?,?,?,?,?)";

		try {
			con = new Conex().conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, fun.getNome());
			stmt.setString(2, fun.getData_nasc());
			stmt.setString(3, fun.getCpf());
			stmt.setString(4, fun.getTelefone());
			stmt.setString(5, fun.getEndereco());
			stmt.setString(6, fun.getEntrada());
			stmt.executeUpdate();
			con.close();

		} catch (SQLException erro) {

			System.out.println(erro);

		}
	}

	public void BuscaFun(Funcionario fun) {

		try {
			con = new Conex().conectar();
			String sql = "SELECT * FROM funcionario WHERE Fun_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, fun.getFun_id());
			rs = stmt.executeQuery();
			while (rs.next()) {
				fun.setFun_id(rs.getInt("fun_id"));
				fun.setNome(rs.getString("nome"));
				fun.setData_nasc(rs.getString("data_nascimento"));
				fun.setCpf(rs.getString("cpf"));
				fun.setTelefone(rs.getString("tel"));
				fun.setEndereco(rs.getString("endereco"));
				fun.setEntrada(rs.getString("entrada"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Funcionario> listar() {

		try {
			con = new Conex().conectar();
			String sql = "SELECT * FROM funcionario";
			ArrayList<Funcionario> funs = new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int fun_id = rs.getInt("fun_id");
				String nome = rs.getString("nome");
				String data_nasc = rs.getString("data_nascimento");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("tel");
				String endereco = rs.getString("endereco");
				String entrada = rs.getString("entrada");

				funs.add(new Funcionario(fun_id,nome,data_nasc,cpf,telefone,endereco,entrada));
			}

			return funs;

		} catch (SQLException erro) {
			System.out.println(erro);
			return null;
		}

	}

	public void Editar(Funcionario fun) {

		
		String sql = "UPDATE funcionario SET nome = ?, data_nascimento = ?,cpf= ?, tel = ?, endereco = ?, entrada = ? WHERE fun_id = ?";
		try {
			con = new Conex().conectar();
			
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, fun.getNome());
			stmt.setString(2, fun.getData_nasc());
			stmt.setString(3, fun.getCpf());
			stmt.setString(4, fun.getTelefone());
			stmt.setString(5, fun.getEndereco());
			stmt.setString(6, fun.getEntrada());
			stmt.setInt(7, fun.getFun_id());
			
			
			stmt.executeUpdate();
			con.close();

		} catch (SQLException erro) {

			System.out.println(erro);

		}

	}
	
	public void Excluir(Funcionario fun) {
		
		try {
			con = new Conex().conectar();
			String sql = "DELETE FROM funcionario WHERE fun_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, fun.getFun_id());
			
			stmt.executeUpdate();
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	
	
	
	

}
