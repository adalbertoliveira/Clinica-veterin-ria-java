package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Atendimento;
import clinicaveterinaria.Conexao;

public class AtendimentoDAO {
	private Connection connection;

	public AtendimentoDAO() {
		this.connection = Conexao.GeraConexao();
	}

	public void adiciona(Atendimento atende) {
		String sql = "INSERT INTO atendimento(iduser, idpessoa, descricao, valoratendimento) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, atende.getIduser());
			stmt.setString(2, atende.getIdpessoa());
			stmt.setString(3, atende.getDescricao());
			stmt.setString(4, atende.getValoratendimento());
			

			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		

	}
	
}
