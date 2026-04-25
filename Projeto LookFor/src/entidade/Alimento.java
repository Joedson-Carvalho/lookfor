package entidade;

public class Alimento extends CadastrarItem {
	
	String ingredientes;
	String dataVencimento;
	String dataFabricacao;
	
	public Alimento(
			String nome, 
			double preco, 
			String codItem, 
			String descItem, 
			String ingredientes, 
			String dataVencimento,
			String dataFabricacao)
	{
		super(nome, preco, codItem, descItem);
		this.ingredientes = ingredientes;
		this.dataFabricacao = dataFabricacao;
		this.dataVencimento = dataVencimento;
	}
	
	public boolean ehPerecivel()
	{
		return this.dataVencimento.trim().isEmpty();
	}

}
