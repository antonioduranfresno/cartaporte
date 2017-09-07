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

  </head>

<body>

    <div id="wrapper">

		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
        
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Camión</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="camion" >
					
				<sf:input type="hidden" path="id" value="${camion.id}" />
							
				<div class="row">
					<div class="col-lg-8">
						<label>Compañía Transporte</label>
						<sf:errors path="companiaTransporte.id" class="label label-danger"></sf:errors>
						<sf:select class="form-control" id="selCompania" path="companiaTransporte.id" value="${camion.companiaTransporte.id}">
							<option value="0">Selección</option>
							<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
			        			<option value="${c.id}" ${c.id == camion.companiaTransporte.id ? 'selected' : '' }>${c.toStringCodigoNombre()}</option>
			        		</c:forEach>
						</sf:select>
					</div>				
				</div>
				
				<br>
			
			   	<div class="row">
		        	<div class="col-lg-6">
		        		<label>Matrícula</label>
		        		<sf:errors path="cami_matricula" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="cami_matricula" value="${camion.cami_matricula}" maxlength="45" />		        		
		        	</div>
					<div class="col-lg-2">
		        		<label>Es tractora</label>		        		
		        		<sf:select class="form-control" path="cami_tractora" value="${camion.cami_tractora}">
		        			<sf:option value="false">No</sf:option>		        		
		        			<sf:option value="true">Sí</sf:option>
		        		</sf:select>
		        	</div>		        	
				</div>
				
				<br>
				
				<div class="footer">      
				
					<div class="col-sm-10 derecha">			      		
			    		<input type="button" class="btn btn-danger" value="Eliminar" onclick='eliminar($("#id").val(),"camion");'>
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
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/maestro.js" />'></script>
     
</body>

</html>