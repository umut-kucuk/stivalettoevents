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
import jakarta.servlet.http.HttpSession;

@WebServlet("/servletSearch")
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventoRepository eR = new EventoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			response.sendRedirect("form-search.jsp?campiVuoti");
		}

		if ((request.getParameter("searchTag") == null || request.getParameter("searchTag") != null)
				&& (request.getParameter("citta").length() == 0 || request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() == 0 || request.getParameter("nome").length() > 0)
				&& (request.getParameter("data1").length() == 0) && (request.getParameter("data2").length() > 0)
				&& (request.getParameter("gratuito") != null || request.getParameter("gratuito") == null)) {
			response.sendRedirect("form-search.jsp?dataIncompleta1");
		}

		if ((request.getParameter("searchTag") == null || request.getParameter("searchTag") != null)
				&& (request.getParameter("citta").length() == 0 || request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() == 0 || request.getParameter("nome").length() > 0)
				&& (request.getParameter("data1").length() > 0) && (request.getParameter("data2").length() == 0)
				&& (request.getParameter("gratuito") != null || request.getParameter("gratuito") == null)) {
			response.sendRedirect("form-search.jsp?dataIncompleta2");
		}

		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			getEventoTagCitta(request, response);
			return;
		}

		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() > 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			getEventoCittaNome(request, response);
			return;
		}

		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			getEventoTag(request, response);
			return;
		}

		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			getEventoCitta(request, response);
			return;
		}

		if ((request.getParameter("searchTag") == null || request.getParameter("searchTag") != null)
				&& (request.getParameter("citta").length() == 0) && (request.getParameter("nome").length() > 0)
				&& (request.getParameter("data1").length() == 0) && (request.getParameter("data2").length() == 0)
				&& (request.getParameter("gratuito") == null)) {
			getEventoNome(request, response);
			return;
		}

		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() > 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") == null)) {
			getEventoTagNome(request, response);
			return;

		}

		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") != null)) {
			getEventoGratuito(request, response);
			return;
		}

		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() > 0)
				&& (request.getParameter("data2").length() > 0) && (request.getParameter("gratuito") == null)) {
			getEventoDateBetween(request, response);
			return;
		}

		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() == 0)
				&& (request.getParameter("data2").length() == 0) && (request.getParameter("gratuito") != null)) {
			getEventoTagGratuito(request, response);
			return;
		}

		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() > 0)
				&& (request.getParameter("data2").length() > 0) && (request.getParameter("gratuito") == null)) {
			getEventoTagData(request, response);
			return;
		}
		
		if ((request.getParameter("searchTag") == null) && (request.getParameter("citta").length() == 0)
				&& (request.getParameter("nome").length() > 0) && (request.getParameter("data1").length() > 0)
				&& (request.getParameter("data2").length() > 0) && (request.getParameter("gratuito") == null)) {
			getEventoNomeData(request, response);
			return;
		}
		
		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() > 0) && (request.getParameter("data1").length() > 0)
				&& (request.getParameter("data2").length() > 0) && (request.getParameter("gratuito") != null)) {
			getEventoAll(request, response);
			return;
		}
		
		
		if ((request.getParameter("searchTag") != null) && (request.getParameter("citta").length() > 0)
				&& (request.getParameter("nome").length() == 0) && (request.getParameter("data1").length() > 0)
				&& (request.getParameter("data2").length() > 0) && (request.getParameter("gratuito") == null)) {
			getEventoCittaTagData(request, response);
			return;
		}
	}
	
	private void getEventoCittaTagData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("searchTag"));
		String citta = request.getParameter("citta");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String data1AsString = request.getParameter("data1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("data2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		List<Evento> eventi = eR.findByCittaAndTagEventoAndDataBetween(citta, id, data1, data2);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	
	private void getEventoAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int id = Integer.parseInt(request.getParameter("searchTag"));
		boolean gratuito = Boolean.parseBoolean(request.getParameter("gratuito"));
		String citta = request.getParameter("citta");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String data1AsString = request.getParameter("data1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("data2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		List<Evento> eventi = eR.findByNomeAndTagIdAndCittaAndGratuitoAndDataBetween(nome, id, citta, gratuito, data1, data2);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	
	private void getEventoNomeData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String data1AsString = request.getParameter("data1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("data2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		List<Evento> eventi = eR.findByNomeAndDataBetween(nome, data1, data2);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}


	private void getEventoTagData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("searchTag"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String data1AsString = request.getParameter("data1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("data2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		List<Evento> eventi = eR.findByTagIdAndDataBetween(id, data1, data2);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoTagGratuito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("searchTag"));
		boolean gratuito = Boolean.parseBoolean(request.getParameter("gratuito"));

		List<Evento> eventi = eR.findByTagIdAndGratuito(id, gratuito);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoCittaNome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String citta = request.getParameter("citta");

		List<Evento> eventi = eR.findByNomeAndCitta(nome, citta);

		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoTagNome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int id = Integer.parseInt(request.getParameter("searchTag"));
		List<Evento> eventi = eR.findEventi2(id, nome);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoTagCitta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("searchTag"));
		String citta = request.getParameter("citta");
		List<Evento> eventi = eR.findEventi1(id, citta);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);

	}

	private void getEventoTag(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("searchTag"));
		List<Evento> eventi = eR.findByTagId(id);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
		session.setAttribute("eventi", eventi);

	}

	private void getEventoNome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		List<Evento> eventi = eR.findByNome(nome);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);

	}

	private void getEventoCitta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String citta = request.getParameter("citta");
		List<Evento> eventi = eR.findByCitta(citta);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoGratuito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean gratuito = Boolean.parseBoolean(request.getParameter("gratuito"));
		List<Evento> eventi = eR.findByGratuito(gratuito);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

	private void getEventoDateBetween(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String data1AsString = request.getParameter("data1");
		Date data1 = null;
		try {
			data1 = formatter.parse(data1AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		String data2AsString = request.getParameter("data2");
		Date data2 = null;
		try {
			data2 = formatter.parse(data2AsString);
		} catch (ParseException e) {
			e.getMessage();
		}

		List<Evento> eventi = eR.findByDataBetween(data1, data2);
		request.setAttribute("eventi", eventi);
		request.getRequestDispatcher("risultati.jsp").forward(request, response);
	}

}
