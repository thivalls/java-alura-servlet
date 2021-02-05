package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.models.Company;
import br.com.alura.gerenciador.persist.Banco;

@WebServlet("/companies")
public class ListCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco db = new Banco();
		List<Company> companies = db.getCompanies();
		request.setAttribute("companies", companies);
		
		RequestDispatcher rd = request.getRequestDispatcher("list-companies.jsp");
		rd.forward(request, response);
	}

}
