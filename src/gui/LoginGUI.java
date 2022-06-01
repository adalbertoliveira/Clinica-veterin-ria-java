package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import modelo.Usuario;
import dao.UsuarioDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginGUI {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 495, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 484, 318);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(39, 103, 46, 18);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(39, 150, 65, 14);
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		panel.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(95, 103, 204, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon(LoginGUI.class.getResource("/image/in.png")));
		btnEntrar.setBounds(95, 214, 204, 23);
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnEntrar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				/** Instanciamos o usuarioDAO */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				/**
				 * Instanciamos o usuário que irá receber os dados do usuário
				 * logado
				 */
				Usuario usuario = new Usuario();
				/**
				 * A variavel de referencia usuario recebe o retorno do metodo
				 * Acesso que também é do tipo Usuario
				 */
				usuario = usuarioDAO.Acesso(txtLogin.getText(),
						txtSenha.getText());

				/**
				 * Para chamar uma variavel estatica não precisamos instanciar a
				 * classe, enfim se o acesso == true então estamos logados Caso
				 * Contrário algo está incorreto
				 */
				if (UsuarioDAO.acesso) {
					// Chama uma tela
					JOptionPane.showMessageDialog(null, "Usuario Logado: "
							+ usuario.getNomeUsuario());
					InicioGUI frame = new InicioGUI();
					frame.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null,
							"Login ou Senha Incorretos champz");

				}

			}

			private void dispose() {
				frame.setVisible(false);

			}
		});
		panel.add(btnEntrar);

		JLabel lblNewLabel_1 = new JLabel("Informe seu login e senha");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(58, 23, 183, 54);
		panel.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(95, 147, 204, 23);
		panel.add(txtSenha);

		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(LoginGUI.class.getResource("/image/out.png")));
		btnSair.setBounds(153, 263, 88, 20);
		btnSair.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnSair);
		
		JLabel lblDoglog = new JLabel("doglog");
		lblDoglog.setIcon(new ImageIcon(LoginGUI.class.getResource("/image/doglog.png")));
		lblDoglog.setBounds(334, 88, 140, 181);
		panel.add(lblDoglog);
	}
}
