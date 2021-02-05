package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.models.Company;
import br.com.alura.gerenciador.persist.Banco;

@WebServlet("/storeCompanies")
public class StoreCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyName = request.getParameter("name");
		String companyCreatedAt = request.getParameter("created_at");
		
		Company company = new Company();
		company.setName(companyName);
		
		Date dtCompany = null;
		try {
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			dtCompany = dt.parse(companyCreatedAt);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		company.setCreated_at(dtCompany);
		
		Banco banco = new Banco();
		banco.save(company);
		
		response.sendRedirect("companies");
		
//		RequestDispatcher rq = request.getRequestDispatcher("/companies");
//		request.setAttribute("companyName", company.getName());
//		rq.forward(request, response);
	}
}
