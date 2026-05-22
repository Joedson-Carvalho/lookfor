package entidade;

import java.nio.file.Path;
import java.nio.file.Paths;

import tools.ConversorJson;
import tools.DataHelper;

public class Eletronico extends CadastrarItem{
	
		private int garantia;
		private double modelo;
		
		public Eletronico() {}
		
		public Eletronico(
				int garantia, 
				double modelo, 
				String nome,
				double preco,
				String codItem,
				String descItem,
				int empresaId) 
		{
			super(nome, preco, codItem, descItem, empresaId);
			this.garantia = garantia;
			this.modelo = modelo;
			
			DefinirId();
		}
		
		public void DefinirId()
		{
			Path path = Paths.get(DataHelper.pathProjeto + "data/eletronico.json");
			var texto = DataHelper.lerTextoDoArquivo(path);
			
			var eletronicos = ConversorJson.desserializarListaDaString(texto, Eletronico.class);
			
			if (eletronicos.isEmpty()) 
			{
				this.id = 0;
			} else 
			{
				var ultimoEletro = eletronicos.getLast();

		    	this.id = ultimoEletro.getId() + 1; 
			}
			
		}
		
		@Override
		public String showInfo() {
		    // super.showInfo() traz nome, preco, codigo, etc., da classe CadastrarItem
		    return super.showInfo() + "\n" +
		           "Garantia: " + this.garantia + " meses\n" +
		           "Modelo: " + this.modelo;
		}

		public int getGarantia() {
			return garantia;
		}

		public void setGarantia(int garantia) {
			this.garantia = garantia;
		}

		public double getModelo() {
			return modelo;
		}

		public void setModelo(double modelo) {
			this.modelo = modelo;
		}

}
