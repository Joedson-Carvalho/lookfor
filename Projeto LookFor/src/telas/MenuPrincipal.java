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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import tools.ConversorJson;
import tools.DataHelper;
import entidade.Alimento;
import entidade.CadastrarItem;
import entidade.CadastrarLojista;
import entidade.Eletronico;
import entidade.Empresa;
import entidade.Endereco;
import enums.TipoItemsEnum;

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
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

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
	private JTextField txtNomeAlimento;
	private JTextField txtPrecoAlimento;
	private JTextField txtCodAlimento;
	private JTextField txtDescricaoAlimento;
	private CadastrarLojista lojistaLogado;
	private CadastrarItem itemSelecionadoLojista;
	public String pathProjeto = "Projeto LookFor/src/";

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagens/icon.png")));
		setTitle("LookFor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 672);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 746, 633);
		contentPane.add(layeredPane);
		
		JPanel panelDeBuscas = new JPanel();
		panelDeBuscas.setBackground(new Color(79, 79, 79));
		layeredPane.setLayer(panelDeBuscas, 1);
		panelDeBuscas.setBounds(0, 0, 746, 633);
		layeredPane.add(panelDeBuscas);
		panelDeBuscas.setLayout(null);
		
		JLabel lblLogin_1 = new JLabel("Lojista? Faça Seu Login ou Cadastro Clicando neste botão:");
		lblLogin_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLogin_1.setForeground(new Color(255, 255, 255));
		lblLogin_1.setBounds(289, 592, 348, 14);
		panelDeBuscas.add(lblLogin_1);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(79, 79, 79));
		panelLogin.setVisible(false);
		layeredPane.setLayer(panelLogin, 0);
		panelLogin.setBounds(0, 0, 746, 633);
		layeredPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblEMail = new JLabel("E-MAIL:");
		lblEMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEMail.setForeground(new Color(255, 255, 255));
		lblEMail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEMail.setBounds(170, 210, 72, 20);
		panelLogin.add(lblEMail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(250, 210, 300, 20);
		panelLogin.add(txtEmail);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSenha.setBounds(170, 250, 72, 20);
		panelLogin.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtSenha.setColumns(10);
		txtSenha.setBounds(250, 250, 300, 20);
		panelLogin.add(txtSenha);
		
		JPanel panelLojista = new JPanel();
		panelLojista.setBackground(new Color(192, 192, 192));
		panelLojista.setVisible(false);
		layeredPane.setLayer(panelLojista, 0);
		panelLojista.setBounds(0, 0, 746, 633);
		layeredPane.add(panelLojista);
		panelLojista.setLayout(null);
		JComboBox comboBoxLojista = new JComboBox();
		String[] colunas = {"Id", "Nome do Item", "Código", "Preço"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        // Retorna false para QUALQUER célula, tornando a tabela inteira somente leitura
		        return false; 
		    }
		};
		JTextArea textAreaMenorPrecoLojista = new JTextArea();
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(55, 114, 251));
		btnEntrar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
