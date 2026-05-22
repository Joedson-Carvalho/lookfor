package entidade;

import java.nio.file.Path;
import java.nio.file.Paths;

import tools.ConversorJson;
import tools.DataHelper;

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
		
		DefinirId();
	}
	
	public void DefinirId()
	{
		Path path = Paths.get("Projeto LookFor/src/data/alimento.json");
		var texto = DataHelper.lerTextoDoArquivo(path);
		
		var alimentos = ConversorJson.desserializarListaDaString(texto, Alimento.class);
		
		if (alimentos.isEmpty()) {
			this.id = 0;
		} else 
		{
			var ultimoAlimento = alimentos.getLast();

	    	this.id = ultimoAlimento.getId() + 1; 
		}
		
		
	}
	
	@Override
	public String toString() {
	    return super.showInfo() + "\n" +
	           "Ingredientes: " + this.ingredientes + "\n" +
	           "Data de Fabricação: " + this.dataFabricacao + "\n" +
	           "Data de Vencimento: " + this.dataVencimento;
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
