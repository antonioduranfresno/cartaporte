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
                    <h2 class="page-header derecha">
						Cartas de porte emitidas	
					</h2>
                </div>                                
           </div> 
           
           <input type="hidden" id="listaIds" name="listaIds" value="${listaIds}" />
           
		   <table id='tablaCartas' class='table table-hover table-striped table-condensed table-bordered'>

				<c:choose>
				    <c:when test="${param.success eq true}">
				        <div class="alert alert-success">Cambios realizados correctamente.</div>
				    </c:when>
				</c:choose>	
							
				<thead>
                    <tr class="info">  
                          <th width="13%">Nº Carta</th>
                          <th width="13%">Fecha Doc.</th>
                          <th width="23%">Destino</th>
                          <th width="23%">Proveedor</th>
                          <th width="12%">T. Transporte</th>
                          <th width="10%">Porte</th>
                          <th width="6%">Ver</th>                                 
                    </tr>
				</thead>
				
				<c:forEach items="${listaCartasEmitidas}" var="c" varStatus="index">
				
					<tr>						
						<td>${c.capo_numeroCarta}</td>
						<td>${c.getCapo_fechaHoraDocumentacionFormateada()}</td>
						<td>${c.capo_destinatario}</td>
						<td>${c.capo_razonSocialCompania}</td>
						<td>${c.tipoTransporte.titr_nombre}</td>
						<td class="text-right">${c.capo_importe}</td>						
						<td class="text-center">							
							<a href="<c:url value="/cartaPorteForm&id=${c.id}/informe" />" class="btn btn-default">
								<span class="glyphicon glyphicon-file"></span>
							</a>
						</td>												
					</tr>
				
				</c:forEach>

		   </table>
			    
                        
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
		
		if($("#listaIds").val()!=""){
			
			var array = $("#listaIds").val().split(",");
			
			for (var i = 0; i < array.length; i++) {				
				window.open("cartaPorteForm&id="+array[i]+"/informe");				
			}			
		}
		
		cargaDatos();
		
	});	
	
	function cargaDatos(){
		
		waitingDialog.show('Un momento, por favor...');
		
		$('#tablaCartas').DataTable({ 										
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