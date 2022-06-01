package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtendimentoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
PagamentoGUI enviatexto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtendimentoGUI frame = new AtendimentoGUI();
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
	public AtendimentoGUI() {
		super("Tela de consuta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(166, 72, 237, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(46, 74, 70, 15);
		contentPane.add(lblNome);

		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(46, 101, 70, 15);
		contentPane.add(lblAnimal);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(166, 99, 175, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(44, 155, 453, 96);
		contentPane.add(textPane);

		JLabel lblDescrio = new JLabel("Descrição do problema:");
		lblDescrio.setBounds(46, 128, 203, 15);
		contentPane.add(lblDescrio);

		JLabel lblSelecioneOProfissional = new JLabel(
				"Selecione o profissional que deverá cuidar do caso");
		lblSelecioneOProfissional.setBounds(46, 275, 381, 15);
		contentPane.add(lblSelecioneOProfissional);
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

						textField_7.setText(rs.getString("crmv"));
						textField_2.setText(rs.getString("nome"));
						textField_3.setText(rs.getString("especialidade"));
						textField_5.setText(rs.getString("valor"));

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
				modelo.addRow(new Object[] { new Integer(crmv), nome, especialidade });
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
		scrollPane.setBounds(44, 302, 453, 163);
		c.add(scrollPane);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(108, 508, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(244, 508, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblProfissonal = new JLabel("Profissonal");
		lblProfissonal.setBounds(108, 477, 114, 19);
		contentPane.add(lblProfissonal);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(250, 477, 108, 19);
		contentPane.add(lblEspecialidade);

		JLabel lblValorDaConsulta = new JLabel("Valor da consulta");
		lblValorDaConsulta.setBounds(406, 477, 136, 15);
		contentPane.add(lblValorDaConsulta);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(416, 508, 53, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblR = new JLabel("R$");
		lblR.setBounds(487, 509, 35, 17);
		contentPane.add(lblR);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField.getText().isEmpty())
						|| (textPane.getText().isEmpty())
						|| (textField_2.getText().isEmpty())
						|| (textField_3.getText().isEmpty())
						|| textField_5.getText().isEmpty()
						|| textField_7.getText().isEmpty()
						
						) {
					JOptionPane.showMessageDialog(null,
							"Preencha todos os campos");
				}else {

				int i = JOptionPane.showConfirmDialog(null,
						"Deseja realmente realizar consulta?");
				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					
					
					
					if(enviatexto == null){
						enviatexto = new PagamentoGUI();
						enviatexto.setVisible(true);
						enviatexto.recebendo1(textField.getText());
						enviatexto.recebendo(textField_5.getText());
						enviatexto.recebendo2(textField_2.getText());
						enviatexto.recebendo3(textPane.getText());
						enviatexto.recebendo4(textField_7.getText());
						enviatexto.recebendo5(textField_6.getText());
						}
						else{
						enviatexto.setVisible(true);
						enviatexto.setState(PagamentoGUI.NORMAL);
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
		}});
		btnConfirmar.setBounds(46, 545, 117, 25);
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteGUI frame = new ClienteGUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(213, 545, 117, 25);
		contentPane.add(btnCancelar);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(46, 47, 70, 15);
		contentPane.add(lblId);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(164, 41, 27, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(29, 481, 70, 15);
		contentPane.add(lblCrmv);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(29, 508, 53, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTelaDeConsulta = new JLabel("Dados do cliente");
		lblTelaDeConsulta.setBounds(226, 12, 132, 15);
		contentPane.add(lblTelaDeConsulta);
	}

	public void recebendo(String recebe) {
		textField.setText(recebe);

	}

	public void recebendo1(String recebe) {

		textField_1.setText(recebe);

	}

	public void recebendo2(String recebe) {

		textField_6.setText(recebe);

	}
}
