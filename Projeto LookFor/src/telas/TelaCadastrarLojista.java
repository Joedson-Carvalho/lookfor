package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import entidade.Empresa;
import entidade.CadastrarLojista;
import tools.ConversorJson;
import tools.DataHelper;

public class TelaCadastrarLojista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtEmailLoja;
	private JTextField txtNomeLoja;
	private JTextField txtCep;
	private JTextField txtNumeroEndereco;
	private JTextField txtEndereco;
	private JTextField txtCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarLojista frame = new TelaCadastrarLojista();
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
	public TelaCadastrarLojista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEMail = new JLabel("E-MAIL:");
		lblEMail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMail.setBounds(25, 164, 59, 14);
		contentPane.add(lblEMail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(25, 128, 59, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(25, 83, 59, 22);
		contentPane.add(lblNome);
		
		JLabel lblMenuLojista = new JLabel("FORMULÁRIO DE CADASTRO DE LOJISTA");
		lblMenuLojista.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLojista.setBounds(49, 21, 339, 35);
		contentPane.add(lblMenuLojista);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(92, 85, 296, 20);
		contentPane.add(txtNome);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(92, 126, 296, 20);
		contentPane.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(92, 162, 296, 20);
		contentPane.add(txtEmail);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var empresa = new Empresa(txtNomeLoja.getText(), txtEmailLoja.getText(), txtTelefone.getText(), txtCnpj.getText());
				var lojistaCadastro = new CadastrarLojista(txtNome.getText(), txtEmail.getText(), txtSenha.getText());
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
				} else 
				{

				}			
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(149, 516, 114, 23);
		contentPane.add(btnCadastrar);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(149, 325, 239, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setBounds(25, 329, 146, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEMailLoja = new JLabel("E-MAIL DA LOJA");
		lblEMailLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblEMailLoja.setBounds(25, 293, 146, 14);
		contentPane.add(lblEMailLoja);
		
		txtEmailLoja = new JTextField();
		txtEmailLoja.setColumns(10);
		txtEmailLoja.setBounds(149, 292, 239, 20);
		contentPane.add(txtEmailLoja);
		
		txtNomeLoja = new JTextField();
		txtNomeLoja.setColumns(10);
		txtNomeLoja.setBounds(149, 248, 239, 20);
		contentPane.add(txtNomeLoja);
		
		JLabel lblNomeLoja = new JLabel("NOME DA LOJA:");
		lblNomeLoja.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeLoja.setBounds(25, 248, 146, 22);
		contentPane.add(lblNomeLoja);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(188, 469, 200, 20);
		contentPane.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setBounds(130, 471, 52, 14);
		contentPane.add(lblCep);
		
		JLabel lblNumeroEndereco = new JLabel("N°");
		lblNumeroEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumeroEndereco.setBounds(25, 471, 28, 14);
		contentPane.add(lblNumeroEndereco);
		
		txtNumeroEndereco = new JTextField();
		txtNumeroEndereco.setColumns(10);
		txtNumeroEndereco.setBounds(50, 468, 59, 22);
		contentPane.add(txtNumeroEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(149, 429, 239, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblEndereco = new JLabel("ENDEREÇO:");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(25, 427, 146, 22);
		contentPane.add(lblEndereco);
		
		JLabel lblMenuLoja = new JLabel("FORMULÁRIO DE CADASTRO DA LOJA");
		lblMenuLoja.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuLoja.setBounds(61, 202, 339, 35);
		contentPane.add(lblMenuLoja);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		lblCnpj.setBounds(25, 370, 146, 14);
		contentPane.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(149, 368, 239, 20);
		contentPane.add(txtCnpj);

	}
}
