package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.models.Company;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.persist.Banco;

import java.util.Date;
import java.util.List;

@WebServlet("/update")
public class UpdateCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String companyCreatedAt = request.getParameter("created_at");
		
		Banco db = new Banco();
		Company company = new Company();
		company.setName(name);
		
		Date dtCompany = null;
		try {
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			dtCompany = dt.parse(companyCreatedAt);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		company.setCreated_at(dtCompany);
		
		db.update(Integer.valueOf(id), company);
		
		response.sendRedirect("companies");
	}

}
