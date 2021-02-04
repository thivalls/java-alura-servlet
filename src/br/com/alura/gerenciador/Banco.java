package br.com.alura.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.models.Company;

public class Banco {
	private static List<Company> companies = new ArrayList<Company>();
	
	static {
		Company empresa1 = new Company();
		empresa1.setName("Google");
		Company empresa2 = new Company();
		empresa2.setName("ZUP");
		
		companies.add(empresa1);
		companies.add(empresa2);
	}
	
	public void save(Company company) {
		Banco.companies.add(company);
	}

	public List<Company> getEmpresas() {
		return Banco.companies;
	}
}
