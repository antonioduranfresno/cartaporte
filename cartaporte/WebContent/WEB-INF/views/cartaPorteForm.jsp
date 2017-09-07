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

  </head>

<body>

    <div id="wrapper">

		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
        
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Carta de Porte</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="cartaPorte" >
					
				<sf:input type="hidden" path="id" value="${cartaPorte.id}" />
				<sf:input type="hidden" path="agencia.id" value="${cartaPorte.agencia.id}" />
				<sf:input type="hidden" path="tipoTransporte.id" value="${cartaPorte.tipoTransporte.id}" />

			   	<div class="row">
		        	<div class="col-lg-4">
		        		<label>Precinto</label>
		        		<sf:errors path="capo_precinto" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_precinto" value="${cartaPorte.capo_precinto}" maxlength="45" />		        		
		        	</div>
					<div class="col-lg-4">
		        		<label>Nº Carta</label>		        		
		        		<sf:input class="form-control" id="capo_numeroCarta" path="capo_numeroCarta" value="${cartaPorte.capo_numeroCarta}" />
		        	</div>	
		        	<div class="col-lg-4 date">
			        	<label>Fecha Documentación</label>
						<sf:errors path="capo_fechaDocumentacion" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divFechaDocumentacion'>							
		                    <sf:input class="form-control" id="capo_fechaDocumentacion" path="capo_fechaDocumentacion" value="${cartaPorte.getCapo_fechaHoraDocumentacionFormateada()}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>									      
							</span>									
	            		</div>	            		
			    	</div>	        	
				</div>
				
				<br>
				
				<div class="row">
		        	<div class="col-lg-4">
		        		<label>Companía de transportes</label>
		        		<sf:errors path="capo_razonSocialCompania" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" id="capo_razonSocialCompania" path="capo_razonSocialCompania" value="${cartaPorte.capo_razonSocialCompania}" />		        		
		        	</div>
					<div class="col-lg-8">
		        		<label>Domicilio social</label>		        		
		        		<sf:errors path="capo_domicilioCompania" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" id="capo_domicilioCompania" path="capo_domicilioCompania" value="${cartaPorte.capo_domicilioCompania}" />
		        	</div>	
		        	<sf:input type="hidden" path="capo_cifCompania" value="${cartaPorte.capo_cifCompania}" />
		        	   	
				</div>
				
				<div class="row">
		        	<div class="col-lg-4">
		        		<label>Transportista efectivo</label>
		        		<sf:errors path="companiaTransporte.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selCompaniaTransporte" path="companiaTransporte.id" value="${cartaPorte.companiaTransporte.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == cartaPorte.companiaTransporte.id ? 'selected' : '' }>${c.cotr_razonSocial}</option>
			        		</c:forEach>
						</sf:select>		        		
		        	</div>
					<div class="col-lg-8">
		        		<label>Domicilio social</label>		        		
		        		<sf:errors path="capo_domicilioCompaniaEfectiva" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_domicilioCompaniaEfectiva" value="${cartaPorte.capo_domicilioCompaniaEfectiva}" maxlength="255" />
		        	</div>
		        	<sf:input type="hidden" path="capo_razonSocialCompaniaEfectiva" value="${cartaPorte.capo_razonSocialCompaniaEfectiva}" />
		        	<sf:input type="hidden" path="capo_cifCompaniaEfectiva" value="${cartaPorte.capo_cifCompaniaEfectiva}" />
				</div>	
				
				<br>	
				
				<div class="row">
					<div class="col-lg-3">
						<label>Conductor</label>
						<sf:errors path="conductor.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selConductor" path="conductor.id" value="${cartaPorte.conductor.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaConductores}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == cartaPorte.conductor.id ? 'selected' : '' }>${c.cond_nombre}</option>
			        		</c:forEach>
						</sf:select>
					</div>
					<div class="col-lg-3">
		        		<label>Carnet de conducir</label>
		        		<sf:input class="form-control" id="carneConducir" path="conductor.cond_carne" value="${cartaPorte.conductor.cond_carne}" />		        		
		        	</div>
		        	<div class="col-lg-3">
		        		<label>Expedido</label>		        		
		        		<sf:input class="form-control" id="fechaExpedicion" path="conductor.cond_fechaExpedicion" value="${cartaPorte.conductor.getCond_fechaExpedicionFormateada()}" />
		        	</div>
		          	<div class="col-lg-3">
		        		<label>Teléfono vehículo</label>
		        		<sf:errors path="capo_telefonoConductor" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" id="telefonoConductor" path="capo_telefonoConductor" value="${cartaPorte.capo_telefonoConductor}" maxlength="15" />
		        	</div>
				</div>
				
				<br>
								
				<div class="row">
					<div class="col-lg-3">
						<label>Matrícula tractora</label>
						<sf:errors path="capo_matriculaTractora" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selCamionTractor" path="capo_matriculaTractora" value="${cartaPorte.capo_matriculaTractora}">
							<option value="0">Selección</option>
							<c:forEach items="${listaCamionesTractores}" var="c" varStatus="index">
			        			<option value="${c.cami_matricula}" ${c.cami_matricula == cartaPorte.capo_matriculaTractora ? 'selected' : '' }>${c.cami_matricula}</option>
			        		</c:forEach>
						</sf:select>
					</div>
					<div class="col-lg-3">
						<label>Remolque/Semiremolque</label>
						<sf:errors path="capo_matriculaRemolque" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selCamionNoTractor" path="capo_matriculaRemolque" value="${cartaPorte.capo_matriculaRemolque}">
							<option value="0">Selección</option>
							<c:forEach items="${listaCamionesNoTractores}" var="c" varStatus="index">
			        			<option value="${c.cami_matricula}" ${c.cami_matricula == cartaPorte.capo_matriculaRemolque ? 'selected' : '' }>${c.cami_matricula}</option>
			        		</c:forEach>
						</sf:select>
					</div>				
					<div class="col-lg-3">
		        		<label>Origen</label>
		        		<sf:input class="form-control" id="origen" path="agencia.agen_nombre" value="${cartaPorte.agencia.agen_nombre}" />
		        	</div>
		      		<div class="col-lg-3">
		        		<label>Destino</label>
		        		<sf:errors path="capo_provincia" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_provincia" value="${cartaPorte.capo_provincia}" maxlength="255" />
		        	</div>
				</div>

				<br>
				
				<div class="row">
					<div class="col-lg-4">
		        		<label>Destinatario</label>
		        		<sf:errors path="capo_destinatario" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_destinatario" value="${cartaPorte.capo_destinatario}" maxlength="255" />		        		
		        	</div>
		      		<div class="col-lg-8">
		        		<label>Domicilio social</label>
		        		<sf:errors path="capo_direccion" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_direccion" value="${cartaPorte.capo_direccion}" maxlength="255" />
		        	</div>
				</div>
				
				<br>	
				
				<div class="row">
					<div class="col-lg-2">
		        		<label>Peso mercancía</label>
						<sf:errors path="capo_pesoMercancia" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control text-right" path="capo_pesoMercancia" value="${cartaPorte.capo_pesoMercancia}" />
		        	</div>
		      		<div class="col-lg-2">
		        		<label>Nº albarán</label>
		        		<sf:errors path="capo_numeroAlbaran" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_numeroAlbaran" value="${cartaPorte.capo_numeroAlbaran}" />
		        	</div>
		        	<div class="col-lg-3 date">
			        	<label>Fecha Salida</label>
						<sf:errors path="capo_fechaSalida" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divFechaSalida'>							
		                    <sf:input class="form-control" id="capo_fechaSalida" path="capo_fechaSalida" value="${cartaPorte.getCapo_fechaHoraSalidaFormateada()}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>									      
							</span>									
	            		</div>	            		
			    	</div>
			    	<div class="col-lg-3 date">
			        	<label>Fecha Llegada</label>
						<sf:errors path="capo_fechaLlegada" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divFechaLlegada'>							
		                    <sf:input class="form-control" id="capo_fechaLlegada" path="capo_fechaLlegada" value="${cartaPorte.getCapo_fechaHoraLlegadaFormateada()}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>									      
							</span>									
	            		</div>	            		
			    	</div>
			    	<div class="col-lg-2">
		        		<label>Arrastre</label>
						<sf:errors path="capo_importe" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control text-right" path="capo_importe" value="${cartaPorte.capo_importe}" />
		        	</div>
				</div>		
				
				<br>
				
				<div class="row">
					<div class="col-lg-8">
		        		<label>Contacto</label>
		        		<sf:errors path="capo_contactoAgencia" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_contactoAgencia" value="${cartaPorte.capo_contactoAgencia}" maxlength="255" />		        		
		        	</div>
		      		<div class="col-lg-4">
		        		<label>Teléfono</label>
		        		<sf:errors path="capo_telefonoContacto" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="capo_telefonoContacto" value="${cartaPorte.capo_telefonoContacto}" maxlength="15" />
		        	</div>
				</div>
				
				<sf:input type="hidden" path="capo_secuenciaRuta" value="${cartaPorte.capo_secuenciaRuta}" />
				
				<br>	
				
				<div class="footer">      
				  	      		
					<div class="col-sm-8 derecha">		
			    		<input type="submit" class="btn btn-primary" name="informe" value="Informe" >
			      	</div>
			    
					<div class="col-sm-2 derecha">			      		
			    		<input type="button" class="btn btn-danger" value="Eliminar" onclick='eliminar($("#id").val(),"cartaPortePendiente");'>
			      	</div>      	
				 	<div class="col-sm-2 derecha">			      		
			      		<input type="submit" class="btn btn-primary" name="action" value="Aceptar" >
			      	</div>      	
			      	
			    </div>				
					
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
    <script type="text/javascript" src='<c:url value="/res/js/cartaPorte.js" />'></script>
         
</body>

</html>