package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaEmpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmpresa frame = new TelaEmpresa();
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
	public TelaEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(0, 255, 0));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEmpresa tela = new TelaCadastroEmpresa();
				tela.setVisible(true);
			}
		});
		btnEntrar.setBounds(72, 174, 152, 44);
		contentPane.add(btnEntrar);
		
		JLabel LookFoor = new JLabel("LookFor");
		LookFoor.setFont(new Font("Arial Black", Font.PLAIN, 22));
		LookFoor.setBounds(95, 24, 163, 50);
		contentPane.add(LookFoor);

	}

}
