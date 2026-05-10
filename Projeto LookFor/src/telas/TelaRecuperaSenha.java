package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
		setTitle("LookFor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRecuperaSenha.class.getResource("/imagens/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 340);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(79, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(TelaRecuperaSenha.class.getResource("/imagens/lookforblack.png")));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(118, 42, 255, 52);
		contentPane.add(lblTitulo);
		
		JLabel lblInformacao = new JLabel("Digite seu endereço de email e enviaremos um código para você");
		lblInformacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacao.setForeground(new Color(255, 255, 255));
		lblInformacao.setBounds(53, 93, 390, 35);
		contentPane.add(lblInformacao);
		
		JLabel lblEMail = new JLabel("Email:");
		lblEMail.setForeground(new Color(255, 255, 255));
		lblEMail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEMail.setBounds(68, 174, 52, 14);
		contentPane.add(lblEMail);
		
		txtEMail = new JTextField();
		txtEMail.setBounds(130, 172, 272, 20);
		contentPane.add(txtEMail);
		txtEMail.setColumns(10);
		
		JButton btnEnviarCodigo = new JButton("ENVIAR CÓDIGO");
		btnEnviarCodigo.setBackground(new Color(55, 114, 251));
		btnEnviarCodigo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnEnviarCodigo.setForeground(new Color(255, 255, 255));
		btnEnviarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlertaUtil.info("Em breve você receberá uma nova senha");
				dispose();
			}
		});
		btnEnviarCodigo.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEnviarCodigo.setBounds(181, 226, 165, 25);
		contentPane.add(btnEnviarCodigo);
		
		JLabel lblNewLabel = new JLabel("recuperar sua conta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 126, 255, 20);
		contentPane.add(lblNewLabel);

	}
}
