package br.com.alura.gerenciador.persist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import br.com.alura.gerenciador.models.Company;

public class Banco {
	private static List<Company> companies = new ArrayList<Company>();
	private static Integer sequence = 1;
	
	static {
		Company empresa1 = new Company();
		empresa1.setName("Google");
		empresa1.setId(Banco.sequence++);
		
		Company empresa2 = new Company();
		empresa2.setName("ZUP");
		empresa2.setId(Banco.sequence++);
		
		companies.add(empresa1);
		companies.add(empresa2);
	}
	
	public void save(Company company) {
		company.setId(Banco.sequence++);
		Banco.companies.add(company);
	}
	
	public void remove(Integer id) {
		Iterator<Company> it = Banco.companies.iterator();
		while(it.hasNext()) {
			if(it.next().getId() == id) {
				it.remove();
			}
		}
	}
	
	public void update(Integer id, Company updatedCompany) {
		Company targetCompany = null;
		if(id != null) {
			for(Company company : Banco.companies) {
				if(company.getId() == id) {
					targetCompany = company;
				}
			}
		}
		targetCompany.setName(updatedCompany.getName());
		targetCompany.setCreated_at(updatedCompany.getCreated_at());
	}

	public List<Company> getCompanies() {
		return Banco.companies;
	}
	
	public Company getById(Integer id) {
		if(id != null) {
			for(Company company : Banco.companies) {
				if(company.getId() == id) {
					return company;
				}
			}
		}
		return null;
	}
}
