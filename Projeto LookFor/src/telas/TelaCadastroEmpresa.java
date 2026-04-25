package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroEmpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEmpresa frame = new TelaCadastroEmpresa();
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
	public TelaCadastroEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(104, 11, 139, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 67, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-MAIL:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 113, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONE:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 154, 84, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 198, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea textNome = new JTextArea();
		textNome.setBounds(104, 63, 218, 22);
		contentPane.add(textNome);
		
		JTextArea textEmail = new JTextArea();
		textEmail.setBounds(104, 109, 218, 22);
		contentPane.add(textEmail);
		
		JTextArea textTelefone = new JTextArea();
		textTelefone.setBounds(104, 150, 218, 22);
		contentPane.add(textTelefone);
		
		JTextArea textId = new JTextArea();
		textId.setBounds(104, 194, 218, 22);
		contentPane.add(textId);
		
		JButton btnProximo = new JButton("PRÓXIMO");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEndereco telaEndereco = new TelaEndereco();
				telaEndereco.setVisible(true);
				
			}
		});
		btnProximo.setFont(new Font("Arial", Font.BOLD, 14));
		btnProximo.setBounds(223, 244, 99, 23);
		contentPane.add(btnProximo);

	}

}
