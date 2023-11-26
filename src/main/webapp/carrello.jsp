<%@page import="it.generationitaly.events.entity.Prenotazione"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="it.generationitaly.events.entity.Evento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="carello.css">
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/43c824bcfa.js"
	crossorigin="anonymous"></script>
    <title>Carrello | Stivaletto</title>
</head>
<body>
 
    <%@ include file="navbar.jsp" %>
    <div class="container-fluid">
        <div class="row">
        <h1><i class="fa-solid fa-cart-shopping" style="color: #0d6f06;"></i>I Tuoi Eventi</h1>
            <div class="col-md-12">
               
                <% List<Prenotazione> prenotazioni = (List<Prenotazione>) request.getAttribute("prenotazioni");
                   if (prenotazioni == null || prenotazioni.isEmpty()) { %>
                    <p><%= "Il tuo carrello è vuoto..." %></p>
                <% } else {
                       double totale = 0;
                       for (Prenotazione prenotazione : prenotazioni) { %>
                           <div class="card" style="width: 18rem">
                               <div class="card-body">
                                   <img class="card-img-top" src="<%= prenotazione.getEvento().getImmagine() %>">
                                   <p style="color: green; font-weight: bold;"><%= prenotazione.getEvento().getNome() %></p>
                                   <p><%= prenotazione.getEvento().getData() %></p>
                                   <p><i class="fa-solid fa-location-dot" style="color: #f0a400;"></i> <%= prenotazione.getEvento().getIndirizzo() %></p>
                                   <% if (prenotazione.getEvento().isGratuito()) { %>
                                       <p><%= "Gratuito" %></p>
                                   <% } else { %>
                                       <p>Prezzo</p>
                                       <% totale += prenotazione.getEvento().getPrezzo() * prenotazione.getQuantita(); %>
                                       <p><%= prenotazione.getEvento().getPrezzo() * prenotazione.getQuantita() + " €" %></p>
                                   <% } %>
                                   <form method="post" action="carrello">
                                       <input type="hidden" name="idPrenotazione" value="<%= prenotazione.getId() %>">
                                       <label style="color:  #f38600; font-weight: bold;" for="quantita">Nr biglietti</label>
                                       <input id="quantita" name="quantita" type="number" min="1" max="25" value="<%= prenotazione.getQuantita() %>">
                                       <button type="submit">&#8635;</button>
                                   </form>
                                   
                                   
                                   <!-- Cancellazione-->
                                   <form method="post" action="delete-event">
                                       <input type="hidden" name="id" value="<%= prenotazione.getId() %>">
                                       <button class="remove-btn" type="submit" name="remove" value="Remove event">Elimina</button>
                                   </form>
                               </div>
                           </div>
                       <% }%>
                             <p>Il totale è: <%= totale + " €"%>
                <%}%>  
             
            
             <div class="col-md-4">
               
                <% if (prenotazioni == null || prenotazioni.isEmpty()) { %>
                    <a href="servletCards"><button>Torna alla HOME</button></a>
                <% } else { %>
                    <form action="prenotaServlet" method="post">
                        <button style="display:block;" class="buy" type="submit">Prenota</button>
                    </form>
                    <a href="servletCards"><button>Torna alla HOME</button></a>
                <% } %>
            </div>
            </div>
            
            
            
            
        </div>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <footer class="text-body-secondary py-5">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Back to the top</a>
            </p>
            <p class="mb-0">
                <%@ include file="foother.html" %>
            </p>
        </div>
    </footer>
</body>
</html>
