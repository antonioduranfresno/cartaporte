<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
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
                    <h2 class="page-header">Agencias</h2>
                </div>                                
           </div> 
           
			<table id='tablaAgencias' class='table table-hover table-striped table-condensed table-bordered'>
			
				<thead>
					<tr class="info">
						<th class="col-sm-1">Código</th>
						<th class="col-sm-2">Nombre</th>
						<th class="col-sm-1">UO</th>
						<th class="col-sm-1">Contacto</th>
						<th class="col-sm-1">Teléfono</th>
						<th class="col-sm-1">Copia Origen</th>
						<th class="col-sm-1">Copia Destino</th>
						<th class="col-sm-1">Copia Transportista</th>
						<th class="col-sm-1">Copia Factura</th>
						<th class="col-sm-1">Editar</th>
						<th class="col-sm-1">Eliminar</th>
					</tr>
				</thead>

				<c:choose>
				    <c:when test="${param.success eq true}">
				        <div class="alert alert-success">Cambios realizados correctamente.</div>
				    </c:when>
				</c:choose>	
							
				<c:forEach items="${listaAgencias}" var="t" varStatus="index">
			
					<tr>
						<td>${t.agen_codigo}</td>
						<td>${t.agen_nombre}</td>
						<td>${t.uo.uo_nombre}</td>
						<td>${t.agen_contacto}</td>
						<td>${t.agen_telefonoContacto}</td>
						<td>${t.agen_copiaOrigen ? 'Sí' : 'No'}</td>
						<td>${t.agen_copiaDestino ? 'Sí' : 'No'}</td>
						<td>${t.agen_copiaTransportista ? 'Sí' : 'No'}</td>
						<td>${t.agen_copiaFactura ? 'Sí' : 'No'}</td>
						
						<td style="text-align: center;"><a href="agenciaForm?idAgencia=${t.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td style="text-align: center;"><a href="#" onclick="eliminar(${t.id},'agencia');" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
			
				</c:forEach>
			
			</table>
			
			<br>
			
			<a href="agenciaForm" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Nueva</a>
			            
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
		
		$('#tablaAgencias').DataTable({ 										
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