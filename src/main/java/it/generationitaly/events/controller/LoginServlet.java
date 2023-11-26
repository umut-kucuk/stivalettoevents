package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.generationitaly.events.entity.Prenotazione;
import it.generationitaly.events.entity.User;
import it.generationitaly.events.repository.UserRepository;
import it.generationitaly.events.repository.impl.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserRepository uR = new UserRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = uR.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getId());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("prenotazioni", prenotazioni);
			user.setPrenotazioni(prenotazioni);
			response.sendRedirect("servletCards");
		} else {
			response.sendRedirect("login.jsp?credenzialiErrate");
		}

	}

}
