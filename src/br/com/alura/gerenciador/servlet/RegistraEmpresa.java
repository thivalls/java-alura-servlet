package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Banco;
import br.com.alura.gerenciador.models.Empresa;

@WebServlet("/registraEmpresa")
public class RegistraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter output = response.getWriter();
//		String param = request.getParameter("product");
//		
//		if(param != null) {
//			output.println("<html><body><h1>Product " + param + "!!!</h1></body></html>");
//		}else {
//			output.println("<html><body><h1>This product is empty yet!!!</h1></body></html>");	
//		}
//		
//		System.out.println("Entrei no servlet product");
//		System.out.println(param);
//	}
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter output = response.getWriter();
//		String param = request.getParameter("product");
//		
//		if(param != null) {
//			output.println("<html><body><h1>Mostrando produto " + param + "!!!</h1></body></html>");
//		}else {
//			output.println("<html><body><h1>This product is empty yet!!!</h1></body></html>");	
//		}
//		
//		System.out.println("Entrei no servlet product no método get");
//	}
//	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("name");
		
		Empresa company = new Empresa();
		company.setName(param);
		
		Banco banco = new Banco();
		banco.save(company);
		
		RequestDispatcher rq = request.getRequestDispatcher("created-company.jsp");
		request.setAttribute("companyName", company.getName());
		rq.forward(request, response);
	}
}
