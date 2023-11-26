<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="registrazione.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script src="registrazione.js"></script>
<title>Sign Up | Stivaletto</title>
</head>
<body>
<section class="h-100 gradient-form" style="background-color: #eee;">
	<%@ include file="navbar.jsp"%>
	
		<div class="container py-5 h-100">
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
									<form method="post" action="sign-up">
										<div class="form-outline mb-4">
											<input class="form-control" type="text" id="signupNome"
												name="nome" placeholder="Nome">
										</div>
										<div class="form-outline mb-4">
											<input class="form-control" type="text" id="signupCognome"
												name="cognome" placeholder="Cognome">
										</div>
										<label for="signupSessoM">Sesso:</label>
										<label for="signupSessoM" style="margin-left: 8px">M</label>
										<input type="radio"	id="signupSessoM" name="sesso" value="M">
										<label for="signupSessoF" style="margin-left: 8px">F</label>
										<input type="radio"	id="signupSessoF" name="sesso" value="F">
										<div class="form-outline mb-4">
											<label class="form-label" for="signupNascita">Data di nascita:</label>
											<input class="form-control" type="date" id="signupNascita" name="dataNascita">
										</div>
										<div class="form-outline mb-4">
											<input class="form-control" type="text" id="signupUsername"
												name="username" placeholder="Username">
										</div>
										<div class="form-outline mb-4">
											<input class="form-control" type="password"
												id="signupPassword" name="password" placeholder="Password">
										</div>
										<div class="form-outline mb-4">
											<input class="form-control" type="text" id="signupEmail"
												name="email" placeholder="nomecognome@gmail.com">
										</div>
										<div class="form-outline mb-4">
											<p>Inserisci il metodo di pagamento:</p>
											<label for="signupCarta">Carta</label>
											<input type="radio" id="signupCarta" name="metodoPagamentoId" value="1">
											<label for="signupPaypal" style="margin-left: 8px">Paypal</label>
											<input type="radio" id="signupPaypal" name="metodoPagamentoId" value="2">
											<label for="signupPagopa" style="margin-left: 8px">Pagopa</label>
											<input type="radio" id="signupPagopa" name="metodoPagamentoId" value="3">
											<label for="signupSatispay" style="margin-left: 8px">Satispay</label>
											<input type="radio" id="signupSatispay" name="metodoPagamentoId" value="4">
										     <%
									         if (request.getParameter("campiObbligatori") != null) {
								             %>
									         <p style="color: red;">Campi obbligatori!</p>
									         <%
									         }
									         %>
										<div class="d-flex align-items-center justify-content-center pb-4"
										     style="margin-top: 15px; margin-right: 40px">
											<button type="submit">SIGN UP</button>
										</div>
										</div>
									</form>
								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-center">
							<div class="text-white px-3 py-4 p-md-5 mx-md-4">
							<img style="opacity: 0.4;" class="img-fluid" src="https://sostegno20.it/wp-content/uploads/2022/05/bambini-geografia-cartina-muta-italia.jpg">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="text-body-secondary py-5">
		<div class="container">
			<p class="mb-0">
				<%@ include file="foother.html"%>
			</p>
		</div>
	</footer>
</body>
</html>