;				var dataLogins = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/lojista.json"));
				var logins = ConversorJson.desserializarListaDaString(dataLogins, CadastrarLojista.class);
				
				var loginEncontrado = logins.stream()
						.filter(x -> 
						x.getEmail().trim().equals(txtEmail.getText().trim()) && 
						x.getSenha().trim().equals(txtSenha.getText().trim()))
						.findFirst()
						.orElse(null);
				
				if(loginEncontrado != null) {
					lojistaLogado = loginEncontrado;
					layeredPane.removeAll();
					layeredPane.add(panelLojista);
					layeredPane.repaint();
					layeredPane.revalidate();
					panelLojista.setVisible(true);
					txtEmail.setText("");
					txtSenha.setText("");
					
					
					var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
					var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
					var enderecoTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/endereco.json"));
					
					var enderecos = ConversorJson.desserializarListaDaString(enderecoTexto, Endereco.class);
		            
					List<CadastrarItem> itemsAlimentos = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
					for (CadastrarItem item : itemsAlimentos) {
					    item.setTipo(TipoItemsEnum.ALIMENTO);
					}
					
					var itemsEletronicos = ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class);
					for (CadastrarItem item : itemsEletronicos) {
					    item.setTipo(TipoItemsEnum.ELETRONICO);
					}
		            
					var verItems = itemsEletronicos;
					verItems.addAll(itemsAlimentos);
					
					verItems = verItems.stream().filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId()).toList();
					
					String buscar = txtBuscarNoLojista.getText().trim().toLowerCase();
					
					var streamBase = verItems.stream()
					    .filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId() && 
						    (x.getNome().toLowerCase().startsWith(buscar) ||
			                 x.getCodItem().toLowerCase().startsWith(buscar))
					    );

					var filtroEscolhido = comboBoxLojista.getSelectedItem().toString();
					List<CadastrarItem> resultadoFinal;

					// 2. Ordenação
					if (filtroEscolhido.equals("Menor Distancia")) {
					    System.out.println("Ordenando por menor distancia...");
					    
					    resultadoFinal = streamBase.sorted((item1, item2) -> {
					        int dist1 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item1.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        int dist2 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item2.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        return Integer.compare(dist1, dist2);
					    }).toList();

					} else {
						
					    // Ordenação por preço
					    resultadoFinal = streamBase.sorted(Comparator.comparingDouble(CadastrarItem::getPreco)).toList();
					    
					    System.out.println(resultadoFinal.get(0).getNome());
					}

					// 3. Preenchimento da Tabela (Usando a Lista resultadoFinal)
					modelo.setRowCount(0);
					resultadoFinal.forEach(p -> {
					    modelo.addRow(new Object[]{
					    		p.getId(),
					            p.getNome(),
					            p.getCodItem(),
					            "R$ " + p.getPreco(),
					    });
					});
					
					if (!resultadoFinal.isEmpty()) {
					    // Pega o primeiro item da lista (índice 0)
					    CadastrarItem primeiroItem = resultadoFinal.get(0);
					    
					    // Formata o texto que vai aparecer no TextArea
					    String textoResultado = "PRODUTO EM DESTAQUE\n\n" +
					                            "Nome: " + primeiroItem.getNome() + "\n" +
					                            "Código: " + primeiroItem.getCodItem() + "\n" +
					                            "Preço: R$ " + primeiroItem.getPreco();
					                            
					    // Adiciona um aviso extra dependendo do filtro usado
					    if (filtroEscolhido.equals("Menor Distancia")) {
					        textoResultado += "\n\n(Item mais próximo da sua localização!)";
					    } else {
					        textoResultado += "\n\n(Item com o menor preço encontrado!)";
					    }
					    
					    textAreaMenorPrecoLojista.setText(textoResultado);
					} else {
					    // Se a busca não retornar nada, limpa a tabela e avisa
						textAreaMenorPrecoLojista.setText("Nenhum item encontrado");
					}
				}else {
					AlertaUtil.erro("Login ou senha inválida");
					txtEmail.setText("");
					txtSenha.setText("");
				}
			}
		});
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEntrar.setBounds(350, 290, 100, 25);
		panelLogin.add(btnEntrar);
		
		JButton btnRecuperarSenha = new JButton("Esqueceu sua senha?");
		btnRecuperarSenha.setForeground(new Color(255, 255, 255));
		btnRecuperarSenha.setBackground(new Color(55, 114, 251));
		btnRecuperarSenha.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnRecuperarSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecuperaSenha recuperarSenha = new TelaRecuperaSenha();
				
				recuperarSenha.setVisible(true);
			}
		});
		btnRecuperarSenha.setBounds(280, 335, 240, 25);
		panelLogin.add(btnRecuperarSenha);
		
		JLabel lblCadastrar = new JLabel("Não Possui Cadastro?");
		lblCadastrar.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCadastrar.setForeground(new Color(255, 255, 255));
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setBounds(295, 380, 130, 25);
		panelLogin.add(lblCadastrar);

		String[] colunasTabela = {"Nome do Item", "Código", "Preço"};
		DefaultTableModel tabelaDeBusca = new DefaultTableModel(colunasTabela, 0);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBackground(new Color(55, 114, 251));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelDeBuscas);
				layeredPane.repaint();
				layeredPane.revalidate();
				panelDeBuscas.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 600, 90, 25);
		panelLogin.add(btnNewButton);
		
		JButton btnLogin_1 = new JButton("Acessar");
		btnLogin_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnLogin_1.setForeground(new Color(255, 255, 255));
		btnLogin_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLogin_1.setBackground(new Color(55, 114, 251));
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
		btnLogin_1.setBounds(633, 588, 103, 23);
		panelDeBuscas.add(btnLogin_1);
		
		JLabel lblNewLabel = new JLabel("Melhor Resultado");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(489, 275, 247, 79);
		panelDeBuscas.add(lblNewLabel);
		
		
		tableDeBusca = new JTable();
		tableDeBusca.setGridColor(new Color(59, 59, 59));
		tableDeBusca.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableDeBusca.setBackground(new Color(238, 238, 238));
		tableDeBusca.setSelectionForeground(new Color(255, 255, 255));
		tableDeBusca.setSelectionBackground(new Color(55, 114, 251));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setFont(new Font("Dialog", Font.BOLD, 12));
		scrollPane.setBackground(new Color(224, 224, 224));
		scrollPane.setBounds(10, 88, 469, 478);
		panelDeBuscas.add(scrollPane);
		
		scrollPane.setViewportView(tableDeBusca);
		
		tableDeBusca.setModel(tabelaDeBusca);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtBuscar.setBackground(new Color(238, 238, 238));
		txtBuscar.setBounds(10, 46, 326, 20);
		panelDeBuscas.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(55, 114, 251));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Dialog", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menor Preço", "Menor Distancia"}));
		comboBox.setBounds(489, 524, 247, 42);
		panelDeBuscas.add(comboBox);
		
		JTextArea textAreaMenorPreco = new JTextArea();
		textAreaMenorPreco.setBounds(489, 365, 247, 148);
		panelDeBuscas.add(textAreaMenorPreco);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(222, 232, 254), new Color(222, 232, 254), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBuscar.setBackground(new Color(55, 114, 251));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Disância 0 significa que a empresa/loja esta o mai perto possivel do consumidor.
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
				var empresaTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/empresa.json"));
				var enderecoTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/endereco.json"));
				
				var empresas = ConversorJson.desserializarListaDaString(empresaTexto, Empresa.class).stream();
				var enderecos = ConversorJson.desserializarListaDaString(enderecoTexto, Endereco.class);
				
				List<CadastrarItem> verItems = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				verItems.addAll(ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class));
				if(!verItems.isEmpty()) 
				{
					
					String buscar = txtBuscar.getText().trim().toLowerCase();
					
					var streamBase = verItems.stream()
					    .filter(x -> x.getNome().toLowerCase().startsWith(buscar) ||
					                 x.getCodItem().toLowerCase().startsWith(buscar));

					var filtroEscolhido = comboBox.getSelectedItem().toString();
					List<CadastrarItem> resultadoFinal;

					// 2. Ordenação
					if (filtroEscolhido.equals("Menor Distancia")) {
					    System.out.println("Ordenando por menor distancia...");
					    
					    resultadoFinal = streamBase.sorted((item1, item2) -> {
					        int dist1 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item1.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        int dist2 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item2.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        return Integer.compare(dist1, dist2);
					    }).toList();

					} else {
					    // Ordenação por preço
					    resultadoFinal = streamBase.sorted(Comparator.comparingDouble(CadastrarItem::getPreco)).toList();
					}

					// 3. Preenchimento da Tabela (Usando a Lista resultadoFinal)
					tabelaDeBusca.setRowCount(0);
					resultadoFinal.forEach(p -> {
					    tabelaDeBusca.addRow(new Object[]{
					            p.getNome(),
					            p.getCodItem(),
					            "R$ " + p.getPreco(),
					    });
					});
					
					if (!resultadoFinal.isEmpty()) {
					    // Pega o primeiro item da lista (índice 0)
					    CadastrarItem primeiroItem = resultadoFinal.get(0);
					    
					    // Formata o texto que vai aparecer no TextArea
					    String textoResultado = "PRODUTO EM DESTAQUE\n\n" +
					                            "Nome: " + primeiroItem.getNome() + "\n" +
					                            "Código: " + primeiroItem.getCodItem() + "\n" +
					                            "Preço: R$ " + primeiroItem.getPreco();
					                            
					    // Adiciona um aviso extra dependendo do filtro usado
					    if (filtroEscolhido.equals("Menor Distancia")) {
					        textoResultado += "\n\n(Item mais próximo da sua localização!)";
					    } else {
					        textoResultado += "\n\n(Item com o menor preço encontrado!)";
					    }
					    
					    textAreaMenorPreco.setText(textoResultado);
					} else {
					    // Se a busca não retornar nada, limpa a tabela e avisa
					    textAreaMenorPreco.setText("Nenhum item encontrado para essa busca.");
					}
					
				}
			}
		});
		btnBuscar.setBounds(377, 45, 89, 23);
		panelDeBuscas.add(btnBuscar);
		

		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagens/lookforblack.png")));
		lblNewLabel_3.setBounds(489, 11, 257, 79);
		panelDeBuscas.add(lblNewLabel_3);
		

		
		JTabbedPane tabbedMenuLojista = new JTabbedPane(JTabbedPane.TOP);
		tabbedMenuLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		tabbedMenuLojista.setForeground(new Color(255, 255, 255));
		tabbedMenuLojista.setBackground(new Color(55, 114, 251));
		tabbedMenuLojista.setBounds(0, 0, 746, 633);
		panelLojista.add(tabbedMenuLojista);
		
		JPanel panelMenuLojista = new JPanel();
		panelMenuLojista.setBackground(new Color(79, 79, 79));
		panelMenuLojista.setLayout(null);
		panelMenuLojista.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedMenuLojista.addTab("Menu Lojista", null, panelMenuLojista, null);
		
		
		
		JButton btnPaginaDeBusca = new JButton("Sair");
		btnPaginaDeBusca.setForeground(new Color(255, 255, 255));
		btnPaginaDeBusca.setBackground(new Color(55, 114, 251));
		btnPaginaDeBusca.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnPaginaDeBusca.setFont(new Font("Dialog", Font.BOLD, 16));
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
		
		JLabel lblNewLabel_2 = new JLabel("Melhor Resultado");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_2.setBounds(489, 275, 247, 79);
		panelMenuLojista.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 88, 469, 478);
		panelMenuLojista.add(scrollPane_1);

		table = new JTable();
		table.setBackground(new Color(238, 238, 238));
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setSelectionBackground(new Color(55, 114, 251));
		table.setGridColor(new Color(59, 59, 59));
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		
		txtBuscarNoLojista = new JTextField();
		txtBuscarNoLojista.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtBuscarNoLojista.setBackground(new Color(238, 238, 238));
		txtBuscarNoLojista.setColumns(10);
		txtBuscarNoLojista.setBounds(10, 46, 326, 20);
		panelMenuLojista.add(txtBuscarNoLojista);
		

		comboBoxLojista.setBackground(new Color(55, 114, 251));
		comboBoxLojista.setForeground(new Color(255, 255, 255));
		comboBoxLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		comboBoxLojista.setModel(new DefaultComboBoxModel(new String[] {"Menor Preço", "Menor Distancia"}));
		comboBoxLojista.setBounds(489, 524, 247, 42);
		panelMenuLojista.add(comboBoxLojista);
		

		textAreaMenorPrecoLojista.setBounds(489, 365, 247, 148);
		panelMenuLojista.add(textAreaMenorPrecoLojista);
		
		JButton btnExcluirLojista = new JButton("Excluir Item");
		btnExcluirLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemSelecionadoLojista == null) 
				{
					AlertaUtil.aviso("Nenhum item selecionado para exclusão.");
				} else 
				{
					var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
					var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
					var alimentos = ConversorJson.desserializarListaDaString(itemsAlimentosListar, Alimento.class);
					var eletronicos = ConversorJson.desserializarListaDaString(itemsEletronicosListar, Eletronico.class);
					
					System.out.println(itemSelecionadoLojista.getTipo() + " " + itemSelecionadoLojista.getNome());
					if (itemSelecionadoLojista.getTipo() == TipoItemsEnum.ALIMENTO) {
						alimentos.removeIf(alimento -> alimento.getId() == itemSelecionadoLojista.getId());
						
						DataHelper.salvarArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"), alimentos);
					} else {
						eletronicos.removeIf(eletronico -> eletronico.getId() == itemSelecionadoLojista.getId());
						
						DataHelper.salvarArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"), eletronicos);
					}
					AlertaUtil.alerta("Item excluido com sucesso :)");
					modelo.setRowCount(0);
				}
			}
		});
		btnExcluirLojista.setEnabled(false);
		btnExcluirLojista.setForeground(Color.WHITE);
		btnExcluirLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExcluirLojista.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnExcluirLojista.setBackground(new Color(55, 114, 251));
		btnExcluirLojista.setBounds(503, 95, 132, 23);
		panelMenuLojista.add(btnExcluirLojista);
		JButton btnEditarItem = new JButton("Editar Item");
		
		JButton btnBuscarNoLojista = new JButton("Buscar");
		btnBuscarNoLojista.setForeground(new Color(255, 255, 255));
		btnBuscarNoLojista.setBackground(new Color(55, 114, 251));
		btnBuscarNoLojista.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnBuscarNoLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBuscarNoLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Disância 0 significa que a empresa/loja esta o mai perto possivel do consumidor.
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
				var empresaTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/empresa.json"));
				var enderecoTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/endereco.json"));
				
				var empresas = ConversorJson.desserializarListaDaString(empresaTexto, Empresa.class).stream();
				var enderecos = ConversorJson.desserializarListaDaString(enderecoTexto, Endereco.class);
				
				List<CadastrarItem> verItems = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				verItems.addAll(ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class));
				if(!verItems.isEmpty()) 
				{
					
					String buscar = txtBuscarNoLojista.getText().trim().toLowerCase();
					
					var streamBase = verItems.stream()
					    .filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId() && 
						    (x.getNome().toLowerCase().startsWith(buscar) ||
			                 x.getCodItem().toLowerCase().startsWith(buscar))
					    );

					var filtroEscolhido = comboBoxLojista.getSelectedItem().toString();
					List<CadastrarItem> resultadoFinal;

					// 2. Ordenação
					if (filtroEscolhido.equals("Menor Distancia")) {
					    System.out.println("Ordenando por menor distancia...");
					    
					    resultadoFinal = streamBase.sorted((item1, item2) -> {
					        int dist1 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item1.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        int dist2 = enderecos.stream()
					                .filter(x -> x.getEmpresaId() == item2.getEmpresaId())
					                .findFirst()
					                .map(x -> x.getDistancia())
					                .orElse(Integer.MAX_VALUE);

					        return Integer.compare(dist1, dist2);
					    }).toList();

					} else {
						
					    // Ordenação por preço
					    resultadoFinal = streamBase.sorted(Comparator.comparingDouble(CadastrarItem::getPreco)).toList();
					    
					    System.out.println(resultadoFinal.get(0).getNome());
					}

					// 3. Preenchimento da Tabela (Usando a Lista resultadoFinal)
					modelo.setRowCount(0);
					resultadoFinal.forEach(p -> {
					    modelo.addRow(new Object[]{
					    		p.getId(),
					            p.getNome(),
					            p.getCodItem(),
					            "R$ " + p.getPreco(),
					    });
					});
					
					if (!resultadoFinal.isEmpty()) {
					    // Pega o primeiro item da lista (índice 0)
					    CadastrarItem primeiroItem = resultadoFinal.get(0);
					    
					    // Formata o texto que vai aparecer no TextArea
					    String textoResultado = "PRODUTO EM DESTAQUE\n\n" +
					                            "Nome: " + primeiroItem.getNome() + "\n" +
					                            "Código: " + primeiroItem.getCodItem() + "\n" +
					                            "Preço: R$ " + primeiroItem.getPreco();
					                            
					    // Adiciona um aviso extra dependendo do filtro usado
					    if (filtroEscolhido.equals("Menor Distancia")) {
					        textoResultado += "\n\n(Item mais próximo da sua localização!)";
					    } else {
					        textoResultado += "\n\n(Item com o menor preço encontrado!)";
					    }
					    
					    textAreaMenorPrecoLojista.setText(textoResultado);
					} else {
					    // Se a busca não retornar nada, limpa a tabela e avisa
						textAreaMenorPrecoLojista.setText("Nenhum item encontrado para essa busca.");
					}
					
				}
							
				
			
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	btnExcluirLojista.setEnabled(true);
		    	btnEditarItem.setEnabled(true);
		        // 1. Pega o ponto (coordenadas X e Y) onde o clique aconteceu
		        java.awt.Point ponto = e.getPoint();
		        
		        // 2. Descobre o índice da linha correspondente a esse ponto
		        int linhaClicada = table.rowAtPoint(ponto);
		        
		        // 3. Verifica se o clique foi realmente em uma linha válida
		        if (linhaClicada != -1) {
		            
		            // Exemplo: Pegar o valor da primeira coluna (índice 0) da linha clicada
		            Object valor = table.getValueAt(linhaClicada, 0);
		            System.out.println("Valor da primeira coluna: " + valor);
		            
		            int idItem = Integer.parseInt(valor.toString());
		            
		            var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
					var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
		            
					List<CadastrarItem> itemsAlimentos = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
					for (CadastrarItem item : itemsAlimentos) {
					    item.setTipo(TipoItemsEnum.ALIMENTO);
					}
					
					var itemsEletronicos = ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class);
					for (CadastrarItem item : itemsEletronicos) {
					    item.setTipo(TipoItemsEnum.ELETRONICO);
					}
		            
					var verItems = itemsEletronicos;
					verItems.addAll(itemsAlimentos);
					
					verItems = verItems.stream().filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId() && x.getId() == idItem).toList();
					
		            CadastrarItem itemSelecionado = verItems.getFirst();

		            if (itemSelecionado.getTipo() == TipoItemsEnum.ALIMENTO) {
		                // O Java já sabe que é um Alimento.
		                // Lógica para deletar de alimento.json
		            	itemSelecionadoLojista = itemSelecionado;
		                
		            } else if (itemSelecionado.getTipo() == TipoItemsEnum.ELETRONICO) {
		                // O Java já sabe que é um Eletrônico.
		                // Lógica para deletar de eletronico.json
		            	itemSelecionadoLojista = itemSelecionado;
		            } else 
		            {
		            	AlertaUtil.alerta("Não foi possivel identificar o tipo do item");
		            	System.out.println("nenhum dos dois");
		            }
		            
		        }
		    }
		});
		
		btnBuscarNoLojista.setBounds(377, 45, 89, 23);
		panelMenuLojista.add(btnBuscarNoLojista);
				
		JLabel lblLogoLojista = new JLabel("");
		lblLogoLojista.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagens/lookforblack.png")));
		lblLogoLojista.setBounds(483, 29, 258, 55);
		panelMenuLojista.add(lblLogoLojista);
		
		JPanel panelCadastrarItem = new JPanel();
		CardLayout layoutLojista = new CardLayout(); // Cria o layout de cartas
		//panelCadastrarItem.setLayout(layoutLojista); // Aplica ele no painel
		panelCadastrarItem.setLayout(null);
		panelCadastrarItem.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedMenuLojista.addTab("Cadastrar Produto", null, panelCadastrarItem, null);
		
		JTabbedPane tabbedSubMenuCadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedSubMenuCadastrar.setForeground(new Color(255, 255, 255));
		tabbedSubMenuCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		tabbedSubMenuCadastrar.setBackground(new Color(55, 114, 251));
		tabbedSubMenuCadastrar.setBounds(0, 53, 741, 552);
		panelCadastrarItem.add(tabbedSubMenuCadastrar);
		
		JPanel panelSubMenuCadastrarEletronico = new JPanel();
		panelSubMenuCadastrarEletronico.setBackground(new Color(79, 79, 79));
		panelSubMenuCadastrarEletronico.setLayout(null);
		panelSubMenuCadastrarEletronico.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedSubMenuCadastrar.addTab("Cadastrar Eletronico", null, panelSubMenuCadastrarEletronico, null);
		
		JButton btnSalvarEletronico = new JButton("Salvar");
		JButton btnSalvarAlimento = new JButton("Salvar");
		
		
		btnEditarItem.setEnabled(false);
		btnEditarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemSelecionadoLojista == null) 
				{
					AlertaUtil.aviso("Nenhum item selecionado para exclusão.");
				} else 
				{
					tabbedMenuLojista.setSelectedIndex(1);
					
					var eletronicosJson = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
					var eletronicos = ConversorJson.desserializarListaDaString(eletronicosJson, Eletronico.class);
					
					var alimentosJson = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
					var alimentos = ConversorJson.desserializarListaDaString(alimentosJson, Alimento.class);
					
					if (itemSelecionadoLojista.getTipo() == TipoItemsEnum.ALIMENTO) {
						btnSalvarAlimento.setText("Editar");
						tabbedSubMenuCadastrar.setSelectedIndex(1);
						var alimento = alimentos.stream().filter(x -> x.getId() == itemSelecionadoLojista.getId()).findFirst().get();

						
						txtDescricaoAlimento.setText(alimento.getDescricaoItem());
						txtIngredientes.setText(alimento.getIngredientes());
						txtFabricacao.setText(alimento.getDataFabricacao());
						txtVencimento.setText(alimento.getDataVencimento());
						txtCodAlimento.setText(alimento.getCodItem());
						txtPrecoAlimento.setText(""+alimento.getPreco()+"");
						txtNomeAlimento.setText(alimento.getNome());
					} else {
						btnSalvarEletronico.setText("Editar");
						var eletronico = eletronicos.stream().filter(x -> x.getId() == itemSelecionadoLojista.getId()).findFirst().get();
						tabbedSubMenuCadastrar.setSelectedIndex(0);

						txtNomeEletronico.setText(eletronico.getNome());
						txtCodItemEletronico.setText(eletronico.getCodItem());
						txtDescricaoEletronico.setText(eletronico.getDescricaoItem());
						txtPrecoEletronico.setText(""+eletronico.getPreco()+"");
						txtModelo.setText(""+eletronico.getModelo()+"");
						txtGarantia.setText(""+eletronico.getGarantia()+"");
					}
				}
								
			}
		});
		btnEditarItem.setForeground(Color.WHITE);
		btnEditarItem.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEditarItem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnEditarItem.setBackground(new Color(55, 114, 251));
		btnEditarItem.setBounds(503, 129, 132, 23);
		panelMenuLojista.add(btnEditarItem);
		
		
		
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setForeground(new Color(255, 255, 255));
		lblNomeItem.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeItem.setBounds(140, 160, 119, 20);
		panelSubMenuCadastrarEletronico.add(lblNomeItem);
		
		txtNomeEletronico = new JTextField();
		txtNomeEletronico.setColumns(10);
		txtNomeEletronico.setBounds(240, 160, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtNomeEletronico);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setForeground(new Color(255, 255, 255));
		lblPreco.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPreco.setBounds(140, 200, 119, 20);
		panelSubMenuCadastrarEletronico.add(lblPreco);
		
		txtPrecoEletronico = new JTextField();
		txtPrecoEletronico.setColumns(10);
		txtPrecoEletronico.setBounds(240, 200, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtPrecoEletronico);
		
		JLabel lblCodItem = new JLabel("Código:");
		lblCodItem.setForeground(new Color(255, 255, 255));
		lblCodItem.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCodItem.setBounds(140, 240, 119, 20);
		panelSubMenuCadastrarEletronico.add(lblCodItem);
		
		txtCodItemEletronico = new JTextField();
		txtCodItemEletronico.setColumns(10);
		txtCodItemEletronico.setBounds(240, 240, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtCodItemEletronico);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setForeground(new Color(255, 255, 255));
		lblDescricaoItem.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescricaoItem.setBounds(140, 360, 91, 20);
		panelSubMenuCadastrarEletronico.add(lblDescricaoItem);
		
		txtDescricaoEletronico = new JTextField();
		txtDescricaoEletronico.setColumns(10);
		txtDescricaoEletronico.setBounds(240, 360, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtDescricaoEletronico);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setForeground(new Color(255, 255, 255));
		lblGarantia.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGarantia.setBounds(140, 280, 119, 20);
		panelSubMenuCadastrarEletronico.add(lblGarantia);
		
		txtGarantia = new JTextField();
		txtGarantia.setColumns(10);
		txtGarantia.setBounds(240, 280, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtGarantia);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblModelo.setBounds(140, 320, 119, 20);
		panelSubMenuCadastrarEletronico.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(240, 320, 350, 20);
		panelSubMenuCadastrarEletronico.add(txtModelo);
		
		
		btnSalvarEletronico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double modeloConvertido = 0.0;
				Double precoConvertido = 0.0;
				int garantiaConvertida = 0;
				
				try {
					garantiaConvertida = Integer.parseInt(txtGarantia.getText());
					modeloConvertido = Double.parseDouble(txtModelo.getText());
					precoConvertido = Double.parseDouble(txtPrecoEletronico.getText());
					
					
					
				} catch(Exception ex) {
					AlertaUtil.erro("Alguma informação inválida!");
					
				}
				
				var eletronico = new Eletronico(
						garantiaConvertida, 
						modeloConvertido,
						txtNomeEletronico.getText(),
						precoConvertido,
						txtCodItemEletronico.getText(),
						txtDescricaoEletronico.getText(),
						lojistaLogado.getEmpresaId());
				
				if ("Editar".equals(btnSalvarEletronico.getText())) { // Substitua pelo nome correto da variável do seu botão
					var eletronicosJson = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
					var eletronicos = ConversorJson.desserializarListaDaString(eletronicosJson, Eletronico.class);

					eletronicos.removeIf(x -> x.getId() == itemSelecionadoLojista.getId());

					eletronico.setId(itemSelecionadoLojista.getId());
					
					eletronicos.add(eletronico);
					
				    // 4. Salva a atualização no arquivo JSON correto
				    DataHelper.salvarArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"), eletronicos);

				    // 5. Exibe a mensagem de sucesso
				    AlertaUtil.alerta("Eletrônico " + txtNomeAlimento.getText() + " atualizado com sucesso.");

				    btnSalvarEletronico.setText("Salvar");
				          
				   
				} else {
					DataHelper.adicionarItemAoJsonESalvar(
							Paths.get(DataHelper.pathProjeto + "data/eletronico.json"), 
							eletronico, 
							Eletronico.class);
					
					AlertaUtil.alerta("Eletrônico " + txtNomeEletronico.getText() + " salvo com sucesso.");
				}	
				
				tabbedMenuLojista.setSelectedIndex(0);
				
			    txtNomeEletronico.setText("");
				txtCodItemEletronico.setText("");
				txtDescricaoEletronico.setText("");
				txtPrecoEletronico.setText("");
				txtModelo.setText("");
				txtGarantia.setText("");
				
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
				var enderecoTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/endereco.json"));
				
				var enderecos = ConversorJson.desserializarListaDaString(enderecoTexto, Endereco.class);
	            
				List<CadastrarItem> itemsAlimentos = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				for (CadastrarItem item : itemsAlimentos) {
				    item.setTipo(TipoItemsEnum.ALIMENTO);
				}
				
				var itemsEletronicos = ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class);
				for (CadastrarItem item : itemsEletronicos) {
				    item.setTipo(TipoItemsEnum.ELETRONICO);
				}
	            
				var verItems = itemsEletronicos;
				verItems.addAll(itemsAlimentos);
				
				verItems = verItems.stream().filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId()).toList();
				
				String buscar = txtBuscarNoLojista.getText().trim().toLowerCase();
				
				var streamBase = verItems.stream()
				    .filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId() && 
					    (x.getNome().toLowerCase().startsWith(buscar) ||
		                 x.getCodItem().toLowerCase().startsWith(buscar))
				    );

				var filtroEscolhido = comboBoxLojista.getSelectedItem().toString();
				List<CadastrarItem> resultadoFinal;

				// 2. Ordenação
				if (filtroEscolhido.equals("Menor Distancia")) {
				    System.out.println("Ordenando por menor distancia...");
				    
				    resultadoFinal = streamBase.sorted((item1, item2) -> {
				        int dist1 = enderecos.stream()
				                .filter(x -> x.getEmpresaId() == item1.getEmpresaId())
				                .findFirst()
				                .map(x -> x.getDistancia())
				                .orElse(Integer.MAX_VALUE);

				        int dist2 = enderecos.stream()
				                .filter(x -> x.getEmpresaId() == item2.getEmpresaId())
				                .findFirst()
				                .map(x -> x.getDistancia())
				                .orElse(Integer.MAX_VALUE);

				        return Integer.compare(dist1, dist2);
				    }).toList();

				} else {
					
				    // Ordenação por preço
				    resultadoFinal = streamBase.sorted(Comparator.comparingDouble(CadastrarItem::getPreco)).toList();
				    
				    System.out.println(resultadoFinal.get(0).getNome());
				}

				// 3. Preenchimento da Tabela (Usando a Lista resultadoFinal)
				modelo.setRowCount(0);
				resultadoFinal.forEach(p -> {
				    modelo.addRow(new Object[]{
				    		p.getId(),
				            p.getNome(),
				            p.getCodItem(),
				            "R$ " + p.getPreco(),
				    });
				});
				
				if (!resultadoFinal.isEmpty()) {
				    // Pega o primeiro item da lista (índice 0)
				    CadastrarItem primeiroItem = resultadoFinal.get(0);
				    
				    // Formata o texto que vai aparecer no TextArea
				    String textoResultado = "PRODUTO EM DESTAQUE\n\n" +
				                            "Nome: " + primeiroItem.getNome() + "\n" +
				                            "Código: " + primeiroItem.getCodItem() + "\n" +
				                            "Preço: R$ " + primeiroItem.getPreco();
				                            
				    // Adiciona um aviso extra dependendo do filtro usado
				    if (filtroEscolhido.equals("Menor Distancia")) {
				        textoResultado += "\n\n(Item mais próximo da sua localização!)";
				    } else {
				        textoResultado += "\n\n(Item com o menor preço encontrado!)";
				    }
				    
				    textAreaMenorPrecoLojista.setText(textoResultado);
				} else {
				    // Se a busca não retornar nada, limpa a tabela e avisa
					textAreaMenorPrecoLojista.setText("Nenhum item encontrado");
				}
			}
		});
		btnSalvarEletronico.setBackground(new Color(55, 114, 251));
		btnSalvarEletronico.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnSalvarEletronico.setForeground(new Color(255, 255, 255));
		btnSalvarEletronico.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvarEletronico.setBounds(490, 450, 100, 25);
		panelSubMenuCadastrarEletronico.add(btnSalvarEletronico);
		
		JButton btnCancelarEletronico = new JButton("Cancelar");
		btnCancelarEletronico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeEletronico.setText("");
				txtCodItemEletronico.setText("");
				txtDescricaoEletronico.setText("");
				txtPrecoEletronico.setText("");
				txtModelo.setText("");
				txtGarantia.setText("");
				btnSalvarEletronico.setText("Salvar");
			}
		});
		btnCancelarEletronico.setBackground(new Color(55, 114, 251));
		btnCancelarEletronico.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnCancelarEletronico.setForeground(new Color(255, 255, 255));
		btnCancelarEletronico.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCancelarEletronico.setBounds(140, 450, 110, 25);
		panelSubMenuCadastrarEletronico.add(btnCancelarEletronico);
		
		JLabel lblCadastroEletronicoMenu = new JLabel("Cadastrar Eletronico");
		lblCadastroEletronicoMenu.setForeground(new Color(255, 255, 255));
		lblCadastroEletronicoMenu.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCadastroEletronicoMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroEletronicoMenu.setBounds(240, 60, 350, 47);
		panelSubMenuCadastrarEletronico.add(lblCadastroEletronicoMenu);
		
		JPanel panelSubMenuCadastrarAlimento = new JPanel();
		panelSubMenuCadastrarAlimento.setBackground(new Color(79, 79, 79));
		panelSubMenuCadastrarAlimento.setLayout(null);
		panelSubMenuCadastrarAlimento.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedSubMenuCadastrar.addTab(" Cadastrar Alimento", null, panelSubMenuCadastrarAlimento, null);
		
		JLabel lblDataVencimento = new JLabel("Data Venc.:");
		lblDataVencimento.setForeground(new Color(255, 255, 255));
		lblDataVencimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDataVencimento.setBounds(140, 280, 110, 20);
		panelSubMenuCadastrarAlimento.add(lblDataVencimento);
		
		txtVencimento = new JTextField();
		txtVencimento.setColumns(10);
		txtVencimento.setBounds(240, 280, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtVencimento);
		
		JLabel lblDataFabricacao = new JLabel("Data Fab.:");
		lblDataFabricacao.setForeground(new Color(255, 255, 255));
		lblDataFabricacao.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDataFabricacao.setBounds(140, 320, 91, 20);
		panelSubMenuCadastrarAlimento.add(lblDataFabricacao);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setColumns(10);
		txtFabricacao.setBounds(240, 320, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtFabricacao);
		
		JLabel lblgredientes = new JLabel("Ingredientes:");
		lblgredientes.setForeground(new Color(255, 255, 255));
		lblgredientes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblgredientes.setBounds(140, 360, 110, 20);
		panelSubMenuCadastrarAlimento.add(lblgredientes);
		
		txtIngredientes = new JTextField();
		txtIngredientes.setColumns(10);
		txtIngredientes.setBounds(240, 360, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtIngredientes);
		
		JLabel lblNomeAlimento = new JLabel("Nome:");
		lblNomeAlimento.setForeground(Color.WHITE);
		lblNomeAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeAlimento.setBounds(140, 160, 119, 20);
		panelSubMenuCadastrarAlimento.add(lblNomeAlimento);
		
		txtNomeAlimento = new JTextField();
		txtNomeAlimento.setColumns(10);
		txtNomeAlimento.setBounds(240, 160, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtNomeAlimento);
		
		JLabel lblPrecoAlimento = new JLabel("Preço:");
		lblPrecoAlimento.setForeground(Color.WHITE);
		lblPrecoAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrecoAlimento.setBounds(140, 200, 119, 20);
		panelSubMenuCadastrarAlimento.add(lblPrecoAlimento);
		
		txtPrecoAlimento = new JTextField();
		txtPrecoAlimento.setColumns(10);
		txtPrecoAlimento.setBounds(240, 200, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtPrecoAlimento);
		
		JLabel lblCodAlimento = new JLabel("Código:");
		lblCodAlimento.setForeground(Color.WHITE);
		lblCodAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCodAlimento.setBounds(140, 240, 119, 20);
		panelSubMenuCadastrarAlimento.add(lblCodAlimento);
		
		txtCodAlimento = new JTextField();
		txtCodAlimento.setColumns(10);
		txtCodAlimento.setBounds(240, 240, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtCodAlimento);
		
		JLabel lblDescricaoAlimento = new JLabel("Descrição:");
		lblDescricaoAlimento.setForeground(Color.WHITE);
		lblDescricaoAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescricaoAlimento.setBounds(140, 400, 91, 20);
		panelSubMenuCadastrarAlimento.add(lblDescricaoAlimento);
		
		txtDescricaoAlimento = new JTextField();
		txtDescricaoAlimento.setColumns(10);
		txtDescricaoAlimento.setBounds(240, 400, 350, 20);
		panelSubMenuCadastrarAlimento.add(txtDescricaoAlimento);
		
		JButton btnCancelarAlimento = new JButton("Cancelar");
		btnCancelarAlimento.setForeground(Color.WHITE);
		btnCancelarAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCancelarAlimento.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnCancelarAlimento.setBackground(new Color(55, 114, 251));
		btnCancelarAlimento.setBounds(140, 450, 110, 25);
		panelSubMenuCadastrarAlimento.add(btnCancelarAlimento);
		
		
		btnSalvarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double precoConvertido = 0.0;
				try {
					precoConvertido = Double.parseDouble(txtPrecoAlimento.getText());
				} catch(Exception ex) {
					AlertaUtil.erro("Valor do preço é inválido!");
				}
