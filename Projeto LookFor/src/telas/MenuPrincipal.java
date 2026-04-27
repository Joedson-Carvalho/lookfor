package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 746, 633);
		contentPane.add(layeredPane);
		
		JPanel panelDeBuscas = new JPanel();
		layeredPane.setLayer(panelDeBuscas, 1);
		panelDeBuscas.setBounds(0, 0, 746, 633);
		layeredPane.add(panelDeBuscas);
		panelDeBuscas.setLayout(null);
		
		JLabel lblLogin_1 = new JLabel("Lojista? Faça Seu Login ou Cadastro Clicando neste botão");
		lblLogin_1.setBounds(295, 592, 348, 14);
		panelDeBuscas.add(lblLogin_1);
		
		JPanel panelLogin = new JPanel();
		layeredPane.setLayer(panelLogin, 0);
		panelLogin.setBounds(0, 0, 746, 633);
		layeredPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblEMail = new JLabel("EMAIL:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(169, 209, 72, 14);
		panelLogin.add(lblEMail);
		
		JLabel lblNewLabel_1 = new JLabel("LookFor");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(257, 172, 132, 14);
		panelLogin.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(257, 207, 192, 20);
		panelLogin.add(textField);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(169, 250, 72, 14);
		panelLogin.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(257, 248, 192, 20);
		panelLogin.add(txtSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(true /*cadastroEMail == txtEmail && cadastroSenha == txtSenha*/) {
					MenuGeral novo = new MenuGeral();
					novo.setVisible(true);
				
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEntrar.setBounds(257, 279, 89, 23);
		panelLogin.add(btnEntrar);
		
		JButton btnRecuperarSenha = new JButton("ESQUECEU SUA SENHA?");
		btnRecuperarSenha.setBounds(250, 313, 199, 23);
		panelLogin.add(btnRecuperarSenha);
		
		JLabel lblCadastrar = new JLabel("Não Possui Cadastro?");
		lblCadastrar.setBounds(305, 382, 118, 14);
		panelLogin.add(lblCadastrar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarLojista novo = new TelaCadastrarLojista();
				novo.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(433, 378, 103, 23);
		panelLogin.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelDeBuscas);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton.setBounds(10, 599, 89, 23);
		panelLogin.add(btnNewButton);
		
		JButton btnLogin_1 = new JButton("Acessar");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelLogin);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnLogin_1.setBounds(647, 588, 89, 23);
		panelDeBuscas.add(btnLogin_1);
		
		JLabel lblNewLabel = new JLabel("tela de buscas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(267, 247, 211, 79);
		panelDeBuscas.add(lblNewLabel);
		


	}
}
