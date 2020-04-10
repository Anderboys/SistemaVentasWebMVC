
<!--   Para trabajar con   ->  c:forEach  <-   -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
		
		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<!--  CDN Boostrap  -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">	 -->
		
 	     <!-- Bootstrap core CSS -->
  		<link href="twitter-bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<!--         <link href="css/miestilo.css" rel="stylesheet" type="text/css"/>         -->
        <link href="css/plugins/footable/footable.core.css" rel="stylesheet" type="text/css"/>
                
        <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="twitter-bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="js/plugins/footable/footable.all.min.js" type="text/javascript"></script>
	
<title>Empleado</title>
</head>
<body>

 	<!--  FILTRO  DE BUSQUEDA --> 
     <form class="navbar-form navbar-right">
                <div class="input-group">
             <input type="text" placeholder="Buscar" class="input-sm form-control" id="filter">
             
             <span class="input-group-btn">
                 <button type="button" class="btn btn-sm btn-primary">
                     <i class="glyphicon glyphicon-search"></i>                         
                     Buscar
                 </button>
             </span>
          </div>
      </form> 
      <!------------------------->   

	<div class="d-flex">
		<div class="col-sm-4">
			<div class="card">
				<div class="card-body">
					<form action="Controlador?menu=Empleado" method="POST">
						<div class="form-group">
							<label>Dni</label> 
							<input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
						</div>
						<div class="form-group">
							<label>Nombres</label> 
							<input type="text" value="${empleado.getNom()}"	name="txtNombre" class="form-control">
						</div>
						<div class="form-group">
							<label>Telefono</label> 
							<input type="text" value="${empleado.getTel()}" name="txtTel" class="form-control">
						</div>
						<div class="form-group">
							<label>Estado</label> 
							<input type="text" value="${empleado.getEstado()}"	name="txtEstado" class="form-control">
						</div>
						<div class="form-group">
							<label>Usuario</label> 
							<input type="text" value="${empleado.getUser()}" name="txtUser"	class="form-control">
						</div>
<!-- 						<button name="accion" value="Agregar" class="btn btn-primary">Agregar</button>							 -->
<!-- 						<button name="accion" value="Editar" class="btn btn-info">Actualizar</button> -->
						
					  <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                       <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
						
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			
<!-- 			<div class="card-body"> -->

			 <div class="table-responsive">
			<table class="footable table table-striped table-hover" data-page-size="10" data-filter="#filter">
<!-- 		<table class="table table-hover"> -->
					<thead>
						<tr>
							<th>ID</th>
							<th>DNI</th>
							<th>NOMBRES</th>
							<th>TELEFONO</th>
							<th>ESTADO</th>
							<th>USER</th>
							<th>ACCIONES</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="em" items="${empleados}">
							<tr>
								<td>${em.getId()}</td>
								<td>${em.getDni()}</td>
								<td>${em.getNom()}</td>
								<td>${em.getTel()}</td>
								<td>${em.getEstado()}</td>
								<td>${em.getUser()}</td>
								<td><a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}" >Editar</a>
									<a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
					
					   <!-- CODIGO DE PAGINACION --> 
		            <tfoot>
		                <tr>
		                    <td colspan="10">
		                        <ul class="pagination pull-right"></ul>
		                    </td>
		                </tr>                
		            </tfoot>
		            <!---------------------------> 
					
				</table>
			</div>
			<!-- 			</div> -->
		</div>
	</div>

 			<!-- FUNCION DE FOOTABLE -->          
            <script lang="javascript">           
             $(function(){
               $('.footable').footable();
              });                         
             </script>  			
            <!---------------------> 
         


</body>
</html>