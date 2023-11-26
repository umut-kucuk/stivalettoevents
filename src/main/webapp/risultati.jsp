<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="it.generationitaly.events.entity.Evento"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Risultati | Stivaletto</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet" href="risultati.css">
</head>
<body>

	<%
	List<Evento> eventi = (List<Evento>) request.getAttribute("eventi");
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<h1 style="color: green; font-weight: bold;">Imposta la tua
					Ricerca</h1>
				<br>
				<form action="servletSearch" method="get">
				 
					<div class="form-group">
						<input type="text" class="form-control"
							id="exampleFormControlInput1" placeholder="Nome Evento"  name="nome"/>
					</div>
					<div id="list1" class="dropdown-check-list" tabindex="100">

						<label id="searchCitta">Città:</label>
									<select class="form-control" list="GFGOptions" id="searchCitta" name="citta">
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
								</select>

						<span style="color: #f38600; font-weight: bold;" class="anchor">Città:</span>

					      
					</div>
					<div class="form-group">
						<label style="color: #f38600; font-weight: bold;"
							class="form-label" for="risultatiData">Da:</label> <input
							class="form-control" type="date" id="risultatiData"
							name="data1"> <label
							style="color: #f38600; font-weight: bold;" class="form-label"
							for="risultatiData">A:</label> <input class="form-control"
							type="date" id="risultatiData" name="data2">
						<div input type="submit">
							<ul>
								<li
									style="font-size: 1.5rem; list-style: none; font-weight: bold; color: green;">

									<input type="radio" name="gratuito"  value="true"/>gratuito

								</li>
								<li
									style="font-size: 1.5rem; list-style: none; font-weight: bold; color: #f38600;"><input
									type="radio" name="gratuito" value="false"/>pagamento</li>
							</ul>
						</div>
						<button type="submit" class="cerca-btn">Cerca</button>
					</div>
					<div class="form-group"></div>
				</form>
			</div>
			
			
			
			
			
			
              <div class="col-md-6">
				<div class="row ">
			<%
			for (Evento evento : eventi) {
			%>
			
					<div class="card" style="width: 18rem">
						<img class="card-img-top" src="<%=evento.getImmagine()%>" alt="" />
						<div class="card-body">
							<h5 class="card-title"><%=evento.getNome()%></h5>
							<p class="card-text">
								<%=evento.getDescrizioneCard()%>
							</p>
							<a href="evento?id=<%=evento.getId()%>"><button
									class="scopri-piu">Scopri di più</button></a>
						</div>
					</div>
		
			<%}%>
		</div>
	</div>
			</div>
			</div>
			<a class="torna" href="servletCards"><div class="torna-home" ><i class="fa-solid fa-house" style="color: #ffffff;"></i></div></a>
	
        
	<script src="https://kit.fontawesome.com/43c824bcfa.js"
		crossorigin="anonymous"></script>
</body>
</html>