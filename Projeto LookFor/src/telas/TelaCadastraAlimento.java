package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastraAlimento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraAlimento frame = new TelaCadastraAlimento();
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
	public TelaCadastraAlimento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR PRODUTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(112, 11, 214, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescricaoItem = new JLabel("Descrição:");
		lblDescricaoItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoItem.setBounds(20, 183, 119, 19);
		contentPane.add(lblDescricaoItem);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(191, 183, 217, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(191, 141, 217, 20);
		contentPane.add(textField_1);
		
		JLabel lblCodItem = new JLabel("Codigo do Item:");
		lblCodItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodItem.setBounds(20, 141, 119, 19);
		contentPane.add(lblCodItem);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(20, 105, 119, 19);
		contentPane.add(lblPreco);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 105, 217, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(191, 67, 217, 20);
		contentPane.add(textField_3);
		
		JLabel lblNomeItem = new JLabel("Nome:");
		lblNomeItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeItem.setBounds(20, 67, 119, 19);
		contentPane.add(lblNomeItem);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 321, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(319, 321, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblFabricacao = new JLabel("Data de Fabricação:");
		lblFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFabricacao.setBounds(20, 214, 140, 19);
		contentPane.add(lblFabricacao);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(191, 214, 217, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(191, 262, 217, 20);
		contentPane.add(textField_5);
		
		JLabel lblDataDoVencimento = new JLabel("Data do Vencimento:");
		lblDataDoVencimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDoVencimento.setBounds(20, 262, 140, 19);
		contentPane.add(lblDataDoVencimento);

	}

}
