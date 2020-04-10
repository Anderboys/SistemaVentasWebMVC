<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/styleformal.css">
<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>


</head>
<body>

	<img class="wave" src="img/wave.png">
	<div class="container">
		<div class="img">
			<img src="img/bg.svg">
		</div>
		<div class="login-content">
		
			<form class="form-sign" action="Validar" method="POST" >
			
				<img src="img/avatar.svg">
				<h2 class="title">Welcome</h2>
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>Username</h5>
						<input type="text" class="input" name="txtuser" required="">
					</div>
				</div>
				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>Password</h5>
						<input type="password" class="input" name="txtpass" required="" >
					</div>
				</div>
				<a href="#">Forgot Password?</a>
<!-- 				 <input name="accion" type="submit" class="btn" value="Ingresar"> -->
				 <button  name="accion" value="Ingresar" class="btn">Ingresar</button>
			</form>
			
			
		</div>
	</div>
	<script type="text/javascript" src="js/mainformal.js"></script>

</body>
</html>