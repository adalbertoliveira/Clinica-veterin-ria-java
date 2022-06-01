package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Funcionario;
import clinicaveterinaria.Conexao;

public class PessoaDAO {
	private Connection connection;
	

	public PessoaDAO() {
		this.connection = Conexao.GeraConexao();
	}

	public void adiciona(Cliente cliente) {
		String sql = "INSERT INTO clientes(nome,idade,telefone,rg,animal,fidelidade) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getIdade());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getRg());
			stmt.setString(5, cliente.getAnimal());
			stmt.setString(6, cliente.getFidelidade());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void delete(Cliente cliente) {
		String sql = "delete from clientes where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void altera(Cliente cliente) {
		String sql = "update clientes set nome=?, idade=?, telefone=?, rg=?, animal=?, fidelidade=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getIdade());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getRg());
			stmt.setString(5, cliente.getAnimal());
			stmt.setString(6, cliente.getFidelidade());
			stmt.setString(7, cliente.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}


	
	public void adiciona(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios(nome,especialidade,valor) VALUES(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getEspecialidade());
			stmt.setString(3, funcionario.getValor());
		
		
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
	}
}
