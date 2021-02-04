package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Banco;
import br.com.alura.gerenciador.models.Company;

@WebServlet("/storeCompanies")
public class StoreCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("name");
		
		Company company = new Company();
		company.setName(param);
		
		Banco banco = new Banco();
		banco.save(company);
		
		RequestDispatcher rq = request.getRequestDispatcher("created-company.jsp");
		request.setAttribute("companyName", company.getName());
		rq.forward(request, response);
	}
}
