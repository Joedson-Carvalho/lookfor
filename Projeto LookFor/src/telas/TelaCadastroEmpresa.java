package telas;

import java.awt.EventQueue;
import entidade.Endereco;
import entidade.Empresa;
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
		setBounds(100, 100, 549, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastrar Empresa");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(62, 11, 188, 26);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(61, 67, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-MAIL:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(61, 113, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONE:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(61, 154, 84, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtNome = new JTextArea();
		txtNome.setBounds(220, 63, 218, 22);
		contentPane.add(txtNome);
		
		JTextArea txtEmail = new JTextArea();
		txtEmail.setBounds(220, 109, 218, 22);
		contentPane.add(txtEmail);
		
		JTextArea txtTelefone = new JTextArea();
		txtTelefone.setBounds(220, 150, 218, 22);
		contentPane.add(txtTelefone);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Arial", Font.BOLD, 14));
		lblRua.setBounds(61, 246, 84, 14);
		contentPane.add(lblRua);
		
		JTextArea txtRua = new JTextArea();
		txtRua.setBounds(220, 242, 218, 22);
		contentPane.add(txtRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumero.setBounds(61, 285, 84, 14);
		contentPane.add(lblNumero);
		
		JTextArea txtNumero = new JTextArea();
		txtNumero.setBounds(220, 281, 218, 22);
		contentPane.add(txtNumero);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setBounds(61, 323, 84, 14);
		contentPane.add(lblCep);
		
		JTextArea txtCep = new JTextArea();
		txtCep.setBounds(220, 319, 218, 22);
		contentPane.add(txtCep);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		lblCnpj.setBounds(61, 199, 84, 14);
		contentPane.add(lblCnpj);
		
		JTextArea txtCnpj = new JTextArea();
		txtCnpj.setBounds(220, 195, 218, 22);
		contentPane.add(txtCnpj);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var cepConvertido = Integer.parseInt(txtNumero.getText());
				var Endereco = new Endereco(txtRua.getText(), txtNumero.getText(), cepConvertido, 0);
				
				var empresa = new Empresa(txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), txtCnpj.getText());
				
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalvar.setBounds(426, 508, 99, 23);
		contentPane.add(btnSalvar);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setBounds(66, 493, 99, 23);
		contentPane.add(btnCancelar);
		
		

	}
}
