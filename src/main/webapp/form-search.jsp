<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="form_source.css">
<title>Ricrca | Stivaletto</title>
</head>
<body>
	<section class="h-1000 gradient-form" style="background-color: #eee;">
		<%@ include file="navbar.jsp"%>
		<div class="container py-5 h-1000">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">
									<div class="text-center">
										<img src="Logo stivaletto colore.png" style="width: 300px;" alt="logo">
	
									</div>
									<form method="get" action="servletSearch">
										<input class="form-control" list="GFGOptions" id="searchNome"
											name="nome" placeholder="Nome evento"> <br> <label
											id="searchCitta">Città:</label> <select class="form-control"
											list="GFGOptions" id="searchCitta" name="citta">
											<option></option>
											<option value="Bari">BARI</option>
											<option value="Bologna">BOLOGNA</option>
											<option value="Catania">CATANIA</option>
											<option value="Firenze">FIRENZE</option>
											<option value="Genova">GENOVA</option>
											<option value="Milano">MILANO</option>
											<option value="Napoli">NAPOLI</option>
											<option value="Palermo">PALERMO</option>
											<option value="Roma">ROMA</option>
											<option value="Torino">TORINO</option>
										</select> <br>
										<div input type="submit">
											<label for="music">Music</label> <input id="music"
												type="radio" name="searchTag" value="1" /> <label
												for="education">Education</label> <input id="education"
												type="radio" name="searchTag" value="2" /> <label
												for="comedy">Comedy</label> <input id="comedy" type="radio"
												name="searchTag" value="3" /> <br> <label
												for="business">Business</label> <input id="business"
												type="radio" name="searchTag" value="4" /> <label
												for="sportnhealth">Sport & Health</label> <input
												id="sportnhealth" type="radio" name="searchTag" value="5" />
											<br> <label for="foodndrink">Food & Drink</label> <input
												id="foodndrink" type="radio" name="searchTag" value="6" />
											<label for="charity">Charity</label> <input id="charity"
												type="radio" name="searchTag" value="7" /> <label for="art">Art</label>
											<input id="art" type="radio" name="searchTag" value="8" /> <br>
											<label for="hobbies">Hobbies</label> <input id="hobbies"
												type="radio" name="searchTag" value="9" /> <label
												for="holiday">Holiday</label> <input id="holiday"
												type="radio" name="searchTag" value="10" />
										</div>
										<div class="form-group">
											<label style="color: #f38600; font-weight: bold;"
												class="form-label" for="risultatiData">Da:</label> <input
												class="form-control" type="date" id="risultatiData"
												name="data1"> <label
												style="color: #f38600; font-weight: bold;"
												class="form-label" for="risultatiData">A:</label> <input
												class="form-control" type="date" id="risultatiData"
												name="data2">
											<div input type="submit">
												<ul>
													<li
														style="font-size: 1.5rem; list-style: none; font-weight: bold; color: green;">
														<input type="radio" name="gratuito" value="true" /> gratuito
													</li>
													<li
														style="font-size: 1.5rem; list-style: none; font-weight: bold; color: #f38600;"><input
														type="radio" name="gratuito" value="false" /> pagamento</li>
												</ul>
											</div>
											<br>
											<%
											if (request.getParameter("campiVuoti") != null) {
											%>
											<p style="color: red;">Compila almeno un campo!</p>
											<%
											}
											%>
											<%
											if (request.getParameter("dataIncompleta1") != null) {
											%>
											<p style="color: red;">Inserisci entrambe le date!</p>
											<%
											}
											%>
											<%
											if (request.getParameter("dataIncompleta2") != null) {
											%>
											<p style="color: red;">Inserisci entrambe le date!</p>
											<%
											}
											%>
											<button type="submit">Cerca</button>
										</div>
									</form>
									<%--
							<hr>
							<hr>
							<form method="get" action="searchByNameAndCityServlet">
								<input class="form-control" list="GFGOptions" id="searchNome"
									name="nome" placeholder="Nome evento"> <br> <label
									id="searchCitta">Città:</label> <select class="form-control"
									list="GFGOptions" id="searchCitta" name="citta">
									<option></option>
									<option value="Napoli">Napoli</option>
									<option value="Milano">Milano</option>
									<!-- Other city options... -->
								</select> <br>
								<button class="btn btn-dark" type="submit">Search(this search button only for the second form)</button>
							</form>
							--%>
								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-center">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<img style="opacity: 0.4;" class="img-fluid"
										src="https://sostegno20.it/wp-content/uploads/2022/05/bambini-geografia-cartina-muta-italia.jpg">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="container">
			<p class="mb-0">
				<%@ include file="foother.html"%>
			</p>
		</div>
	</footer>
</body>
</html>