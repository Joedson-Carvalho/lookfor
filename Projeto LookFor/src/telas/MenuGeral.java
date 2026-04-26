package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGeral extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGeral frame = new MenuGeral();
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
	public MenuGeral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 484, 611);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Menu Principal", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WORK IN PROGRESS...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 11, 344, 40);
		panel.add(lblNewLabel);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Cadastrar Produto", null, contentPane_2, null);
		
		JLabel lblCadastro = new JLabel("Cadastrar Item");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastro.setBounds(158, 10, 117, 22);
		contentPane_2.add(lblCadastro);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 53, 459, 419);
		contentPane_2.add(tabbedPane_1);
		
		JPanel contentPane_3 = new JPanel();
		contentPane_3.setLayout(null);
		contentPane_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane_1.addTab("Cadastrar Eletrônicos", null, contentPane_3, null);
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeItem.setBounds(10, 60, 119, 19);
		contentPane_3.add(lblNomeItem);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 60, 217, 20);
		contentPane_3.add(textField_1);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(10, 98, 119, 19);
		contentPane_3.add(lblPreco);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 98, 217, 20);
		contentPane_3.add(textField_2);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(10, 134, 119, 19);
		contentPane_3.add(lblCodItem);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(181, 134, 217, 20);
		contentPane_3.add(textField_3);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(10, 176, 119, 19);
		contentPane_3.add(lblDescricaoItem);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(181, 176, 217, 20);
		contentPane_3.add(textField_4);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGarantia.setBounds(10, 222, 119, 19);
		contentPane_3.add(lblGarantia);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(181, 222, 217, 20);
		contentPane_3.add(textField_5);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(10, 265, 119, 19);
		contentPane_3.add(lblModelo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(181, 265, 217, 20);
		contentPane_3.add(textField_6);
		
		JLabel lblCadastrarEletronico = new JLabel("Cadastrar Eletrônico");
		lblCadastrarEletronico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastrarEletronico.setBounds(139, 8, 176, 20);
		contentPane_3.add(lblCadastrarEletronico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(309, 323, 89, 23);
		contentPane_3.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(35, 323, 89, 23);
		contentPane_3.add(btnCancelar);
		
		JPanel contentPane_4 = new JPanel();
		contentPane_4.setLayout(null);
		contentPane_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane_1.addTab("Cadastrar Alimento", null, contentPane_4, null);
		
		JLabel lblDescricaoItem_1 = new JLabel("DESCRIÇÃO DO ITEM:");
		lblDescricaoItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescricaoItem_1.setBounds(10, 168, 154, 14);
		contentPane_4.add(lblDescricaoItem_1);
		
		JLabel lblCodigoItem = new JLabel("CÓDIGO  DO ITEM:");
		lblCodigoItem.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoItem.setBounds(10, 123, 134, 23);
		contentPane_4.add(lblCodigoItem);
		
		JLabel lblPreco_1 = new JLabel("PREÇO:");
		lblPreco_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreco_1.setBounds(10, 85, 70, 14);
		contentPane_4.add(lblPreco_1);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(10, 50, 59, 14);
		contentPane_4.add(lblNome);
		
		JLabel lblTitulo_1 = new JLabel("CADASTRAR ITEM");
		lblTitulo_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo_1.setBounds(112, 11, 203, 14);
		contentPane_4.add(lblTitulo_1);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvar_1.setBounds(313, 335, 89, 23);
		contentPane_4.add(btnSalvar_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(167, 48, 203, 20);
		contentPane_4.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(167, 83, 203, 20);
		contentPane_4.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(167, 125, 203, 20);
		contentPane_4.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(167, 166, 203, 20);
		contentPane_4.add(textField_10);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataVencimento.setBounds(10, 205, 154, 14);
		contentPane_4.add(lblDataVencimento);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(167, 203, 203, 20);
		contentPane_4.add(textField_11);
		
		JLabel lblDataFabricacao = new JLabel("Data Fabricacao");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataFabricacao.setBounds(10, 240, 154, 14);
		contentPane_4.add(lblDataFabricacao);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(167, 234, 203, 20);
		contentPane_4.add(textField_12);
		
		JLabel lblgredientes = new JLabel("Ingredientes");
		lblgredientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblgredientes.setBounds(10, 277, 154, 14);
		contentPane_4.add(lblgredientes);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(167, 275, 203, 20);
		contentPane_4.add(textField_13);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar_1.setBounds(10, 335, 89, 23);
		contentPane_4.add(btnCancelar_1);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Recuperar Senha", null, contentPane_1, null);
		
		JLabel lblTitulo = new JLabel("LookFor");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(120, 11, 105, 30);
		contentPane_1.add(lblTitulo);
		
		JLabel lblInformacao = new JLabel("Digite seu endereço de email e enviaremos um código para você reculperar sua conta");
		lblInformacao.setBounds(10, 53, 414, 52);
		contentPane_1.add(lblInformacao);
		
		JLabel lblEMail = new JLabel("Email:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(10, 130, 52, 14);
		contentPane_1.add(lblEMail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 128, 272, 20);
		contentPane_1.add(textField);
		
		JButton btnEnviarCodigo = new JButton("ENVIAR CÓDIGO");
		btnEnviarCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		btnEnviarCodigo.setBounds(135, 196, 141, 23);
		contentPane_1.add(btnEnviarCodigo);

	}

}
