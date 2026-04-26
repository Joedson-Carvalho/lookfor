package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidade.Alimento;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarAlimentoFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtCodigoItem;
	private JTextField txtDescricaoItem;
	private JTextField txtDataVencimento;
	private JTextField txtDataFabricacao;
	private JTextField txtIgredientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAlimentoFinal frame = new TelaCadastrarAlimentoFinal();
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
	public TelaCadastrarAlimentoFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescricaoItem = new JLabel("DESCRIÇÃO DO ITEM:");
		lblDescricaoItem.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescricaoItem.setBounds(10, 168, 154, 14);
		contentPane.add(lblDescricaoItem);
		
		JLabel lblCodigoItem = new JLabel("CÓDIGO  DO ITEM:");
		lblCodigoItem.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoItem.setBounds(10, 123, 134, 23);
		contentPane.add(lblCodigoItem);
		
		JLabel lblPreco = new JLabel("PREÇO:");
		lblPreco.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreco.setBounds(10, 85, 70, 14);
		contentPane.add(lblPreco);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(10, 50, 59, 14);
		contentPane.add(lblNome);
		
		JLabel lblTitulo = new JLabel("CADASTRAR ITEM");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(112, 11, 203, 14);
		contentPane.add(lblTitulo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var precoConvertido = Double.parseDouble(txtPreco.getText());
				
				var alimento = new Alimento(
						txtNome.getText(), 
						precoConvertido,
						txtCodigoItem.getText(),
						txtDescricaoItem.getText(),
						txtIgredientes.getText(),
						txtDataVencimento.getText(),
						txtDataFabricacao.getText());
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvar.setBounds(313, 335, 89, 23);
		contentPane.add(btnSalvar);
		
		txtNome = new JTextField();
		txtNome.setBounds(167, 48, 203, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(167, 83, 203, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtCodigoItem = new JTextField();
		txtCodigoItem.setBounds(167, 125, 203, 20);
		contentPane.add(txtCodigoItem);
		txtCodigoItem.setColumns(10);
		
		txtDescricaoItem = new JTextField();
		txtDescricaoItem.setBounds(167, 166, 203, 20);
		contentPane.add(txtDescricaoItem);
		txtDescricaoItem.setColumns(10);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataVencimento.setBounds(10, 205, 154, 14);
		contentPane.add(lblDataVencimento);
		
		txtDataVencimento = new JTextField();
		txtDataVencimento.setColumns(10);
		txtDataVencimento.setBounds(167, 203, 203, 20);
		contentPane.add(txtDataVencimento);
		
		JLabel lblDataFabricacao = new JLabel("Data Fabricacao");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataFabricacao.setBounds(10, 240, 154, 14);
		contentPane.add(lblDataFabricacao);
		
		txtDataFabricacao = new JTextField();
		txtDataFabricacao.setColumns(10);
		txtDataFabricacao.setBounds(167, 234, 203, 20);
		contentPane.add(txtDataFabricacao);
		
		JLabel lblgredientes = new JLabel("Ingredientes");
		lblgredientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblgredientes.setBounds(10, 277, 154, 14);
		contentPane.add(lblgredientes);
		
		txtIgredientes = new JTextField();
		txtIgredientes.setColumns(10);
		txtIgredientes.setBounds(167, 275, 203, 20);
		contentPane.add(txtIgredientes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar.setBounds(10, 335, 89, 23);
		contentPane.add(btnCancelar);

	}
}
