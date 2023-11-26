package it.generationitaly.events.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login-signup.jsp");
			return;
		}
		
		request.getSession().invalidate();
		response.sendRedirect("servletCards");
	}

}
