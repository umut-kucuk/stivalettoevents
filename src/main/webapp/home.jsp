<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="it.generationitaly.events.entity.Evento"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author" content="Livingstone Amang" />
<meta name="generator" content="Hugo 0.112.5" />
<title>Stivaletto | Homepage</title>

<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
	<link rel="stylesheet" href="carousel.css"></link>

<script src="https://kit.fontawesome.com/43c824bcfa.js"
	crossorigin="anonymous"></script>

<meta name="theme-color" content="#712cf9" />
<meta charset="ISO-8859-1">
<title>Stivaletto | Homepage</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
	<!--  <a href="login.jsp">LOGIN</a>
	<a href="signup.jsp">SIGN UP</a>
	<a href="form-search.jsp">SEARCH</a>
	-->

	<main>
		<section class="py-5 text-center container carousel-container">
			<div id="carouselExampleCaptions" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="https://images.unsplash.com/photo-1674574124792-3be232f1957f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
							class="d-block w-100" alt="..." />
						<div class="carousel-caption d-none d-md-block">
							<h5 class="c-title">Benvenuto su Stivaletto Events</h5>
							<p class="c-description">Che tu sia appassionato di musica, arte, sport o cultura, Stivaletto Events offre una vasta gamma di possibilità per rendere le tue serate indimenticabili.</p>
						</div>
					</div>
					<div class="carousel-item">
						<img
							src="https://images.unsplash.com/photo-1682695795557-17447f921f79?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
							class="d-block w-100" alt="..." />
						<div class="carousel-caption d-none d-md-block">
							<h5 class="c-title">Siamo i migliori in Italia</h5>
							<p class="c-description">Con Stivaletto, scopri gli eventi più straordinari e vivi esperienze uniche in tutta Italia!</p>
						</div>
					</div>
					<div class="carousel-item">
						<img
							src="https://images.unsplash.com/photo-1682695794947-17061dc284dd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
							class="d-block w-100" alt="..." />
						<div class="carousel-caption d-none d-md-block">
							<h5 class="c-title">I tuoi eventi su Stivaletto</h5>
							<p class="c-description">Scopri una miriade di eventi unici e indimenticabili, personalizzati appositamente per te, su Stivaletto - il luogo ideale per vivere le tue passioni allo stato puro.</p>
						</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</section>


		<div class="container">
			<h1 class="main-title">La nostra selezione per te</h1>
			<p class="main-description">Eventi Popolari</p>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

				<!-- Qui inizia La Card -->

				<%
				Evento evento1 = (Evento) request.getAttribute("evento1");
				Evento evento2 = (Evento) request.getAttribute("evento2");
				Evento evento3 = (Evento) request.getAttribute("evento3");
				%>

				<div class="col">
					<div class="card shadow-sm">
						<!-- Immagine evento -->
						<img src="<%=evento1.getImmagine()%>" alt="">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c" />

						</svg>
						<div class="card-body">
							<p class="card-text">
								<!-- Qui inizia la descrizione dell'evento -->
								<%=evento1.getDescrizioneCard()%>
								<!-- Qui inizia il nome dell'evento -->
							<p class="event-name"><%=evento1.getNome()%></p>
							<!-- Qui inizia la data dell'evento -->
							<p class="event-date"><%=evento1.getData()%></p>
							<!-- Qui inizia l'indirizzo dell'evento -->
							<p class="event-indirizzo"><%=evento1.getIndirizzo()%></p>

							</p>
							<div class="d-flex justify-content-between align-items-center">



								<a href="evento?id=<%=evento1.getId()%>"><button
										class="scopri-piu">Scopri di più</button></a>


							</div>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card shadow-sm">
						<img src="<%=evento2.getImmagine()%>" alt="">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c" />

						</svg>
						<div class="card-body">
							<p class="card-text">
								<%=evento2.getDescrizioneCard()%>
							<p class="event-name"><%=evento2.getNome()%></p>
							<p class="event-date"><%=evento2.getData()%></p>
							<p class="event-indirizzo"><%=evento2.getIndirizzo()%></p>

							</p>
							<div class="d-flex justify-content-between align-items-center">

								<a href="evento?id=<%=evento2.getId()%>"><button
										class="scopri-piu">Scopri di più</button></a>


							</div>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card shadow-sm">
						<img src="<%=evento3.getImmagine()%>" alt="">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c" />

						</svg>
						<div class="card-body">
							<p class="card-text">
								<%=evento3.getDescrizioneCard()%>
							<p class="event-name"><%=evento3.getNome()%></p>
							<p class="event-date"><%=evento3.getData()%></p>
							<p class="event-indirizzo"><%=evento3.getIndirizzo()%></p>
							</p>
							<div class="d-flex justify-content-between align-items-center">

								<a href="evento?id=<%=evento3.getId()%>"><button
										class="scopri-piu">Scopri di più</button></a>


							</div>
						</div>
					</div>
				</div>





				<div class="tag-eventi">
					<%--
					<a class="eventi-regione"><i class="fa-solid fa-music"></i> Music</a>
					<a class="eventi-regione"><i class="fa-solid fa-school"></i> Education</a>
					<a class="eventi-regione"><i class="fa-solid fa-laugh"></i> Comedy</a>
					<a href="form-search.jsp" class="eventi-regione">Altri...</a>
					--%>
					<form method="get" action="searchByTag">
						<button id="searchTag" name="searchTag" value="1"
							class="eventi-regione" type="submit">
							<i class="fa-solid fa-music"></i> Music
						</button>
						<button id="searchTag" name="searchTag" value="3"
							class="eventi-regione" type="submit">
							<i class="fa-solid fa-laugh"></i> Comedy
						</button>
						<button id="searchTag" name="searchTag" value="8"
							class="eventi-regione" type="submit">
							<i class="fa-solid fa-brush"></i> Art
						</button>
						<button id="searchTag" name="searchTag" value="6"
							class="eventi-regione" type="submit">
							<i class="fa-solid fa-basketball"></i> Sport & Health
						</button>
						<button id="searchTag" name="searchTag" value="5"
							class="eventi-regione" type="submit">
							<i class="fa-solid fa-burger"></i> Food & Drink
						</button>
					</form>
					<a href="form-search.jsp"><button class="eventi-regione">Altri...</button></a>
				</div>
	</main>

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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>