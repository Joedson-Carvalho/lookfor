package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidade.CadastrarItem;

public class LeitorTxt {
	 public static void main(String[] args) {
		 
	 String caminho = "src\\data\\data.txt";
	 
	 List<CadastrarItem> listar = new ArrayList<CadastrarItem>();
	 
	 try (BufferedReader br = new BufferedReader (new FileReader(caminho))){

		 String line = br.readLine();
		 line = br.readLine();
		 while (line != null) {
			 String[] vect = line.split(",");
			 String name = vect [0];
			 Double price = Double.parseDouble(vect[1]);			 
			 String qte = vect [2];
			 String desc = vect[3];
			 CadastrarItem prod = new CadastrarItem(name, price, qte, desc);
			 listar.add(prod);
			 
			 line = br.readLine();
		 }
		 
		 System.out.println("Produtos");
		 for(CadastrarItem p : listar) {
			 System.out.println(p);
			 
		 }
	 }
	 catch (IOException e) {
		 System.out.println("Error" + e.getMessage());
	 }
	 }
}