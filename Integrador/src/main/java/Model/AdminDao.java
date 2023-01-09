package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conex;

public class AdminDao {

	Connection conn;
	ResultSet rs;

	public int buscaAdm(Admin adm) {
		int r = 0;
		try {

			conn = new Conex().conectar();
			String sql = "SELECT * FROM admin WHERE ad_cpf = ? AND ad_senha = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, adm.getAd_cpf());
			stmt.setString(2, adm.getAd_senha());

			rs = stmt.executeQuery();

			while (rs.next()) {

				r = r + 1;
				
				adm.setAd_id(rs.getInt("ad_id"));
				adm.setAd_nome(rs.getString("ad_nome"));
			}

			if (r == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}

	}
	
	
	
}
