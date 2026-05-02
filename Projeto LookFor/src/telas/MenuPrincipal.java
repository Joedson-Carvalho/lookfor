package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tools.ConversorJson;
import tools.DataHelper;
import entidade.CadastrarLojista;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.util.stream.Collectors;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTable table;
	private JTextField textField;
	private JTextField txtNomeEletronico;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtNomeAlimento;
	private JTextField txtPrecoAlimento;
	private JTextField txtCodItemAlimento;
	private JTextField txtDescricaoAlimento;
	private JTextField txtVencimento;
	private JTextField txtFabricacao;
	private JTextField txtIngredientes;

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
		layeredPane.setLayer(panelDeBuscas, 0);
		panelDeBuscas.setBounds(0, 0, 746, 633);
		layeredPane.add(panelDeBuscas);
		panelDeBuscas.setLayout(null);
		
		JLabel lblLogin_1 = new JLabel("Lojista? Faça Seu Login ou Cadastro Clicando neste botão:");
		lblLogin_1.setBounds(289, 592, 348, 14);
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
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(257, 207, 192, 20);
		panelLogin.add(txtEmail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(169, 250, 72, 14);
		panelLogin.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(257, 248, 192, 20);
		panelLogin.add(txtSenha);
		
		JPanel panelLojista = new JPanel();
		layeredPane.setLayer(panelLojista, 2);
		panelLojista.setBounds(0, 0, 746, 633);
		layeredPane.add(panelLojista);
		panelLojista.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
;				var dataLogins = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/lojista.json"));
				var logins = ConversorJson.desserializarListaDaString(dataLogins, CadastrarLojista.class);
				
				var loginEncontrado = logins.stream()
						.filter(x -> 
						x.getEmail().trim().equals(txtEmail.getText().trim()) && 
						x.getSenha().trim().equals(txtSenha.getText().trim()));
				
				if(loginEncontrado != null) {
					layeredPane.removeAll();
					layeredPane.add(panelLojista);
					layeredPane.repaint();
					layeredPane.revalidate();
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
		

		
		JTabbedPane tabbedMenuLojista = new JTabbedPane(JTabbedPane.TOP);
		tabbedMenuLojista.setBounds(0, 0, 746, 633);
		panelLojista.add(tabbedMenuLojista);
		
		JPanel panelMenuPrincipal = new JPanel();
		panelMenuPrincipal.setLayout(null);
		panelMenuPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedMenuLojista.addTab("Menu Lojista", null, panelMenuPrincipal, null);
		
		JLabel lblProgressoEmAndamento = new JLabel("WORK IN PROGRESS...");
		lblProgressoEmAndamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgressoEmAndamento.setBounds(38, 11, 344, 40);
		panelMenuPrincipal.add(lblProgressoEmAndamento);
		
		table = new JTable();
		table.setBounds(38, 179, 399, 313);
		panelMenuPrincipal.add(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(38, 88, 399, 26);
		panelMenuPrincipal.add(textField);
		
		JPanel panelCadastrarItem = new JPanel();
		panelCadastrarItem.setLayout(null);
		panelCadastrarItem.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedMenuLojista.addTab("Cadastrar Produto", null, panelCadastrarItem, null);
		
		JLabel lblCadastro = new JLabel("Cadastrar Item");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastro.setBounds(158, 10, 117, 22);
		panelCadastrarItem.add(lblCadastro);
		
		JTabbedPane tabbedSubMenuCadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedSubMenuCadastrar.setBounds(0, 53, 479, 419);
		panelCadastrarItem.add(tabbedSubMenuCadastrar);
		
		JPanel panelSubMenuCadastrarEletronico = new JPanel();
		panelSubMenuCadastrarEletronico.setLayout(null);
		panelSubMenuCadastrarEletronico.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedSubMenuCadastrar.addTab("Cadastrar Eletronico", null, panelSubMenuCadastrarEletronico, null);
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeItem.setBounds(27, 34, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblNomeItem);
		
		txtNomeEletronico = new JTextField();
		txtNomeEletronico.setColumns(10);
		txtNomeEletronico.setBounds(198, 34, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtNomeEletronico);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(27, 72, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblPreco);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 72, 217, 20);
		panelSubMenuCadastrarEletronico.add(textField_2);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(27, 108, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblCodItem);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 108, 217, 20);
		panelSubMenuCadastrarEletronico.add(textField_3);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(27, 150, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblDescricaoItem);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(198, 150, 217, 20);
		panelSubMenuCadastrarEletronico.add(textField_4);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGarantia.setBounds(27, 196, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblGarantia);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(198, 196, 217, 20);
		panelSubMenuCadastrarEletronico.add(textField_5);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(27, 239, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblModelo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(198, 239, 217, 20);
		panelSubMenuCadastrarEletronico.add(textField_6);
		
		JButton btnSalvarEletronico = new JButton("Salvar");
		btnSalvarEletronico.setBounds(326, 297, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnSalvarEletronico);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(52, 297, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnCancelar);
		
		JPanel panelSubMenuCadastrarAlimento = new JPanel();
		panelSubMenuCadastrarAlimento.setLayout(null);
		panelSubMenuCadastrarAlimento.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedSubMenuCadastrar.addTab(" Cadastrar Alimento", null, panelSubMenuCadastrarAlimento, null);
		
		JLabel lblDescricaoItem_1 = new JLabel("DESCRIÇÃO DO ITEM:");
		lblDescricaoItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescricaoItem_1.setBounds(10, 168, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDescricaoItem_1);
		
		JLabel lblCodigoItem = new JLabel("CÓDIGO  DO ITEM:");
		lblCodigoItem.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoItem.setBounds(10, 123, 134, 23);
		panelSubMenuCadastrarAlimento.add(lblCodigoItem);
		
		JLabel lblPreco_1 = new JLabel("PREÇO:");
		lblPreco_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreco_1.setBounds(10, 85, 70, 14);
		panelSubMenuCadastrarAlimento.add(lblPreco_1);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(10, 50, 59, 14);
		panelSubMenuCadastrarAlimento.add(lblNome);
		
		JButton btnSalvarAlimento = new JButton("Salvar");
		btnSalvarAlimento.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvarAlimento.setBounds(313, 335, 89, 23);
		panelSubMenuCadastrarAlimento.add(btnSalvarAlimento);
		
		txtNomeAlimento = new JTextField();
		txtNomeAlimento.setColumns(10);
		txtNomeAlimento.setBounds(167, 48, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtNomeAlimento);
		
		txtPrecoAlimento = new JTextField();
		txtPrecoAlimento.setColumns(10);
		txtPrecoAlimento.setBounds(167, 83, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtPrecoAlimento);
		
		txtCodItemAlimento = new JTextField();
		txtCodItemAlimento.setColumns(10);
		txtCodItemAlimento.setBounds(167, 125, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtCodItemAlimento);
		
		txtDescricaoAlimento = new JTextField();
		txtDescricaoAlimento.setColumns(10);
		txtDescricaoAlimento.setBounds(167, 166, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtDescricaoAlimento);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataVencimento.setBounds(10, 205, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDataVencimento);
		
		txtVencimento = new JTextField();
		txtVencimento.setColumns(10);
		txtVencimento.setBounds(167, 203, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtVencimento);
		
		JLabel lblDataFabricacao = new JLabel("Data Fabricacao");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataFabricacao.setBounds(10, 240, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDataFabricacao);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setColumns(10);
		txtFabricacao.setBounds(167, 234, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtFabricacao);
		
		JLabel lblgredientes = new JLabel("Ingredientes");
		lblgredientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblgredientes.setBounds(10, 277, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblgredientes);
		
		txtIngredientes = new JTextField();
		txtIngredientes.setColumns(10);
		txtIngredientes.setBounds(167, 275, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtIngredientes);
		
		JButton btnCancelarAlimento = new JButton("Cancelar");
		btnCancelarAlimento.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarAlimento.setBounds(10, 335, 89, 23);
		panelSubMenuCadastrarAlimento.add(btnCancelarAlimento);
		


	}
}
