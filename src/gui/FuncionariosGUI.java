package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Funcionario;
import dao.FuncionarioDAO;

public class FuncionariosGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosGUI frame = new FuncionariosGUI();
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
	public FuncionariosGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeFunc = new JLabel("Cadastro de funcionários");
		lblCadastroDeFunc.setBounds(193, 10, 200, 29);
		contentPane.add(lblCadastroDeFunc);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(32, 57, 58, 34);
		contentPane.add(lblNome);

		JLabel lblEspecialodade = new JLabel("Especialidade:");
		lblEspecialodade.setBounds(32, 93, 139, 29);
		contentPane.add(lblEspecialodade);

		JLabel lblValorDaConsulta = new JLabel("Valor da consulta:");
		lblValorDaConsulta.setBounds(32, 128, 139, 29);
		contentPane.add(lblValorDaConsulta);

		textField = new JTextField();
		textField.setBounds(134, 72, 200, -8);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(102, 63, 218, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(163, 96, 157, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(193, 131, 127, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(123, 163, 48, 29);
		contentPane.add(lblCrmv);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(193, 166, 127, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();

				funcionario.setNome(textField_1.getText());
				funcionario.setEspecialidade(textField_2.getText());
				funcionario.setValor(textField_3.getText());

				// fazendo a validação dos dados
				if ((textField_1.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty() || (textField_3
								.getText().isEmpty()))) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos.");
				} else {
					// instanciando a classe pessoaDAO do pacote dao e criando
					// seu objeto dao

					int i = JOptionPane.showConfirmDialog(null,
							"Confirme os dados: " + "\n" + "\n" + "Nome: "
									+ textField_1.getText() + "\n"
									+ "Especialidade: " + textField_2.getText()
									+ "\n" + "Valor: " + textField_3.getText()
									+ "\n" + "\n");
					if (i == JOptionPane.YES_OPTION) {
						FuncionarioDAO dao = new FuncionarioDAO();
						dao.adiciona(funcionario);

						JOptionPane.showMessageDialog(null, "Usuário "
								+ textField_1.getText()
								+ " inserido com sucesso! ");
						dispose();
						FuncionariosGUI frame = new FuncionariosGUI();
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
		btnCadastrar.setBounds(23, 408, 117, 25);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnLimpar.setBounds(163, 408, 117, 25);
		contentPane.add(btnLimpar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(297, 408, 117, 25);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(426, 408, 117, 25);
		contentPane.add(btnExcluir);

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
					String query = "SELECT * FROM funcionarios where crmv = '"
							+ ID_ + "'";
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						textField_4.setText(rs.getString("crmv"));
						textField_1.setText(rs.getString("nome"));
						textField_2.setText(rs.getString("especialidade"));
						textField_3.setText(rs.getString("valor"));

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
		modelo.addColumn("Especialidade");
		modelo.addColumn("Valor consulta");
		// exibe os dados da tabela MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/clinica", "root", "root");

			// procedimentos para obter os dados de uma tabela
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM funcionarios";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int crmv = rs.getInt("crmv");
				String nome = rs.getString("nome");
				String especialidade = rs.getString("especialidade");
				String valor = rs.getString("valor");
				modelo.addRow(new Object[] { new Integer(crmv), nome,
						especialidade, valor });
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
		scrollPane.setBounds(65, 222, 421, 163);
		c.add(scrollPane);
	}

}
