package entidade;

public class Empresa {
		
		int id;
		String nome;
		String email;
		String telefone;
		String cnpj;
		
		public Empresa(String nomeEmpresa, String email, String telefone, String cnpj) 
		{
			this.nome = nomeEmpresa;
			this.email = email;
			this.telefone = telefone;
			this.cnpj = cnpj;
		}

}
