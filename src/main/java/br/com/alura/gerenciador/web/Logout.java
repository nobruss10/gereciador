package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.web.Cookies;


@WebServlet(urlPatterns="/Logout")
public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter() ;
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado") ;
		
		if(usuario == null) {
			 writer.println("<html><body>Não há usuario logado!<body></html>");
			 return ;
		}
		req.getSession().removeAttribute("usuario.logado");
		writer.println("<html><body>Deslogado com sucesso!<body></html>");
	}
}
