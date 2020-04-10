<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body background="http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg">

	<div class="container mt-4 col-lg-4">
		<div class="card col-sm-10">
			<div class="card-body">
			
			
				<form class="form-sign" action="Validar" method="POST">
				
					<div class="form-group text-center">
						<h3>Login</h3>
						<img src="img/logo.jpg" alt="70" width="170" />
						 <label>Bienvenidos al Sistema</label>
					</div>
					
					<div class="form-group">
						<label>Usuario:</label> <input type="text" name="txtuser"  required=""  value="ander" class="form-control">
							
					</div>
					
					<div class="form-group">
						<label>Password:</label> <input type="password" name="txtpass" required="" value="45089145" class="form-control">
							
					</div>				
					
<!-- 					<input type="submit" name="accion" value="Ingresar" -->
<!-- 						class="btn btn-primary btn-block"> -->						
					<button  name="accion" value="Ingresar" class="btn btn-primary btn-block">Ingresar</button>
						
				</form>
			</div>
		</div>
	</div>


</body>
</html>