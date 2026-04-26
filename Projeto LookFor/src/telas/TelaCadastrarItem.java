package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaCadastrarItem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarItem frame = new TelaCadastrarItem();
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
	public TelaCadastrarItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastrar Item");
		lblCadastro.setBounds(158, 10, 117, 22);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblCadastro);
		
		JLabel lblSelecionar = new JLabel("Selecione o tipo de item a ser cadastrado");
		lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelecionar.setBounds(48, 100, 325, 30);
		contentPane.add(lblSelecionar);
		
		JButton btnEletronico = new JButton("Eletrônico");
		btnEletronico.setBounds(53, 141, 117, 39);
		contentPane.add(btnEletronico);
		
		JButton btnAlimento = new JButton("Alimento");
		btnAlimento.setBounds(257, 141, 102, 39);
		contentPane.add(btnAlimento);

	}
}
