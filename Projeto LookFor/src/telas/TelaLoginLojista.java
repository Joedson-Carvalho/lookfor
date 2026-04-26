package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaLoginLojista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEMail;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginLojista frame = new TelaLoginLojista();
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
	public TelaLoginLojista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LookFor");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(145, 21, 132, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEMail = new JLabel("EMAIL:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(57, 58, 72, 14);
		contentPane.add(lblEMail);
		
		txtEMail = new JTextField();
		txtEMail.setColumns(10);
		txtEMail.setBounds(145, 56, 192, 20);
		contentPane.add(txtEMail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(57, 99, 72, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(145, 97, 192, 20);
		contentPane.add(txtSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEntrar.setBounds(145, 128, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnRecuperarSenha = new JButton("ESQUECEU SUA SENHA?");
		btnRecuperarSenha.setBounds(138, 162, 199, 23);
		contentPane.add(btnRecuperarSenha);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(321, 227, 103, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCadastrar = new JLabel("Não Possui Cadastro?");
		lblCadastrar.setBounds(193, 231, 118, 14);
		contentPane.add(lblCadastrar);

	}
}
