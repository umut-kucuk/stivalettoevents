package it.generationitaly.events.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import it.generationitaly.events.entity.MetodoPagamento;
import it.generationitaly.events.entity.User;
import it.generationitaly.events.repository.MetodoPagamentoRepository;
import it.generationitaly.events.repository.UserRepository;
import it.generationitaly.events.repository.impl.MetodoPagamentoRepositoryImpl;
import it.generationitaly.events.repository.impl.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserRepository userRepository = new UserRepositoryImpl();
	private MetodoPagamentoRepository metodoPagamentoRepository = new MetodoPagamentoRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sesso = request.getParameter("sesso");

		
		String dataNascitaAsString = request.getParameter("dataNascita");
		System.out.println("data di nascita"+dataNascitaAsString);
		String metodoPagamentoIdAsString = request.getParameter("metodoPagamentoId");
		System.out.println("metodo pagamento id"+metodoPagamentoIdAsString);
       

		if(nome.length()>0 && cognome.length()>0 && username.length()>0 && password.length()>0 && email.length()>0 && sesso.length()>0 && dataNascitaAsString.length()>0 && metodoPagamentoIdAsString!= null ) {
		
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date dataNascita = null;
			try {
				dataNascita = formatter.parse(dataNascitaAsString);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}
			 int metodoPagamentoId = Integer.parseInt(metodoPagamentoIdAsString);
		        System.out.println(metodoPagamentoId);
				MetodoPagamento metodoPagamento = metodoPagamentoRepository.findById(metodoPagamentoId);
			
			User user = new User();
			user.setNome(nome);
			user.setCognome(cognome);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setSesso(sesso);
			user.setDataNascita(dataNascita);
	        user.setMetodoPagamento(metodoPagamento);
	        
	        
			userRepository.save(user);
			response.sendRedirect("login.jsp");

		}else {
			response.sendRedirect("signup.jsp?campiObbligatori");
		}
		
	}

}
