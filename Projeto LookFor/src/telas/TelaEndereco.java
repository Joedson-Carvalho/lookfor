package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class TelaEndereco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEndereco frame = new TelaEndereco();
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
	public TelaEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RUA:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 64, 64, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NUMERO:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 111, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CEP:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 151, 64, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_4.setBounds(71, 22, 129, 20);
		contentPane.add(lblNewLabel_4);
		
		JTextArea textRua = new JTextArea();
		textRua.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textRua.setBounds(84, 63, 139, 22);
		contentPane.add(textRua);
		
		JTextArea textNumero = new JTextArea();
		textNumero.setBounds(84, 107, 139, 22);
		contentPane.add(textNumero);
		
		JTextArea textCep = new JTextArea();
		textCep.setBounds(84, 150, 140, 22);
		contentPane.add(textCep);
		
		JButton btnCadastrar = new JButton("CADASTRA");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(128, 279, 95, 23);
		contentPane.add(btnCadastrar);

	}
}
