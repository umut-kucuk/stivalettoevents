package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.events.entity.Prenotazione;
import it.generationitaly.events.entity.User;
import it.generationitaly.events.repository.PrenotazioneRepository;
import it.generationitaly.events.repository.impl.PrenotazioneRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete-event")
public class DeleteEventServlet extends HttpServlet {

	private PrenotazioneRepository prenotazioneRepository = new PrenotazioneRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Prenotazione prenotazione = prenotazioneRepository.findById(id);

	
			prenotazioneRepository.deleteById(id);

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
			prenotazioni.removeIf(p -> p.getId() == id);

			saveChangesPrenotazioni(request, response, session, user, prenotazioni);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
		dispatcher.forward(request, response);
	}

	private void changeQuantita(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			User user, List<Prenotazione> prenotazioni, int idPrenotazione, int quantita)
			throws ServletException, IOException {
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == idPrenotazione) {
				prenotazione.setQuantita(quantita);
				prenotazioneRepository.update(prenotazione);
				saveChangesPrenotazioni(request, response, session, user, prenotazioni);
				return;
			}
		}
	}

	private void saveChangesPrenotazioni(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			User user, List<Prenotazione> prenotazioni) throws ServletException, IOException {
		user.setPrenotazioni(prenotazioni);
		session.setAttribute("prenotazioni", prenotazioni);
		request.setAttribute("prenotazioni", prenotazioni);
	}

	/*
	 * int id = Integer.parseInt(request.getParameter("id")); Prenotazione
	 * prenotazione = prenotazioneRepository.findById(id);
	 * 
	 * if (prenotazione.getQuantita() > 1) { int quantita =
	 * prenotazione.getQuantita() - 1; changeQuantita(request, response,
	 * request.getSession(), (User) request.getSession().getAttribute("user"),
	 * (List<Prenotazione>) request.getSession().getAttribute("prenotazioni"), id,
	 * quantita); } else { prenotazioneRepository.deleteById(id);
	 * 
	 * HttpSession session = request.getSession(); User user = (User)
	 * session.getAttribute("user"); List<Prenotazione> prenotazioni =
	 * (List<Prenotazione>) session.getAttribute("prenotazioni");
	 * prenotazioni.removeIf(p -> p.getId() == id);
	 * 
	 * saveChangesPrenotazioni(request, response, session, user, prenotazioni); }
	 * 
	 * RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
	 * dispatcher.forward(request, response); }
	 * 
	 * private void changeQuantita(HttpServletRequest request, HttpServletResponse
	 * response, HttpSession session, User user, List<Prenotazione> prenotazioni,
	 * int idPrenotazione, int quantita) throws ServletException, IOException { for
	 * (Prenotazione prenotazione : prenotazioni) { if (prenotazione.getId() ==
	 * idPrenotazione) { prenotazione.setQuantita(quantita);
	 * prenotazioneRepository.update(prenotazione); saveChangesPrenotazioni(request,
	 * response, session, user, prenotazioni); return; } } }
	 * 
	 * private void saveChangesPrenotazioni(HttpServletRequest request,
	 * HttpServletResponse response, HttpSession session, User user,
	 * List<Prenotazione> prenotazioni) throws ServletException, IOException {
	 * user.setPrenotazioni(prenotazioni); session.setAttribute("prenotazioni",
	 * prenotazioni); request.setAttribute("prenotazioni", prenotazioni); }
	 * 
	 */

}