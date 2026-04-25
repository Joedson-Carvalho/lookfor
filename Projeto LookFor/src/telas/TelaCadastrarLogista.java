package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarLogista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeLojista;
	private JTextField textSenha;
	private JTextField textEmailLojista;
	private JTextField textTelefone;
	private JTextField textEMailLoja;
	private JTextField textNomeLoja;
	private JTextField textCep;
	private JTextField textNumeroEndereco;
	private JTextField textEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarLogista frame = new TelaCadastrarLogista();
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
	public TelaCadastrarLogista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEMail = new JLabel("E-MAIL:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(10, 154, 59, 14);
		contentPane.add(lblEMail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(10, 118, 59, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(10, 73, 59, 22);
		contentPane.add(lblNome);
		
		JLabel lblMenuLojista = new JLabel("FORMULÁRIO DE CADASTRO DE LOJISTA");
		lblMenuLojista.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLojista.setBounds(34, 11, 339, 35);
		contentPane.add(lblMenuLojista);
		
		textNomeLojista = new JTextField();
		textNomeLojista.setBounds(77, 75, 296, 20);
		contentPane.add(textNomeLojista);
		textNomeLojista.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(77, 116, 296, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		textEmailLojista = new JTextField();
		textEmailLojista.setBounds(77, 152, 296, 20);
		contentPane.add(textEmailLojista);
		textEmailLojista.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(136, 450, 114, 23);
		contentPane.add(btnCadastrar);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(134, 315, 239, 20);
		contentPane.add(textTelefone);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setBounds(10, 319, 146, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEMailLoja = new JLabel("E-MAIL DA LOJA");
		lblEMailLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMailLoja.setBounds(10, 283, 146, 14);
		contentPane.add(lblEMailLoja);
		
		textEMailLoja = new JTextField();
		textEMailLoja.setColumns(10);
		textEMailLoja.setBounds(134, 282, 239, 20);
		contentPane.add(textEMailLoja);
		
		textNomeLoja = new JTextField();
		textNomeLoja.setColumns(10);
		textNomeLoja.setBounds(134, 238, 239, 20);
		contentPane.add(textNomeLoja);
		
		JLabel lblNomeLoja = new JLabel("NOME DA LOJA:");
		lblNomeLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeLoja.setBounds(10, 238, 146, 22);
		contentPane.add(lblNomeLoja);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(173, 385, 200, 20);
		contentPane.add(textCep);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setBounds(111, 387, 52, 14);
		contentPane.add(lblCep);
		
		JLabel lblNumeroEndereco = new JLabel("N°");
		lblNumeroEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumeroEndereco.setBounds(10, 387, 28, 14);
		contentPane.add(lblNumeroEndereco);
		
		textNumeroEndereco = new JTextField();
		textNumeroEndereco.setColumns(10);
		textNumeroEndereco.setBounds(32, 385, 59, 20);
		contentPane.add(textNumeroEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(134, 354, 239, 20);
		contentPane.add(textEndereco);
		
		JLabel lblEndereco = new JLabel("ENDEREÇO:");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(10, 352, 146, 22);
		contentPane.add(lblEndereco);
		
		JLabel lblMenuLoja = new JLabel("FORMULÁRIO DE CADASTRO DA LOJA");
		lblMenuLoja.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLoja.setBounds(46, 192, 339, 35);
		contentPane.add(lblMenuLoja);

	}

}
