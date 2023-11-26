package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.events.entity.Prenotazione;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/prenotaServlet")
public class PrenotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
		prenotazioni.clear();
		
		session.setAttribute("prenotazioni", prenotazioni);
		response.sendRedirect("pagina_conferma_carrello.html");
		
	
	}

}
