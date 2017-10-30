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
        
           <sf:form method="post" modelAttribute="form">

            <div class="row">
                <div class="col-sm-12">
                    <h2 class="page-header derecha">Rutas
                    <a href="rutaForm" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Nueva</a>
                    </h2>
                </div>                                
           </div> 
           
			<table id='tablaRutas' class='table table-hover table-striped table-condensed table-bordered'>

				<c:choose>
				    <c:when test="${param.success eq true}">
				        <div class="alert alert-success">Cambios realizados correctamente.</div>
				    </c:when>			    
				</c:choose>	
							
				<thead>
					<tr class="info">	
						<th width="8%">Check</th>					
						<th width="45%">Compañía / Entregas</th>
						<th width="15%">Tipo transporte</th>
						<th width="8%">Docum.</th>
						<th width="8%">Salida</th>
						<th width="8%">Editar</th>
						<th width="8%">Eliminar</th>
					</tr>
				</thead>

				<c:forEach items="${listaRutas}" var="c" varStatus="index">
			
					<tr>
						
						<td><sf:checkbox path="mapa[${c.id}]"  value="mapa[${c.id}]"/></td>
						<td><a class="accordion-toggle" data-toggle="collapse" data-target='#${c.id}'>${c.companiaTransporte.toStringCodigoNombre()}</a>
						
							<div class="accordion-body collapse" id="${c.id}">
							
								<br>
								
								<table class='table table-striped table-condensed table-bordered' style="width: 98%; margin: 1%;">
						
									<tr>
										<th class="col-sm-3 success">Llegada</th>
										<th class="col-sm-6 success">Destino</th>
										<th class="col-sm-3 success">Importe</th>													
									</tr>
									
									<c:forEach items="${listaEntregas}" var="e" varStatus="index">
										
										<c:if test="${e.ruta.id eq c.id}">
											
											<tr>
												<td>${e.getEntr_horaLlegadaFormateada()}</td>
												<td>${e.destino.dest_destinatario}</td>
												<td class="text-right">${e.entr_importe}</td>							
											</tr>
											
										</c:if>
									
									</c:forEach>
								
								</table>
		
							</div>						
						
						</td>	
						
						<td>${c.tipoTransporte.titr_nombre}</td>
						<td>${c.getRuta_horaDocumentacionFormateada()}</td>
						<td>${c.getRuta_horaSalidaFormateada()}</td>
						<td class="text-center"><a href="rutaForm?idRuta=${c.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td class="text-center"><a href="#" onclick="eliminar(${c.id},'ruta');" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
								
					</tr>
							
				</c:forEach>
			
			</table>
			
			<input type="submit" class="btn btn-primary" id="btnGenerarCartasPortePendientes" name="GenerarCartasPortePendientes" value="Generar cartas porte pendientes">
			    
			<br> 
			            
			</sf:form>
			
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
		
		$('#tablaRutas').DataTable({
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