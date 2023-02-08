package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ClientDao;

@WebServlet("/supprimerPersonne")
public class DeletePersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDao clientDao = new ClientDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		clientDao.remove(num);
		response.sendRedirect("personne");
	}

}