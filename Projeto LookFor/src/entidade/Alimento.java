package entidade;

public class Alimento extends CadastrarItem {
	
	String tabelaNutricional;
	String dataVencimento;
	String dataFabricacao;
	
	public Alimento(
			String nome, 
			double preco, 
			String codItem, 
			String descItem, 
			String tabelaNutricional, 
			String dataVencimento,
			String dataFabricacao)
	{
		super(nome, preco, codItem, descItem);
		this.tabelaNutricional = tabelaNutricional;
		this.dataFabricacao = dataFabricacao;
		this.dataVencimento = dataVencimento;
	}
	
	public boolean ehPerecivel()
	{
		return this.dataVencimento.trim().isEmpty();
	}
	
	
	
}
