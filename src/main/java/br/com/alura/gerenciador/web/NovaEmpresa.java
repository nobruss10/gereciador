package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.xml.internal.serialize.Printer;
import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Empresa empresa  = new Empresa(req.getParameter("nome")) ;
		new EmpresaDAO().adiciona(empresa);
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html><body><P> Empresa Adiconada com sucesso: " + req.getParameter("nome") +"</p></body></html>");
	}
}