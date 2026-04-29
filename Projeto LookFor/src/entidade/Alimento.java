package entidade;

public class Alimento extends CadastrarItem {
	
	private String ingredientes;
	private String dataVencimento;
	private String dataFabricacao;
	
	public Alimento()
	{}
	
	public Alimento(
			String nome, 
			double preco, 
			String codItem, 
			String descItem, 
			String ingredientes, 
			String dataVencimento,
			String dataFabricacao,
			int empresaId)
	{
		super(nome, preco, codItem, descItem, empresaId);
		this.ingredientes = ingredientes;
		this.dataFabricacao = dataFabricacao;
		this.dataVencimento = dataVencimento;
	}
	
	public boolean ehPerecivel()
	{
		return !this.dataVencimento.trim().isEmpty();
	}
	
	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}


}
