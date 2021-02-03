package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		String param = request.getParameter("product");
		
		if(param != null) {
			output.println("<html><body><h1>Product " + param + "!!!</h1></body></html>");
		}else {
			output.println("<html><body><h1>This product is empty yet!!!</h1></body></html>");	
		}
		
		System.out.println("Entrei no servlet product");
		System.out.println(param);
	}

}
