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
			Path path = Paths.get("Projeto LookFor/src/data/eletronico.json");
			var texto = DataHelper.lerTextoDoArquivo(path);
			
			var eletronicos = ConversorJson.desserializarListaDaString(texto, Eletronico.class);
			var ultimoEletro = eletronicos.getLast();

	    	this.id = ultimoEletro.getId() + 1; 
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
