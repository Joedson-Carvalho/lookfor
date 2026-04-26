package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidade.CadastrarItem;

public class LeitorTxt {
	 public static void main(String[] args) {
	 String path = "src\\data\\data.txt";
	
	 List<CadastrarItem> list = new ArrayList<CadastrarItem>();
	 
	 try (BufferedReader br = new BufferedReader (new FileReader(path))){

		 String line = br.readLine();
		 line = br.readLine();
		 while (line != null) {
			 String[] vect = line.split(",");
			 String name = vect [0];
			 Double price = Double.parseDouble(vect[1]);			 
			 String qte = vect [2];
			 String desc = vect[3];

			 //String price = vect [1];
			 //Integer qte = Integer.parseInt(vect[2]);
			 
			 CadastrarItem prod = new CadastrarItem(name, price, qte, desc);
			 list.add(prod);
			 
			 line = br.readLine();
		 }
		 
		 System.out.println("Produtos");
		 for(CadastrarItem p : list) {
			 System.out.println(p);
			 
		 }
	 }
	 catch (IOException e) {
		 System.out.println("Error" + e.getMessage());
	 }
	 }
}