package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Banco;
import br.com.alura.gerenciador.models.Empresa;

@WebServlet("/empresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		
		Banco db = new Banco();
		List<Empresa> empresas = db.getEmpresas();
		
		output.println("<html>");
		output.println("<body>");
		output.println("<ul>");
		for (Empresa empresa : empresas) {
			output.println("<li>" + empresa.getName() + "</li>");
		}
		output.println("</ul>");
		output.println("</body>");
		output.println("</html>");
	}

}
