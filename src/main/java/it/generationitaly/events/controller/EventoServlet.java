package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.repository.EventoRepository;
import it.generationitaly.events.repository.impl.EventoRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/evento")
public class EventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventoRepository eventoRepository = new EventoRepositoryImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession(); // request.getSession(false);
		System.out.println("siamo dentro la servlet");
		String idAsString = request.getParameter("id");
		if (idAsString != null) {
			getEventoInfo(request, response);
			getCards(request, response);
			System.out.println("siamo fuori");
			return;
		}
		
		
	}

	private void getCards(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> idCards = randomId();

		int id1 = idCards.get(1);
		System.out.println(id1);
		int id2 = idCards.get(2);
		System.out.println(id2);

		Evento evento1 = eventoRepository.findById(id1);
		Evento evento2 = eventoRepository.findById(id2);
		System.out.println(evento1.getNome());
		System.out.println(evento2.getNome());

		request.setAttribute("evento1", evento1);
		request.setAttribute("evento2", evento2);
		request.getRequestDispatcher("evento.jsp").forward(request, response);
	}
	
	private void getEventoInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idAsString = request.getParameter("id");
		System.out.println(idAsString);
		int id = Integer.parseInt(idAsString);
		Evento evento = eventoRepository.findById(id);
		request.setAttribute("evento", evento);
		request.getRequestDispatcher("evento.jsp");
		
	}
	
	private static List<Integer> randomId() {

		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			int add = (int) (Math.random() * (10 - 1 + 1)) + 1;
			while (ids.contains(add)) {
				add = (int) (Math.random() * (10 - 1 + 1)) + 1;
			}

			ids.add(add);

		}
		return ids;
	}
}
