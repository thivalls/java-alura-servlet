package br.com.alura.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.models.Product;

public class Banco {
	private static List<Product> products = new ArrayList<Product>();
	
	public void save(Product product) {
		Banco.products.add(product);
		System.out.println("salvando o produto " + product.getName()  + " no banco de dados");
	}
	
	public List<Product> getProducts() {
		return Banco.products;
	}
}
