package br.com.alura.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.models.Empresa;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setName("Google");
		Empresa empresa2 = new Empresa();
		empresa2.setName("ZUP");
		
		empresas.add(empresa1);
		empresas.add(empresa2);
	}
	
	public void save(Empresa empresa) {
		Banco.empresas.add(empresa);
		System.out.println("salvando empresa " + empresa.getName()  + " no banco de dados");
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
}
