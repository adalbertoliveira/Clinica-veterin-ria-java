package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Atendimento;
import modelo.Pagamento;
import dao.AtendimentoDAO;
import dao.PagamentoDAO;

public class PagamentoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblR;
	private JLabel lblCliente;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JTextField textField_3;
	private JLabel lblCrmv;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblFidelidade;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblValor;
	private JLabel lblEmxDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentoGUI frame = new PagamentoGUI();
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
	public PagamentoGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneAForma = new JLabel("Selecione a forma de pagamento");
		lblSelecioneAForma.setBounds(157, 0, 253, 31);
		contentPane.add(lblSelecioneAForma);
		
		JLabel lblValorDaConsulta = new JLabel("Valor da consulta:");
		lblValorDaConsulta.setBounds(24, 38, 141, 29);
		contentPane.add(lblValorDaConsulta);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(178, 41, 94, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblR = new JLabel("R$");
		lblR.setBounds(279, 40, 40, 24);
		contentPane.add(lblR);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(94, 76, 71, 24);
		contentPane.add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(178, 77, 242, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(178, 117, 242, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel = new JLabel("Veterinário:");
		lblNewLabel.setBounds(65, 116, 100, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atendimento atende = new Atendimento();
				atende.setIdpessoa(textField_3.getText());
				atende.setIduser(textField_4.getText());
				atende.setValoratendimento(textField.getText());
				atende.setDescricao(textField_5.getText());
				AtendimentoDAO dao = new AtendimentoDAO();
				dao.adiciona(atende);
			}
		});
		btnFinalizar.setBounds(65, 357, 117, 25);
		contentPane.add(btnFinalizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(424, 357, 117, 25);
		contentPane.add(btnCancelar);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(460, 76, 40, 24);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(510, 77, 64, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblCrmv = new JLabel("CRMV:");
		lblCrmv.setBounds(450, 116, 50, 24);
		contentPane.add(lblCrmv);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(510, 117, 64, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
	
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(75, 146, 86, 37);
		contentPane.add(lblDescrio);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(38, 189, 536, 50);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnAVista = new JButton("A vista");
		btnAVista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pagamento pagamento= new Pagamento();
				pagamento.setFidelidade(textField_6.getText());
				
				if (textField_6.getText() == "s") {
				
					PagamentoDAO dao = new PagamentoDAO();
					dao.vista();
					PagamentoDAO desconto = new PagamentoDAO();
					desconto.desconto();
					JOptionPane.showMessageDialog(null, "Cliente "
							+ textField_6.getText() + " excluido com sucesso! ");
					dispose();
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					;
				} else if (textField_6.getText() == "n") {
					System.out.println("Clicou em N�o");
					PagamentoDAO dao = new PagamentoDAO();
					dao.vista();
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Cliente "
							+ textField_6.getText() + " excluido com sucesso! ");
					dispose();
			

				}
			}
		});
		btnAVista.setBounds(38, 275, 117, 25);
		contentPane.add(btnAVista);
		
		JButton btnEmx = new JButton("Parcelado");
		btnEmx.setBounds(38, 312, 117, 25);
		contentPane.add(btnEmx);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(510, 41, 31, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblFidelidade = new JLabel("Fidelidade:");
		lblFidelidade.setBounds(411, 38, 81, 22);
		contentPane.add(lblFidelidade);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(414, 276, 114, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(414, 314, 114, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		lblValor = new JLabel("Valor a vista:");
		lblValor.setBounds(279, 275, 105, 24);
		contentPane.add(lblValor);
		
		lblEmxDe = new JLabel("Em 2x de:");
		lblEmxDe.setBounds(279, 322, 70, 15);
		contentPane.add(lblEmxDe);
	}
	public void recebendo(String recebe) {
		textField.setText(recebe);

	}

	public void recebendo1(String recebe) {

		textField_1.setText(recebe);

	}

	public void recebendo2(String recebe) {

		textField_2.setText(recebe);
	

	}
	public void recebendo3(String recebe) {

	
		textField_5.setText(recebe);

	}
	public void recebendo4(String recebe) {

		
		textField_4.setText(recebe);

	}
	public void recebendo5(String recebe) {

		
		textField_3.setText(recebe);

	}
}
