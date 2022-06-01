package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import modelo.Limitenome;
import modelo.Usuario;
import dao.InsertUserDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UsuarioGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGUI() {
		super("Cadastro de funcionários");
		setTitle("Cadastro de funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblCadastroDe = new JLabel(
				"Informe os dados para o cadastro do funcin\u00E1rio no sistema");
		lblCadastroDe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCadastroDe.setBounds(20, 10, 342, 14);
		contentPane.add(lblCadastroDe);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNome.setBounds(66, 67, 37, 14);
		contentPane.add(lblNome);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblLogin.setBounds(90, 93, 34, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblSenha.setBounds(104, 119, 40, 14);
		contentPane.add(lblSenha);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCargo.setBounds(131, 145, 38, 14);
		contentPane.add(lblCargo);

		textField_1 = new JTextField();
		textField_1.setBounds(124, 64, 227, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setDocument(new Limitenome(66));
		textField_2 = new JTextField();
		textField_2.setBounds(154, 90, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(177, 116, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(207, 142, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setDocument(new Limitenome(66));
		final DefaultTableModel modelo = new DefaultTableModel();

		// constrói a tabela
		JTable tabela = new JTable(modelo);
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = tabela.getSelectedRow();
					String ID_ = (tabela.getModel().getValueAt(row, 0))
							.toString();
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost/clinica", "root", "root");

					// procedimentos para obter os dados de uma tabela
					Statement stmt = conn.createStatement();
					String query = "SELECT * FROM tbl_usuario where idUsuario = '"
							+ ID_ + "'";
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						textField.setText(rs.getString("idUsuario"));
						textField_1.setText(rs.getString("nomeUsuario"));
						textField_4.setText(rs.getString("cargoUsuario"));
					

					}

					// fim procedimento para obter os dados
				} catch (Exception ex) {
					System.out
							.println("Ocorreu algum problema com o banco de dados");
				}

			}
		});

		// Cria duas colunas
		modelo.addColumn("CRMV");
		modelo.addColumn("Nome");
		modelo.addColumn("Cargo");
	
		// exibe os dados da tabela MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/clinica", "root", "root");

			// procedimentos para obter os dados de uma tabela
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM tbl_usuario";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("idUsuario");
				String nome = rs.getString("nomeUsuario");
				String cargo = rs.getString("cargoUsuario");
				String valor = rs.getString("valorUsuario");
				modelo.addRow(new Object[] { new Integer(id), nome, cargo,
						valor });
			}

			// fim procedimento para obter os dados
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema com o banco de dados");
		}
		// fim MySQL

		tabela.setPreferredScrollableViewportSize(new Dimension(350, 160));

		Container c = getContentPane();

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(33, 328, 503, 163);
		c.add(scrollPane);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = new Usuario();

				usuario.setNomeUsuario(textField_1.getText());
				usuario.setLoginUsuario(textField_2.getText());
				usuario.setSenhaUsuario(textField_3.getText());
				usuario.setCargoUsuario(textField_4.getText());
			
				// fazendo a validação dos dados
				if ((textField_1.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty() || (textField_3
								.getText().isEmpty() || (textField_4.getText()
								.isEmpty())))) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos.");
				} else {
					// instanciando a classe pessoaDAO do pacote dao e criando
					// seu objeto dao

					int i = JOptionPane.showConfirmDialog(null,
							"Confirme os dados: " + "\n" + "\n" + "Nome: "
									+ textField_1.getText() + "\n" + "Login: "
									+ textField_2.getText() + "\n" + "Senha: "
									+ textField_3.getText() + "\n" + "Cargo: "
									+ textField_4.getText() + "\n");
					if (i == JOptionPane.YES_OPTION) {
						InsertUserDAO dao = new InsertUserDAO();
						dao.adiciona(usuario);

						JOptionPane.showMessageDialog(null, "Usuário "
								+ textField_1.getText()
								+ " inserido com sucesso! ");
						dispose();
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
					} else if (i == JOptionPane.NO_OPTION) {
						System.out.println("Clicou em Não");
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
						dispose();
					} else if (i == JOptionPane.CANCEL_OPTION) {
						System.out.println("Clicou em Cancel");
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
						dispose();

					}
				}

				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnCadastrar.setBounds(33, 260, 91, 24);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnLimpar.setBounds(337, 260, 73, 24);
		contentPane.add(btnLimpar);

		JLabel lblPreenchaTodosOs = new JLabel("Preencha todos os campos");
		lblPreenchaTodosOs
				.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblPreenchaTodosOs.setBounds(45, 36, 156, 14);
		contentPane.add(lblPreenchaTodosOs);

		JButton btnVoltarParaO = new JButton("Voltar");
		btnVoltarParaO.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnVoltarParaO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnVoltarParaO.setBounds(450, 31, 67, 24);
		contentPane.add(btnVoltarParaO);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UsuarioGUI.class
				.getResource("/image/catlog.png")));
		label.setBounds(408, 93, 128, 128);
		contentPane.add(label);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(textField.getText());
				int i = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir esse Funcionario?");
				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					InsertUserDAO dao = new InsertUserDAO();
					dao.delete(usuario);
					dispose();
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Funcionario "
							+ textField.getText() + " excluido com sucesso! ");
				} else if (i == JOptionPane.NO_OPTION) {
					System.out.println("Clicou em Não");
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
					dispose();
				} else if (i == JOptionPane.CANCEL_OPTION) {
					System.out.println("Clicou em Cancel");
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
					dispose();

				}
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnExcluir.setBounds(185, 260, 83, 24);
		contentPane.add(btnExcluir);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(234, 173, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblCrmv = new JLabel("CRMV:");
		lblCrmv.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCrmv.setBounds(177, 178, 45, 14);
		contentPane.add(lblCrmv);
		
		JButton Alterar = new JButton("Alterar");
		Alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();

				usuario.setNomeUsuario(textField_1.getText());
				usuario.setLoginUsuario(textField_2.getText());
				usuario.setSenhaUsuario(textField_3.getText());
				usuario.setCargoUsuario(textField_4.getText());
			
				// fazendo a validação dos dados
				if ((textField_1.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty() || (textField_3
								.getText().isEmpty() || (textField_4.getText()
								.isEmpty())))) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos.");
				} else {
					// instanciando a classe pessoaDAO do pacote dao e criando
					// seu objeto dao

					int i = JOptionPane.showConfirmDialog(null,
							"Confirme os dados: " + "\n" + "\n" + "Nome: "
									+ textField_1.getText() + "\n"
									+ "\n" + "Cargo: "
									+ textField_4.getText() + "\n");
					if (i == JOptionPane.YES_OPTION) {
						InsertUserDAO dao = new InsertUserDAO();
						dao.altera(usuario);

						JOptionPane.showMessageDialog(null, "Usuário "
								+ textField_1.getText()
								+ " inserido com sucesso! ");
						dispose();
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
					} else if (i == JOptionPane.NO_OPTION) {
						System.out.println("Clicou em Não");
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
						dispose();
					} else if (i == JOptionPane.CANCEL_OPTION) {
						System.out.println("Clicou em Cancel");
						UsuarioGUI frame = new UsuarioGUI();
						frame.setVisible(true);
						dispose();

					}
				}

				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			
			}
		});
		Alterar.setFont(new Font("Dialog", Font.PLAIN, 11));
		Alterar.setBounds(463, 260, 73, 24);
		contentPane.add(Alterar);
	}
}
