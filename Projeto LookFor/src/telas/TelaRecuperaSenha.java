package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaRecuperaSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRecuperaSenha frame = new TelaRecuperaSenha();
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
	public TelaRecuperaSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("LookFor");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(120, 11, 105, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblInformacao = new JLabel("Digite seu endereço de email e enviaremos um código para você reculperar sua conta");
		lblInformacao.setBounds(10, 53, 414, 52);
		contentPane.add(lblInformacao);
		
		JLabel lblEMail = new JLabel("Email:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(10, 130, 52, 14);
		contentPane.add(lblEMail);
		
		txtEMail = new JTextField();
		txtEMail.setBounds(72, 128, 272, 20);
		contentPane.add(txtEMail);
		txtEMail.setColumns(10);
		
		JButton btnEnviarCodigo = new JButton("ENVIAR CÓDIGO");
		btnEnviarCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		btnEnviarCodigo.setBounds(135, 196, 141, 23);
		contentPane.add(btnEnviarCodigo);

	}
}
