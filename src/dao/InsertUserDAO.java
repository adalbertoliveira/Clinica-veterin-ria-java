package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Usuario;
import clinicaveterinaria.Conexao;

public class InsertUserDAO {

	private Connection connection;
	Long idUsuario;
	String nomeUsuario;
	String loginUsuario;
	String senhaUsuario;
	String cargoUsuario;

	public InsertUserDAO() {
		this.connection = Conexao.GeraConexao();
	}

	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO tbl_usuario(nomeUsuario, loginUsuario, senhaUsuario, cargoUsuario, valorUsuario) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getLoginUsuario());
			stmt.setString(3, usuario.getSenhaUsuario());
			stmt.setString(4, usuario.getCargoUsuario());
			stmt.setString(5, usuario.getValorUsuario());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void delete(Usuario usuario) {
		String sql = "delete from tbl_usuario where idUsuario = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getIdUsuario());

			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update pessoa set nomeUsuario=?, loginUsuario=?, senhaUsuario=?, cargoUsuario=?, valorUsuario=? where idUsuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getLoginUsuario());
			stmt.setString(3, usuario.getSenhaUsuario());
			stmt.setString(4, usuario.getCargoUsuario());
			stmt.setString(5, usuario.getValorUsuario());
			stmt.setString(6, usuario.getIdUsuario());
			stmt.execute();
			stmt.close();

			
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

}