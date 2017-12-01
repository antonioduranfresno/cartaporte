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
                <div class="col-sm-12">
                    <h2 class="page-header">Conductor</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="conductor" >
					
				<sf:input type="hidden" path="id" value="${conductor.id}" />
			
				<div class="row">
		      		<div class="col-sm-8">
                  		<label>Compañía Transporte</label>
                  		<sf:errors path="companiaTransporte.id" class="label label-danger"></sf:errors>
                  		<sf:select class="form-control" id="selCompania" path="companiaTransporte.id" value="${conductor.companiaTransporte.id}">
                       		<option value="0">Selección</option>
                          	<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
                          		<option value="${c.id}" ${c.id == conductor.companiaTransporte.id ? 'selected' : '' }>${c.cotr_razonSocial}</option>
                   			</c:forEach>
                   		</sf:select>
		        	</div>                     
		      	</div>
		      	
		      	<br>

				<div class="row">
		        	<div class="col-sm-5">
		        		<label>Carnet de conducir</label>
		        		<sf:errors path="cond_carne" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_carne" class="form-control" value="${conductor.cond_carne}" maxlength="15" />		        		
		        	</div>
		        	<div class="col-sm-3 date">
			        	<label>Fecha Expedición</label>
						<sf:errors path="cond_fechaExpedicion" class="label label-danger"></sf:errors>
						<div class='input-group date' id='divFechaExpedicion'>							
		                    <sf:input class="form-control" id="cond_fechaExpedicion" path="cond_fechaExpedicion" value="${conductor.getCond_fechaExpedicionFormateada()}" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>									      
							</span>									
	            		</div>	            		
			    	</div>
				</div>
				
				<br>
				
				<div class="row">
		        	<div class="col-sm-5">
		        		<label>Nombre</label>
		        		<sf:errors path="cond_nombre" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_nombre" class="form-control" value="${conductor.cond_nombre}" maxlength="45" />		        		
		        	</div>			
		        	<div class="col-sm-3">
		        		<label>Teléfono</label>
		        		<sf:errors path="cond_telefono" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_telefono" class="form-control" value="${conductor.cond_telefono}" maxlength="45" />		        		
		        	</div>
				</div>
				
				<br>
				
				<div class="footer">      
				
					<div class="col-sm-10 derecha">			      		
			    		<input type="button" class="btn btn-danger" value="Eliminar" onclick="eliminar(${conductor.id},'conductor');">
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
    
    <script type="text/javascript">
    
    $(document).ready(function() {
    	
		$('#divFechaExpedicion').datetimepicker({
		 	language: 'es',
		 	format: "dd/mm/yyyy",
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0	
		});	

    });
    
    </script>
     
</body>

</html>