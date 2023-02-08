package controller;

import java.io.IOException;

import dao.ClientDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;

@WebServlet("/modifierPersonne")
public class EditPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientDao clientDao = new ClientDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Client client = clientDao.findById(num);
		request.setAttribute("personne", client);
		request.getRequestDispatcher("/WEB-INF/editPersonne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Client client = new Client(num, nom, prenom);
		clientDao.update(client);
		response.sendRedirect("personne");
	}

}