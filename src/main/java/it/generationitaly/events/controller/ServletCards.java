package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.repository.EventoRepository;
import it.generationitaly.events.repository.impl.EventoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servletCards")
public class ServletCards extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventoRepository eR = new EventoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getCards(request, response);

	}

	private void getCards(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Integer> idCards = randomId();

		int id1 = idCards.get(1);
		int id2 = idCards.get(2);
		int id3 = idCards.get(3);

		Evento evento1 = eR.findById(id1);
		Evento evento2 = eR.findById(id2);
		Evento evento3 = eR.findById(id3);

		request.setAttribute("evento1", evento1);
		request.setAttribute("evento2", evento2);
		request.setAttribute("evento3", evento3);
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	private static List<Integer> randomId() {

		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			int add = (int) (Math.random() * (10 - 1 + 1)) + 1;
			while (ids.contains(add)) {
				add = (int) (Math.random() * (10 - 1 + 1)) + 1;
			}

			ids.add(add);

		}
		return ids;
	}

}
