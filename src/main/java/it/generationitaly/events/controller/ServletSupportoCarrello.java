package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.events.entity.Prenotazione;
import it.generationitaly.events.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servletSupportoCarrello")
public class ServletSupportoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		} else {
			List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
			request.setAttribute("prenotazioni", prenotazioni);
			request.getRequestDispatcher("carrello.jsp").forward(request, response);
		}
	}

}
