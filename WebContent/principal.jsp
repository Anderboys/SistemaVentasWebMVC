<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Principal</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-info">

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
<!--       <li class="nav-item active"> -->
<!--         <a style="margin-left:10px ; border:none" class="btn btn-outline-light" href="Controlador?menu=Home&accion=Listar" target="myFrame">Home </a> -->
<!--       </li> -->
      <li class="nav-item">
        <a style="margin-left:10px ; border:none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar"target="myFrame">Producto</a>
      </li>
      <li class="nav-item">
        <a style="margin-left:10px ; border:none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
        																			  
      </li>
       <li class="nav-item">
        <a style="margin-left:10px ; border:none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
      </li>
       <li class="nav-item">
        <a style="margin-left:10px ; border:none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=Listar" target="myFrame">Nueva Venta</a>
      </li>     
    </ul> 
    
      
         
  </div>
  
	  	<div class="dropdown">
			  <button style= border:none class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	<!-- 		   // Obtener datos Attribute = usuario + objeto = emp -->
			    ${usuario.getNom()}
			  </button>
			  <div class="dropdown-menu text-center" >
			    <a class="dropdown-item" href="#">
			 	   <img src="img/user.png" alt="60" width="60" />		 	   
			    </a> 
			    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
			    <a class="dropdown-item" href="#">usuario@gmail.com</a>
			    <div class="dropdown-divider"></div>
			    			    
			    <form action="Validar" method ="POST">
			     <button  name="accion" value="Salir" class="dropdown-item" href="#">salir</button>
			    </form>  
			   
			  </div>
		</div>	
	</nav>

	 <div class="embed-responsives m-4" style="height: 530px;">
             <iframe  name="myFrame"  style="height: 100%; width: 100%; border:none "></iframe>
     </div>




<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>