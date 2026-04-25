package entidade;

public class Eletronico extends CadastrarItem{
	
		int garantia;
		double modelo;
		
		public Eletronico(
				int garantia, 
				double modelo, 
				String nome,
				double preco,
				String codItem,
				String descItem) 
		{
			super(nome, preco, codItem, descItem);
			this.garantia = garantia;
			this.modelo = modelo;
		}

}
