package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLoginLogista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginLogista frame = new TelaLoginLogista();
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
	public TelaLoginLogista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LookFor");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(108, 10, 132, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 47, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 88, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEntrar.setBounds(108, 131, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnRecuperarSenha = new JButton("ESQUECEU SUA SENHA?");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecuperaSenha telaRecuperaSenha = new TelaRecuperaSenha();
				telaRecuperaSenha.setVisible(true);
						
			}
			
		});
		btnRecuperarSenha.setBounds(57, 180, 199, 23);
		contentPane.add(btnRecuperarSenha);
		
		textField = new JTextField();
		textField.setBounds(108, 45, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 86, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

}
