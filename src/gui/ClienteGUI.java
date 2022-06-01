package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.ClienteDAO;
import modelo.Limitenome;
import modelo.Limiteidade;
import modelo.Limiterg;
import modelo.Limitetelefone;
import modelo.Cliente;

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

public class ClienteGUI extends JFrame {

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
	private JTextField textField_5;
	AtendimentoGUI enviatexto ;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI();
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
	public ClienteGUI() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setForeground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblCadastris = new JLabel("Cadastros de clientes");
		lblCadastris.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCadastris.setBounds(21, 12, 125, 14);
		contentPane.add(lblCadastris);

		textField = new JTextField();
		textField.setBounds(100, 106, 261, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setDocument(new Limitenome(66));
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNome.setBounds(39, 109, 33, 14);
		contentPane.add(lblNome);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblIdade.setBounds(49, 145, 31, 14);
		contentPane.add(lblIdade);

		textField_1 = new JTextField();
		textField_1.setBounds(100, 142, 33, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setDocument(new Limiteidade(2));
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblTelefone.setBounds(39, 179, 49, 14);
		contentPane.add(lblTelefone);

		textField_2 = new JTextField();
		textField_2.setBounds(100, 173, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setDocument(new Limitetelefone(13));
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblRg.setBounds(49, 212, 16, 14);
		contentPane.add(lblRg);

		textField_3 = new JTextField();
		textField_3.setBounds(100, 209, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setDocument(new Limiterg(7));
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(34, 242, 70, 15);
		contentPane.add(lblAnimal);

		textField_5 = new JTextField();
		textField_5.setBounds(100, 240, 205, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setDocument(new Limitenome(66));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instanciando a classe Pessoa do pacote modelo e criando seu
				// objeto usuarios
				Cliente cliente = new Cliente();
				cliente.setNome(textField.getText());
				cliente.setIdade(textField_1.getText());
				cliente.setTelefone(textField_2.getText());
				cliente.setRg(textField_3.getText());
				cliente.setAnimal(textField_5.getText());
				cliente.setFidelidade(textField_6.getText());

				// fazendo a validação dos dados
				if ((textField.getText().isEmpty())
						|| (textField_1.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty())
						|| textField_5.getText().isEmpty()
						|| textField_6.getText().isEmpty()
						) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos");
				} else {
					// instanciando a classe pessoaDAO do pacote dao e criando
					// seu objeto dao
					int i = JOptionPane.showConfirmDialog(null,
							"Confirme os dados: " + "\n" + "\n" + "Nome: "
									+ textField.getText() + "\n" + "Idade: "
									+ textField_1.getText() + "\n"
									+ "Telefone: " + textField_2.getText()
									+ "\n" + "RG: " + textField_3.getText()
									+ "\n" + "Animal: " + textField_5.getText()
									+ "\n");
					if (i == JOptionPane.YES_OPTION) {
						System.out.println("Clicou em Sim");
						ClienteDAO dao = new ClienteDAO();
						dao.adiciona(cliente);
						dispose();
						ClienteGUI frame = new ClienteGUI();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Cliente "
								+ textField.getText()
								+ " inserido com sucesso! ");
					} else if (i == JOptionPane.NO_OPTION) {
						System.out.println("Clicou em Não");
						ClienteGUI frame = new ClienteGUI();
						frame.setVisible(true);
						dispose();
					} else if (i == JOptionPane.CANCEL_OPTION) {
						System.out.println("Clicou em Cancel");
						ClienteGUI frame = new ClienteGUI();
						frame.setVisible(true);
						dispose();

					}
					// apaga os dados preenchidos nos campos de texto
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_5.setText("");
					textField_4.setText("");
					textField_6.setText("");
				}
			}
		});
		btnCadastrar.setBounds(21, 368, 91, 24);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_4.setText("");
				textField_6.setText("");
				
			}

		});

		btnLimpar.setBounds(139, 368, 79, 24);
		contentPane.add(btnLimpar);

		JButton btnSair = new JButton("Voltar");
		btnSair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnSair.setBounds(449, 34, 67, 24);
		contentPane.add(btnSair);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ClienteGUI.class
				.getResource("/image/personlog.png")));
		label.setBounds(407, 86, 128, 128);
		contentPane.add(label);

		JLabel lblPreenchaTodosOs = new JLabel("Preencha todos os campos");
		lblPreenchaTodosOs.setBounds(31, 38, 191, 15);
		contentPane.add(lblPreenchaTodosOs);

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
					String query = "SELECT * FROM clientes where id = '" + ID_
							+ "'";
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						textField_4.setText(rs.getString("id"));
						textField.setText(rs.getString("nome"));
						textField_1.setText(rs.getString("idade"));
						textField_2.setText(rs.getString("telefone"));
						textField_3.setText(rs.getString("rg"));
						textField_5.setText(rs.getString("animal"));
						textField_6.setText(rs.getString("fidelidade"));

					}

					// fim procedimento para obter os dados
				} catch (Exception ex) {
					System.out
							.println("Ocorreu algum problema com o banco de dados");
				}
			}
		});

		// Cria duas colunas
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Telefone");
		modelo.addColumn("Rg");
		modelo.addColumn("Animal");
		modelo.addColumn("Fidelidade");
		

		// exibe os dados da tabela MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/clinica", "root", "root");

			// procedimentos para obter os dados de uma tabela
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM clientes";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String idade = rs.getString("idade");
				String telefone = rs.getString("telefone");
				String rg = rs.getString("rg");
				String animal = rs.getString("animal");
				String fidelidade = rs.getString("fidelidade");
				
				modelo.addRow(new Object[] { new Integer(id), nome, idade,
						telefone, rg, animal, fidelidade});
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

		scrollPane.setBounds(21, 421, 588, 148);
		c.add(scrollPane);

	
		getContentPane().add(label);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(100, 75, 67, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblDigiteOId = new JLabel("ID");
		lblDigiteOId.setBounds(55, 82, 49, 15);
		contentPane.add(lblDigiteOId);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setId(textField_4.getText());
				int i = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir esse cliente?");
				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					ClienteDAO dao = new ClienteDAO();
					dao.delete(cliente);
					dispose();
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Cliente "
							+ textField_4.getText() + " excluido com sucesso! ");
				} else if (i == JOptionPane.NO_OPTION) {
					System.out.println("Clicou em Não");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();
				} else if (i == JOptionPane.CANCEL_OPTION) {
					System.out.println("Clicou em Cancel");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();

				}
			}
		});
		btnExcluir.setBounds(364, 367, 79, 24);
		contentPane.add(btnExcluir);

		

		setSize(634, 610);
		setVisible(true);
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setId(textField_4.getText());
				cliente.setNome(textField.getText());
				cliente.setIdade(textField_1.getText());
				cliente.setTelefone(textField_2.getText());
				cliente.setRg(textField_3.getText());
				cliente.setAnimal(textField_5.getText());
				cliente.setFidelidade(textField_6.getText());
				
				int i = JOptionPane.showConfirmDialog(null,
						"Deseja realmente alterar os dados?");
				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					ClienteDAO dao = new ClienteDAO();
					dao.altera(cliente);
					dispose();
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Cliente "
							+ textField_4.getText() + " alterado com sucesso! ");
				} else if (i == JOptionPane.NO_OPTION) {
					System.out.println("Clicou em Não");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();
				} else if (i == JOptionPane.CANCEL_OPTION) {
					System.out.println("Clicou em Cancel");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();

				}

			}
		});
		btnAlterar.setBounds(236, 367, 100, 25);
		contentPane.add(btnAlterar);
		
		JButton btnAbrirConsulta = new JButton("Abrir consulta");
		btnAbrirConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// fazendo a validação dos dados
				if ((textField.getText().isEmpty())
						|| (textField_1.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty())
						|| textField_5.getText().isEmpty()
						) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos");
				}else {
				
				
				int i = JOptionPane.showConfirmDialog(null,
						"Deseja realmente alterar abrir uma consulta com veterinário?");
				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					if(enviatexto == null){
						enviatexto = new AtendimentoGUI();
						enviatexto.setVisible(true);
						enviatexto.recebendo(textField.getText());
						enviatexto.recebendo1(textField_5.getText());
						enviatexto.recebendo2(textField_4.getText());
						}
						else{
						enviatexto.setVisible(true);
						enviatexto.setState(AtendimentoGUI.NORMAL);
						}
					dispose();
					
					
				
					
				} else if (i == JOptionPane.NO_OPTION) {
					System.out.println("Clicou em Não");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();
				} else if (i == JOptionPane.CANCEL_OPTION) {
					System.out.println("Clicou em Cancel");
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					dispose();

				}
				
			}
				// apaga os dados preenchidos nos campos de texto
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_4.setText("");
				textField_6.setText("");
			}
		});
		btnAbrirConsulta.setBounds(474, 367, 135, 25);
		contentPane.add(btnAbrirConsulta);
		
		textField_6 = new JTextField();
		textField_6.setBounds(100, 279, 40, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblFidelidade = new JLabel("Fidelidade");
		lblFidelidade.setBounds(10, 273, 91, 30);
		contentPane.add(lblFidelidade);

	}
}
