package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Usuario;





public class UsuarioDAO  {
	
	/**Váriavel estática que definirá se o acesso (Autenticação) realmente aconteceu */
	public static boolean acesso;

	/**Esse método retorna um Objeto do tipo Usuario já preenchido com os dados do Usuario Logado
	 * Dessa forma poderemos trabalhar com os dados recuperados do banco */
	public Usuario Acesso(String login, String senha) {
		
		/**Instancia um novo usuário */
		Usuario user = new Usuario();
		
		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/clinica", "root", "root");
			consulta = (Statement) conn.createStatement();
			/**Realiza a consulta no banco passando dois parametros: login e senha */
			tabela = consulta.executeQuery( "SELECT idUsuario, nomeUsuario, loginUsuario, senhaUsuario, cargoUsuario from tbl_usuario WHERE loginUsuario='"
							+ login + "'and senhaUsuario='" + senha + "'");

			/**Se  os dados que foram passados existirem no banco de dados então pegamos esses dados e passamos para o objeto que foi instanciado */
			if (tabela.next()) {
				/**Repare que para pegar os dados temos que usar o tabela.get... */
				user.setIdUsuario(tabela.getString("idUsuario"));
				user.setNomeUsuario(tabela.getString("nomeUsuario"));
				user.setLoginUsuario(tabela.getString("loginUsuario"));
				user.setSenhaUsuario(tabela.getString("senhaUsuario"));
				user.setCargoUsuario(tabela.getString("cargoUsuario"));
				/**A variavel Acesso recebe True, ou seja estamos autenticados */
				acesso = true;
			} else {
				/**A variavel recebe false, não foi autencicado */
				acesso = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}


}
