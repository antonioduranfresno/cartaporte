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
                    <h2 class="page-header">Conductor</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="conductor" >
					
				<sf:input type="hidden" path="id" value="${conductor.id}" />
<%-- 				<sf:input type="hidden" path="agencia.id" value="${conductor.agencia.id}" /> --%>
			
				<div class="row">
		      		<div class="col-lg-8">
                  		<label>Compañía Transporte</label>
                  		<sf:errors path="companiaTransporte.id" class="label label-danger"></sf:errors>
                  		<sf:select class="form-control" id="selCompania" path="companiaTransporte.id" value="${conductor.companiaTransporte.id}">
                       		<option value="0">Selección</option>
                          	<c:forEach items="${listaCompaniasTransporte}" var="c" varStatus="index">
                          		<option value="${c.id}" ${c.id == conductor.companiaTransporte.id ? 'selected' : '' }>${c.toStringCodigoNombre()}</option>
                   			</c:forEach>
                   		</sf:select>
		        	</div>                     
		      	</div>

				<div class="row">
		        	<div class="col-lg-12">
		        		<label>Dni</label>
		        		<sf:errors path="cond_dni" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_dni" class="form-control" value="${conductor.cond_dni}" maxlength="45" />		        		
		        	</div>
				</div>
				
				<div class="row">
		        	<div class="col-lg-12">
		        		<label>Nombre</label>
		        		<sf:errors path="cond_nombre" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_nombre" class="form-control" value="${conductor.cond_nombre}" maxlength="45" />		        		
		        	</div>
				</div>
			
				<div class="row">
		        	<div class="col-lg-12">
		        		<label>Teléfono</label>
		        		<sf:errors path="cond_telefono" class="label label-danger"></sf:errors>
		        		<sf:input  path="cond_telefono" class="form-control" value="${conductor.cond_telefono}" maxlength="45" />		        		
		        	</div>
				</div>
				
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
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/maestro.js" />'></script>
     
</body>

</html>