package br.com.alura.gerenciador.persist;

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
	
	public void remove(int id) {
		Banco.companies.remove(id);
	}
	
	public void update(int id, Company company) {
		Banco.companies.set(id, company);
	}

	public List<Company> getCompanies() {
		return Banco.companies;
	}
	
	public Company getById(int id) {
		Company company = Banco.companies.get(id);
		return company;
	}
}
