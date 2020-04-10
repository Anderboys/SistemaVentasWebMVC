<!--   Para trabajar con   ->  c:forEach  <-   -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<title>Cliente</title>
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
                        <form action="Controlador?menu=Cliente" method="POST">
                            <div class="form-group">
                                <label>Dni</label>
                                <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" value="${cliente.getNom()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Direccion</label>
                                <input type="text" value="${cliente.getDirec()}" name="txtTel" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                            </div>                        
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
<!--                         <table class="table table-hover table-responsive"> -->
                        <table class="footable table table-condensed table-hover"  data-page-size="20" data-filter="#filter" >
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>DNI</th>
                                    <th>NOMBRES</th>
                                    <th>DIRECCION</th>
                                    <th>ESTADO</th>                                   
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="cli" items="${clientes}">
                                    <tr>
                                        <td>${cli.getId()}</td>
                                        <td>${cli.getDni()}</td>
                                        <td>${cli.getNom()}</td>
                                        <td>${cli.getDirec()}</td>
                                        <td>${cli.getEstado()}</td>                                        
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cli.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cli.getId()}">Delete</a>
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
                </div>
            </div>
        </div>  
        
        	<!-- FUNCION DE FOOTABLE -->          
            <script lang="javascript">           
             $(function(){
               $('.footable').footable();
              });                         
             </script>  			
            <!---------------------> 
            
<!--         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<!--         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> -->
<!--         <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> -->
</body>
</html>