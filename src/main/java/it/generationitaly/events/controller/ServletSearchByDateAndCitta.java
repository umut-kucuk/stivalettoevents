package it.generationitaly.events.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.repository.EventoRepository;
import it.generationitaly.events.repository.impl.EventoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servletDateAndCitta")
public class ServletSearchByDateAndCitta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EventoRepository eR = new EventoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("date1") == null || request.getParameter("date2") == null ) {
			response.sendRedirect("risultati.jsp?dateNonCompilate");
		}else {
			getEventoDateAndCitta(request, response);
			return;
		}
		
	}

	private void getEventoDateAndCitta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String citta = request.getParameter("citta");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		String data1AsString = request.getParameter("date1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("date2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}
		
		List<Evento> eventi = eR.findByCittaDateBetween(citta, data1, data2);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}
	
}
