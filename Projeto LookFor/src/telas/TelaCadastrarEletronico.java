package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarEletronico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeItem;
	private JTextField textPreco;
	private JTextField textCodItem;
	private JTextField textDescricaoItem;
	private JTextField textGarantia;
	private JTextField textModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarEletronico frame = new TelaCadastrarEletronico();
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
	public TelaCadastrarEletronico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeItem.setBounds(10, 60, 119, 19);
		contentPane.add(lblNomeItem);
		
		textNomeItem = new JTextField();
		textNomeItem.setBounds(181, 60, 217, 20);
		contentPane.add(textNomeItem);
		textNomeItem.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(10, 98, 119, 19);
		contentPane.add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(181, 98, 217, 20);
		contentPane.add(textPreco);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(10, 134, 119, 19);
		contentPane.add(lblCodItem);
		
		textCodItem = new JTextField();
		textCodItem.setColumns(10);
		textCodItem.setBounds(181, 134, 217, 20);
		contentPane.add(textCodItem);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(10, 176, 119, 19);
		contentPane.add(lblDescricaoItem);
		
		textDescricaoItem = new JTextField();
		textDescricaoItem.setColumns(10);
		textDescricaoItem.setBounds(181, 176, 217, 20);
		contentPane.add(textDescricaoItem);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGarantia.setBounds(10, 222, 119, 19);
		contentPane.add(lblGarantia);
		
		textGarantia = new JTextField();
		textGarantia.setColumns(10);
		textGarantia.setBounds(181, 222, 217, 20);
		contentPane.add(textGarantia);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(10, 265, 119, 19);
		contentPane.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(181, 265, 217, 20);
		contentPane.add(textModelo);
		
		JLabel lblCadastrarEletronico = new JLabel("Cadastrar Eletrônico");
		lblCadastrarEletronico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastrarEletronico.setBounds(139, 8, 176, 20);
		contentPane.add(lblCadastrarEletronico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(309, 323, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(35, 323, 89, 23);
		contentPane.add(btnCancelar);

	}
}
