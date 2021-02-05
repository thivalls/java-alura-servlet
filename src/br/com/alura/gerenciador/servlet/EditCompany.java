package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.models.Company;
import br.com.alura.gerenciador.persist.Banco;

/**
 * Servlet implementation class EditCompany
 */
@WebServlet("/edit")
public class EditCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Banco db = new Banco();
		Company company = db.getById(Integer.valueOf(id));
		
		// creating bag
		request.setAttribute("company", company);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("edit-company.jsp");
		rd.forward(request, response);
	}

}
