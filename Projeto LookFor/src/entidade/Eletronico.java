package entidade;

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
