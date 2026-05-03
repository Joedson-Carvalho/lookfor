package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import entidade.CadastrarItem;
import entidade.CadastrarLojista;
import entidade.Empresa;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtNomeEletronico;
	private JTextField txtPrecoEletronico;
	private JTextField txtCodItemEletronico;
	private JTextField txtDescricaoEletronico;
	private JTextField txtGarantia;
	private JTextField txtModelo;
	private JTextField txtNomeAlimento;
	private JTextField txtPrecoAlimento;
	private JTextField txtCodItemAlimento;
	private JTextField txtDescricaoAlimento;
	private JTextField txtVencimento;
	private JTextField txtFabricacao;
	private JTextField txtIngredientes;
	private JTextField txtNome;
	private JTextField txtCadastrarSenha;
	private JTextField txtCadastrarEmail;
	private JTextField txtNomeLoja;
	private JTextField txtEmailLoja;
	private JTextField txtTelefone;
	private JTextField txtCadastrarCnpj;
	private JTextField txtEndereco;
	private JTextField txtNumeroEndereco;
	private JTextField txtCep;
	private JTextField txtBuscar;
	private JTable tableDeBusca;
	private JTextField txtBuscarNoLojista;
	private JTable table;

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
		panelLogin.setVisible(false);
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
		panelLojista.setVisible(false);
		layeredPane.setLayer(panelLojista, 0);
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
						x.getSenha().trim().equals(txtSenha.getText().trim()))
						.findFirst()
						.orElse(null);
				
				if(loginEncontrado != null) {
					layeredPane.removeAll();
					layeredPane.add(panelLojista);
					layeredPane.repaint();
					layeredPane.revalidate();
					panelLojista.setVisible(true);
					txtEmail.setText("");
					txtSenha.setText("");
				}else {
					AlertaUtil.erro("Login ou senha inválida");
					txtEmail.setText("");
					txtSenha.setText("");
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEntrar.setBounds(257, 279, 89, 23);
		panelLogin.add(btnEntrar);
		
		JButton btnRecuperarSenha = new JButton("ESQUECEU SUA SENHA?");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecuperarSenha.setBounds(250, 313, 199, 23);
		panelLogin.add(btnRecuperarSenha);
		
		JLabel lblCadastrar = new JLabel("Não Possui Cadastro?");
		lblCadastrar.setBounds(305, 382, 118, 14);
		panelLogin.add(lblCadastrar);

		String[] colunasTabela = {"Nome do Item", "Código", "Preço"};
		DefaultTableModel tabelaDeBusca = new DefaultTableModel(colunasTabela, 0);
		
		JButton btnNewButton = new JButton("voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelDeBuscas);
				layeredPane.repaint();
				layeredPane.revalidate();
				panelDeBuscas.setVisible(true);
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
				tabelaDeBusca.setRowCount(0);
				panelLogin.setVisible(true);
			}
		});
		btnLogin_1.setBounds(647, 588, 89, 23);
		panelDeBuscas.add(btnLogin_1);
		
		JLabel lblNewLabel = new JLabel("tela de buscas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(525, 11, 211, 79);
		panelDeBuscas.add(lblNewLabel);
		
		
		tableDeBusca = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 469, 478);
		panelDeBuscas.add(scrollPane);
		
		scrollPane.setViewportView(tableDeBusca);
		
		tableDeBusca.setModel(tabelaDeBusca);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 46, 326, 20);
		panelDeBuscas.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/alimento.json"));
				
				List<CadastrarItem> verItems = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				verItems.addAll(ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class));
				if(!verItems.isEmpty()) 
				{
					String buscar = txtBuscar.getText().trim().toLowerCase();
					
					var itemsFiltrados = verItems.stream()
						    .filter(x -> x.getNome().toLowerCase().startsWith(buscar) ||
					                 x.getCodItem().toLowerCase().startsWith(buscar))
					    .sorted(Comparator.comparingDouble(CadastrarItem::getPreco))
					    .toList();
					
					tabelaDeBusca.setRowCount(0);
					
					itemsFiltrados.forEach(p -> {
						tabelaDeBusca.addRow(new Object[]{
								p.getNome(),
								p.getCodItem(),
								"R$ " + p.getPreco(),
						}
								);
					});
					
				}
			}
		});
		btnBuscar.setBounds(377, 45, 89, 23);
		panelDeBuscas.add(btnBuscar);
		
		JTextArea textAreaMenorPreco = new JTextArea();
		textAreaMenorPreco.setBounds(489, 142, 247, 148);
		panelDeBuscas.add(textAreaMenorPreco);
		
		JLabel lblMenorPreco = new JLabel("Menor Preço");
		lblMenorPreco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenorPreco.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenorPreco.setBounds(489, 89, 247, 42);
		panelDeBuscas.add(lblMenorPreco);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menor Preço", "Menor Distancia"}));
		comboBox.setBounds(489, 301, 247, 42);
		panelDeBuscas.add(comboBox);
		

		
		JTabbedPane tabbedMenuLojista = new JTabbedPane(JTabbedPane.TOP);
		tabbedMenuLojista.setBounds(0, 0, 746, 633);
		panelLojista.add(tabbedMenuLojista);
		
		JPanel panelMenuLojista = new JPanel();
		panelMenuLojista.setLayout(null);
		panelMenuLojista.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedMenuLojista.addTab("Menu Lojista", null, panelMenuLojista, null);
		
		String[] colunas = {"Nome do Item", "Código", "Preço"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		JButton btnPaginaDeBusca = new JButton("Sair");
		btnPaginaDeBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelDeBuscas);
				layeredPane.repaint();
				layeredPane.revalidate();
				tabelaDeBusca.setRowCount(0);
				panelDeBuscas.setVisible(true);

			}
		});
		btnPaginaDeBusca.setBounds(10, 571, 89, 23);
		panelMenuLojista.add(btnPaginaDeBusca);
		
		JLabel lblNewLabel_2 = new JLabel("tela de buscas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(525, 11, 211, 79);
		panelMenuLojista.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 88, 469, 478);
		panelMenuLojista.add(scrollPane_1);

		table = new JTable();
		table.setModel(tabelaDeBusca);
		scrollPane_1.setViewportView(table);
		
		txtBuscarNoLojista = new JTextField();
		txtBuscarNoLojista.setColumns(10);
		txtBuscarNoLojista.setBounds(10, 46, 326, 20);
		panelMenuLojista.add(txtBuscarNoLojista);
		
		JButton btnBuscarNoLojista = new JButton("Buscar");
		btnBuscarNoLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/alimento.json"));
				
				List<CadastrarItem> verItems = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				verItems.addAll(ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class));
				if(!verItems.isEmpty()) 
				{
					String buscar = txtBuscarNoLojista.getText().trim().toLowerCase();
					
					var itemsFiltrados = verItems.stream()
						    .filter(x -> x.getNome().toLowerCase().startsWith(buscar) ||
					                 x.getCodItem().toLowerCase().startsWith(buscar))
					    .sorted(Comparator.comparingDouble(CadastrarItem::getPreco))
					    .toList();
					
					tabelaDeBusca.setRowCount(0);
					
					itemsFiltrados.forEach(p -> {
						tabelaDeBusca.addRow(new Object[]{
								p.getNome(),
								p.getCodItem(),
								"R$ " + p.getPreco(),
						}
								);
					});
					
				}
			}
		});
		btnBuscarNoLojista.setBounds(377, 45, 89, 23);
		panelMenuLojista.add(btnBuscarNoLojista);
		
		JTextArea textAreaMenorPreco_1 = new JTextArea();
		textAreaMenorPreco_1.setBounds(489, 142, 247, 148);
		panelMenuLojista.add(textAreaMenorPreco_1);
		
		JLabel lblMenorPreco_1 = new JLabel("Menor Preço");
		lblMenorPreco_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenorPreco_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenorPreco_1.setBounds(489, 89, 247, 42);
		panelMenuLojista.add(lblMenorPreco_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(489, 301, 247, 42);
		panelMenuLojista.add(comboBox_1);
		
		JPanel panelCadastrarItem = new JPanel();
		panelCadastrarItem.setLayout(null);
		panelCadastrarItem.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedMenuLojista.addTab("Cadastrar Produto", null, panelCadastrarItem, null);
		
		JLabel lblCadastro = new JLabel("Cadastrar Item");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastro.setBounds(158, 10, 117, 22);
		panelCadastrarItem.add(lblCadastro);
		
		JTabbedPane tabbedSubMenuCadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedSubMenuCadastrar.setBounds(0, 53, 741, 552);
		panelCadastrarItem.add(tabbedSubMenuCadastrar);
		
		JPanel panelSubMenuCadastrarEletronico = new JPanel();
		panelSubMenuCadastrarEletronico.setLayout(null);
		panelSubMenuCadastrarEletronico.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedSubMenuCadastrar.addTab("Cadastrar Eletronico", null, panelSubMenuCadastrarEletronico, null);
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeItem.setBounds(171, 103, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblNomeItem);
		
		txtNomeEletronico = new JTextField();
		txtNomeEletronico.setColumns(10);
		txtNomeEletronico.setBounds(342, 103, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtNomeEletronico);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(171, 141, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblPreco);
		
		txtPrecoEletronico = new JTextField();
		txtPrecoEletronico.setColumns(10);
		txtPrecoEletronico.setBounds(342, 141, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtPrecoEletronico);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(171, 177, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblCodItem);
		
		txtCodItemEletronico = new JTextField();
		txtCodItemEletronico.setColumns(10);
		txtCodItemEletronico.setBounds(342, 177, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtCodItemEletronico);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(171, 219, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblDescricaoItem);
		
		txtDescricaoEletronico = new JTextField();
		txtDescricaoEletronico.setColumns(10);
		txtDescricaoEletronico.setBounds(342, 219, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtDescricaoEletronico);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGarantia.setBounds(171, 265, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblGarantia);
		
		txtGarantia = new JTextField();
		txtGarantia.setColumns(10);
		txtGarantia.setBounds(342, 265, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtGarantia);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(171, 308, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(342, 308, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtModelo);
		
		JButton btnSalvarEletronico = new JButton("Salvar");
		btnSalvarEletronico.setBounds(458, 366, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnSalvarEletronico);
		
		JButton btnCancelarEletronico = new JButton("Cancelar");
		btnCancelarEletronico.setBounds(196, 366, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnCancelarEletronico);
		
		JPanel panelSubMenuCadastrarAlimento = new JPanel();
		panelSubMenuCadastrarAlimento.setLayout(null);
		panelSubMenuCadastrarAlimento.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedSubMenuCadastrar.addTab(" Cadastrar Alimento", null, panelSubMenuCadastrarAlimento, null);
		
		JLabel lblDescricaoItem_1 = new JLabel("DESCRIÇÃO DO ITEM:");
		lblDescricaoItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescricaoItem_1.setBounds(156, 230, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDescricaoItem_1);
		
		JLabel lblCodigoItem = new JLabel("CÓDIGO  DO ITEM:");
		lblCodigoItem.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoItem.setBounds(156, 185, 134, 23);
		panelSubMenuCadastrarAlimento.add(lblCodigoItem);
		
		JLabel lblPreco_1 = new JLabel("PREÇO:");
		lblPreco_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreco_1.setBounds(156, 147, 70, 14);
		panelSubMenuCadastrarAlimento.add(lblPreco_1);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(156, 112, 59, 14);
		panelSubMenuCadastrarAlimento.add(lblNome);
		
		JButton btnSalvarAlimento = new JButton("Salvar");
		btnSalvarAlimento.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvarAlimento.setBounds(459, 397, 89, 23);
		panelSubMenuCadastrarAlimento.add(btnSalvarAlimento);
		
		txtNomeAlimento = new JTextField();
		txtNomeAlimento.setColumns(10);
		txtNomeAlimento.setBounds(313, 110, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtNomeAlimento);
		
		txtPrecoAlimento = new JTextField();
		txtPrecoAlimento.setColumns(10);
		txtPrecoAlimento.setBounds(313, 145, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtPrecoAlimento);
		
		txtCodItemAlimento = new JTextField();
		txtCodItemAlimento.setColumns(10);
		txtCodItemAlimento.setBounds(313, 187, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtCodItemAlimento);
		
		txtDescricaoAlimento = new JTextField();
		txtDescricaoAlimento.setColumns(10);
		txtDescricaoAlimento.setBounds(313, 228, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtDescricaoAlimento);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataVencimento.setBounds(156, 267, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDataVencimento);
		
		txtVencimento = new JTextField();
		txtVencimento.setColumns(10);
		txtVencimento.setBounds(313, 265, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtVencimento);
		
		JLabel lblDataFabricacao = new JLabel("Data Fabricacao");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataFabricacao.setBounds(156, 302, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblDataFabricacao);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setColumns(10);
		txtFabricacao.setBounds(313, 296, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtFabricacao);
		
		JLabel lblgredientes = new JLabel("Ingredientes");
		lblgredientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblgredientes.setBounds(156, 339, 154, 14);
		panelSubMenuCadastrarAlimento.add(lblgredientes);
		
		txtIngredientes = new JTextField();
		txtIngredientes.setColumns(10);
		txtIngredientes.setBounds(313, 337, 203, 20);
		panelSubMenuCadastrarAlimento.add(txtIngredientes);
		
		JButton btnCancelarAlimento = new JButton("Cancelar");
		btnCancelarAlimento.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarAlimento.setBounds(156, 397, 89, 23);
		panelSubMenuCadastrarAlimento.add(btnCancelarAlimento);
		
		JPanel panelCadastrarLojista = new JPanel();
		panelCadastrarLojista.setVisible(false);
		layeredPane.setLayer(panelCadastrarLojista, 0);
		panelCadastrarLojista.setBounds(0, 0, 746, 633);
		layeredPane.add(panelCadastrarLojista);
		panelCadastrarLojista.setLayout(null);
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					layeredPane.removeAll();
					layeredPane.add(panelCadastrarLojista);
					layeredPane.repaint();
					layeredPane.revalidate();
					panelCadastrarLojista.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(433, 378, 103, 23);
		panelLogin.add(btnCadastrar);
		
		JLabel lblMenuLojista = new JLabel("FORMULÁRIO DE CADASTRO DE LOJISTA");
		lblMenuLojista.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLojista.setBounds(215, 36, 339, 35);
		panelCadastrarLojista.add(lblMenuLojista);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(258, 100, 296, 20);
		panelCadastrarLojista.add(txtNome);
		
		JLabel lblNome_1 = new JLabel("NOME:");
		lblNome_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome_1.setBounds(191, 98, 59, 22);
		panelCadastrarLojista.add(lblNome_1);
		
		JLabel lblSenha_1 = new JLabel("SENHA");
		lblSenha_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha_1.setBounds(191, 143, 59, 14);
		panelCadastrarLojista.add(lblSenha_1);
		
		txtCadastrarSenha = new JTextField();
		txtCadastrarSenha.setColumns(10);
		txtCadastrarSenha.setBounds(258, 141, 296, 20);
		panelCadastrarLojista.add(txtCadastrarSenha);
		
		txtCadastrarEmail = new JTextField();
		txtCadastrarEmail.setColumns(10);
		txtCadastrarEmail.setBounds(258, 177, 296, 20);
		panelCadastrarLojista.add(txtCadastrarEmail);
		
		JLabel lblEMail_1 = new JLabel("E-MAIL:");
		lblEMail_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail_1.setBounds(191, 179, 59, 14);
		panelCadastrarLojista.add(lblEMail_1);
		
		JLabel lblMenuLoja = new JLabel("FORMULÁRIO DE CADASTRO DA LOJA");
		lblMenuLoja.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLoja.setBounds(227, 217, 339, 35);
		panelCadastrarLojista.add(lblMenuLoja);
		
		JLabel lblNomeLoja = new JLabel("NOME DA LOJA:");
		lblNomeLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeLoja.setBounds(191, 263, 146, 22);
		panelCadastrarLojista.add(lblNomeLoja);
		
		txtNomeLoja = new JTextField();
		txtNomeLoja.setColumns(10);
		txtNomeLoja.setBounds(315, 263, 239, 20);
		panelCadastrarLojista.add(txtNomeLoja);
		
		txtEmailLoja = new JTextField();
		txtEmailLoja.setColumns(10);
		txtEmailLoja.setBounds(315, 307, 239, 20);
		panelCadastrarLojista.add(txtEmailLoja);
		
		JLabel lblEMailLoja = new JLabel("E-MAIL DA LOJA");
		lblEMailLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMailLoja.setBounds(191, 308, 146, 14);
		panelCadastrarLojista.add(lblEMailLoja);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setBounds(191, 344, 146, 14);
		panelCadastrarLojista.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(315, 340, 239, 20);
		panelCadastrarLojista.add(txtTelefone);
		
		txtCadastrarCnpj = new JTextField();
		txtCadastrarCnpj.setColumns(10);
		txtCadastrarCnpj.setBounds(315, 383, 239, 20);
		panelCadastrarLojista.add(txtCadastrarCnpj);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		lblCnpj.setBounds(191, 385, 146, 14);
		panelCadastrarLojista.add(lblCnpj);
		
		JLabel lblEndereco = new JLabel("ENDEREÇO:");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(191, 442, 146, 22);
		panelCadastrarLojista.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(315, 444, 239, 20);
		panelCadastrarLojista.add(txtEndereco);
		
		txtNumeroEndereco = new JTextField();
		txtNumeroEndereco.setColumns(10);
		txtNumeroEndereco.setBounds(216, 483, 59, 22);
		panelCadastrarLojista.add(txtNumeroEndereco);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(354, 484, 200, 20);
		panelCadastrarLojista.add(txtCep);
		
		JLabel lblNumeroEndereco = new JLabel("N°");
		lblNumeroEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumeroEndereco.setBounds(191, 486, 28, 14);
		panelCadastrarLojista.add(lblNumeroEndereco);
		
		JButton btnCadastrarLojista = new JButton("CADASTRAR");
		btnCadastrarLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var empresa = new Empresa(txtNomeLoja.getText(), txtEmailLoja.getText(), txtTelefone.getText(), txtCadastrarCnpj.getText());
				var lojistaCadastro = new CadastrarLojista(txtNome.getText(), txtCadastrarEmail.getText(), txtCadastrarSenha.getText());
				lojistaCadastro.setEmpresaId(empresa.getId());
			
			    var listaEmpresaTexto = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/empresa.json"));
				var listaEmpresa = ConversorJson.desserializarListaDaString(listaEmpresaTexto, Empresa.class);
			    var ehEmpresaDuplicada = empresa.verificaDuplicidadeEmpresa(listaEmpresa);
				
				var listaLojistaTexto = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/lojista.json"));
				var listaLojista = ConversorJson.desserializarListaDaString(listaLojistaTexto, CadastrarLojista.class);
				boolean ehLojistaDuplicado = lojistaCadastro.verificaDuplicata(listaLojista);

				if(ehEmpresaDuplicada && ehLojistaDuplicado) 
				{
						DataHelper.adicionarItemAoJsonESalvar(
								Paths.get("Projeto LookFor/src/data/empresa.json"), 
								empresa, 
								Empresa.class);
						DataHelper.adicionarItemAoJsonESalvar(
								Paths.get("Projeto LookFor/src/data/lojista.json"), 
								lojistaCadastro, 
								CadastrarLojista.class);
					    AlertaUtil.alerta("Cadastro realizado com sucesso");
	
							layeredPane.removeAll();
							layeredPane.add(panelLogin);
							layeredPane.repaint();
							layeredPane.revalidate();
							panelLogin.setVisible(true);
						
					    
				} else 
				{	
				    AlertaUtil.aviso("Cadastro Inválido");
				}			
			}
		});
		btnCadastrarLojista.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrarLojista.setBounds(440, 535, 114, 23);
		panelCadastrarLojista.add(btnCadastrarLojista);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setBounds(296, 486, 52, 14);
		panelCadastrarLojista.add(lblCep);
		
		JButton btnCancelarCadastro = new JButton("CANCELAR");
		btnCancelarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelLogin);
				layeredPane.repaint();
				layeredPane.revalidate();
				panelLogin.setVisible(true);
			}
		});
		btnCancelarCadastro.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarCadastro.setBounds(175, 535, 114, 23);
		panelCadastrarLojista.add(btnCancelarCadastro);
		


	}
}
