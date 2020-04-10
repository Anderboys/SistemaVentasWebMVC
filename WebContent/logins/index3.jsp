<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<meta charset="utf-8">
<title>Insert title here</title>

 <%--------  CSS LOGIN -------------%>
         <link rel="stylesheet" href="css/stylelogin2.css"/>
		<script src="https://kit.fontawesome.com/a81368914c.js"></script>
         
</head>

 		<body background="http://wallpaperget.com/images/4k-dark-wallpaper-21.jpg">
<!--  	<body background="http://wallpaperget.com/images/4k-dark-wallpaper-8.jpg"> -->
		
			<div class="login-box">
<!-- 				<form class="form-sign" action="Validar" method="POST"> -->
					<form>								
						<h1>Login</h1>								
					
					<div class="textbox">
						<i class="fas fa-user" aria-hidden="true"></i>
<!-- 					<i class="glyphicon glyphicon-user"></i> -->
<!-- 						 <input type="text" placeholder="Username" name="txtuser"  required=""  value="" > -->
						 <input type="text" placeholder="Username"   required=""   >
					</div>
					
					<div class="textbox">
						<i class="fas fa-lock" aria-hidden="true"></i>
<!-- 					<i class="glyphicon glyphicon-lock"></i> -->
<!-- 						<input type="password" placeholder="Password" name="txtpass" required="" value="" > -->
						<input type="password" placeholder="Password" required=""  >
						 	
					</div>				
										
					<input class="btn" type="button"  name="accion" value="Sign In" >
					</form>	
					
			</div>
		
		
</body>
</html>
