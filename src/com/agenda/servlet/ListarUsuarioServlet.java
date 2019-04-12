package com.agenda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.agenda.modelos.Pessoas;
import com.agenda.service.CadastroUsuarioService;

public class ListarUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest requestListar, HttpServletResponse responseListar)
			throws ServletException, IOException {
	
		
		Pessoas pessoa = new Pessoas();
		
		pessoa.setNome(requestListar.getParameter("nome"));
		pessoa.setEmail(requestListar.getParameter("email"));
		pessoa.setSenha(requestListar.getParameter("password"));
		pessoa.setTelefone(requestListar.getParameter("telefone"));
		pessoa.setEndereco(requestListar.getParameter("endereco"));
	
		CadastroUsuarioService service = new CadastroUsuarioService();
		service.cadastra(pessoa);
	}
}
