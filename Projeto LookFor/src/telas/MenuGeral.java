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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import entidade.CadastrarLojista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entidade.Eletronico;
import tools.DataHelper;
import tools.ConversorJson;
import entidade.Alimento;
import java.nio.file.Paths;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import entidade.CadastrarItem;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import javax.swing.JScrollPane;

public class MenuGeral extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanePrincipal;
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
	private JTextField txtInputBusca;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGeral frame = new MenuGeral(null);
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
	public MenuGeral(CadastrarLojista lojistaLogado) {
		if (lojistaLogado != null)
			System.out.println(lojistaLogado.getEmail());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePrincipal);
		contentPanePrincipal.setLayout(null);
		
		JTabbedPane tabbedMenuLojista = new JTabbedPane(JTabbedPane.TOP);
		tabbedMenuLojista.setBounds(0, 0, 484, 611);
		contentPanePrincipal.add(tabbedMenuLojista);
		
		JPanel panelMenuPrincipal = new JPanel();
		panelMenuPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedMenuLojista.addTab("Menu Principal", null, panelMenuPrincipal, null);
		panelMenuPrincipal.setLayout(null);
		
		JLabel lblProgressoEmAndamento = new JLabel("WORK IN PROGRESS...");
		lblProgressoEmAndamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgressoEmAndamento.setBounds(38, 11, 344, 40);
		panelMenuPrincipal.add(lblProgressoEmAndamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 179, 399, 313);
		panelMenuPrincipal.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
				
		
		String[] colunas = {"Nome do Item", "Código", "Preço"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		table.setModel(modelo);
		
		JPanel panelCadastrarItem = new JPanel();
		panelCadastrarItem.setLayout(null);
		panelCadastrarItem.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedMenuLojista.addTab("Cadastrar Produto", null, panelCadastrarItem, null);
		
		txtInputBusca = new JTextField();
		txtInputBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				var itemsEletronicosTexto = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/eletronico.json"));
				var itemsAlimentosTexto = DataHelper.lerTextoDoArquivo(Paths.get("Projeto LookFor/src/data/alimento.json"));
				
				List<CadastrarItem> items = ConversorJson.desserializarListaDaString(itemsAlimentosTexto, CadastrarItem.class);
				items.addAll(ConversorJson.desserializarListaDaString(itemsEletronicosTexto, CadastrarItem.class));
				
				if (!items.isEmpty()) 
				{
					String busca = txtInputBusca.getText().trim().toLowerCase();

					var itemsFiltrados = items.stream()
					    .filter(x -> x.getNome().toLowerCase().startsWith(busca) ||
					                 x.getCodItem().toLowerCase().startsWith(busca))
					    .sorted(Comparator.comparingDouble(CadastrarItem::getPreco))
					    .toList();
							
					modelo.setRowCount(0);
					
					itemsFiltrados.forEach(p -> {
					    modelo.addRow(new Object[]{
					        p.getNome(), 
					        p.getCodItem(), 
					        "R$ " + p.getPreco()
					    });
					});
				}
			}
		});
		txtInputBusca.setBounds(38, 88, 399, 26);
		panelMenuPrincipal.add(txtInputBusca);
		txtInputBusca.setColumns(10);
		
		
		
		JLabel lblCadastro = new JLabel("Cadastrar Item");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastro.setBounds(158, 10, 117, 22);
		panelCadastrarItem.add(lblCadastro);
		
		JTabbedPane tabbedSubMenuCadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedSubMenuCadastrar.setBounds(0, 53, 479, 419);
		panelCadastrarItem.add(tabbedSubMenuCadastrar);
		
		JPanel panelSubMenuCadastrarEletronico = new JPanel();
		panelSubMenuCadastrarEletronico.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSubMenuCadastrarEletronico.setLayout(null);
		tabbedSubMenuCadastrar.addTab("Cadastrar Eletrônicos", null, panelSubMenuCadastrarEletronico, null);
		
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
		
		txtPrecoEletronico = new JTextField();
		txtPrecoEletronico.setColumns(10);
		txtPrecoEletronico.setBounds(198, 72, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtPrecoEletronico);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(27, 108, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblCodItem);
		
		txtCodItemEletronico = new JTextField();
		txtCodItemEletronico.setColumns(10);
		txtCodItemEletronico.setBounds(198, 108, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtCodItemEletronico);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(27, 150, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblDescricaoItem);
		
		txtDescricaoEletronico = new JTextField();
		txtDescricaoEletronico.setColumns(10);
		txtDescricaoEletronico.setBounds(198, 150, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtDescricaoEletronico);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGarantia.setBounds(27, 196, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblGarantia);
		
		txtGarantia = new JTextField();
		txtGarantia.setColumns(10);
		txtGarantia.setBounds(198, 196, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtGarantia);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(27, 239, 119, 19);
		panelSubMenuCadastrarEletronico.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(198, 239, 217, 20);
		panelSubMenuCadastrarEletronico.add(txtModelo);
		
		JButton btnSalvarEletronico = new JButton("Salvar");
		btnSalvarEletronico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lojistaLogado != null) 
				{
					var precoEletronicoConvertido = Double.parseDouble(txtPrecoEletronico.getText());
					var modeloEletronicoConvertido = Double.parseDouble(txtModelo.getText());
					var garantiaConvertida = Integer.parseInt(txtGarantia.getText());
					
					var eletronico = new Eletronico(
							garantiaConvertida, 
							modeloEletronicoConvertido, 
							txtNomeEletronico.getText(), 
							precoEletronicoConvertido,
							txtCodItemEletronico.getText(),
							txtDescricaoEletronico.getText(),
							lojistaLogado.getEmpresaId());
					
					DataHelper.adicionarItemAoJsonESalvar(
							Paths.get("Projeto LookFor/src/data/eletronico.json"), 
							eletronico, 
							Eletronico.class);
					
					panelCadastrarItem.setVisible(false);
					panelMenuPrincipal.setVisible(true);
					contentPanePrincipal.revalidate();
				}
			}
		});
		btnSalvarEletronico.setBounds(326, 297, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnSalvarEletronico);
		
		JButton btnCancelarEletronico = new JButton("Cancelar");
		btnCancelarEletronico.setBounds(52, 297, 89, 23);
		panelSubMenuCadastrarEletronico.add(btnCancelarEletronico);
		
		JPanel panelSubMenuCadastrarAlimento = new JPanel();
		panelSubMenuCadastrarAlimento.setLayout(null);
		panelSubMenuCadastrarAlimento.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedSubMenuCadastrar.addTab("Cadastrar Alimento", null, panelSubMenuCadastrarAlimento, null);
		
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
		btnSalvarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lojistaLogado != null) 
				{
					var precoAlimentoConvertido = Double.parseDouble(txtPrecoAlimento.getText());
					var alimento = new Alimento(
							txtNomeAlimento.getText(),
							precoAlimentoConvertido,
							txtCodItemAlimento.getText(),
							txtDescricaoAlimento.getText(),
							txtIngredientes.getText(),
							txtVencimento.getText(),
							txtFabricacao.getText(),
							lojistaLogado.getEmpresaId());
					
					DataHelper.adicionarItemAoJsonESalvar(
							Paths.get("Projeto LookFor/src/data/alimento.json"), 
							alimento, 
							Alimento.class);
					
					panelCadastrarItem.setVisible(false);
					panelMenuPrincipal.setVisible(true);
					contentPanePrincipal.revalidate();
				}	
			}
		});
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
