package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.repository.EventoRepository;
import it.generationitaly.events.repository.impl.EventoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchByTag")
public class SearchByTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventoRepository eventoRepository = new EventoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("searchTag"));
		
		List<Evento> eventi = eventoRepository.findByTagId(id);
		
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
