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
                    <h2 class="page-header">Compañia Transporte</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="companiaTransporte" >
					
				<sf:input type="hidden" path="id" value="${companiaTransporte.id}" />
				<sf:input type="hidden" path="agencia.id" value="${companiaTransporte.agencia.id}" />
			
			   	<div class="row">
		        	<div class="col-lg-2">
		        		<label>Código</label>
		        		<sf:errors path="cotr_codigo" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="cotr_codigo" value="${companiaTransporte.cotr_codigo}" maxlength="6" />		        		
		        	</div>
		        	<div class="col-lg-3">
		        		<label>CIF</label>
		        		<sf:errors path="cotr_cif" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="cotr_cif" value="${companiaTransporte.cotr_cif}" maxlength="15" />		        		
		        	</div>			        				   	
		        	<div class="col-lg-7">
		        		<label>Razón social</label>
		        		<sf:errors path="cotr_razonSocial" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="cotr_razonSocial" value="${companiaTransporte.cotr_razonSocial}" maxlength="255" />		        		
		        	</div>
				</div>
				
				<br>
				
			   	<div class="row">
		        	<div class="col-lg-12">
		        		<label>Domicilio</label>
		        		<sf:errors path="cotr_domicilio" class="label label-danger"></sf:errors>
		        		<sf:input class="form-control" path="cotr_domicilio" value="${companiaTransporte.cotr_domicilio}" maxlength="255" />		        		
		        	</div>
				</div>				
				
				<br>
				
				<div class="footer">      
				
					<div class="col-sm-10 derecha">			      		
			    		<input type="button" class="btn btn-danger" value="Eliminar" onclick='eliminar($("#id").val(),"companiaTransporte");'>
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