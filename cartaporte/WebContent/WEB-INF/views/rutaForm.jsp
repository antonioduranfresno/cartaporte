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
    <link rel="stylesheet" href="res/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="res/css/estilos.css"/>
    
    <style type="text/css">
    
    .datetimepicker thead tr{
		visibility: hidden;	
	}
    
    </style>

  </head>

<body>

    <div id="wrapper">

		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
        
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Ruta</h2>
                </div>                                
           </div> 
           
           <sf:form id="formRuta" method="post" modelAttribute="ruta" >
					
				<sf:input type="hidden" path="id" id="id" value="${ruta.id}" />
				<sf:input type="hidden" path="agencia.id" value="${ruta.agencia.id}" />
							
				<div class="row">
					<div class="col-lg-12">
						<label>Compañía Transporte</label>
						<sf:errors path="companiaTransporte.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selCompania" path="companiaTransporte.id" value="${ruta.companiaTransporte.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == ruta.companiaTransporte.id ? 'selected' : '' }>${c.toStringCodigoNombre()}</option>
			        		</c:forEach>
						</sf:select>
					</div>				
				</div>
				
				<br>
			
				<div class="row">
					<div class="col-lg-6">
						<label>Tipo Transporte</label>
						<sf:errors path="tipoTransporte.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selTipoTransporte" path="tipoTransporte.id" value="${ruta.tipoTransporte.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaTiposTransporte}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == ruta.tipoTransporte.id ? 'selected' : '' }>${c.titr_nombre}</option>
			        		</c:forEach>
						</sf:select>
					</div>
					<div class="col-lg-3 date">
			        	<label>Hora Documentación</label>
						<sf:errors path="ruta_horaDocumentacion" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divHoraDocumentacion'>
		                    <sf:input class="form-control" id="ruta_horaDocumentacion" path="ruta_horaDocumentacion" value="${ruta.ruta_horaDocumentacion}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-time"></span>									      
							</span>									
	            		</div>	            		
			    	</div>	        	
					<div class="col-lg-3 date">
			        	<label>Hora Salida</label>
						<sf:errors path="ruta_horaSalida" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divHoraSalida'>							
		                    <sf:input class="form-control" id="ruta_horaSalida" path="ruta_horaSalida" value="${ruta.ruta_horaSalida}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-time"></span>									      
							</span>									
	            		</div>	            		
			    	</div>	 	        	
				</div>
				
				<br>
				
				<div class="footer">      
				
					<div class="col-sm-10 derecha">			      		
			    		<input type="button" class="btn btn-danger" id="btnEliminar" value="Eliminar" onclick='eliminar($("#id").val(),"ruta");'>
			      	</div>      	
				 	<div class="col-sm-2 derecha">			      		
			      		<input type="submit" class="btn btn-primary" id="btnAceptar" name="action" value="Aceptar" >
			      	</div>      	
			      	
			    </div>				
					
		   </sf:form>
		   
		   <sf:form id="formEntrega" method="post" modelAttribute="entrega" >
		   
			   <div class="row">
	                <div class="col-lg-12">
	                    <h2 class="page-header">Entregas</h2>
	                </div>                                
	           </div>
		   
		   		<sf:input type="hidden" path="id" value="${entrega.id}" />
				<sf:input type="hidden" path="ruta.id" value="${ruta.id}" />
		   
				<div class="row">
					<div class="col-lg-6">
						<label>Destino</label>
						<sf:errors path="destino.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selDestino" path="destino.id" value="${entrega.destino.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaDestinos}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == entrega.destino.id ? 'selected' : '' }>${c.dest_destinatario}</option>
			        		</c:forEach>
						</sf:select>
					</div>
					<div class="col-lg-3 date">
			        	<label>Hora Llegada</label>
						<sf:errors path="entr_horaLlegada" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divHoraLlegada'>							
		                    <sf:input class="form-control" id="entr_horaLlegada" path="entr_horaLlegada" value="${entrega.entr_horaLlegada}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-time"></span>									      
							</span>									
	            		</div>	            		
			    	</div>
		        	<div class="col-lg-3">
		        		<label>Importe</label>
		        		<sf:errors path="entr_importe" class="label label-danger"></sf:errors>
		        		<sf:input  path="entr_importe" class="form-control text-right" value="${entrega.entr_importe}" />		        		
		        	</div>			
				</div>	
			
				<div class="footer">      
				
				 	<div class="col-sm-12 derecha">			      		
			      		<input type="submit" class="btn btn-primary" name="entrega" value="Aceptar" >
			      	</div>      	
			      	
			    </div>		
			    
			    <table id='tablaEntregas' class='table table-hover table-striped table-condensed table-bordered'>
			
					<thead>
						<tr class="info">							
							<th class="col-sm-2">Hora Llegada</th>
							<th class="col-sm-6">Destino</th>
							<th class="col-sm-2">Importe</th>
							<th class="col-sm-2">Eliminar</th>
						</tr>
					</thead>
								
					<c:forEach items="${listaEntregas}" var="c" varStatus="index">
				
						<tr>
							<td>${c.getEntr_horaLlegadaFormateada()}</td>
							<td>${c.destino.dest_destinatario}</td>
							<td class="text-right">${c.entr_importe}</td>						
							<td class="text-center"><a href="#" onclick="eliminarEntrega(${c.id});" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
				
					</c:forEach>
			
				</table>
			
			</sf:form>
			
		</div>
		      
    </div>

    <script type="text/javascript" src='<c:url value="/res/js/jquery-1.10.2.js" />' ></script>
	<script type="text/javascript" src='<c:url value="/res/js/bootstrap.min.js" />' ></script>    
	<script type="text/javascript" src='<c:url value="/res/js/sb-admin-2.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/metisMenu.min.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/bootstrap-datetimepicker.min.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/locales/bootstrap-datetimepicker.es.js" />'></script>    
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/maestro.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/ruta.js" />'></script>
     
</body>

</html>