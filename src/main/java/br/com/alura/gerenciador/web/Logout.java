package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.web.Cookies;

@WebServlet(urlPatterns = "/Logout")
public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		String msg;
		if (usuario == null) {
			msg = "Não há usuário logado!" ;
			redirecionar(req, resp , msg) ;
			return;
		}
		msg = "Usuário Deslogado!" ;
		req.getSession().removeAttribute("usuarioLogado");
		// resp.sendRedirect("Logout.html");
		redirecionar(req, resp, msg);
	}

	private void redirecionar(HttpServletRequest req, HttpServletResponse resp, String msg)
			throws ServletException, IOException {
		req.setAttribute("msg", msg);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/logout.jsp");
		dispatcher.forward(req, resp);
	}
}
