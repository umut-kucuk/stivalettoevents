
<%@page import="it.generationitaly.events.entity.Evento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.generationitaly.events.entity.*"%>
<html>
<head>
<script src="https://kit.fontawesome.com/43c824bcfa.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="evento.css"></link>
<link rel="stylesheet" href="event.css">

<meta charset="UTF-8">
<title>Info Evento | Stivaletto</title>

</head>

<body>

	<div class="container-fluid">
		<div class="row">

			<div class="col-md-8">
				<%
				Evento evento = (Evento) request.getAttribute("evento");
				%>
				<div class="image-container">
					<img src="<%=evento.getImmagine()%>" class="evento-immagine">
				</div>
				<h1 class="evento-nome"><%=evento.getNome()%></h1>
				<p>
					<i class="fa-solid fa-calendar" style="color: #f0a400;"></i>
					<%=evento.getData()%></p>
				<p>
					<i class="fa-solid fa-location-dot" style="color: #f0a400;"></i>
					<%=evento.getCitta()%></p>
				<p>
					<i class="fa-solid fa-house" style="color: #f0a400;"></i>
					<%=evento.getIndirizzo()%></p>
				<p class="evento-desc"><%=evento.getDescrizione()%></p>
				<%
				if (evento.isGratuito()) {
				%>
				<p class="event-type"><%="Gratuito"%></p>
				<%
				} else {
				%>
				<p class="event-type">
					<i class="fa-solid fa-money-bill"></i>
					<%=evento.getPrezzo()+ " €"%></p>
				<%
				}
				%>
				<p class="event-tag"><%=evento.getTagEvento().getNome()%></p>
				<form method="get" action="carrello">
					<input type="hidden" name="eventoId" value="<%=evento.getId()%>">
					<button type="submit">
						<i class="fa-solid fa-money-bill" style="color: #ffff;"></i>
						Prenota ora
					</button>
				</form>
				<a href="servletCards"><button>
						<i class="fa-solid fa-house" style="color: #ffff;"></i> Torna alla
						HOME
					</button></a>
			</div>
			
			<div class="col-md-4">
				<h1>Altri eventi che ti potrebbero interessare</h1>
				
				<%
				Evento evento1 = (Evento) request.getAttribute("evento1");
				Evento evento2 = (Evento) request.getAttribute("evento2");
				%>
				
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="<%=evento1.getImmagine()%>" alt="">
					<div class="card-body">
						<h5 class="card-title"><%=evento1.getNome()%></h5>
						<p class="card-text"><%=evento1.getDescrizioneCard()%></p>
						<a href="evento?id=<%=evento1.getId()%>"><button
										class="scopri-piu">Scopri di pi�</button></a>
					</div>
				</div>
				<br>
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="<%=evento2.getImmagine()%>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=evento2.getNome()%></h5>
						<p class="card-text"><%=evento2.getDescrizioneCard()%></p>
						<a href="evento?id=<%=evento2.getId()%>"><button
										class="scopri-piu">Scopri di pi�</button></a>
					</div>
				</div>
			</div>

			<footer class="text-body-secondary py-5">
				<div class="container">
					<p class="float-end mb-1">
						<a href="#">Back to the top</a>
					</p>
					<p class="mb-0">
						<%@ include file="foother.html"%>
					</p>
				</div>
			</footer>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>