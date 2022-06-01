package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;



public class InicioGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGUI frame = new InicioGUI();
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
	public InicioGUI() {
		super("Inicio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelecioneUmaDas = new JLabel("Selecione qual m\u00F3dulo deseja ter acesso");
		lblSelecioneUmaDas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblSelecioneUmaDas.setBounds(32, 43, 311, 27);
		contentPane.add(lblSelecioneUmaDas);
		
		
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteGUI frame = new ClienteGUI();
				frame.setVisible(true);
				
			}
		});
		btnClientes.setBounds(32, 232, 141, 25);
		contentPane.add(btnClientes);

		JButton btnUsuarios = new JButton("Usuários");
		btnUsuarios.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioGUI frame = new UsuarioGUI();
				frame.setVisible(true);
			}
		});

				btnUsuarios.setBounds(32, 176, 141, 25);
		contentPane.add(btnUsuarios);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(InicioGUI.class.getResource("/image/out.png")));
		btnSair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(435, 416, 100, 25);
		contentPane.add(btnSair);
		
		JLabel lblCatbg = new JLabel("");
		lblCatbg.setIcon(new ImageIcon(InicioGUI.class.getResource("/image/catbg.png")));
		lblCatbg.setBounds(329, 82, 148, 191);
		contentPane.add(lblCatbg);
		
		JButton btnHistorico = new JButton("Histórico");
		btnHistorico.setBounds(32, 288, 141, 25);
		contentPane.add(btnHistorico);
		
		JButton btnFuncionrios = new JButton("Funcionários");
		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionariosGUI frame = new FuncionariosGUI();
				frame.setVisible(true);
			}
		});
		btnFuncionrios.setBounds(32, 343, 141, 25);
		contentPane.add(btnFuncionrios);
		
	
	}
}