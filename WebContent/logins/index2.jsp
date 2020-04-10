<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

    <%--------  CSS LOGIN -------------%>
         <link rel="stylesheet" href="css/stylelogin.css"/>

</head>
<body>

	<div class="box">
<!-- 				<form class="form-sign" action="Validar" method="POST"> -->
					<form >			
						<h2>Login</h2>				
					
					<div class="inputBox">
						 <input type="text" name="txtuser"  required=""  value="" >
						 <label>Usuario:</label>
					</div>
					
					<div class="inputBox">
						 <input type="password" name="txtpass" required="" value="" >
						 <label>Password:</label>	
					</div>				
										
					<input type="submit"  name="accion" value="Ingresar" >
						
				</form>
			</div>

</body>
</html>