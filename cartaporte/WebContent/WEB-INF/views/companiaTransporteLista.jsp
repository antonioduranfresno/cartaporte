<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="facturas" content="">
    <meta name="Antonio Durán" content="">
    <link rel="icon" href="res/img/ico/favicon.ico" type="image/x-icon" />
    
    <title>CARTAS DE PORTE - Gefco España S.A.</title>

    <link rel="stylesheet" href="res/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="res/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="res/css/sb-admin-2.min.css"/>      
    <link rel="stylesheet" href="res/css/metisMenu.min.css"/>
    <link rel="stylesheet" href="res/css/estilos.css"/>
    <link rel="stylesheet" href="res/css/dataTables.bootstrap.min.css"/>

  </head>

<body>

    <div id="wrapper">

		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
        
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Compañías Transporte</h2>
                </div>                                
           </div> 
           
			<table id='tablaCompaniasTransporte' class='table table-hover table-striped table-condensed table-bordered'>
			
				<thead>
					<tr class="info">
						<th class="col-sm-1">Código</th>
						<th class="col-sm-3">Razón Social</th>
						<th class="col-sm-6">Domicilio</th>
						<th class="col-sm-1">Editar</th>
						<th class="col-sm-1">Eliminar</th>
					</tr>
				</thead>

				<c:choose>
				    <c:when test="${param.success eq true}">
				        <div class="alert alert-success">Cambios realizados correctamente.</div>
				    </c:when>
				</c:choose>	
							
				<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
			
					<tr>
						<td>${c.cotr_codigo}</td>
						<td>${c.cotr_razon_social}</td>
						<td>${c.cotr_domicilio}</td>
						<td style="text-align: center;"><a href="companiaTransporteForm?idCompania=${c.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td style="text-align: center;"><a href="#" onclick="eliminar(${c.id},'companiaTransporte');" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
			
				</c:forEach>
			
			</table>
			
			<br>
			
			<a href="companiaTransporteForm" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Nuevo</a>
			            
        </div>
    </div>

    <script type="text/javascript" src='<c:url value="/res/js/jquery-1.10.2.js" />' ></script>
	<script type="text/javascript" src='<c:url value="/res/js/bootstrap.min.js" />' ></script>    
	<script type="text/javascript" src='<c:url value="/res/js/sb-admin-2.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/metisMenu.min.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/jquery.dataTables.js" />'></script>
	<script type="text/javascript" src='<c:url value="/res/js/dataTables.bootstrap.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/maestro.js" />'></script>
    
    <script type="text/javascript">
    
	$(document).ready(function() {
		
		cargaDatos();
		
	});	
	
	function cargaDatos(){
		
		waitingDialog.show('Un momento, por favor...');
		
		$('#tablaCompaniasTransporte').DataTable({ 										
	    	"language": {
	    		"url": "res/json/es.json"
	        },
	    	"pageLength": 20,
	    	"initComplete": waitingDialog.hide()			 		    	
	    });		
			
	}
	
    </script>
    
</body>

</html>