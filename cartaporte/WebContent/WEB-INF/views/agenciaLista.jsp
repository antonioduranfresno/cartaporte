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
                <div class="col-sm-12">
                    <h2 class="page-header">Agencias</h2>
                </div>                                
           </div> 
           
			<table id='tablaAgencias' class='table table-hover table-striped table-condensed table-bordered'>
			
				<thead>
					<tr class="info">
						<th width="8%">Código</th>
						<th width="17%">Nombre</th>						
						<th width="12%">C/ Origen</th>
						<th width="12%">C/ Destino</th>
						<th width="16%">C/ Transportista</th>
						<th width="14%">C/ Factura</th>
						<th width="7%">M.D.</th>
						<th width="7%">Editar</th>
						<th width="7%">Borrar</th>
					</tr>
				</thead>

				<c:choose>
				    <c:when test="${param.success eq true}">
				        <div class="alert alert-success">Cambios realizados correctamente.</div>
				    </c:when>
				</c:choose>	
				
				<c:set var="agenciaUsuario" value="${usuario.getAgencia().getAgen_codigo()}"/>
							
				<c:forEach items="${listaAgencias}" var="t" varStatus="index">
			
					<c:set var="agenciaLista" value="${t.agen_codigo}"/>
					
					<c:if test="${agenciaUsuario == agenciaLista}">		
						<tr>
							<td>${t.agen_codigo}</td>
							<td>${t.agen_nombre}</td>						
							<td>${t.agen_copiaOrigen ? 'Sí' : 'No'}</td>
							<td>${t.agen_copiaDestino ? 'Sí' : 'No'}</td>
							<td>${t.agen_copiaTransportista ? 'Sí' : 'No'}</td>
							<td>${t.agen_copiaFactura ? 'Sí' : 'No'}</td>
							<td>${t.agen_mediosDurables ? 'Sí' : 'No'}</td>
							<td style="text-align: center;"><a href="agenciaForm?idAgencia=${t.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td style="text-align: center;"><a href="#" onclick="eliminar(${t.id},'agencia');" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:if>
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