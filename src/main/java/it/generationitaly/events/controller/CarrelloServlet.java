package it.generationitaly.events.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.entity.Prenotazione;
import it.generationitaly.events.entity.User;
import it.generationitaly.events.repository.EventoRepository;
import it.generationitaly.events.repository.PrenotazioneRepository;
import it.generationitaly.events.repository.impl.EventoRepositoryImpl;
import it.generationitaly.events.repository.impl.PrenotazioneRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carrello")
public class CarrelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EventoRepository eventoRepository = new EventoRepositoryImpl();
    private PrenotazioneRepository prenotazioneRepository = new PrenotazioneRepositoryImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        } else {
            List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
            int eventoId = Integer.parseInt(request.getParameter("eventoId"));
            Evento evento = eventoRepository.findById(eventoId);
            if (prenotazioni == null || prenotazioni.isEmpty()) {
                createNewCarrello(request, response, session, user, evento);
            } else {
                boolean eventExists = false;
                for (Prenotazione p : prenotazioni) {
                    if (p.getEvento().getId() == eventoId) {
                        int quantita = p.getQuantita();
                        int quantitaModificata = quantita + 1;
                        p.setQuantita(quantitaModificata);
                        prenotazioneRepository.update(p);
                        eventExists = true;
                        break;
                    }
                }

                if (!eventExists) {
                    Prenotazione prenotazione = new Prenotazione();
                    prenotazione.setUser(user);
                    prenotazione.setEvento(evento);
                    prenotazione.setQuantita(1);
                    prenotazioneRepository.save(prenotazione);
                    prenotazioni.add(prenotazione);
                }

                saveChangesPrenotazioni(request, response, session, user, prenotazioni);
            }
        }
    }

    private void saveChangesPrenotazioni(HttpServletRequest request, HttpServletResponse response,
            HttpSession session, User user, List<Prenotazione> prenotazioni) throws ServletException, IOException {
        user.setPrenotazioni(prenotazioni);
        session.setAttribute("prenotazioni", prenotazioni);
        request.setAttribute("prenotazioni", prenotazioni);
        request.getRequestDispatcher("carrello.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPrenotazione = Integer.parseInt(request.getParameter("idPrenotazione"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
        changeQuantita(request, response, session, user, prenotazioni,idPrenotazione, quantita);
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

    private void createNewCarrello(HttpServletRequest request, HttpServletResponse response, HttpSession session,
            User user, Evento evento) throws ServletException, IOException {
        List<Prenotazione> prenotazioni = (List<Prenotazione>) session.getAttribute("prenotazioni");
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUser(user);
        prenotazione.setEvento(evento);
        prenotazione.setQuantita(1);
        prenotazioneRepository.save(prenotazione);
        prenotazioni.add(prenotazione);
        saveChangesPrenotazioni(request, response, session, user, prenotazioni);
    }
}
