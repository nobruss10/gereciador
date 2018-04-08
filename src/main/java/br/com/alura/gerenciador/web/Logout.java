package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		String msg;
		if (usuario == null) {
			msg = "Não há usuário logado!";
			req.setAttribute("msg", msg);
			return "/WEB-INF/view/logout.jsp";
		}
		msg = "Usuário Deslogado!";
		req.getSession().removeAttribute("usuarioLogado");
		// resp.sendRedirect("Logout.html");
		return "/WEB-INF/view/logout.jsp";
	}


}