//				
				var alimento = new Alimento(
						txtNomeAlimento.getText(), 
						precoConvertido,
						txtCodAlimento.getText(),
						txtDescricaoAlimento.getText(),
						txtIngredientes.getText(),
						txtVencimento.getText(),
						txtFabricacao.getText(),
						lojistaLogado.getEmpresaId());
				
				if ("Editar".equals(btnSalvarAlimento.getText())) {
					var alimentosJson = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
					var alimentos = ConversorJson.desserializarListaDaString(alimentosJson, Alimento.class);

					alimentos.removeIf(x -> x.getId() == itemSelecionadoLojista.getId());

					alimento.setId(itemSelecionadoLojista.getId());
					
					alimentos.add(alimento);
					
				    // 4. Salva a atualização no arquivo JSON correto
				    DataHelper.salvarArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"), alimentos);

				    // 5. Exibe a mensagem de sucesso
				    AlertaUtil.alerta("Alimento " + txtNomeAlimento.getText() + " atualizado com sucesso.");

				    btnSalvarAlimento.setText("Salvar");
				} else 
				{
					DataHelper.adicionarItemAoJsonESalvar(
							Paths.get(DataHelper.pathProjeto + "data/alimento.json"), 
							alimento, 
							Alimento.class);
					
					AlertaUtil.alerta("Alimento " + txtNomeAlimento.getText() + " salvo com sucesso.");
				}

				tabbedMenuLojista.setSelectedIndex(0);
				txtNomeAlimento.setText("");
				txtPrecoAlimento.setText("");
				txtCodAlimento.setText("");
				txtDescricaoAlimento.setText("");
				txtIngredientes.setText("");
				txtVencimento.setText("");
				txtFabricacao.setText("");
				
				var itemsEletronicosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/eletronico.json"));
				var itemsAlimentosListar = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/alimento.json"));
				var enderecoTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/endereco.json"));
				
				var enderecos = ConversorJson.desserializarListaDaString(enderecoTexto, Endereco.class);
	            
				List<CadastrarItem> itemsAlimentos = ConversorJson.desserializarListaDaString(itemsAlimentosListar, CadastrarItem.class);
				for (CadastrarItem item : itemsAlimentos) {
				    item.setTipo(TipoItemsEnum.ALIMENTO);
				}
				
				var itemsEletronicos = ConversorJson.desserializarListaDaString(itemsEletronicosListar, CadastrarItem.class);
				for (CadastrarItem item : itemsEletronicos) {
				    item.setTipo(TipoItemsEnum.ELETRONICO);
				}
	            
				var verItems = itemsEletronicos;
				verItems.addAll(itemsAlimentos);
				
				verItems = verItems.stream().filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId()).toList();
				
				String buscar = txtBuscarNoLojista.getText().trim().toLowerCase();
				
				var streamBase = verItems.stream()
				    .filter(x -> x.getEmpresaId() == lojistaLogado.getEmpresaId() && 
					    (x.getNome().toLowerCase().startsWith(buscar) ||
		                 x.getCodItem().toLowerCase().startsWith(buscar))
				    );

				var filtroEscolhido = comboBoxLojista.getSelectedItem().toString();
				List<CadastrarItem> resultadoFinal;

				// 2. Ordenação
				if (filtroEscolhido.equals("Menor Distancia")) {
				    System.out.println("Ordenando por menor distancia...");
				    
				    resultadoFinal = streamBase.sorted((item1, item2) -> {
				        int dist1 = enderecos.stream()
				                .filter(x -> x.getEmpresaId() == item1.getEmpresaId())
				                .findFirst()
				                .map(x -> x.getDistancia())
				                .orElse(Integer.MAX_VALUE);

				        int dist2 = enderecos.stream()
				                .filter(x -> x.getEmpresaId() == item2.getEmpresaId())
				                .findFirst()
				                .map(x -> x.getDistancia())
				                .orElse(Integer.MAX_VALUE);

				        return Integer.compare(dist1, dist2);
				    }).toList();

				} else {
					
				    // Ordenação por preço
				    resultadoFinal = streamBase.sorted(Comparator.comparingDouble(CadastrarItem::getPreco)).toList();
				    
				    System.out.println(resultadoFinal.get(0).getNome());
				}

				// 3. Preenchimento da Tabela (Usando a Lista resultadoFinal)
				modelo.setRowCount(0);
				resultadoFinal.forEach(p -> {
				    modelo.addRow(new Object[]{
				    		p.getId(),
				            p.getNome(),
				            p.getCodItem(),
				            "R$ " + p.getPreco(),
				    });
				});
				
				if (!resultadoFinal.isEmpty()) {
				    // Pega o primeiro item da lista (índice 0)
				    CadastrarItem primeiroItem = resultadoFinal.get(0);
				    
				    // Formata o texto que vai aparecer no TextArea
				    String textoResultado = "PRODUTO EM DESTAQUE\n\n" +
				                            "Nome: " + primeiroItem.getNome() + "\n" +
				                            "Código: " + primeiroItem.getCodItem() + "\n" +
				                            "Preço: R$ " + primeiroItem.getPreco();
				                            
				    // Adiciona um aviso extra dependendo do filtro usado
				    if (filtroEscolhido.equals("Menor Distancia")) {
				        textoResultado += "\n\n(Item mais próximo da sua localização!)";
				    } else {
				        textoResultado += "\n\n(Item com o menor preço encontrado!)";
				    }
				    
				    textAreaMenorPrecoLojista.setText(textoResultado);
				} else {
				    // Se a busca não retornar nada, limpa a tabela e avisa
					textAreaMenorPrecoLojista.setText("Nenhum item encontrado");
				}
			}
		});
		btnSalvarAlimento.setForeground(Color.WHITE);
		btnSalvarAlimento.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvarAlimento.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnSalvarAlimento.setBackground(new Color(55, 114, 251));
		btnSalvarAlimento.setBounds(490, 450, 100, 25);
		panelSubMenuCadastrarAlimento.add(btnSalvarAlimento);
		
		JLabel lblCadastroAlimentoMenu = new JLabel("Cadastrar Alimento");
		lblCadastroAlimentoMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroAlimentoMenu.setForeground(Color.WHITE);
		lblCadastroAlimentoMenu.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCadastroAlimentoMenu.setBounds(240, 60, 350, 47);
		panelSubMenuCadastrarAlimento.add(lblCadastroAlimentoMenu);
		
		JLabel lblLogoCad = new JLabel("");
		lblLogoCad.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagens/lookforblack.png")));
		lblLogoCad.setBounds(476, 10, 255, 65);
		panelCadastrarItem.add(lblLogoCad);
		
		JPanel panelCadastrarLojista = new JPanel();
		panelCadastrarLojista.setBackground(new Color(79, 79, 79));
		panelCadastrarLojista.setVisible(false);
		layeredPane.setLayer(panelCadastrarLojista, 0);
		panelCadastrarLojista.setBounds(0, 0, 746, 633);
		layeredPane.add(panelCadastrarLojista);
		panelCadastrarLojista.setLayout(null);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(55, 114, 251));
		btnCadastrar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					layeredPane.removeAll();
					layeredPane.add(panelCadastrarLojista);
					layeredPane.repaint();
					layeredPane.revalidate();
					panelCadastrarLojista.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBounds(450, 380, 100, 25);
		panelLogin.add(btnCadastrar);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagens/lookforblack500.png")));
		lblNewLabel_4.setBounds(117, 30, 500, 107);
		panelLogin.add(lblNewLabel_4);
		
		JLabel lblMenuLojista = new JLabel("FORMULÁRIO DE CADASTRO DE LOJISTA");
		lblMenuLojista.setForeground(new Color(255, 255, 255));
		lblMenuLojista.setBackground(new Color(255, 255, 255));
		lblMenuLojista.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMenuLojista.setBounds(208, 40, 330, 20);
		panelCadastrarLojista.add(lblMenuLojista);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBounds(275, 100, 300, 20);
		panelCadastrarLojista.add(txtNome);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setForeground(new Color(255, 255, 255));
		lblNome_1.setBackground(new Color(255, 255, 255));
		lblNome_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome_1.setBounds(155, 100, 59, 20);
		panelCadastrarLojista.add(lblNome_1);
		
		JLabel lblSenha_1 = new JLabel("Senha:");
		lblSenha_1.setForeground(new Color(255, 255, 255));
		lblSenha_1.setBackground(new Color(255, 255, 255));
		lblSenha_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSenha_1.setBounds(155, 140, 59, 20);
		panelCadastrarLojista.add(lblSenha_1);
		
		txtCadastrarSenha = new JTextField();
		txtCadastrarSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCadastrarSenha.setColumns(10);
		txtCadastrarSenha.setBounds(275, 140, 300, 20);
		panelCadastrarLojista.add(txtCadastrarSenha);
		
		txtCadastrarEmail = new JTextField();
		txtCadastrarEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCadastrarEmail.setColumns(10);
		txtCadastrarEmail.setBounds(275, 180, 300, 20);
		panelCadastrarLojista.add(txtCadastrarEmail);
		
		JLabel lblEMail_1 = new JLabel("E-Mail:");
		lblEMail_1.setForeground(new Color(255, 255, 255));
		lblEMail_1.setBackground(new Color(255, 255, 255));
		lblEMail_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEMail_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEMail_1.setBounds(155, 180, 59, 20);
		panelCadastrarLojista.add(lblEMail_1);
		
		JLabel lblMenuLoja = new JLabel("FORMULÁRIO DE CADASTRO DA LOJA");
		lblMenuLoja.setForeground(new Color(255, 255, 255));
		lblMenuLoja.setBackground(new Color(255, 255, 255));
		lblMenuLoja.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuLoja.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMenuLoja.setBounds(208, 240, 330, 20);
		panelCadastrarLojista.add(lblMenuLoja);
		
		JLabel lblNomeLoja = new JLabel("Nome da Loja:");
		lblNomeLoja.setForeground(new Color(255, 255, 255));
		lblNomeLoja.setBackground(new Color(255, 255, 255));
		lblNomeLoja.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeLoja.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeLoja.setBounds(155, 300, 119, 20);
		panelCadastrarLojista.add(lblNomeLoja);
		
		txtNomeLoja = new JTextField();
		txtNomeLoja.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNomeLoja.setColumns(10);
		txtNomeLoja.setBounds(275, 300, 300, 20);
		panelCadastrarLojista.add(txtNomeLoja);
		
		txtEmailLoja = new JTextField();
		txtEmailLoja.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmailLoja.setColumns(10);
		txtEmailLoja.setBounds(275, 340, 300, 20);
		panelCadastrarLojista.add(txtEmailLoja);
		
		JLabel lblEMailLoja = new JLabel("E-Mail da Loja:");
		lblEMailLoja.setForeground(new Color(255, 255, 255));
		lblEMailLoja.setBackground(new Color(255, 255, 255));
		lblEMailLoja.setHorizontalAlignment(SwingConstants.LEFT);
		lblEMailLoja.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEMailLoja.setBounds(155, 340, 146, 20);
		panelCadastrarLojista.add(lblEMailLoja);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBackground(new Color(255, 255, 255));
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTelefone.setBounds(155, 380, 119, 20);
		panelCadastrarLojista.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(275, 380, 110, 20);
		panelCadastrarLojista.add(txtTelefone);
		
		txtCadastrarCnpj = new JTextField();
		txtCadastrarCnpj.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCadastrarCnpj.setColumns(10);
		txtCadastrarCnpj.setBounds(445, 380, 130, 20);
		panelCadastrarLojista.add(txtCadastrarCnpj);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(new Color(255, 255, 255));
		lblCnpj.setBackground(new Color(255, 255, 255));
		lblCnpj.setHorizontalAlignment(SwingConstants.LEFT);
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCnpj.setBounds(391, 380, 59, 20);
		panelCadastrarLojista.add(lblCnpj);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setBackground(new Color(255, 255, 255));
		lblEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEndereco.setBounds(155, 420, 146, 20);
		panelCadastrarLojista.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(275, 420, 300, 20);
		panelCadastrarLojista.add(txtEndereco);
		
		txtNumeroEndereco = new JTextField();
		txtNumeroEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNumeroEndereco.setColumns(10);
		txtNumeroEndereco.setBounds(275, 460, 59, 22);
		panelCadastrarLojista.add(txtNumeroEndereco);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCep.setBounds(405, 460, 170, 20);
		panelCadastrarLojista.add(txtCep);
		
		JLabel lblNumeroEndereco = new JLabel("Número:");
		lblNumeroEndereco.setForeground(new Color(255, 255, 255));
		lblNumeroEndereco.setBackground(new Color(255, 255, 255));
		lblNumeroEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroEndereco.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumeroEndereco.setBounds(155, 460, 78, 20);
		panelCadastrarLojista.add(lblNumeroEndereco);
		
		JButton btnCadastrarLojista = new JButton("Cadastrar");
		btnCadastrarLojista.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnCadastrarLojista.setBackground(new Color(55, 114, 251));
		btnCadastrarLojista.setForeground(new Color(255, 255, 255));
		btnCadastrarLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validando o preenchimento do cep
				if (txtCep.getText().chars().count() != 8) AlertaUtil.aviso("CEP inválido!");
				
				var empresa = new Empresa(txtNomeLoja.getText(), txtEmailLoja.getText(), txtTelefone.getText(), txtCadastrarCnpj.getText());
				var lojistaCadastro = new CadastrarLojista(txtNome.getText(), txtCadastrarEmail.getText(), txtCadastrarSenha.getText());
				lojistaCadastro.setEmpresaId(empresa.getId());
			
			    var listaEmpresaTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/empresa.json"));
				var listaEmpresa = ConversorJson.desserializarListaDaString(listaEmpresaTexto, Empresa.class);
			    var ehEmpresaDuplicada = empresa.verificaDuplicidadeEmpresa(listaEmpresa);
				
				var listaLojistaTexto = DataHelper.lerTextoDoArquivo(Paths.get(DataHelper.pathProjeto + "data/lojista.json"));
				var listaLojista = ConversorJson.desserializarListaDaString(listaLojistaTexto, CadastrarLojista.class);
				
				int distancia = ThreadLocalRandom.current().nextInt(1, 11);
				var endereco = new Endereco(txtEndereco.getText(), txtNumeroEndereco.getText(), Integer.parseInt(txtCep.getText()), distancia, empresa.getId());
			
				boolean ehLojistaDuplicado = lojistaCadastro.verificaDuplicata(listaLojista);

				if(ehEmpresaDuplicada && ehLojistaDuplicado) 
				{
						DataHelper.adicionarItemAoJsonESalvar(
								Paths.get(DataHelper.pathProjeto + "data/empresa.json"), 
								empresa, 
								Empresa.class);
						
						DataHelper.adicionarItemAoJsonESalvar(
								Paths.get(DataHelper.pathProjeto + "data/lojista.json"), 
								lojistaCadastro, 
								CadastrarLojista.class);
						
						DataHelper.adicionarItemAoJsonESalvar(
								Paths.get(DataHelper.pathProjeto + "data/endereco.json"), 
								endereco, 
								Endereco.class);
						
						
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
		btnCadastrarLojista.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrarLojista.setBounds(461, 535, 114, 23);
		panelCadastrarLojista.add(btnCadastrarLojista);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setBackground(new Color(255, 255, 255));
		lblCep.setHorizontalAlignment(SwingConstants.CENTER);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCep.setBounds(344, 460, 52, 20);
		panelCadastrarLojista.add(lblCep);
		
		JButton btnCancelarCadastro = new JButton("Cancelar");
		btnCancelarCadastro.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 128), new Color(0, 0, 128)));
		btnCancelarCadastro.setBackground(new Color(55, 114, 251));
		btnCancelarCadastro.setForeground(new Color(255, 255, 255));
		btnCancelarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelLogin);
				layeredPane.repaint();
				layeredPane.revalidate();
				panelLogin.setVisible(true);
			}
		});
		btnCancelarCadastro.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCancelarCadastro.setBounds(275, 535, 114, 23);
		panelCadastrarLojista.add(btnCancelarCadastro);
		


	}
}
